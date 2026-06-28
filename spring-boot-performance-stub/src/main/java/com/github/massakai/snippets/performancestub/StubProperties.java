package com.github.massakai.snippets.performancestub;

import java.util.List;
import org.springframework.boot.context.properties.ConfigurationProperties;

/** パフォーマンステスト用スタブ API の設定値です. */
@ConfigurationProperties(prefix = "stub")
public record StubProperties(
    StubResponse responses,
    List<DelayPattern> delays
) {
}
