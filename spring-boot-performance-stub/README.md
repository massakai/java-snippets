# Spring Boot Performance Stub

Spring Bootで性能テスト用の遅延レスポンスを返すスタブAPIのサンプルです。

## Run Tests

Web MVC の実装には `spring-boot-starter-webmvc`、テストには `spring-boot-starter-webmvc-test` を使用します。

```bash
./gradlew test -PspringBootVersion=4.0.10
./gradlew test -PspringBootVersion=4.1.3
./gradlew test -PspringBootVersion=4.2.0
```

GitHub Actionsでは、Gradle wrapper 9.9.2を使ってSpring Boot 4.0.10 / 4.1.3 / 4.2.0 と Java 17 / 21 / 25 の組み合わせでテストします。
