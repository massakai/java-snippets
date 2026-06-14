# Spring Boot Performance Stub Agent Notes

## Purpose

- 性能テスト用の遅延レスポンスを返すスタブ API の挙動を確認する

## Test Focus

- `StubController` のレスポンス内容
- `StubProperties` による遅延設定の反映
- Spring Boot 3.5.15 / 4.0.7 / 4.1.0 でテストが通ること

## Run Commands

```bash
./gradlew test -PspringBootVersion=3.5.15
./gradlew test -PspringBootVersion=4.0.7
./gradlew test -PspringBootVersion=4.1.0
```

## Related Article

- 未整理。記事を追加したらここか `README.md` に追記する

## Naming Consistency Notes

- 記事やメモでは `DelayPattern`、`StubController`、`StubProperties`、`StubResponse` の表記ずれに注意する
- Spring Boot バージョンは `3.5.15` / `4.0.7` / `4.1.0` を明記する

## CI

- `.github/workflows/spring-boot-performance-stub.yaml` で Java 17 / 21 / 25 と Spring Boot 3.5.15 / 4.0.7 / 4.1.0 を検証する
