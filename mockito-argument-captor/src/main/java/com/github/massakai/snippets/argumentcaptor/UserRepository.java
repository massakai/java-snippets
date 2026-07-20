package com.github.massakai.snippets.argumentcaptor;

/** ユーザーの保存先を表します. */
public interface UserRepository {

  /**
   * ユーザーを保存します.
   *
   * @param user 保存するユーザー
   */
  void save(User user);
}
