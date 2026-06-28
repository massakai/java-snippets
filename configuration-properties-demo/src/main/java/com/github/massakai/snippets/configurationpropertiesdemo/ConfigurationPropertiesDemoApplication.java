package com.github.massakai.snippets.configurationpropertiesdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

/** 旧 configuration properties サンプルのエントリーポイントです. */
@SpringBootApplication
@ConfigurationPropertiesScan
public class ConfigurationPropertiesDemoApplication {

  /**
   * サンプルアプリケーションを起動します.
   *
   * @param args コマンドライン引数
   */
  public static void main(String[] args) {
    SpringApplication.run(ConfigurationPropertiesDemoApplication.class, args);
  }
}
