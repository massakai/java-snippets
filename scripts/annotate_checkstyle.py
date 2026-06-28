#!/usr/bin/env python3

from __future__ import annotations

import os
import sys
from pathlib import Path
import xml.etree.ElementTree as ET


def escape_workflow_value(value: str) -> str:
    return value.replace("%", "%25").replace("\r", "%0D").replace("\n", "%0A")


def to_relative_path(raw_name: str, workspace: Path) -> str:
    path = Path(raw_name)
    if path.is_absolute():
        try:
            return str(path.relative_to(workspace))
        except ValueError:
            return raw_name
    return raw_name


def main() -> int:
    if len(sys.argv) != 2:
        raise SystemExit("usage: annotate_checkstyle.py <report_dir>")

    report_dir = Path(sys.argv[1])
    workspace = Path(os.environ.get("GITHUB_WORKSPACE", os.getcwd())).resolve()

    for report_path in sorted(report_dir.glob("*.xml")):
        document = ET.parse(report_path)
        root = document.getroot()

        for file_element in root.findall("file"):
            raw_name = file_element.get("name", "")
            relative_path = to_relative_path(raw_name, workspace)

            for error_element in file_element.findall("error"):
                line = error_element.get("line")
                column = error_element.get("column")
                severity = error_element.get("severity", "error")
                if severity == "warning":
                    severity = "error"
                message = error_element.get("message", "")
                source = error_element.get("source", "")
                title = source.split(".")[-1] if source else ""

                metadata = [f"file={escape_workflow_value(relative_path)}"]
                if line:
                    metadata.append(f"line={line}")
                if column:
                    metadata.append(f"col={column}")
                if title:
                    metadata.append(f"title={escape_workflow_value(title)}")

                print(
                    f"::{severity} {','.join(metadata)}::"
                    f"{escape_workflow_value(message)}"
                )

    return 0


if __name__ == "__main__":
    raise SystemExit(main())
