# Spring Boot Configuration Properties Agent Notes

## Purpose

- Spring Boot 3.5.x / 4.1.0 で `record` に `@ConfigurationProperties` を付けた設定バインドを確認する

## Test Focus

- `@ConfigurationPropertiesScan` で通常系の設定クラスが登録されること
- `@EnableConfigurationProperties` でも同じ `RecommendationProperties` を明示登録できること
- `Duration`、`URI`、ネストした `cache` / `retry` 設定が型付きで bind されること
- `@Validated` と Jakarta Bean Validation により、必須値・最小値・ネストした設定を検証できること

## Run Commands

```bash
./gradlew test -PspringBootVersion=3.5.15
./gradlew test -PspringBootVersion=4.1.0
./gradlew test -PspringBootVersion=4.1.0 -PjavaVersion=21
```

## Related Article

- 未整理。記事を追加したらここか `README.md` に追記する

## Naming Consistency Notes

- 記事やメモでは `RecommendationProperties`、`article.recommendation`、`@ConfigurationPropertiesScan`、`@EnableConfigurationProperties` の表記ずれに注意する
- 設定ファイルはリポジトリ規約に合わせて `application.yaml` を使う

## CI

- `.github/workflows/spring-boot-configuration-properties.yaml` で `-PjavaVersion` による Gradle toolchain 切り替えを使い、Java 17 / 21 / 25 と Spring Boot 3.5.15 / 4.1.0 を検証する
