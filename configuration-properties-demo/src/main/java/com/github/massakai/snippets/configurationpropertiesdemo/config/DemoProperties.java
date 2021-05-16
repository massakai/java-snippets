package com.github.massakai.snippets.configurationpropertiesdemo.config;

import javax.validation.Valid;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;
import org.springframework.validation.annotation.Validated;

@ConfigurationProperties("demo")
@ConstructorBinding
@Validated
public class DemoProperties {
  @Valid
  private final APIConfig apiConfig;

  public DemoProperties(final APIConfig apiConfig) {
    this.apiConfig = apiConfig;
  }

  public APIConfig getApiConfig() {
    return apiConfig;
  }
}
