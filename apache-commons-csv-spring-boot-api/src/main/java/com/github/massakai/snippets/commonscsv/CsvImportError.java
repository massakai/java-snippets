package com.github.massakai.snippets.commonscsv;

public record CsvImportError(int rowNumber, String field, String message) {
}
