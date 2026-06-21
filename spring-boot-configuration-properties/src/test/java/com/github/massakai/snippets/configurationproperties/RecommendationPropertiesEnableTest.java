package com.github.massakai.snippets.configurationproperties;

import static org.assertj.core.api.Assertions.assertThat;

import java.net.URI;
import java.time.Duration;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig(RecommendationPropertiesEnableTest.TestConfig.class)
@TestPropertySource(properties = {
        "article.recommendation.endpoint=https://example.internal/test",
        "article.recommendation.page-size=5",
        "article.recommendation.timeout=1500ms",
        "article.recommendation.cache.enabled=false",
        "article.recommendation.cache.ttl=30s",
        "article.recommendation.cache.max-entries=50",
        "article.recommendation.retry.max-attempts=1",
        "article.recommendation.retry.initial-interval=50ms"
})
class RecommendationPropertiesEnableTest {

    @Autowired
    RecommendationProperties properties;

    @Test
    void bindsPropertiesRegisteredByEnableConfigurationProperties() {
        assertThat(properties.endpoint()).isEqualTo(URI.create("https://example.internal/test"));
        assertThat(properties.pageSize()).isEqualTo(5);
        assertThat(properties.timeout()).isEqualTo(Duration.ofMillis(1500));

        assertThat(properties.cache().enabled()).isFalse();
        assertThat(properties.cache().ttl()).isEqualTo(Duration.ofSeconds(30));
        assertThat(properties.cache().maxEntries()).isEqualTo(50);

        assertThat(properties.retry().maxAttempts()).isEqualTo(1);
        assertThat(properties.retry().initialInterval()).isEqualTo(Duration.ofMillis(50));
    }

    @Configuration(proxyBeanMethods = false)
    @EnableConfigurationProperties(RecommendationProperties.class)
    static class TestConfig {
    }
}
