# Range Sum Query 2D - Immutable

| Field | Value |
|-------|-------|
| Topic | Arrays & Hashing |
| Difficulty | Medium |
| Primary Pattern | 2D Prefix Sum |
| Secondary Pattern | — |
| Confidence | — |
| Last Revision | Never |

---

## Problem Summary

Given a 2D matrix, precompute so that each `sumRegion(row1, col1, row2, col2)` query returns the sum of elements in the rectangle in O(1).

---

## Constraints (typical)

- Matrix is immutable (no updates)
- Multiple queries — preprocessing is worthwhile
- `O(1)` per query required

---

## Brute Force

Sum all elements in the rectangle each query → O(m × n) per query. Too slow.

---

## Core Observation

Build a 2D prefix sum table `prefix[i][j]` = sum of all elements in `matrix[0..i-1][0..j-1]`. Rectangle sum = inclusion-exclusion of 4 prefix values: `P[r2+1][c2+1] - P[r1][c2+1] - P[r2+1][c1] + P[r1][c1]`.

`submission-3` uses row-prefix sums only (1D per row), computing queries in O(rows) not O(1). This is an incomplete optimization — the full 2D prefix gives O(1).

---

## Thinking Process

**Full 2D prefix (optimal):**
1. `prefix[i][j] = matrix[i-1][j-1] + prefix[i-1][j] + prefix[i][j-1] - prefix[i-1][j-1]`
2. `sumRegion(r1, c1, r2, c2)` = `prefix[r2+1][c2+1] - prefix[r1][c2+1] - prefix[r2+1][c1] + prefix[r1][c1]`

**`submission-3` (row-prefix only):**
- Precompute per-row prefix sums
- For each query, sum row slices: O(r2 - r1 + 1) per query

---

## Why the Approach Works

Inclusion-exclusion on the 4 corners of the prefix table gives the rectangle sum in O(1). Adding top-right and bottom-left to cancel the top-left's double subtraction yields the exact inner rectangle.

---

## Pattern Recognition

| Role | Pattern |
|------|---------|
| Primary | 2D Prefix Sum with inclusion-exclusion |
| Simpler | 1D row prefix (submission-3) — O(n) per query |

### Pattern Recognition Clues

- "Immutable 2D matrix, multiple rectangle sum queries"
- Precompute once, query many times

Cross-ref: [Arrays & Hashing](../Arrays%20%26%20Hashing/README.md) · [PATTERNS.md](../../PATTERNS.md#prefix-sum)

---

## Alternative Approaches

`submission-3`'s row-prefix approach — correct but O(rows) per query, not O(1). Prefer full 2D prefix in interviews.

---

## Critical Implementation Details

- `prefix` table is `(m+1) × (n+1)` to simplify edge cases (row 0 and col 0 are 0-rows)
- Inclusion-exclusion: add bottom-right, subtract top part and left part, add back top-left (subtracted twice)
- Indices are 1-based in `prefix`, 0-based in `matrix`

---

## Edge Cases

- `row1 == row2 && col1 == col2` → single element
- Query covering entire matrix
- Row-only or column-only queries

---

## Common Mistakes

- Off-by-one: confusing 0-based matrix indices with 1-based prefix indices
- Forgetting the `+prefix[r1][c1]` in inclusion-exclusion (double-subtraction correction)

---

## Complexity

| | |
|--|--|
| Preprocessing | O(m × n) |
| Query | O(1) with 2D prefix; O(n_rows) with row-prefix |
| Space | O(m × n) |

---

## Similar Problems

- [subarray-sum-equals-k](../subarray-sum-equals-k/README.md) — 1D prefix sum with HashMap
- [minimum-size-subarray-sum](../minimum-size-subarray-sum/README.md) — 1D prefix sum application

---

## One-line Takeaway

**2D prefix[i][j] = sum of top-left sub-matrix; rectangle sum via 4-corner inclusion-exclusion in O(1).**

---

## Revision Checklist

- [ ] 2D prefix recurrence formula?
- [ ] 4-corner inclusion-exclusion for rectangle sum?
- [ ] Why prefix table is (m+1)×(n+1)?
- [ ] `submission-3`'s approach: row-prefix is O(rows) not O(1)?

---

## Revision History

| Date | Note |
|------|------|
| — | `submission-3` uses row-prefix (O(rows) query); optimal is full 2D prefix (O(1) query) |
