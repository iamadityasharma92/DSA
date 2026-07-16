# Remove Element

| Field | Value |
|-------|-------|
| Topic | Two Pointers |
| Difficulty | Easy |
| Primary Pattern | Two Pointers (partition) |
| Secondary Pattern | — |
| Confidence | — |
| Last Revision | Never |

---

## Problem Summary

Remove all occurrences of a specific value `val` from array `nums` in-place. Return the count `k` of elements not equal to `val`. First `k` elements should be the non-`val` values (order may vary).

---

## Constraints (typical)

- In-place, O(1) extra space
- Elements beyond index `k` don't matter
- `0 ≤ val ≤ 100`

---

## Brute Force

Create a new array of non-`val` elements → O(n) space. Violates in-place.

---

## Core Observation

`submission-1` uses a two-pointer partition approach: `i` = write position, `j` = scan position. When `nums[j] != val`, write to `nums[i]`, swap `nums[j] = val`, advance `i`. Return `i`.

Simpler alternative: `i` points to next write slot; scan `j`; when `nums[j] != val`, `nums[i++] = nums[j]`.

---

## Thinking Process

**Simple partition:**
1. `i = 0`.
2. For each `j`: if `nums[j] != val` → `nums[i++] = nums[j]`.
3. Return `i`.

**`submission-1` approach:** finds first `val` position, then partition-swaps. More complex but same result.

---

## Why the Approach Works

The write pointer `i` accumulates only non-`val` elements. Since order among non-`val` elements is preserved (left-to-right scan), the first `i` entries are the answer.

---

## Pattern Recognition

| Role | Pattern |
|------|---------|
| Primary | Write-pointer partition (keep qualifying elements) |
| Related | remove-duplicates uses same write-pointer idea with different condition |

### Pattern Recognition Clues

- "Remove specific value in-place, return count"
- In-place partitioning

Cross-ref: [Two Pointers](../Two%20Pointers/README.md)

---

## Alternative Approaches

**Swap with end:** when `nums[j] == val`, swap with `nums[n-1]`, `n--`. O(n) but changes element order more.

---

## Critical Implementation Details

- `submission-1` starts by finding the first `val` occurrence (`i`), then uses `j = i` — functional but unnecessarily complex
- Simpler: single pass with `i` as write pointer; never read `nums[i]` after writing (safe even with overlapping regions since we only write when reading ahead)
- Return `i` = count of surviving elements

---

## Edge Cases

- No `val` in array → return `n` (write pointer never blocked)
- All `val` → return 0
- `n = 0` → return 0

---

## Common Mistakes

- Using complex two-pointer setup when a single write-pointer suffices
- Confusing with remove-duplicates (different condition: `!= val` vs `!= prev element`)

---

## Complexity

| | |
|--|--|
| Time | O(n) |
| Space | O(1) |

---

## Similar Problems

- [remove-duplicates-from-sorted-array](../remove-duplicates-from-sorted-array/README.md) — same write-pointer, sorted dedup
- [sort-colors](../sort-colors/README.md) — three-way partition

---

## One-line Takeaway

**Write pointer: copy non-val elements to front; return write count.**

---

## Revision Checklist

- [ ] Simple version: single write-pointer `i`, scan `j`, copy when `nums[j] != val`?
- [ ] Return `i` — what does it represent?

---

## Revision History

| Date | Note |
|------|------|
| — | `submission-1` (complex find+partition); simpler write-pointer approach preferred in interviews |
