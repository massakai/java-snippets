package com.github.massakai.snippets.configurationproperties;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import java.net.URI;
import java.time.Duration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

/** 記事向け推薦 API サンプルで使う設定値です. */
@Validated
@ConfigurationProperties("article.recommendation")
public record RecommendationProperties(
    @NotNull URI endpoint,
    @Min(1) int pageSize,
    @NotNull Duration timeout,
    @NotNull @Valid Cache cache,
    @NotNull @Valid Retry retry) {

  /** キャッシュに関するネスト設定です. */
  public record Cache(
      boolean enabled,
      @NotNull Duration ttl,
      @Min(1) int maxEntries) {
  }

  /** リトライに関するネスト設定です. */
  public record Retry(
      @Min(1) int maxAttempts,
      @NotNull Duration initialInterval) {
  }
}
