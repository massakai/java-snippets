package com.github.massakai.snippets.performancestub;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

/** パフォーマンステスト用スタブ API のエントリーポイントです. */
@SpringBootApplication
@ConfigurationPropertiesScan
public class PerformanceStubApplication {

  /**
   * サンプルアプリケーションを起動します.
   *
   * @param args コマンドライン引数
   */
  public static void main(final String[] args) {
    SpringApplication.run(PerformanceStubApplication.class, args);
  }
}
