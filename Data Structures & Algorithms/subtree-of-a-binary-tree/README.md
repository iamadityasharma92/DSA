# Subtree of a Binary Tree

| Field | Value                            |
|-------|----------------------------------|
| Topic | Trees                            |
| Difficulty | Easy                             |
| Primary Pattern | DFS with `isSameTree` subroutine |
| Secondary Pattern | —                                |
| Confidence | HIGH                             |
| Last Revision | 17/6/2026                        |

---

## Problem Summary

Given roots of two trees `root` and `subRoot`, return `true` if `subRoot` is a subtree of `root` — i.e., some node in `root`'s tree has a subtree identical to `subRoot`.

---

## Constraints (typical)

- `1 ≤ root.length ≤ 2000`
- `1 ≤ subRoot.length ≤ 1000`

---

## Brute Force

For each node in `root`, check `isSameTree(node, subRoot)` → O(m × n). This IS the approach — it's the intended solution.

---

## Core Observation

Decompose into two problems:
1. `isSameTree(p, q)` — are two trees identical?
2. `isSubtree(root, subRoot)` — recursively check each node of `root`

---

## Thinking Process

1. Base: `root == null` → `false` (no node left to check).
2. If `isSameTree(root, subRoot)` → `true` (found a match at current node).
3. Else recurse: `isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot)`.

---

## Why the Approach Works

Every node is a potential root of a matching subtree. The recursive DFS visits all nodes. `isSameTree` runs on each candidate node — O(n) per call × O(m) nodes = O(m × n) total.

---

## Pattern Recognition

| Role | Pattern |
|------|---------|
| Primary | DFS + same-tree subroutine |
| Optimization | String serialization + KMP/rolling hash → O(m + n) |

### Pattern Recognition Clues

- "Is subRoot somewhere in root's tree?"
- Reuse `isSameTree` as a building block

Cross-ref: [Trees](../Trees/README.md)

---

## Alternative Approaches

**Serialization:** serialize both trees (pre-order with null markers) → check if `subSerial` is a substring of `rootSerial` using KMP → O(m + n). More complex.

---

## Critical Implementation Details

- `root == null` check before `isSameTree` prevents NPE
- `||` short-circuits: if left subtree match found, don't check right
- `isSameTree` must handle null-null (true), one-null (false), and value mismatch (false)

---

## Edge Cases

- `subRoot` is a single leaf
- `subRoot` is the entire root
- `root` has duplicate subtrees — any match returns `true`
- `subRoot` has same structure but different values

---

## Common Mistakes

- Checking `root.val == subRoot.val` as the only condition (ignores structural match)
- Using `&&` instead of `||` for the left/right recursive calls (requires match in BOTH subtrees)

---

## Complexity

| | |
|--|--|
| Time | O(m × n) — m nodes × isSameTree O(n) |
| Space | O(h_root) recursion |

---

## Similar Problems

- [same-binary-tree](../same-binary-tree/README.md) — the subroutine used here

---

## One-line Takeaway

**DFS every node as a candidate root; call `isSameTree(node, subRoot)` at each.**

---

## Revision Checklist

- [ ] Base case: `root == null` → false (not null == null)?
- [ ] Short-circuit `||` in the recursive call?
- [ ] `isSameTree` as a separate subroutine?

---

## Revision History

| Date | Note |
|------|------|
| — | Documented from `submission-0.java` |
