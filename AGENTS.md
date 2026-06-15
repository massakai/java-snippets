# Agent Guide

このファイルは、このリポジトリで作業する AI エージェント向けの入口です。
人間と AI の両方に適用する共通運用ルールは [docs/repository-guidelines.md](docs/repository-guidelines.md) を参照してください。

## Read Order

作業前に、次の順で前提を確認します。

1. この `AGENTS.md`
2. ルートの [README.md](README.md)
3. 貢献フローが関係する場合は [CONTRIBUTING.md](CONTRIBUTING.md)
4. 共通運用ルールの [docs/repository-guidelines.md](docs/repository-guidelines.md)
5. 変更対象サンプル配下の `README.md`
6. 変更対象サンプル配下の `AGENTS.md` があればそれも確認する

## Document Roles

- [README.md](README.md): リポジトリの入口
- [CONTRIBUTING.md](CONTRIBUTING.md): Issue / Pull Request / 検証の進め方
- [docs/repository-guidelines.md](docs/repository-guidelines.md): 命名、構成、CI などの共通方針
- サンプル配下の `README.md`: サンプルの目的、確認内容、実行方法
- サンプル配下の `AGENTS.md`: AI 向けの補助情報

## Sample AGENTS.md Minimal Template

サンプル配下の `AGENTS.md` には、原則として次の最小項目を置きます。

- `Purpose`
- `Test Focus`
- `Run Commands`
- `Naming Consistency Notes`

必要に応じて、次の項目を追加します。

- `Related Article`
- `CI`
- バージョン差分や確認対象を明示する補足

## Sub-agent Notes

- サブエージェントは常設担当として扱わず、必要時だけ起動する
- 単一サンプルの調査や修正では、そのサンプルだけを読む `sample-owner` 相当の役割で進める
- 横断タスクでは、サンプル固有の文脈と共通方針の整理を混ぜない
- サンプル固有の前提は会話履歴ではなく、各サンプル配下の `README.md` や `AGENTS.md` に残す
- サブエージェントに渡す作業範囲は、原則として単一サンプルまたは明確な横断確認に限定する
