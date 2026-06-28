package com.github.massakai.snippets.commonscsv;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/** Apache Commons CSV を使ったサンプル API のエントリーポイントです. */
@SpringBootApplication
public class CommonsCsvApiApplication {

  /**
   * サンプルアプリケーションを起動します.
   *
   * @param args コマンドライン引数
   */
  public static void main(String[] args) {
    SpringApplication.run(CommonsCsvApiApplication.class, args);
  }
}
