package com.github.massakai.snippets.performancestub;

/** スタブ API の遅延候補を重みつきで表します. */
public record DelayPattern(
    int weight,
    long millis
) {
}
