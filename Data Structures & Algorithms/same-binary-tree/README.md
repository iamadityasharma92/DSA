# Same Binary Tree

| Field | Value |
|-------|-------|
| Topic | Trees |
| Difficulty | Easy |
| Primary Pattern | DFS |
| Secondary Pattern | Recursion |
| Confidence | — |
| Last Revision | Never |

---

## Problem Summary

Interview problem `same-binary-tree`. Documented from accepted Java submissions in this folder (best understanding across attempts).

---

## Core Observation

Structural equality requires matching values and identical subtree shapes.

---

## Thinking Process

1. Base null checks
2. Compare root.val
3. sameTree(left) and sameTree(right)
4. Short-circuit false

**Best understanding:** Both null true; one null false; vals equal and recurse left/right

---

## Why the Approach Works

Recursive decomposition checks local root then both subtrees.

---

## Pattern Recognition

| Role | Pattern |
|------|---------|
| Primary | DFS |
| Secondary | Recursion |

### Pattern Recognition Clues

- Identical tree structure and values
- Boolean equality

Cross-ref: topic hub · [PATTERNS.md](../../PATTERNS.md)

---

## Alternative Approaches

BFS queue pair-wise compare.

---

## Critical Implementation Details

- Null symmetry first
- Value compare after structure

---

## Edge Cases

- Both empty true
- Mirror shapes different values false

---

## Common Mistakes

- Only comparing values not structure
- Missing null asymmetry

---

## Complexity

| | |
|--|--|
| Time | O(n) |
| Space | O(h) |

---

## Similar Problems

- [subtree-of-a-binary-tree](../subtree-of-a-binary-tree/README.md)
- [invert-a-binary-tree](../invert-a-binary-tree/README.md)

---

## One-line Takeaway

**Same tree → null symmetry + val + both subtrees.**

---

## Revision Checklist

- [ ] null cases
- [ ] val and children

---

## Revision History

| Date | Note |
|------|------|
| — | Initial documentation from submission-0 |
