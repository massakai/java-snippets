# Configuration Properties Demo

Deprecated: このサンプルは新規用途には使わず、`spring-boot-configuration-properties` を参照してください。

`configuration-properties-demo` は後方参照用に残している旧名称のサンプルです。
現行のブログ記事、検証、説明の参照先は `spring-boot-configuration-properties` に集約します。

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

## Notes

- このサンプルは後方参照と比較用に残しています
- 新規の説明や記事から参照するコードは `spring-boot-configuration-properties` を使ってください
- 実装は Spring Boot 3.5 / 4.0 / 4.1 系の matrix で継続確認しています
