# Search in Rotated Sorted Array II

| Field | Value |
|-------|-------|
| Topic | Binary Search |
| Difficulty | Medium |
| Primary Pattern | Binary Search with duplicate escape |
| Secondary Pattern | — |
| Confidence | — |
| Last Revision | Never |

---

## Problem Summary

Same as "Search in Rotated Sorted Array" but the array may contain **duplicates**. Return `true`/`false` whether target exists. O(log n) average but O(n) worst case.

---

## Constraints (typical)

- Values can repeat
- O(log n) average; O(n) worst case acceptable

---

## Brute Force

Linear scan → O(n). Works but ignores sorted structure.

---

## Core Observation

Same sorted-half logic as the no-duplicates variant, but when `nums[m] == nums[l]` (can't determine which half is sorted due to duplicates), escape by `l++`.

---

## Thinking Process

1. `l = 0`, `r = n-1`.
2. While `l <= r`: `m = l + (r-l)/2`.
3. If `nums[m] == target` → return `true`.
4. If `nums[m] > nums[l]` → left half sorted:
   - Target in `[nums[l], nums[m])` → `r = m-1`; else `l = m+1`.
5. Else if `nums[l] > nums[m]` → right half sorted:
   - Target in `(nums[m], nums[r]]` → `l = m+1`; else `r = m-1`.
6. **Else (`nums[m] == nums[l]`):** can't determine → `l++` (shrink ambiguity).

---

## Why the Approach Works

Duplicate `nums[m] == nums[l]` makes it impossible to tell if the left or right half is sorted. Incrementing `l` removes one ambiguous element without losing the target (if `nums[l] == target`, it would have been caught at step 3 at some point or the loop corrects itself).

---

## Pattern Recognition

| Role | Pattern |
|------|---------|
| Primary | Sorted-half BS + escape for duplicates |
| Contrast | No-duplicates variant: `>=` check instead of three-way split |

### Pattern Recognition Clues

- "Rotated sorted, duplicates allowed"
- O(n) worst case when all elements are the same

Cross-ref: [Binary Search](../Binary%20Search/README.md) · [PATTERNS.md](../../PATTERNS.md#binary-search-templates)

---

## Alternative Approaches

Linear scan — O(n), no duplicates issue. Acceptable when worst case is already O(n).

---

## Critical Implementation Details

- Check `nums[m] > nums[l]` (not `>=`) — equality goes to the `else l++` escape
- `submission-3` correctly uses `>` and `<` for the two sorted-half cases and `else l++`
- Worst case all-duplicates → O(n) (degrades to linear via repeated `l++`)

---

## Edge Cases

- All same value, target = that value → returns `true`
- All same value, target ≠ → exhausts all positions via `l++`, returns `false`
- No rotation

---

## Common Mistakes

- Using `>=` in sorted-half check (eats into the duplicate escape case)
- Not handling the `nums[m] == nums[l]` case at all (gives wrong answers with duplicates)

---

## Complexity

| | |
|--|--|
| Time | O(log n) average; O(n) worst (all duplicates) |
| Space | O(1) |

---

## Similar Problems

- [find-target-in-rotated-sorted-array](../find-target-in-rotated-sorted-array/README.md) — same logic, no duplicates (O(log n) guaranteed)

---

## One-line Takeaway

**Rotated BS + duplicates: if nums[m] == nums[l], can't determine sorted half → l++ to escape.**

---

## Revision Checklist

- [ ] Three-way split: `nums[m] > nums[l]` vs `nums[l] > nums[m]` vs equal?
- [ ] What happens in the equal case?
- [ ] Why does worst case degrade to O(n)?

---

## Revision History

| Date | Note |
|------|------|
| — | Documented from `submission-3.java` |
