package com.github.massakai.snippets.performancestub;

/** スタブ API が返す固定レスポンス内容です. */
public record StubResponse(
    int status,
    String body
) {
}
