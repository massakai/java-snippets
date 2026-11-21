# Spring Boot Configuration Properties

Spring Boot 4.0.10 / 4.1.3 / 4.2.0 で、`@ConfigurationProperties` を付けた `record` に YAML の設定値を bind する最小サンプルです。

## What This Sample Verifies

- `article.recommendation` 配下の複数プロパティを `RecommendationProperties` にまとめて bind できる
- `URI`、`Duration`、`int`、`boolean` などの型付きプロパティを扱える
- `cache` と `retry` のようなネストした設定を `record` の入れ子で表現できる
- `@Validated` と Bean Validation により、必須値と最小値をバインド時に検証できる
- 親 record の `@Valid` により、`cache` / `retry` 内の制約も cascade validation できる
- 通常系では `@ConfigurationPropertiesScan` で設定クラスを検出できる
- 補足として `@EnableConfigurationProperties(RecommendationProperties.class)` でも明示登録できる
- `spring-boot-configuration-processor` により、コンパイル時に IDE 補完用 metadata を生成できる

## Main Code

```java
@SpringBootApplication
@ConfigurationPropertiesScan
public class ConfigurationPropertiesSampleApplication {
}
```

```java
@Validated
@ConfigurationProperties("article.recommendation")
public record RecommendationProperties(
        @NotNull URI endpoint,
        @Min(1) int pageSize,
        @NotNull Duration timeout,
        @NotNull @Valid Cache cache,
        @NotNull @Valid Retry retry) {

    public record Cache(boolean enabled, @NotNull Duration ttl, @Min(1) int maxEntries) {
    }

    public record Retry(@Min(1) int maxAttempts, @NotNull Duration initialInterval) {
    }
}
```

`spring-boot-starter-validation` を依存関係に追加しています。制約アノテーションは
`jakarta.validation` パッケージを使います。

`@EnableConfigurationProperties` で明示登録したい場合は、次のようにも書けます。

```java
@Configuration(proxyBeanMethods = false)
@EnableConfigurationProperties(RecommendationProperties.class)
class PropertiesConfig {
}
```

## Configuration

このリポジトリの規約に合わせて設定ファイルは `application.yaml` を使います。

```yaml
article:
  recommendation:
    endpoint: https://example.internal/recommendations
    page-size: 20
    timeout: 750ms
    cache:
      enabled: true
      ttl: 5m
      max-entries: 1000
    retry:
      max-attempts: 3
      initial-interval: 200ms
```

## Run Tests

```bash
./gradlew test
./gradlew test -PspringBootVersion=4.0.10
./gradlew test -PspringBootVersion=4.1.3
./gradlew test -PspringBootVersion=4.2.0
./gradlew test -PspringBootVersion=4.0.10 -PjavaVersion=21
./gradlew test -PspringBootVersion=4.1.3 -PjavaVersion=21
./gradlew test -PspringBootVersion=4.2.0 -PjavaVersion=21
```

## Verified Matrix

ローカルと GitHub Actions では、Java 17 / 21 / 25 と Spring Boot 4.0.10 / 4.1.3 / 4.2.0 の全9通りを検証します。
`-PjavaVersion` で Gradle toolchain を切り替えます。

## Notes

- このサンプルでは repository 単体で検証できるように、Gradle 設定、`application.yaml`、自動テスト、CI workflow を含めています。
- validation 違反時には `ConfigurationPropertiesBindException` の原因として `BindValidationException` が出て、対象 field と制約コードを確認できます。制約メッセージは実行ロケールにより変わるため、テストではメッセージ本文ではなく field と制約コードを検証しています。
- `@Value` は単発の値を読むには手軽ですが、関連する複数設定やネスト構造を扱うと、キー文字列が分散しやすく型のまとまりも見えにくくなります。
- `@ConfigurationProperties` なら prefix ごとに設定をまとめられ、`Duration` や `URI` などへの変換、ネストした構造、IDE 補完用 metadata と相性が良いです。
- `record` の単一コンストラクタは Spring Boot 4.0.10 / 4.1.3 / 4.2.0 では `@ConstructorBinding` なしで bind できます。
- 補完用 metadata は `./gradlew compileJava` 後に `build/classes/java/main/META-INF/spring-configuration-metadata.json` に生成されます。

## Pitfalls

- `@ConfigurationProperties` を付けただけでは Bean 登録されません。通常は `@ConfigurationPropertiesScan`、個別登録なら `@EnableConfigurationProperties` を使います。
- YAML の kebab-case キー、たとえば `page-size` や `initial-interval` は Java record component の `pageSize` / `initialInterval` に relaxed binding されます。
- `@ConfigurationProperties` の validation にはクラス側の `@Validated` が必要です。制約を付けるだけでは起動時 validation は有効になりません。
- ネストした object 内の制約は、親 component に `@Valid` がないと cascade validation されません。ネスト object 自体を必須にする場合は `@NotNull` も併記します。
- `int` のような primitive は未設定時に `0` になるため、必須かつ正の値なら `@Min(1)` を付けます。未設定と `0` を区別したい場合は `Integer` を使います。
