# Balanced Binary Tree

| Field | Value |
|-------|-------|
| Topic | Trees |
| Difficulty | Easy |
| Primary Pattern | Tree DFS (post-order) |
| Secondary Pattern | Height + balance check |
| Confidence | — |
| Last Revision | Never |

---

## Problem Summary

Return whether a binary tree is height-balanced: for **every** node, `|height(left) − height(right)| ≤ 1`.

---

## Constraints (typical)

- Empty tree is balanced
- Must hold at all nodes, not only the root

---

## Brute Force

For every node, compute left/right heights with separate recursions → O(n²).

---

## Core Observation

One post-order DFS can **return height** and **detect imbalance** while unwinding — O(n).

If any node has height diff > 1, the whole tree fails.

---

## Thinking Process

1. DFS returns height of subtree (`0` for null).
2. After children: if `|L − R| > 1`, mark unbalanced (flag or sentinel).
3. Return `1 + max(L, R)`.
4. Root API returns whether any imbalance was seen.

(`submission-1` / `submission-2` use a counter/flag `d`; equivalent to a boolean.)

---

## Why the Approach Works

Height of a node needs both child heights first → post-order. Checking balance at each node during that pass covers the definition exactly once per node.

---

## Pattern Recognition

| Role | Pattern |
|------|---------|
| Primary | DFS post-order combining child results |
| Alternative | Return `-1` sentinel for “unbalanced” to prune early |

See: [Trees](../Trees/README.md), [PATTERNS.md](../../PATTERNS.md#tree-dfs--aggregate-up).

---

## Alternative Approaches

| Approach | Notes |
|----------|-------|
| Flag + height return | Used here; simple |
| Sentinel `-1` | Can short-circuit remaining work |
| Top-down height calls | Correct but O(n²) |

Final understanding: **single DFS; check |L−R| at every node while computing height**.

---

## Critical Implementation Details

- Null height = 0
- Check **every** node, not only root
- Flag must be visible after DFS (field or array/holder)

---

## Edge Cases

- Empty tree → true
- Single node → true
- Skewed chain → false for depth ≥ 2 imbalance patterns
- Balanced heights but deep tree → still true if diffs ≤ 1 everywhere

---

## Common Mistakes

- Only checking the root’s children
- Confusing diameter problem with balance
- Returning early without combining both sides’ heights correctly

---

## Complexity

| | |
|--|--|
| Time | O(n) |
| Space | O(h) recursion |

---

## Similar Problems

- [depth-of-binary-tree](../depth-of-binary-tree/README.md) — height only
- [binary-tree-diameter](../binary-tree-diameter/README.md) — same DFS shape, different aggregate
- [same-binary-tree](../same-binary-tree/README.md) — structural DFS

---

## One-line Takeaway

**Post-order: compute height and verify |L−R| ≤ 1 at every node in one pass.**

---

## Revision Checklist

- [ ] Why post-order?
- [ ] Difference vs diameter DFS?
- [ ] Can I write the `-1` sentinel variant?

---

## Revision History

| Date | Note |
|------|------|
| — | Documented from `submission-1.java` / `submission-2.java` (same approach) |
