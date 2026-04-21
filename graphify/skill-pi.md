---
name: graphify
description: Knowledge graph extraction and code navigation for any project
tools: bash, edit, read, write
trigger: /graphify
---

# /graphify

Turn any folder of files into a navigable knowledge graph with community detection, an honest audit trail, and three outputs: interactive HTML, GraphRAG-ready JSON, and a plain-language GRAPH_REPORT.md.

## Usage

```
graphify .                              # full pipeline on current directory
graphify --update                       # incremental - re-extract only new/changed files
graphify --watch                        # watch folder, auto-rebuild on code changes
graphify query "<question>"             # BFS traversal of the graph
graphify path "NodeA" "NodeB"           # shortest path between two concepts
graphify add <url> --author "Name"      # fetch URL and add to graph
```

## Rules

- Before answering architecture or codebase questions, **read** `graphify-out/GRAPH_REPORT.md` for god nodes and community structure.
- If `graphify-out/wiki/index.md` exists, **navigate it** instead of reading raw files.
- After modifying code files in this session, run `graphify update .` to keep the graph current (AST-only, no API cost).
- Treat `graphify-out/graph.json` as the canonical source of truth for codebase structure.

## What graphify gives you

1. **Persistent graph** – relationships survive across sessions.
2. **Honest audit trail** – every edge is tagged EXTRACTED, INFERRED, or AMBIGUOUS.
3. **Cross-document surprise** – community detection finds connections between files you'd never think to ask about.
