package com.github.massakai.snippets.configurationpropertiesdemo.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

@ConfigurationProperties("demo")
@ConstructorBinding
public class DemoProperties {
  private final APIConfig apiConfig;

  public DemoProperties(final APIConfig apiConfig) {
    this.apiConfig = apiConfig;
  }

  public APIConfig getApiConfig() {
    return apiConfig;
  }
}
