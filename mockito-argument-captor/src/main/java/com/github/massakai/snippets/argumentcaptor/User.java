package com.github.massakai.snippets.argumentcaptor;

import java.time.Instant;

/** 保存するユーザーを表します. */
public record User(String name, String emailAddress, Instant createdAt) {}
