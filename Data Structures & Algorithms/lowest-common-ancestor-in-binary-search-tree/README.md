# Lowest Common Ancestor in Binary Search Tree

| Field | Value |
|-------|-------|
| Topic | Trees |
| Difficulty | Medium |
| Primary Pattern | BST Property |
| Secondary Pattern | Recursion |
| Confidence | — |
| Last Revision | Never |

---

## Problem Summary

Interview problem `lowest-common-ancestor-in-binary-search-tree`. Documented from accepted Java submissions in this folder (best understanding across attempts).

---

## Core Observation

First node where p and q diverge to different subtrees is LCA.

---

## Thinking Process

1. If p,q < root → left
2. If p,q > root → right
3. Otherwise return root
4. Iterative or recursive

**Best understanding:** Walk from root: both < root go left; both > go right; else current is LCA

---

## Why the Approach Works

BST ordering localizes split point without full tree search.

---

## Pattern Recognition

| Role | Pattern |
|------|---------|
| Primary | BST Property |
| Secondary | Recursion |

### Pattern Recognition Clues

- BST not generic tree
- Two node values given

Cross-ref: topic hub · [PATTERNS.md](../../PATTERNS.md)

---

## Alternative Approaches

Generic LCA DFS—works but ignores BST.

---

## Critical Implementation Details

- Use values not reference equality if nodes given
- Return when split occurs

---

## Edge Cases

- One ancestor of other
- Root is LCA

---

## Common Mistakes

- Treating as general binary tree
- Wrong direction on equal

---

## Complexity

| | |
|--|--|
| Time | O(h) |
| Space | O(1) iterative |

---

## Similar Problems

- [insert-into-a-binary-search-tree](../insert-into-a-binary-search-tree/README.md)
- [delete-node-in-a-bst](../delete-node-in-a-bst/README.md)

---

## One-line Takeaway

**BST LCA → walk until values split subtrees.**

---

## Revision Checklist

- [ ] Compare both to root
- [ ] Split → return root

---

## Revision History

| Date | Note |
|------|------|
| — | Initial documentation from submission-2 |
