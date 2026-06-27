package com.github.massakai.snippets.commonscsv;

import java.util.List;

public record CategoryImportResponse(
        int totalRows,
        int validRows,
        int invalidRows,
        List<Category> categories,
        List<CsvImportError> errors
) {
}
