package com.github.massakai.snippets.commonscsv;

import java.util.List;

/** 1 回の CSV インポート結果をまとめて返します. */
public record CategoryImportResponse(
    int totalRows,
    int validRows,
    int invalidRows,
    List<Category> categories,
    List<CsvImportError> errors
) {
}
