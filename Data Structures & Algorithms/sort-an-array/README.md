# Sort an Array

| Field | Value |
|-------|-------|
| Topic | Arrays & Hashing |
| Difficulty | Medium |
| Primary Pattern | In-place comparison sort |
| Secondary Pattern | — |
| Confidence | — |
| Last Revision | Never |

---

## Problem Summary

Sort an array of integers in ascending order. Return the sorted array. Must be better than O(n²) average.

---

## Constraints (typical)

- `1 ≤ nums.length ≤ 5 × 10⁴`
- `-5 × 10⁴ ≤ nums[i] ≤ 5 × 10⁴`
- O(n log n) or better required

---

## Brute Force

Selection sort or bubble sort → O(n²). Exceeds time limit.

---

## Core Observation

`submission-0` uses `Arrays.sort(nums)` — O(n log n) via Java's dual-pivot quicksort for primitives. For interviews, you should know how to implement merge sort or quicksort.

---

## Thinking Process

**Merge Sort (canonical interview answer):**
1. `mergeSort(nums, 0, n-1)`.
2. Base: `l >= r` → return.
3. `mid = (l+r)/2`. Recurse on both halves.
4. Merge: merge sorted halves back into `nums[l..r]`.

**Quick Sort (in-place, O(log n) space):**
1. Pick pivot, partition (elements < pivot left, > pivot right).
2. Recurse on both sides.

---

## Why the Approach Works

Merge sort: divide and conquer — merging two sorted arrays is O(n). T(n) = 2T(n/2) + O(n) → O(n log n) by Master Theorem.

---

## Pattern Recognition

| Role | Pattern |
|------|---------|
| Primary | Divide and conquer sorting |
| Interview | Implement merge sort; `Arrays.sort` won't suffice as the answer |

### Pattern Recognition Clues

- "Sort array O(n log n)"
- Foundation for many problems that pre-sort input

---

## Alternative Approaches

**Counting sort:** O(n + range) for bounded integer ranges — useful if `|nums[i]| ≤ 50000`.

**Heap sort:** O(n log n), O(1) space, but poor cache performance.

---

## Critical Implementation Details

- `Arrays.sort` for `int[]` uses dual-pivot quicksort (O(n log n) average, O(n²) worst)
- For interview: merge sort preferred (guaranteed O(n log n), stable)
- `submission-0` is the minimal solution — fine for problem acceptance, not for interview

---

## Edge Cases

- Already sorted → best case for insertion sort, average for quicksort
- All same values → sorted trivially
- Single element

---

## Common Mistakes

- Using `Arrays.sort` on a `List` of `Integer` (boxing overhead) instead of primitive `int[]`
- Quick sort: random pivot needed to avoid O(n²) worst case on sorted input

---

## Complexity

| | Merge Sort | Quick Sort |
|--|--|--|
| Time | O(n log n) always | O(n log n) avg, O(n²) worst |
| Space | O(n) | O(log n) avg |

---

## Similar Problems

- [top-k-elements-in-list](../top-k-elements-in-list/README.md) — uses sorting as a step
- [sort-colors](../sort-colors/README.md) — O(n) sort for 3-element alphabet

---

## One-line Takeaway

**`Arrays.sort` for acceptance; know merge sort for interviews: divide, recurse, merge.**

---

## Revision Checklist

- [ ] Merge sort recurrence?
- [ ] Why merge sort preferred over quicksort in interviews (guaranteed O(n log n))?
- [ ] When is counting sort better?

---

## Revision History

| Date | Note |
|------|------|
| — | `submission-0` uses `Arrays.sort`; implement merge sort for interview |
