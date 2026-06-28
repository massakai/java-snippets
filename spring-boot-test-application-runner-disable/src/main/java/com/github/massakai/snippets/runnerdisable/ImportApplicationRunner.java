package com.github.massakai.snippets.runnerdisable;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

/** 起動時処理が有効なときにサンプル取込処理を実行します. */
@Component
@ConditionalOnProperty(
    prefix = "startup.import",
    name = "enabled",
    havingValue = "true",
    matchIfMissing = true
)
public class ImportApplicationRunner implements ApplicationRunner {

  private final ImportService importService;

  /**
   * 起動時に実行する取込サービスを受け取って runner を生成します.
   *
   * @param importService 起動時に呼び出す取込サービス
   */
  public ImportApplicationRunner(final ImportService importService) {
    this.importService = importService;
  }

  /**
   * 起動時フックが有効な場合にサンプル取込処理を実行します.
   *
   * @param args アプリケーション起動引数
   */
  @Override
  public void run(final ApplicationArguments args) {
    importService.execute();
  }
}
