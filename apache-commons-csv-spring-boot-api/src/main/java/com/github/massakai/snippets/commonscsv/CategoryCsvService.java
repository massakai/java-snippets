package com.github.massakai.snippets.commonscsv;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Service;

/** サンプルカテゴリの CSV 出力と CSV 取込時の検証を担当します. */
@Service
public class CategoryCsvService {

  private static final List<Category> SAMPLE_CATEGORIES = List.of(
      new Category(1, "Books", "Books and magazines"),
      new Category(2, "Games", "Video games and board games"),
      new Category(3, "Kitchen", "Kitchen tools")
  );

  private static final CSVFormat EXPORT_FORMAT = CSVFormat.DEFAULT.builder()
      .setHeader("id", "name", "description")
      .setRecordSeparator("\n")
      .get();

  private static final CSVFormat IMPORT_FORMAT = CSVFormat.DEFAULT.builder()
      .setHeader()
      .setSkipHeaderRecord(true)
      .setTrim(true)
      .setIgnoreEmptyLines(true)
      .get();

  /**
   * メモリ上のサンプルカテゴリを CSV 文字列として出力します.
   *
   * @return CSV 形式のカテゴリ一覧
   * @throws IOException CSV 出力に失敗した場合
   */
  public String exportCategories() throws IOException {
    final StringWriter writer = new StringWriter();

    try (CSVPrinter printer = EXPORT_FORMAT.print(writer)) {
      for (Category category : SAMPLE_CATEGORIES) {
        printer.printRecord(category.id(), category.name(), category.description());
      }
    }

    return writer.toString();
  }

  /**
   * CSV を読み込み、取り込めた行と検証エラーを返します.
   *
   * @param inputStream 取込対象の CSV 入力ストリーム
   * @return 取込結果の集計と検証エラー
   * @throws IOException CSV の読み込みに失敗した場合
   */
  public CategoryImportResponse importCategories(
      final InputStream inputStream
  ) throws IOException {
    final List<Category> categories = new ArrayList<>();
    final List<CsvImportError> errors = new ArrayList<>();
    int totalRows = 0;

    try (
        BufferedReader reader =
            new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
        CSVParser parser = IMPORT_FORMAT.parse(reader)
    ) {
      validateHeaders(parser.getHeaderMap(), errors);

      if (!errors.isEmpty()) {
        return new CategoryImportResponse(0, 0, 0, List.of(), errors);
      }

      for (CSVRecord record : parser) {
        totalRows++;
        final List<CsvImportError> rowErrors = validateRecord(record);

        if (rowErrors.isEmpty()) {
          categories.add(new Category(
              Integer.parseInt(record.get("id")),
              record.get("name"),
              record.get("description")
          ));
        } else {
          errors.addAll(rowErrors);
        }
      }
    }

    return new CategoryImportResponse(
        totalRows,
        categories.size(),
        totalRows - categories.size(),
        List.copyOf(categories),
        List.copyOf(errors)
    );
  }

  private void validateHeaders(
      final Map<String, Integer> headerMap,
      final List<CsvImportError> errors
  ) {
    for (String header : List.of("id", "name", "description")) {
      if (!headerMap.containsKey(header)) {
        errors.add(new CsvImportError(1, header, "missing required header"));
      }
    }
  }

  private List<CsvImportError> validateRecord(final CSVRecord record) {
    final List<CsvImportError> errors = new ArrayList<>();
    final int rowNumber = Math.toIntExact(record.getRecordNumber() + 1);
    final String id = record.get("id");
    final String name = record.get("name");

    if (id.isBlank()) {
      errors.add(new CsvImportError(rowNumber, "id", "must not be blank"));
    } else {
      try {
        final int parsedId = Integer.parseInt(id);
        if (parsedId <= 0) {
          errors.add(new CsvImportError(rowNumber, "id", "must be a positive integer"));
        }
      } catch (NumberFormatException ex) {
        errors.add(new CsvImportError(rowNumber, "id", "must be a positive integer"));
      }
    }

    if (name.isBlank()) {
      errors.add(new CsvImportError(rowNumber, "name", "must not be blank"));
    }

    return errors;
  }
}
