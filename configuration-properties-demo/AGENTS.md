# Configuration Properties Demo Agent Notes

## Purpose

- `@ConfigurationProperties` によるネストした設定値のバインドと検証を確認する

## Test Focus

- `DemoProperties` と `ApiConfig` に URL と `Duration` を正しく束縛できること
- Bean Validation を有効にしたままアプリケーションコンテキストを起動できること

## Run Commands

```bash
./gradlew test -PspringBootVersion=4.0.10
./gradlew test -PspringBootVersion=4.1.3
./gradlew test -PspringBootVersion=4.2.0
```

## Naming Consistency Notes

- 記事やメモでは `DemoProperties`、`ApiConfig`、`demo.api-config` の表記ずれに注意する
- Spring Boot の確認対象は `4.0.10` / `4.1.3` / `4.2.0`

## CI

- GitHub Actions で Spring Boot `4.0.10` / `4.1.3` / `4.2.0` と Java `17` / `21` / `25` の組み合わせをテストする
