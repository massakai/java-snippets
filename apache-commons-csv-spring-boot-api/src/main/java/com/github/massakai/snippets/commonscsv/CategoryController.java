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

@RestController
@RequestMapping("/categories")
public class CategoryController {

    private final CategoryCsvService categoryCsvService;

    public CategoryController(CategoryCsvService categoryCsvService) {
        this.categoryCsvService = categoryCsvService;
    }

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

    @PostMapping(value = "/import", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public CategoryImportResponse importCategories(@RequestParam("file") MultipartFile file) throws IOException {
        return categoryCsvService.importCategories(file.getInputStream());
    }
}
