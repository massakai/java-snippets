package com.github.massakai.snippets.commonscsv;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/** サンプルカテゴリの CSV エクスポートとインポート API を提供します. */
@RestController
@RequestMapping("/categories")
public class CategoryController {

  private final CategoryCsvService categoryCsvService;

  /**
   * CSV 処理を行うサービスを受け取ってコントローラを生成します.
   *
   * @param categoryCsvService CSV の入出力を担当するサービス
   */
  public CategoryController(CategoryCsvService categoryCsvService) {
    this.categoryCsvService = categoryCsvService;
  }

  /**
   * サンプルカテゴリをダウンロード可能な CSV として返します.
   *
   * @return CSV ダウンロードレスポンス
   * @throws IOException CSV の生成に失敗した場合
   */
  @GetMapping(value = "/export", produces = "text/csv")
  public ResponseEntity<String> exportCategories() throws IOException {
    return ResponseEntity.ok()
        .contentType(new MediaType("text", "csv", StandardCharsets.UTF_8))
        .header(HttpHeaders.CONTENT_DISPOSITION, ContentDisposition.attachment()
            .filename("categories.csv")
            .build()
            .toString())
        .body(categoryCsvService.exportCategories());
  }

  /**
   * アップロードされた CSV を読み込み、検証結果つきで返します.
   *
   * @param file 取込対象の CSV ファイル
   * @return 取込結果の集計と検証エラー
   * @throws IOException CSV の読み込みに失敗した場合
   */
  @PostMapping(value = "/import", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
  public CategoryImportResponse importCategories(
      @RequestParam("file") MultipartFile file
  ) throws IOException {
    return categoryCsvService.importCategories(file.getInputStream());
  }
}
