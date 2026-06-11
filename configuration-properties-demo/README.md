# Configuration Properties Demo

Spring Boot 2.4.4 で `@ConfigurationProperties` を使ったネストした設定値のバインドを確認するサンプルです。

## What This Sample Verifies

- `demo.hogeApiConfig` と `demo.fugaApiConfig` を `DemoProperties` にバインドできる
- `Duration` を含む設定値を型安全に扱える
- テストでプロパティ値の読み取り結果を確認できる

## Run Tests

```bash
./gradlew test
```

## Notes

- Spring Boot バージョンは `build.gradle` で `2.4.4` に固定しています
- GitHub Actions は未設定です。必要になったら workflow を追加してください
