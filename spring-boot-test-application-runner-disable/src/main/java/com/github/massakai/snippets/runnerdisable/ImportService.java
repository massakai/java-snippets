package com.github.massakai.snippets.runnerdisable;

import org.springframework.stereotype.Service;

/** ApplicationRunner から呼ばれる最小構成のサービスです. */
@Service
public class ImportService {

  /** サンプルの取込処理を実行します. */
  public void execute() {
    // 実際のバッチ処理をここに置く想定
  }
}
