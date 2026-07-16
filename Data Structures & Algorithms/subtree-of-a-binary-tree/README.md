# Subtree of a Binary Tree

| Field | Value |
|-------|-------|
| Topic | Trees |
| Difficulty | Easy |
| Primary Pattern | DFS |
| Secondary Pattern | Tree Matching |
| Confidence | — |
| Last Revision | Never |

---

## Problem Summary

Interview problem `subtree-of-a-binary-tree`. Documented from accepted Java submissions in this folder (best understanding across attempts).

---

## Core Observation

Subtree match requires identical structure at some node covering all sub nodes.

---

## Thinking Process

1. If root null false
2. If sameTree(root,subRoot) true
3. Search left or right subtree
4. Combine with OR

**Best understanding:** DFS root; at each node if sameTree(node, subRoot) return true

---

## Why the Approach Works

Every node is candidate root for subtree equality check.

---

## Pattern Recognition

| Role | Pattern |
|------|---------|
| Primary | DFS |
| Secondary | Tree Matching |

### Pattern Recognition Clues

- Contains subtree copy
- Not merely same values

Cross-ref: topic hub · [PATTERNS.md](../../PATTERNS.md)

---

## Alternative Approaches

Serialize and substring—possible but heavier.

---

## Critical Implementation Details

- sameTree handles null symmetry
- Subtree must include all descendants

---

## Edge Cases

- subRoot null true
- Single node match

---

## Common Mistakes

- Confusing subtree with subpath
- Not checking both children equal

---

## Complexity

| | |
|--|--|
| Time | O(mn) |
| Space | O(h) |

---

## Similar Problems

- [same-binary-tree](../same-binary-tree/README.md)
- [invert-a-binary-tree](../invert-a-binary-tree/README.md)

---

## One-line Takeaway

**Subtree check → DFS + sameTree at each node.**

---

## Revision Checklist

- [ ] sameTree helper
- [ ] OR children

---

## Revision History

| Date | Note |
|------|------|
| — | Initial documentation from submission-0 |
