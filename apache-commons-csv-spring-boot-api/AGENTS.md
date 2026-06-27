# Apache Commons CSV Spring Boot API Agent Notes

## Purpose

- Spring Boot + Apache Commons CSV で CSV export/import API の最小実装を確認する

## Test Focus

- `GET /categories/export` がヘッダー付き CSV を `text/csv` として返すこと
- `POST /categories/import` が multipart CSV をパースし、正常行とバリデーションエラーを返すこと
- `id` は正の整数、`name` は空文字不可として扱うこと
- Spring Boot 3.5.14 / 4.0.6 / 4.1.0 でテストが通ること

## Run Commands

```bash
./gradlew test -PspringBootVersion=3.5.14
./gradlew test -PspringBootVersion=4.0.6
./gradlew test -PspringBootVersion=4.1.0
```

## Related Article

- 未整理。記事を追加したらここか `README.md` に追記する

## Naming Consistency Notes

- 記事やメモでは `CategoryController`、`CategoryCsvService`、`CategoryImportResponse`、`CsvImportError` の表記ずれに注意する
- API パスは `/categories/export` と `/categories/import` に統一する
- CSV ヘッダーは `id,name,description` に統一する
- Spring Boot バージョンは `3.5.14`、`4.0.6`、`4.1.0` を明記する

## CI

- `.github/workflows/apache-commons-csv-spring-boot-api.yaml` で Java 17 / 21 / 25 と Spring Boot 3.5.14 / 4.0.6 / 4.1.0 を検証する
