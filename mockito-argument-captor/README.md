# Mockito ArgumentCaptor

JUnit 5 と Mockito の `ArgumentCaptor` を使い、サービスがリポジトリへ渡す引数を検証するサンプルです。

## What This Sample Verifies

- `UserService` が名前の前後空白を除去して `UserRepository.save(User)` に渡す
- メールアドレスを小文字化して保存する
- `Clock.fixed` を使い、`createdAt` を固定して検証する
- `verify(..., times(2))` と `getAllValues()` で複数回の `save` 呼び出しの引数を順に検証する

## Dependencies

- Java 25（既定 toolchain）
- JUnit Jupiter 5.12.2
- Mockito 5.23.0

## Run Tests

```sh
./gradlew test
```

Java 17 / 21 / 25 を明示して検証する場合は、`javaVersion` プロパティを指定します。

```sh
./gradlew check -PjavaVersion=17
./gradlew check -PjavaVersion=21
./gradlew check -PjavaVersion=25
```

`UserServiceTest` は `MockitoExtension`、`@Mock`、`@Captor` を使用します。`ArgumentCaptor` は
`verify` の引数として `capture()` し、1 回の呼び出しでは `getValue()`、複数回の呼び出しでは
`getAllValues()` から保存対象を取得します。

GitHub Actions では、Gradle wrapper 9.5.1 を使って Java 17 / 21 / 25 を toolchain として
指定し、`check` を実行します。既定 toolchain は Java 25 です。
