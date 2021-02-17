package com.github.massakai.snippets.configurationpropertiesdemo.config;

import static org.junit.jupiter.api.Assertions.*;

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
  @DisplayName("APIConfigの値がアプリケーションプロパティから読み込まれる")
  void getApiConfig() throws MalformedURLException {
    APIConfig apiConfig = demoProperties.getApiConfig();

    assertEquals(new URL("http://localhost/hoge"), apiConfig.getUrl());
    assertEquals(Duration.ofMillis(100), apiConfig.getConnectionTimeout());
    assertEquals(Duration.ofMillis(200), apiConfig.getReadTimeout());
  }
}