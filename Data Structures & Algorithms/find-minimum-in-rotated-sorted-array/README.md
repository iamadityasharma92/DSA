# Find Minimum in Rotated Sorted Array

| Field | Value |
|-------|-------|
| Topic | Binary Search |
| Difficulty | Medium |
| Primary Pattern | Binary Search on rotated sorted array |
| Secondary Pattern | Running minimum tracking |
| Confidence | — |
| Last Revision | Never |

---

## Problem Summary

A sorted array was rotated at an unknown pivot. Find the minimum element in O(log n).

---

## Constraints (typical)

- All values unique
- `1 ≤ n ≤ 5000`
- Must be O(log n)

---

## Brute Force

`submission-0`: linear scan tracking min → O(n). Correct but too slow.

---

## Core Observation

At any mid point, one of the two halves is **sorted**. The minimum is in the unsorted half (where the rotation pivot is). Compare `nums[mid]` with `nums[r]`:

- `nums[mid] < nums[r]` → right half is sorted; minimum could be `mid` but is NOT to the right of `mid` → `r = mid - 1`
- else → rotation/pivot is in or right of `mid`; minimum is right of `mid` → `l = mid + 1`

Track `mini` throughout since the minimum could be `nums[mid]` itself at any point.

---

## Thinking Process

1. `l = 0`, `r = n-1`, `mini = INT_MAX`.
2. While `l <= r`: `m = l + (r-l)/2`.
3. `mini = min(mini, nums[m])`.
4. If `nums[m] < nums[r]` → `r = m - 1` (search left half including m).
5. Else → `l = m + 1` (minimum is right).
6. Return `mini`.

---

## Why the Approach Works

By comparing `nums[mid]` to `nums[r]` (not `nums[l]`), we reliably identify which half is sorted. The minimum must be in the other half. Tracking `mini` handles the case where `mid` itself is the minimum.

---

## Pattern Recognition

| Role | Pattern |
|------|---------|
| Primary | BS: compare mid to boundary to determine sorted half |
| Contrast | Find target in rotated array adds a target range check |

### Pattern Recognition Clues

- "Find minimum in rotated sorted array"
- Cannot use standard BS; need to reason about sorted halves

Cross-ref: [Binary Search](../Binary%20Search/README.md) · [PATTERNS.md](../../PATTERNS.md#binary-search-templates)

---

## Alternative Approaches

Linear scan O(n) — always finds min but doesn't meet the O(log n) requirement.

---

## Critical Implementation Details

- Compare `nums[mid]` to `nums[r]`, **not** `nums[l]` — comparing to `nums[l]` can mislead when array isn't rotated
- Always update `mini = min(mini, nums[mid])` before shrinking — don't rely on final `l`/`r` alone
- Use `l <= r` (inclusive bounds, `mid` checked on every iteration)

---

## Edge Cases

- Not rotated (already sorted) → min is `nums[0]`
- Rotated once → one large segment + one small segment
- Two-element array

---

## Common Mistakes

- Comparing `nums[mid]` to `nums[l]` instead of `nums[r]` (breaks when array is not rotated)
- Not tracking running `mini` and relying only on final pointer position

---

## Complexity

| | |
|--|--|
| Time | O(log n) |
| Space | O(1) |

---

## Similar Problems

- [find-target-in-rotated-sorted-array](../find-target-in-rotated-sorted-array/README.md) — same sorted-half logic + target range check
- [binary-search](../binary-search/README.md) — unrotated foundation

---

## One-line Takeaway

**Compare mid to right boundary; if sorted right→search left, else search right; track running min.**

---

## Revision Checklist

- [ ] Compare `nums[mid]` to `nums[r]` — not `nums[l]`?
- [ ] When does `r = mid - 1` and when `l = mid + 1`?
- [ ] Why track `mini` rather than just return `nums[l]`?

---

## Revision History

| Date | Note |
|------|------|
| — | `submission-0` (brute) → `submission-1` (binary search, optimal) |
