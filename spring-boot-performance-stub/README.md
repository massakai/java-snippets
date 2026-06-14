# Spring Boot Performance Stub

Spring Bootで性能テスト用の遅延レスポンスを返すスタブAPIのサンプルです。

## Run Tests

```bash
./gradlew test -PspringBootVersion=3.5.15
./gradlew test -PspringBootVersion=4.0.7
./gradlew test -PspringBootVersion=4.1.0
```

GitHub Actionsでは、Gradle wrapper 9.5.1を使ってSpring Boot 3.5.15 / 4.0.7 / 4.1.0 と Java 17 / 21 / 25 の組み合わせでテストします。
