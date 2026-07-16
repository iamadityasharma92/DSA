# Depth of Binary Tree

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

Interview problem `depth-of-binary-tree`. Documented from accepted Java submissions in this folder (best understanding across attempts).

---

## Core Observation

Height is one plus the deeper subtree.

---

## Thinking Process

1. Base null → 0
2. Recurse both children
3. Return 1 + max
4. Single node depth 1

**Best understanding:** return 1 + max(depth(left), depth(right)); null → 0

---

## Why the Approach Works

Longest root-to-leaf path dominates height.

---

## Pattern Recognition

| Role | Pattern |
|------|---------|
| Primary | DFS |
| Secondary | BFS |

### Pattern Recognition Clues

- Maximum depth/height
- Tree metric

Cross-ref: topic hub · [PATTERNS.md](../../PATTERNS.md)

---

## Alternative Approaches

BFS level count.

---

## Critical Implementation Details

- +1 per node level
- Null before recurse

---

## Edge Cases

- Empty tree
- Skewed chain depth n

---

## Common Mistakes

- Count edges not nodes
- Missing +1

---

## Complexity

| | |
|--|--|
| Time | O(n) |
| Space | O(h) |

---

## Similar Problems

- [same-binary-tree](../same-binary-tree/README.md)
- [invert-a-binary-tree](../invert-a-binary-tree/README.md)

---

## One-line Takeaway

**Tree depth = 1 + max(left,right), base null=0.**

---

## Revision Checklist

- [ ] Null returns 0
- [ ] +1 each node

---

## Revision History

| Date | Note |
|------|------|
| — | Initial documentation from submission-0 |
