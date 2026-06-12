# Configuration Properties Demo

`@ConfigurationProperties` でネストした設定値を型安全にバインドし、Bean Validation で検証するサンプルです。

## 内容

- `DemoProperties` と `APIConfig` を record で定義する
- `@ConfigurationPropertiesScan` で設定クラスを自動検出する
- URL と `Duration` のバインドをテストで確認する

## Run Tests

```bash
./gradlew test -PspringBootVersion=3.5.14
./gradlew test -PspringBootVersion=4.0.6
```

GitHub Actionsでは、Gradle wrapper 9.5.1を使ってSpring Boot 3.5.14 / 4.0.6 と Java 17 / 21 / 25 の組み合わせでテストします。
