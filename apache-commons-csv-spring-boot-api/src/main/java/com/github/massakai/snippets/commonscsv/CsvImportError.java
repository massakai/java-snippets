package com.github.massakai.snippets.commonscsv;

/** CSV インポート時に検出した 1 件の検証エラーを表します. */
public record CsvImportError(int rowNumber, String field, String message) {
}
