package com.github.massakai.snippets.configurationpropertiesdemo.config;

import jakarta.validation.Valid;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

@ConfigurationProperties("demo")
@Validated
public record DemoProperties(@Valid APIConfig apiConfig) {
}
