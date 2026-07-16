# Two Integer Sum II

| Field | Value |
|-------|-------|
| Topic | Two Pointers |
| Difficulty | Medium |
| Primary Pattern | Two Pointers (sorted array) |
| Secondary Pattern | — |
| Confidence | — |
| Last Revision | Never |

---

## Problem Summary

Given a **sorted** (ascending) 1-indexed array, return the 1-indexed indices `[i, j]` where `nums[i] + nums[j] == target`. Exactly one solution. Use O(1) space.

---

## Constraints (typical)

- Array is sorted ascending (key constraint enabling two pointers)
- 1-indexed output: `i < j`
- O(1) extra space required

---

## Brute Force

All pairs → O(n²). Violates time.

---

## Core Observation

Sorted array + sum target → two-pointer technique. Start at both ends: if `sum < target`, advance left; if `sum > target`, advance right; if `== target`, return.

---

## Thinking Process

1. `l = 0`, `r = n-1`.
2. While `l < r`: `sum = nums[l] + nums[r]`.
3. `sum == k` → return `{l+1, r+1}` (1-indexed).
4. `sum < k` → `l++` (need larger).
5. `sum > k` → `r--` (need smaller).

---

## Why the Approach Works

In a sorted array, `nums[l] + nums[r]` is the sum of the smallest and largest available values. If it's too small, the only way to increase is to move `l` right. If too large, move `r` left. Converging pointers cover all necessary pairs.

---

## Pattern Recognition

| Role | Pattern |
|------|---------|
| Primary | Two pointers on sorted array for pair sum |
| Contrast | two-integer-sum (unsorted) → HashMap O(n) space |

### Pattern Recognition Clues

- "Two sum in sorted array, O(1) space"
- Sorted property enables converging pointers

Cross-ref: [Two Pointers](../Two%20Pointers/README.md) · [PATTERNS.md](../../PATTERNS.md#two-pointers)

---

## Alternative Approaches

Binary search: for each `nums[l]`, binary search for `target - nums[l]` in the right portion → O(n log n). Same space but slower.

---

## Critical Implementation Details

- Output is 1-indexed: return `{l+1, r+1}`
- `while(l < r)` not `l <= r` — problem guarantees a solution; equal indices invalid
- Advance the pointer on the limiting side (smaller sum → advance left; larger → advance right)

---

## Edge Cases

- Sum achieved immediately (`nums[0] + nums[n-1] == target`)
- Numbers at adjacent indices

---

## Common Mistakes

- Returning 0-indexed instead of 1-indexed
- `l <= r` in loop condition (meaningless when `l == r`, single element can't form pair)

---

## Complexity

| | |
|--|--|
| Time | O(n) |
| Space | O(1) |

---

## Similar Problems

- [two-integer-sum](../two-integer-sum/README.md) — unsorted, HashMap approach
- [three-integer-sum](../three-integer-sum/README.md) — same two-pointer inner loop on sorted array

---

## One-line Takeaway

**Sorted array: two pointers from ends; advance smaller sum's pointer; return 1-indexed.**

---

## Revision Checklist

- [ ] Why O(1) space here but O(n) for unsorted variant?
- [ ] When to advance `l` vs `r`?
- [ ] 1-indexed output: `l+1`, `r+1`?

---

## Revision History

| Date | Note |
|------|------|
| — | Documented from `submission-1.java` |
