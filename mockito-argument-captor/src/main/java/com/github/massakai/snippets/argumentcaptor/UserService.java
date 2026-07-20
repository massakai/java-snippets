package com.github.massakai.snippets.argumentcaptor;

import java.time.Clock;
import java.time.Instant;
import java.util.Locale;

/** 入力を整形してユーザーを保存するサービスです. */
public class UserService {

  private final UserRepository userRepository;
  private final Clock clock;

  /**
   * 保存先と時刻の取得元を指定してサービスを生成します.
   *
   * @param userRepository ユーザーの保存先
   * @param clock 作成日時の取得元
   */
  public UserService(final UserRepository userRepository, final Clock clock) {
    this.userRepository = userRepository;
    this.clock = clock;
  }

  /**
   * 入力を整形してユーザーを保存します.
   *
   * @param name ユーザー名
   * @param emailAddress メールアドレス
   */
  public void register(final String name, final String emailAddress) {
    final User user =
        new User(name.trim(), emailAddress.toLowerCase(Locale.ROOT), Instant.now(clock));
    userRepository.save(user);
  }
}
