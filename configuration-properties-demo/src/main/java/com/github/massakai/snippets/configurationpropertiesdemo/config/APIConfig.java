package com.github.massakai.snippets.configurationpropertiesdemo.config;

import jakarta.validation.constraints.NotNull;
import java.net.URL;
import java.time.Duration;

/** {@code demo.api-config} から束縛する API 向けのネスト設定です. */
public record ApiConfig(
    @NotNull URL url,
    @NotNull Duration connectionTimeout,
    @NotNull Duration readTimeout
) {
}
