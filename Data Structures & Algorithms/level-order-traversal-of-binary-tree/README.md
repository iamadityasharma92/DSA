# Level Order Traversal of Binary Tree

| Field | Value |
|-------|-------|
| Topic | Trees |
| Difficulty | Medium |
| Primary Pattern | BFS |
| Secondary Pattern | Queue |
| Confidence | — |
| Last Revision | Never |

---

## Problem Summary

Interview problem `level-order-traversal-of-binary-tree`. Documented from accepted Java submissions in this folder (best understanding across attempts).

---

## Core Observation

FIFO queue visits nodes layer by layer left to right.

---

## Thinking Process

1. Enqueue root
2. While queue: process level count nodes
3. Poll, add val, enqueue children
4. Append level to answer

**Best understanding:** Queue BFS; process level size snapshots into result list

---

## Why the Approach Works

Queue ordering naturally groups nodes by depth when level size tracked.

---

## Pattern Recognition

| Role | Pattern |
|------|---------|
| Primary | BFS |
| Secondary | Queue |

### Pattern Recognition Clues

- Return levels or flat order
- Tree layer traversal

Cross-ref: topic hub · [PATTERNS.md](../../PATTERNS.md)

---

## Alternative Approaches

DFS with depth map—less natural.

---

## Critical Implementation Details

- Snapshot queue size per level
- Skip null root

---

## Edge Cases

- Single node
- Skewed tree still BFS

---

## Common Mistakes

- Not fixing level boundary
- Null children enqueued

---

## Complexity

| | |
|--|--|
| Time | O(n) |
| Space | O(n) |

---

## Similar Problems

- [depth-of-binary-tree](../depth-of-binary-tree/README.md)
- [invert-a-binary-tree](../invert-a-binary-tree/README.md)

---

## One-line Takeaway

**Level order → BFS queue with per-level size loop.**

---

## Revision Checklist

- [ ] Queue BFS
- [ ] Level size snapshot

---

## Revision History

| Date | Note |
|------|------|
| — | Initial documentation from submission-1 |
