package com.github.massakai.snippets.configurationpropertiesdemo.config;

import jakarta.validation.Valid;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

/** 旧デモアプリケーション全体の設定値を表します. */
@ConfigurationProperties("demo")
@Validated
public record DemoProperties(@Valid ApiConfig apiConfig) {
}
