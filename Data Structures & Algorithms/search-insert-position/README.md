# Search Insert Position

| Field | Value |
|-------|-------|
| Topic | Binary Search |
| Difficulty | Easy |
| Primary Pattern | Binary Search — leftmost insert position |
| Secondary Pattern | — |
| Confidence | — |
| Last Revision | Never |

---

## Problem Summary

Given a sorted array and a target, return the index if target is found. If not, return the index where it would be inserted in order.

---

## Constraints (typical)

- Sorted, no duplicates
- O(log n) required

---

## Brute Force

Linear scan → O(n). Returns first index where `nums[i] >= target`.

---

## Core Observation

This is the **lower bound** binary search: find the leftmost position where `nums[pos] >= target`. Standard binary search with half-open right boundary and `r = m` on overshoot.

---

## Thinking Process

1. `l = 0`, `r = nums.length` (half-open — `r` can be past the end for insert-at-end).
2. While `l < r`: `m = l + (r-l)/2`.
3. If `nums[m] == target` → return `m`.
4. If `nums[m] > target` → `r = m` (target would go before or at `m`).
5. Else → `l = m + 1`.
6. Return `l` (insert position if not found).

---

## Why the Approach Works

When `l == r`, the loop exits. `l` is the first position where all elements to the left are strictly less than `target` — the correct insert position.

---

## Pattern Recognition

| Role | Pattern |
|------|---------|
| Primary | Lower bound / leftmost position binary search |
| Template | Half-open `[l, r)` with `r = n`; return `l` |

### Pattern Recognition Clues

- "Return index if found, else insert position"
- Always returns a valid index even if target absent

Cross-ref: [Binary Search](../Binary%20Search/README.md) · [PATTERNS.md](../../PATTERNS.md#binary-search-templates)

---

## Alternative Approaches

Linear scan O(n) — too slow. Java's `Arrays.binarySearch` returns negative insertion point if not found — usable but non-portable interview answer.

---

## Critical Implementation Details

- `r = nums.length` (not `nums.length - 1`) — target may need to be inserted after the last element
- Return `l`, not `r` (they're equal at exit, but `l` is conventional)
- `while(l < r)` not `l <= r` to avoid processing the out-of-bounds `r = nums.length` index

---

## Edge Cases

- Target smaller than all elements → return 0
- Target larger than all elements → return `n`
- Target equal to a middle element → found and returned immediately

---

## Common Mistakes

- `r = nums.length - 1` (misses insert-at-end case)
- `while(l <= r)` with `r = n` (accesses `nums[n]` — out of bounds)

---

## Complexity

| | |
|--|--|
| Time | O(log n) |
| Space | O(1) |

---

## Similar Problems

- [binary-search](../binary-search/README.md) — exact match only
- [eating-bananas](../eating-bananas/README.md) — BS on value space

---

## One-line Takeaway

**Lower-bound BS: `r = n`; `r = m` on overshoot; `l = m+1` on undershoot; return `l`.**

---

## Revision Checklist

- [ ] Why `r = nums.length` not `nums.length - 1`?
- [ ] `while(l < r)` not `l <= r`?
- [ ] Return `l` at the end?

---

## Revision History

| Date | Note |
|------|------|
| — | Documented from `submission-0.java` |
