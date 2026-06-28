package com.github.massakai.snippets.runnerdisable;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/** ApplicationRunner の有効・無効を確認するサンプルのエントリーポイントです. */
@SpringBootApplication
public class ApplicationRunnerDisableApplication {

  /**
   * サンプルアプリケーションを起動します.
   *
   * @param args コマンドライン引数
   */
  public static void main(String[] args) {
    SpringApplication.run(ApplicationRunnerDisableApplication.class, args);
  }
}
