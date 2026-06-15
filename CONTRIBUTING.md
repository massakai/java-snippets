# Contributing

このリポジトリへの Issue 作成や Pull Request 提出前に、まず [README.md](README.md) と [docs/repository-guidelines.md](docs/repository-guidelines.md) を確認してください。

## Before You Start

- 追加や変更の対象が既存サンプルか、新規サンプルかを明確にする
- 記事やメモと対応する変更では、クラス名、プロパティ名、ファイル名、実行コマンド、Spring Boot バージョンの表記ずれを避ける
- 作業開始前に `git fetch origin master` を実行し、最新の `origin/master` を基点に作業ブランチを切る
- `master` や detached HEAD では作業しない
- AI エージェント向けの補助指示が必要な場合は [AGENTS.md](AGENTS.md) も参照する

## Adding Or Updating Samples

- サンプルは目的が分かる英語の kebab-case ディレクトリに置く
- サンプル配下の `README.md` に、目的、確認できること、実行方法を書く
- ルート `README.md` にサンプル名と概要を追記する
- Gradle プロジェクトでは `gradle` ではなく `./gradlew` を使う
- YAML ファイルの拡張子は `.yaml` を使う

## Verification

- 変更したサンプル配下で `./gradlew test` を実行して確認する
- Spring Boot の複数バージョンを扱うサンプルでは、対象バージョンごとに確認する
- Pull Request 本文や作業結果には、実行した確認コマンドを残す
- 複数の Java や Spring Boot の組み合わせを確認した場合は、確認した組み合わせを明記する
- テスト以外の手動確認を行った場合も、確認内容と結果を残す
- テストを実行していない場合は、理由と未確認範囲を Pull Request に明記する
- CI 対象にしないサンプルは、README に理由と手動確認手順を書く

## Pull Requests

- サンプル固有の修正と、リポジトリ全体の運用や workflow の変更は原則として別 Pull Request に分ける
- Pull Request のタイトルと本文は原則として日本語で書く
- Pull Request のタイトルに `[codex]` は付けない
- Pull Request は原則 Draft で作成し、レビュー可能になった段階で Ready for review にする
- 本文には少なくとも `変更概要`、`背景`、`確認内容` を含める
- 大きめの方針変更やドキュメント再設計のように論点整理が必要な変更は、原則として事前に Issue を作成する
- Pull Request が関連する Issue を持つ場合は、本文に関連 Issue を記載する
- 既存の Pull Request に追加コミットを積んでスコープや確認内容が変わった場合は、本文も更新する
- Codex で作成した Pull Request には `codex` ラベルを付ける
- `gh` で Pull Request 本文を渡すときは、原則として `--body-file` を使う
- `gh pr create --draft` や `gh pr edit` の後は、Draft 状態や本文が意図どおりか確認する

## Issue Guidance

- 新しいサンプルの提案や検証テーマの追加は、テンプレートに沿って確認したい内容を具体的に記載する
- ドキュメントや運用ルールの見直しは、対象ドキュメント、困りごと、期待する完了条件を明記する
- テンプレートに当てはまらない相談は、必要に応じて通常の Issue を使ってよい
