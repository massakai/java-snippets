# Spring Boot Test Application Runner Disable Agent Notes

## Purpose

- `@SpringBootTest` 実行時に `ApplicationRunner` を条件付きで無効化する構成を確認する

## Test Focus

- `startup.import.enabled` の有効 / 無効で `ImportApplicationRunner` の動作が切り替わること
- `ImportService` の呼び出し有無をテストで確認できること
- Spring Boot 3.5.14 / 4.0.6 の両方でテストが通ること

## Run Commands

```bash
./gradlew test -PspringBootVersion=3.5.14
./gradlew test -PspringBootVersion=4.0.6
```

## Related Article

- 未整理。記事を追加したらここか `README.md` に追記する

## Naming Consistency Notes

- 記事やメモでは `ImportApplicationRunner`、`ImportService`、`startup.import.enabled` の表記ずれに注意する
- 有効 / 無効の両テストを `ImportApplicationRunnerEnabledTest` と `ImportApplicationRunnerDisabledTest` に対応付けて説明する

## CI

- `.github/workflows/spring-boot-test-application-runner-disable.yaml` で Java 17 / 21 / 25 と Spring Boot 3.5.14 / 4.0.6 を検証する
