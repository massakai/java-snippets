package com.github.massakai.snippets.configurationproperties;

import java.net.URI;
import java.time.Duration;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

@Validated
@ConfigurationProperties("article.recommendation")
public record RecommendationProperties(
        @NotNull URI endpoint,
        @Min(1) int pageSize,
        @NotNull Duration timeout,
        @NotNull @Valid Cache cache,
        @NotNull @Valid Retry retry) {

    public record Cache(
            boolean enabled,
            @NotNull Duration ttl,
            @Min(1) int maxEntries) {
    }

    public record Retry(
            @Min(1) int maxAttempts,
            @NotNull Duration initialInterval) {
    }
}
