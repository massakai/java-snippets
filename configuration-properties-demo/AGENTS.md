# Configuration Properties Demo Agent Notes

## Purpose

- Spring Boot 2.4.4 の `@ConfigurationProperties` バインド挙動を確認する

## Test Focus

- `DemoProperties` に `hogeApiConfig` と `fugaApiConfig` が正しく束縛されること
- `connectionTimeout` と `readTimeout` が `Duration` として読めること

## Run Commands

```bash
./gradlew test
```

## Related Article

- 未整理。記事を追加したらここか `README.md` に追記する

## Naming Consistency Notes

- 記事やメモでは `DemoProperties`、`APIConfig`、`demo.hogeApiConfig`、`demo.fugaApiConfig` の表記ずれに注意する
- Spring Boot バージョンは `2.4.4` 固定として扱う

## CI

- 現時点では GitHub Actions の対象外
