package com.github.massakai.snippets.configurationproperties;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.runner.ApplicationContextRunner;
import org.springframework.context.annotation.Configuration;

class RecommendationPropertiesValidationTest {

    @Test
    void failsWhenRequiredEndpointIsNotConfigured() {
        assertValidationFailure(
                contextRunner().withPropertyValues(requiredProperties()),
                "endpoint",
                "NotNull.article.recommendation.endpoint");
    }

    @Test
    void failsWhenPageSizeIsLessThanOne() {
        assertValidationFailure(
                validContextRunner().withPropertyValues("article.recommendation.page-size=0"),
                "pageSize",
                "Min.article.recommendation.pageSize");
    }

    @Test
    void failsWhenNestedRetryPropertyIsInvalid() {
        assertValidationFailure(
                validContextRunner().withPropertyValues("article.recommendation.retry.max-attempts=0"),
                "retry.maxAttempts",
                "Min.article.recommendation.retry.maxAttempts");
    }

    private ApplicationContextRunner contextRunner() {
        return new ApplicationContextRunner().withUserConfiguration(TestConfig.class);
    }

    private ApplicationContextRunner validContextRunner() {
        return contextRunner()
                .withPropertyValues("article.recommendation.endpoint=https://example.internal/test")
                .withPropertyValues(requiredProperties());
    }

    private String[] requiredProperties() {
        return new String[] {
                "article.recommendation.page-size=5",
                "article.recommendation.timeout=1500ms",
                "article.recommendation.cache.enabled=false",
                "article.recommendation.cache.ttl=30s",
                "article.recommendation.cache.max-entries=50",
                "article.recommendation.retry.max-attempts=1",
                "article.recommendation.retry.initial-interval=50ms"
        };
    }

    private void assertValidationFailure(
            ApplicationContextRunner runner, String fieldName, String constraintCode) {
        runner.run(context -> {
            assertThat(context).hasFailed();
            assertThat(context.getStartupFailure())
                    .hasStackTraceContaining("Binding validation errors on article.recommendation")
                    .hasStackTraceContaining("field '" + fieldName + "'")
                    .hasStackTraceContaining(constraintCode);
        });
    }

    @Configuration(proxyBeanMethods = false)
    @EnableConfigurationProperties(RecommendationProperties.class)
    static class TestConfig {
    }
}
