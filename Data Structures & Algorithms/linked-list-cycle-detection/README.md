# Linked List Cycle Detection

| Field | Value |
|-------|-------|
| Topic | Linked List |
| Difficulty | Easy |
| Primary Pattern | Floyd's Cycle Detection (fast/slow) |
| Secondary Pattern | — |
| Confidence | — |
| Last Revision | Never |

---

## Problem Summary

Given the head of a linked list, return `true` if there is a cycle (some node's `next` points back to a previous node), `false` otherwise.

---

## Constraints (typical)

- `0 ≤ n ≤ 10⁴`
- Must be O(1) extra space

---

## Brute Force

HashSet of visited nodes — O(n) time but O(n) space. Violates the O(1) space constraint.

---

## Core Observation

A fast pointer (2 steps) and a slow pointer (1 step): if there is a cycle, the fast pointer laps the slow pointer inside the cycle and they meet. If no cycle, the fast pointer reaches `null`.

---

## Thinking Process

1. `slow = head`, `fast = head`.
2. While `fast.next != null && fast.next.next != null`:
   - `slow = slow.next`
   - `fast = fast.next.next`
   - If `slow == fast` → return `true`.
3. Return `false`.

---

## Why the Approach Works

In a cyclic list, the fast pointer gains one position on the slow pointer per step inside the cycle. Since the cycle is finite, they must eventually be at the same position. In an acyclic list, fast reaches `null` first.

---

## Pattern Recognition

| Role | Pattern |
|------|---------|
| Primary | Floyd's detect-only (phase 1 of full algorithm) |
| Extended | Phase 2 (find cycle entry) used in find-duplicate-integer |

### Pattern Recognition Clues

- "Cycle in linked list"
- O(1) space constraint → rules out HashSet

Cross-ref: [Linked List](../Linked%20List/README.md) · [PATTERNS.md](../../PATTERNS.md#floyd-cycle-fast--slow)

---

## Alternative Approaches

**HashSet:** add each node; on revisit → cycle. O(n) space — violates constraint but simpler to code.

---

## Critical Implementation Details

- Guard: `fast.next != null && fast.next.next != null` — check both before taking two steps
- Both pointers start at `head` (not `head.next`)
- Null `head` → return `false` immediately (or guard fails safely)

---

## Edge Cases

- Empty list → `false`
- Single node pointing to itself → cycle
- Two nodes with cycle
- Very long list, cycle far from head

---

## Common Mistakes

- Checking only `fast != null` (then `fast.next.next` can NPE)
- Starting `fast` at `head.next` (misses some cycle configurations or wastes a step)
- Using `==` on Integer wrapper values (fine for node references, but Integer cache only goes to 127)

---

## Complexity

| | |
|--|--|
| Time | O(n) |
| Space | O(1) |

---

## Similar Problems

- [find-duplicate-integer](../find-duplicate-integer/README.md) — Floyd full algorithm (detect + find entry)
- [reorder-linked-list](../reorder-linked-list/README.md) — also uses slow/fast for midpoint

---

## One-line Takeaway

**Fast (×2) and slow (×1): they meet iff there's a cycle; guard both next steps.**

---

## Revision Checklist

- [ ] Guard condition: why `fast.next != null && fast.next.next != null`?
- [ ] Where do both pointers start?
- [ ] Contrast detect-only vs find-entry (2-phase Floyd)?

---

## Revision History

| Date | Note |
|------|------|
| — | Documented from `submission-2.java` |
