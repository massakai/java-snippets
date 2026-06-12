# Configuration Properties Demo Agent Notes

## Purpose

- `@ConfigurationProperties` によるネストした設定値のバインドと検証を確認する

## Test Focus

- `DemoProperties` と `APIConfig` に URL と `Duration` を正しく束縛できること
- Bean Validation を有効にしたままアプリケーションコンテキストを起動できること

## Run Commands

```bash
./gradlew test -PspringBootVersion=3.5.14
./gradlew test -PspringBootVersion=4.0.6
```

## Naming Consistency Notes

- 記事やメモでは `DemoProperties`、`APIConfig`、`demo.api-config` の表記ずれに注意する
- Spring Boot の確認対象は `3.5.14` と `4.0.6`

## CI

- GitHub Actions で Spring Boot `3.5.14` / `4.0.6` と Java `17` / `21` / `25` の組み合わせをテストする
