# Sort Colors (Dutch National Flag)

| Field | Value |
|-------|-------|
| Topic | Two Pointers |
| Difficulty | Medium |
| Primary Pattern | Three-way partition (Dutch National Flag) |
| Secondary Pattern | — |
| Confidence | — |
| Last Revision | Never |

---

## Problem Summary

Sort an array containing only `0`, `1`, and `2` in-place such that 0s come first, then 1s, then 2s. Must be O(n) with O(1) space.

---

## Constraints (typical)

- Values only 0, 1, 2
- In-place, O(1) extra space
- Single pass preferred

---

## Brute Force

Count each value, overwrite array — O(n) time, two passes. Valid but not the intended one-pass approach.

---

## Core Observation

**Dutch National Flag:** three pointers `l`, `r`, `i`. `l` = next write position for 0; `r` = next write position for 2; `i` = current scanner.
- `nums[i] == 0` → swap with `nums[l]`, `l++`, `i++`
- `nums[i] == 2` → swap with `nums[r]`, `r--` (**don't increment `i`** — new element at `i` is unknown)
- `nums[i] == 1` → `i++`

---

## Thinking Process

1. `l = 0`, `r = n-1`, `i = 0`.
2. While `i <= r`:
   - 0: `swap(i, l)`, `l++`, `i++`
   - 2: `swap(i, r)`, `r--` (no `i++`)
   - 1: `i++`

---

## Why the Approach Works

- Elements in `[0, l)` are all 0s.
- Elements in `(r, n-1]` are all 2s.
- Elements in `[l, i)` are all 1s.
- `i` advances only when the current element is placed correctly: 0 (swapped to left, `l++`) or 1 (already in place). For 2, the incoming swapped element from `r` is unknown — check it again.

---

## Pattern Recognition

| Role | Pattern |
|------|---------|
| Primary | Dutch National Flag — three-way partition in one pass |
| Contrast | Two-way partition (Lomuto) handles only binary values |

### Pattern Recognition Clues

- "Sort array with only 3 distinct values in-place"
- Single pass required

Cross-ref: [Two Pointers](../Two%20Pointers/README.md) · [PATTERNS.md](../../PATTERNS.md#two-pointers)

---

## Alternative Approaches

Two passes: count each color, overwrite → O(n), O(1), simpler. Fails "one-pass" constraint.

---

## Critical Implementation Details

- For 0: advance both `l` and `i` (the element from `l` is already known to be 1, safe to skip)
- For 2: **only** advance `r` — the element swapped from `r` must be re-examined
- Loop condition: `i <= r` (not `i < n`) — stop when `i` passes `r` (everything beyond `r` is 2)

---

## Edge Cases

- All same color → loop runs but no swaps
- Single element → immediate return (or loop does nothing)
- `[2, 0, 1]` → test case for correctness

---

## Common Mistakes

- Incrementing `i` after swapping a 2 (the element coming from `r` is unknown)
- Loop condition `i < n` instead of `i <= r` (processes already-sorted 2s)
- `swap(i, l)` then not incrementing `i` (infinite loop for 0)

---

## Complexity

| | |
|--|--|
| Time | O(n) — single pass |
| Space | O(1) |

---

## Similar Problems

- [remove-element](../remove-element/README.md) — two-way partition
- [remove-duplicates-from-sorted-array](../remove-duplicates-from-sorted-array/README.md) — write-pointer partition

---

## One-line Takeaway

**DNF: l→0s, r→2s, i scans; swap 0 with l (i++), swap 2 with r (no i++), skip 1.**

---

## Revision Checklist

- [ ] Three pointer roles: l, r, i?
- [ ] Why no `i++` after swapping a 2?
- [ ] Loop condition: `i <= r` not `i < n`?

---

## Revision History

| Date | Note |
|------|------|
| — | Documented from `submission-3.java` |
