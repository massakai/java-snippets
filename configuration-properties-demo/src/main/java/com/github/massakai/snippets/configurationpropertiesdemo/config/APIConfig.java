package com.github.massakai.snippets.configurationpropertiesdemo.config;

import java.net.URL;
import java.time.Duration;
import javax.validation.constraints.NotNull;

public class APIConfig {
  @NotNull
  private final URL url;
  @NotNull
  private final Duration connectionTimeout;
  @NotNull
  private final Duration readTimeout;

  public APIConfig(final URL url, final Duration connectionTimeout, final Duration readTimeout) {
    this.url = url;
    this.connectionTimeout = connectionTimeout;
    this.readTimeout = readTimeout;
  }

  public URL getUrl() {
    return url;
  }

  public Duration getConnectionTimeout() {
    return connectionTimeout;
  }

  public Duration getReadTimeout() {
    return readTimeout;
  }
}
