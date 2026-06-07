# Spring Boot Performance Stub

Spring Bootで性能テスト用の遅延レスポンスを返すスタブAPIのサンプルです。

## Run Tests

```bash
./gradlew test -PspringBootVersion=3.5.14
./gradlew test -PspringBootVersion=4.0.6
```

GitHub Actionsでは、Gradle wrapper 9.5.1を使ってSpring Boot 3.5.14 / 4.0.6 と Java 17 / 21 / 25 の組み合わせでテストします。
