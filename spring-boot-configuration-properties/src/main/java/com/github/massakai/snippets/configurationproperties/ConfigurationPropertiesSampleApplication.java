package com.github.massakai.snippets.configurationproperties;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

/** 現行 configuration properties サンプルのエントリーポイントです. */
@SpringBootApplication
@ConfigurationPropertiesScan
public class ConfigurationPropertiesSampleApplication {

  /**
   * サンプルアプリケーションを起動します.
   *
   * @param args コマンドライン引数
   */
  public static void main(String[] args) {
    SpringApplication.run(ConfigurationPropertiesSampleApplication.class, args);
  }
}
