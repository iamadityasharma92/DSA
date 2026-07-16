# Search a 2D Matrix

| Field | Value |
|-------|-------|
| Topic | Binary Search |
| Difficulty | Medium |
| Primary Pattern | Binary Search — 2D to 1D virtual mapping |
| Secondary Pattern | — |
| Confidence | — |
| Last Revision | Never |

---

## Problem Summary

Given an `m × n` matrix where rows are sorted and the first integer of each row is greater than the last of the previous row (globally sorted). Search for a target in O(log(m × n)).

---

## Constraints (typical)

- Each row sorted ascending
- First element of each row > last of previous row
- O(log(m × n)) required

---

## Brute Force

Linear scan all cells → O(m × n). Doesn't meet O(log) requirement.

---

## Core Observation

The matrix is effectively a sorted 1D array of length `m × n`. Binary search treating indices `0..m*n-1` as linear, converting `mid` to `[mid/n][mid%n]`.

---

## Thinking Process

1. `l = 0`, `r = m*n - 1`.
2. While `l <= r`: `mid = l + (r-l)/2`.
3. `midval = matrix[mid/n][mid%n]`.
4. `midval == target` → `true`; `midval < target` → `l = mid+1`; else `r = mid-1`.
5. Return `false`.

---

## Why the Approach Works

The row-major linear index `idx` maps to `row = idx / n`, `col = idx % n`. The 2D array's global sorted order makes this a straightforward 1D binary search.

---

## Pattern Recognition

| Role | Pattern |
|------|---------|
| Primary | 2D to 1D flattening for binary search |
| Contrast | Staircase search (top-right start) is O(m+n) — different matrix structure |

### Pattern Recognition Clues

- "Globally sorted 2D matrix (each row sorted, first > last of prev row)"
- O(log(m×n)) → treat as 1D

Cross-ref: [Binary Search](../Binary%20Search/README.md) · [PATTERNS.md](../../PATTERNS.md#binary-search-templates)

---

## Alternative Approaches

**Staircase (top-right):** start at `matrix[0][n-1]`; if `> target` move left, if `< target` move down. O(m+n) — works for a different matrix type where only rows are sorted.

**Two-pass BS:** BS for row first, then BS within row. O(log m + log n) = O(log(m×n)) same but more code.

---

## Critical Implementation Details

- `mid/n` gives the row, `mid%n` gives the column
- Specifically: divide by `n` (number of **columns**), not `m` (number of rows)
- `r = m*n - 1`, not `m*n`

---

## Edge Cases

- `target < matrix[0][0]` → not found
- `target > matrix[m-1][n-1]` → not found
- Single-cell matrix

---

## Common Mistakes

- Dividing by `m` instead of `n` (row count vs column count)
- Off-by-one: `r = m*n` instead of `m*n - 1`

---

## Complexity

| | |
|--|--|
| Time | O(log(m × n)) |
| Space | O(1) |

---

## Similar Problems

- [binary-search](../binary-search/README.md) — 1D foundation
- [find-target-in-rotated-sorted-array](../find-target-in-rotated-sorted-array/README.md) — same BS structure

---

## One-line Takeaway

**Treat m×n matrix as 1D array; `matrix[mid/n][mid%n]` for standard binary search.**

---

## Revision Checklist

- [ ] Mapping formula: `row = mid / n`, `col = mid % n` (divide by columns)?
- [ ] `r = m*n - 1` not `m*n`?
- [ ] When does staircase search apply vs 2D binary search?

---

## Revision History

| Date | Note |
|------|------|
| — | Documented from `submission-3.java` |
