# Same Binary Tree

| Field | Value                     |
|-------|---------------------------|
| Topic | Trees                     |
| Difficulty | Easy                      |
| Primary Pattern | DFS structural comparison |
| Secondary Pattern | —                         |
| Confidence | HIGH                      |
| Last Revision | 17/7/2026                 |

---

## Problem Summary

Given the roots of two binary trees `p` and `q`, return `true` if they are structurally identical with the same node values, `false` otherwise.

---

## Constraints (typical)

- `0 ≤ n ≤ 100`
- Values fit in int

---

## Brute Force

No meaningful brute force — recursive DFS is both the simplest and optimal approach.

---

## Core Observation

Two trees are the same if: both null (base case, same), or one null/values differ (false), or current values match AND left subtrees match AND right subtrees match.

---

## Thinking Process

1. `if p == null && q == null` → `true`
2. `if p == null || q == null || p.val != q.val` → `false`
3. `return isSameTree(p.left, q.left) && isSameTree(p.right, q.right)`

---

## Why the Approach Works

Structural equality requires matching at every position. The recursive calls cover every node pair simultaneously. `&&` short-circuits on first mismatch — efficient.

---

## Pattern Recognition

| Role | Pattern |
|------|---------|
| Primary | Pre-order structural DFS (check current, then recurse) |
| Related | subtree-of-a-binary-tree uses this as a subroutine |

### Pattern Recognition Clues

- "Are two trees identical?"
- Subroutine for subtree check

Cross-ref: [Trees](../Trees/README.md)

---

## Alternative Approaches

Serialize both trees to strings and compare — O(n) but O(n) extra space. Less efficient.

**BFS (level order):** use queues to compare level by level. O(n) same.

---

## Critical Implementation Details

- Null-null check returns `true` first — base case
- Order of conditions in the `if false` case: null-null handled already; `||` catches single null or value mismatch
- `&&` is critical (not `||`) — both subtrees must match

---

## Edge Cases

- Both empty → `true`
- One empty, one non-empty → `false`
- Same structure, different values → `false`
- Same values, different structure → `false`

---

## Common Mistakes

- Checking `p.val != q.val` before the null checks → NPE
- Using `||` in the recursive call (only one subtree matching is not sufficient)

---

## Complexity

| | |
|--|--|
| Time | O(n) |
| Space | O(h) recursion stack |

---

## Similar Problems

- [subtree-of-a-binary-tree](../subtree-of-a-binary-tree/README.md) — calls `isSameTree` as a helper
- [invert-a-binary-tree](../invert-a-binary-tree/README.md) — similar DFS structure

---

## One-line Takeaway

**null-null → true; null mismatch or val mismatch → false; AND of left-same AND right-same.**

---

## Revision Checklist

- [ ] Base case order: null-null check first?
- [ ] `&&` in recursive call (both subtrees must match)?
- [ ] How is this used in subtree-of-a-binary-tree?

---

## Revision History

| Date | Note |
|------|------|
| — | Documented from `submission-0.java` |
