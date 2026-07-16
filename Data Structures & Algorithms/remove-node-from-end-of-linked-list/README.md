# Remove Node From End of Linked List

| Field | Value |
|-------|-------|
| Topic | Linked List |
| Difficulty | Medium |
| Primary Pattern | Two Pointers (n-gap) |
| Secondary Pattern | — |
| Confidence | — |
| Last Revision | Never |

---

## Problem Summary

Given the head of a linked list and integer `n`, remove the n-th node from the **end** and return the head.

---

## Constraints (typical)

- `1 ≤ n ≤ list length`
- n is always valid

---

## Brute Force

Two passes: first count length `L`, then remove node at `L - n`. O(n) time, two passes.

---

## Core Observation

Two pointers with an `n`-node gap. Advance `first` by `n` steps. Then advance both until `first.next == null` — `second` is now at the node just before the target. Bypass the target.

---

## Thinking Process

1. `first = head`, `second = head`.
2. Advance `first` by `n` steps.
3. If `first == null` → the head must be removed → return `head.next`.
4. While `first.next != null`: advance both `first` and `second`.
5. `second.next = second.next.next`.
6. Return `head`.

---

## Why the Approach Works

The `n`-node gap ensures `second` reaches the predecessor of the n-th-from-end node exactly when `first` reaches the last node. The null check on `first` after the gap handles `n == list_length` (removing the head).

---

## Pattern Recognition

| Role | Pattern |
|------|---------|
| Primary | Two pointers with fixed gap |
| Application | One-pass O(n), no length computation |

### Pattern Recognition Clues

- "Find/remove n-th from end in one pass"
- Maintain exact gap between two pointers

Cross-ref: [Linked List](../Linked%20List/README.md)

---

## Alternative Approaches

Two-pass: compute length, then remove at `length - n`. O(n) same, simpler logic.

---

## Critical Implementation Details

- Advance `first` exactly `n` times (not `n-1`)
- `first == null` check after the gap loop handles removal of head (`n == length`)
- Stop when `first.next == null` (not `first == null`) — `second` must be one step before target

---

## Edge Cases

- Single node (`n = 1`) → return null (first becomes null, return `head.next`)
- Remove head (`n = list_length`) → handled by the `first == null` check
- Two-node list, remove last

---

## Common Mistakes

- Advancing `first` by `n-1` instead of `n` (off-by-one; `second` ends up at the target, not the predecessor)
- Not checking `first == null` after the gap (crash when removing head)
- `while(first != null)` instead of `while(first.next != null)` (overshoots by one)

---

## Complexity

| | |
|--|--|
| Time | O(n) — single pass |
| Space | O(1) |

---

## Similar Problems

- [reverse-linked-list-ii](../reverse-linked-list-ii/README.md) — also uses positioning with offsets
- [linked-list-cycle-detection](../linked-list-cycle-detection/README.md) — same fast/slow gap idea

---

## One-line Takeaway

**Gap of n between two pointers; stop when first.next == null; second is the predecessor of target.**

---

## Revision Checklist

- [ ] How many steps does `first` advance initially?
- [ ] What does `first == null` after the gap mean?
- [ ] Loop condition: `first.next != null` not `first != null`?

---

## Revision History

| Date | Note |
|------|------|
| — | Documented from `submission-2.java` |
