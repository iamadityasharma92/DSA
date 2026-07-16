# Merge Sorted Array

| Field | Value |
|-------|-------|
| Topic | Two Pointers |
| Difficulty | Easy |
| Primary Pattern | Two Pointers (fill from the back) |
| Secondary Pattern | — |
| Confidence | — |
| Last Revision | Never |

---

## Problem Summary

Merge `nums2` into `nums1` (which has extra space at the end). `nums1` has `m` valid elements, `nums2` has `n`. Merge in-place so `nums1` is sorted.

---

## Constraints (typical)

- `nums1.length = m + n` (pre-allocated)
- Both arrays sorted ascending
- Merge in-place (O(1) extra space)

---

## Brute Force

Copy `nums2` into the trailing zeros of `nums1`, then sort — O((m+n) log(m+n)). Wastes the sorted property.

---

## Core Observation

Fill from the **back**. Start pointers at the last valid elements of each array (`m-1`, `n-1`) and at the last position in `nums1` (`m+n-1`). The larger value goes to `last--`. Continue until `nums2` is exhausted.

---

## Thinking Process

1. `last = m+n-1; m--; n--`.
2. While `n >= 0`:
   - If `m >= 0 && nums1[m] > nums2[n]` → `nums1[last--] = nums1[m--]`
   - Else → `nums1[last--] = nums2[n--]`
3. When `n < 0`, all of `nums2` is merged (remaining `nums1` is already in place).

---

## Why the Approach Works

Writing from the back avoids overwriting unprocessed elements in `nums1`. Elements already in `nums1[0..m-1]` are only written further right, preserving unprocessed ones. The guard `m >= 0` handles exhausted `nums1`.

---

## Pattern Recognition

| Role | Pattern |
|------|---------|
| Primary | Back-fill: write largest first from the end |
| Contrast | Front-merge requires extra space |

### Pattern Recognition Clues

- "Merge in-place into first array with extra trailing space"
- Think backwards: fill the destination from the end

Cross-ref: [Two Pointers](../Two%20Pointers/README.md)

---

## Alternative Approaches

Copy `nums2` to end of `nums1`, sort — O((m+n) log(m+n)). Simple but ignores sorted property.

---

## Critical Implementation Details

- Pre-decrement both pointers (`m--; n--`) before the loop — indices are 0-based last valid element
- Guard `m >= 0` inside the loop (nums1 may be exhausted first)
- Stop when `n < 0` — remaining nums1 is already correct (already in place)
- No need to drain `m` — nums1 elements stay where they are

---

## Edge Cases

- `m = 0` → just copy nums2
- `n = 0` → nothing to do
- `nums2` entirely larger → nums2 fills the front

---

## Common Mistakes

- Draining remaining `m` after loop (unnecessary — nums1 already in place)
- Not guarding `m >= 0` in the while body (ArrayIndexOutOfBoundsException)
- Going forward instead of backward (needs O(n) extra space)

---

## Complexity

| | |
|--|--|
| Time | O(m + n) |
| Space | O(1) |

---

## Similar Problems

- [merge-strings-alternately](../merge-strings-alternately/README.md) — two-source merge with different ordering
- [merge-two-sorted-linked-lists](../merge-two-sorted-linked-lists/README.md) — same sorted merge, linked lists

---

## One-line Takeaway

**Fill nums1 from the back: larger of tail elements goes last; stop when nums2 exhausted.**

---

## Revision Checklist

- [ ] Why fill from the back?
- [ ] Guard on `m >= 0` in the loop?
- [ ] Why don't we need to drain remaining `nums1` elements?

---

## Revision History

| Date | Note |
|------|------|
| — | Documented from `submission-2.java` |
