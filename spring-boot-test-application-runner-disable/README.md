# Spring Boot Test Application Runner Disable

`@SpringBootTest` で `ApplicationRunner` が起動してしまう問題を確認するサンプルです。

## 内容

- 起動時処理の有効/無効を `startup.import.enabled` で切り替える
- `ApplicationRunner` を `@ConditionalOnProperty` で制御する
- `@SpringBootTest(properties = "...")` で有効/無効を切り替える
- テストで runner の実行有無を `@MockitoBean` で確認する

## Run Tests

```bash
./gradlew test -PspringBootVersion=3.5.14
./gradlew test -PspringBootVersion=4.0.6
```
