# Invert a Binary Tree

| Field | Value |
|-------|-------|
| Topic | Trees |
| Difficulty | Easy |
| Primary Pattern | DFS |
| Secondary Pattern | BFS |
| Confidence | — |
| Last Revision | Never |

---

## Problem Summary

Interview problem `invert-a-binary-tree`. Documented from accepted Java submissions in this folder (best understanding across attempts).

---

## Core Observation

Mirror tree by swapping children at every node.

---

## Thinking Process

1. Base null return
2. Swap root.left and root.right
3. Recurse inverted subtrees
4. Return root

**Best understanding:** Swap left/right at each node recursively or queue BFS

---

## Why the Approach Works

Local swap at all nodes produces global mirror.

---

## Pattern Recognition

| Role | Pattern |
|------|---------|
| Primary | DFS |
| Secondary | BFS |

### Pattern Recognition Clues

- Mirror/invert binary tree
- Swap children

Cross-ref: topic hub · [PATTERNS.md](../../PATTERNS.md)

---

## Alternative Approaches

Iterative stack same swaps.

---

## Critical Implementation Details

- Swap before or after recurse both fine
- Handle null

---

## Edge Cases

- Empty tree
- Single node

---

## Common Mistakes

- Only swapping root
- Losing child references

---

## Complexity

| | |
|--|--|
| Time | O(n) |
| Space | O(h) |

---

## Similar Problems

- [same-binary-tree](../same-binary-tree/README.md)
- [depth-of-binary-tree](../depth-of-binary-tree/README.md)

---

## One-line Takeaway

**Invert tree → swap children at every node DFS/BFS.**

---

## Revision Checklist

- [ ] Swap left right
- [ ] Recurse both

---

## Revision History

| Date | Note |
|------|------|
| — | Initial documentation from submission-0 |
