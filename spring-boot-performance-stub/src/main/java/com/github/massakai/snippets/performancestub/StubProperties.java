package com.github.massakai.snippets.performancestub;

import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "stub")
public record StubProperties(
        StubResponse responses,
        List<DelayPattern> delays
) {
}
