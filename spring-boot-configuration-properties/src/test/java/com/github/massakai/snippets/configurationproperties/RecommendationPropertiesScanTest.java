package com.github.massakai.snippets.configurationproperties;

import static org.assertj.core.api.Assertions.assertThat;

import java.net.URI;
import java.time.Duration;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RecommendationPropertiesScanTest {

  @Autowired
  RecommendationProperties properties;

  @Test
  void bindsApplicationYamlByConfigurationPropertiesScan() {
    assertThat(properties.endpoint()).isEqualTo(URI.create("https://example.internal/recommendations"));
    assertThat(properties.pageSize()).isEqualTo(20);
    assertThat(properties.timeout()).isEqualTo(Duration.ofMillis(750));

    assertThat(properties.cache().enabled()).isTrue();
    assertThat(properties.cache().ttl()).isEqualTo(Duration.ofMinutes(5));
    assertThat(properties.cache().maxEntries()).isEqualTo(1000);

    assertThat(properties.retry().maxAttempts()).isEqualTo(3);
    assertThat(properties.retry().initialInterval()).isEqualTo(Duration.ofMillis(200));
  }
}
