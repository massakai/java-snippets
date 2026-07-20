# Sample Guide

## Purpose

Mockito `ArgumentCaptor` による、リポジトリへ渡す `User` の検証を示す最小サンプルです。

## Test Focus

- `verify` と `ArgumentCaptor.capture()` により `save(User)` の引数を取得する
- `getValue()` で 1 回の保存内容を検証する
- `times(2)` と `getAllValues()` で複数回の保存内容と順序を検証する

## Run Commands

```sh
./gradlew test
./gradlew check -PjavaVersion=17
./gradlew check -PjavaVersion=21
./gradlew check -PjavaVersion=25
```

## Naming Consistency Notes

- パッケージは `com.github.massakai.snippets.argumentcaptor` を使う
- テスト名は検証する振る舞いが分かる英語の lower camel case にする
