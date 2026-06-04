# Spring Boot Test Application Runner Disable

`@SpringBootTest` で `ApplicationRunner` が起動してしまう問題を確認するサンプルです。

## 内容

- `ApplicationRunner` を `@ConditionalOnProperty` で制御する
- `@SpringBootTest(properties = "...")` で有効/無効を切り替える
- テストで runner の実行有無を `@MockitoBean` で確認する

## Run Tests

```bash
gradle test -PspringBootVersion=3.5.14
gradle test -PspringBootVersion=4.0.6
```
