package com.github.massakai.snippets.configurationpropertiesdemo.config;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest
@TestPropertySource(properties = {
  "demo.apiConfig.url = http://localhost/hoge",
  "demo.apiConfig.connectionTimeout = 100ms",
  "demo.apiConfig.readTimeout = 200ms"})
class DemoPropertiesTest {

  @Autowired
  DemoProperties demoProperties;

  @Test
  @DisplayName("アプリケーションコンテキストがロードできる")
  void loadContext() {

  }

  @Test
  @DisplayName("ApiConfigの値がアプリケーションプロパティから読み込まれる")
  void getApiConfig() throws MalformedURLException {
    final ApiConfig apiConfig = demoProperties.apiConfig();

    assertEquals(new URL("http://localhost/hoge"), apiConfig.url());
    assertEquals(Duration.ofMillis(100), apiConfig.connectionTimeout());
    assertEquals(Duration.ofMillis(200), apiConfig.readTimeout());
  }
}
