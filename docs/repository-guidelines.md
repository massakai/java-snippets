# Repository Guidelines

このドキュメントは、このリポジトリで作業する人間と AI の両方に適用する共通運用ルールです。

## Repository Role

- 各サブディレクトリを独立したサンプルプロジェクトとして扱う
- ブログ記事や技術メモで参照する検証済みコードを置く
- 1つのサンプルでは、確認したい挙動が読み取りやすい最小構成を優先する

## Documentation Responsibilities

- ドキュメントの役割分担は、ルートの `README.md`、`CONTRIBUTING.md`、`AGENTS.md` を入口として使い分ける
- 記事から参照されるコードは、本文とクラス名、プロパティ名、ファイル名がずれないようにする
- ブログ記事用の検証であっても、リポジトリ単体で意図が分かる説明を残す

## Sample Layout

- サンプルは目的が分かる英語の kebab-case ディレクトリに置く
- Java パッケージは原則 `com.github.massakai.snippets` 配下に置く
- サンプル名が分かる短いサブパッケージ名を使う
- 検証目的に直接関係しない依存関係や設定は追加しない
- 依存関係を追加した場合は、サンプル README に目的を簡潔に記載する

## Spring Boot Samples

- Gradle プロジェクトには Gradle wrapper を置き、原則として `gradle` ではなく `./gradlew` で実行する
- Gradle wrapper のバージョンは原則 9.5.1 に揃え、変更する場合は README や workflow に理由を残す
- 設定ファイルの YAML 拡張子は `.yaml` に統一する
- `application.yml` や workflow の `.yml` は使わず、`.yaml` を使う
- Spring Boot のバージョン差を確認する場合は、Gradle プロパティや README に検証対象を明記する
- テストで挙動を示せる場合は、できるだけ自動テストとして残す

## Testing And CI

- 実行手順や確認内容は `CONTRIBUTING.md` と各サンプルの README に従う
- サンプルを追加したら、必要に応じて `.github/workflows/*.yaml` にテスト実行を追加する
- workflow ファイル名も `.yaml` を使う
- CI で確認している Java、Gradle、Spring Boot のバージョンは README または記事側で参照できるようにする
- Pull Request の検証は原則として `pull_request` イベントで行う
- `push` イベントでの実行は原則として `master` への push のみに限定する
- `push` と `pull_request` を併用する workflow では、同一コミットへの重複実行がないか確認する
- matrix を追加・変更する場合は、実行数と所要時間が過剰にならないか見積もる

## Git Baseline

- ブランチ戦略は GitHub Flow とし、`master` をデフォルトブランチとして扱う
- 作業は最新の `origin/master` を基点に作業ブランチを作って始める
- ローカル `master` はリモート取り込み専用とし、直接コミットしない
- デフォルトブランチへの直接 push は行わず、必ず Pull Request 経由で取り込む
- 一時退避のために `git stash` を使った場合は、作業終了時に残存がないか確認する

## Pull Request Scope

- サンプルの内容に関する修正は、原則として対象サンプルごとに Pull Request を分ける
- リポジトリ全体の共通方針に関する変更は、同じ意図の変更であれば 1 つの Pull Request にまとめてよい
- ただし、サンプル固有の修正とリポジトリ全体の方針変更は原則として同じ Pull Request に混在させない
- 実装変更と、その変更内容を検証するテストの追加・更新は、原則として同一コミットに含める

## Editing Notes

- 既存サンプルの目的と無関係な整形や大規模な並べ替えは避ける
- 生成物、IDE 設定、OS 由来のファイルはコミットしない
- 既存の未追跡ファイルや変更は、依頼内容と無関係なら触らない
- サンプルコードは説明のための簡潔さを優先しつつ、テストで実際に動く状態を保つ
