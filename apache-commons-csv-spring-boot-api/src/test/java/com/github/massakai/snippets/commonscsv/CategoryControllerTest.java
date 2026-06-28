package com.github.massakai.snippets.commonscsv;

import static java.nio.charset.StandardCharsets.UTF_8;
import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.multipart;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@SpringBootTest
class CategoryControllerTest {

  @Autowired
  WebApplicationContext webApplicationContext;

  MockMvc mockMvc;

  @BeforeEach
  void setUp() {
    mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
  }

  @Test
  void exportCategoriesReturnsCsvAttachment() throws Exception {
    final String expectedCsv = String.join(
        "\n",
        "id,name,description",
        "1,Books,Books and magazines",
        "2,Games,Video games and board games",
        "3,Kitchen,Kitchen tools"
    ) + "\n";

    mockMvc.perform(get("/categories/export"))
        .andExpect(status().isOk())
        .andExpect(content().contentTypeCompatibleWith("text/csv"))
        .andExpect(
            header().string(
                HttpHeaders.CONTENT_DISPOSITION,
                containsString("categories.csv")
            )
        )
        .andExpect(
            content().string(expectedCsv)
        );
  }

  @Test
  void importCategoriesReturnsParsedRowsAndValidationErrors() throws Exception {
    final String csvBody = String.join(
        "\n",
        "id,name,description",
        "10,Stationery,Pens and notebooks",
        "-1,Invalid,negative id",
        ",Blank id,missing id",
        "12,,missing name"
    ) + "\n";

    final MockMultipartFile file = new MockMultipartFile(
        "file",
        "categories.csv",
        MediaType.TEXT_PLAIN_VALUE,
        csvBody.getBytes(UTF_8)
    );

    mockMvc.perform(multipart("/categories/import").file(file))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.totalRows").value(4))
        .andExpect(jsonPath("$.validRows").value(1))
        .andExpect(jsonPath("$.invalidRows").value(3))
        .andExpect(jsonPath("$.categories[0].id").value(10))
        .andExpect(jsonPath("$.categories[0].name").value("Stationery"))
        .andExpect(jsonPath("$.categories[0].description").value("Pens and notebooks"))
        .andExpect(jsonPath("$.errors[0].rowNumber").value(3))
        .andExpect(jsonPath("$.errors[0].field").value("id"))
        .andExpect(jsonPath("$.errors[0].message").value("must be a positive integer"))
        .andExpect(jsonPath("$.errors[1].rowNumber").value(4))
        .andExpect(jsonPath("$.errors[1].field").value("id"))
        .andExpect(jsonPath("$.errors[1].message").value("must not be blank"))
        .andExpect(jsonPath("$.errors[2].rowNumber").value(5))
        .andExpect(jsonPath("$.errors[2].field").value("name"))
        .andExpect(jsonPath("$.errors[2].message").value("must not be blank"));
  }
}
