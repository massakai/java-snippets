# Configuration Properties Demo

`@ConfigurationProperties` でネストした設定値を型安全にバインドし、Bean Validation で検証するサンプルです。

## 内容

- `DemoProperties` と `APIConfig` を record で定義する
- `@ConfigurationPropertiesScan` で設定クラスを自動検出する
- URL と `Duration` のバインドをテストで確認する

## Run Tests

```bash
./gradlew test -PspringBootVersion=3.5.15
./gradlew test -PspringBootVersion=4.0.7
./gradlew test -PspringBootVersion=4.1.0
```

GitHub Actionsでは、Gradle wrapper 9.5.1を使ってSpring Boot 3.5.15 / 4.0.7 / 4.1.0 と Java 17 / 21 / 25 の組み合わせでテストします。
