package com.github.massakai.snippets.configurationpropertiesdemo.config;

import java.net.URL;
import java.time.Duration;
import jakarta.validation.constraints.NotNull;

public record APIConfig(
        @NotNull URL url,
        @NotNull Duration connectionTimeout,
        @NotNull Duration readTimeout
) {
}
