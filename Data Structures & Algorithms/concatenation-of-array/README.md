# Concatenation of Array

| Field | Value |
|-------|-------|
| Topic | Arrays & Hashing |
| Difficulty | Easy |
| Primary Pattern | Array construction |
| Secondary Pattern | — |
| Confidence | — |
| Last Revision | Never |

---

## Problem Summary

Given an integer array `nums` of length `n`, return a new array of length `2n` that is `nums` followed by `nums` (i.e. `[nums, nums]`).

---

## Constraints (typical)

- `1 ≤ n ≤ 1000`, values fit in int
- Output is exactly length `2n`

---

## Brute Force

No complexity issue here — the naive approach IS the optimal approach.

---

## Core Observation

Each element `nums[i]` belongs at both index `i` and index `i + n` in the output.

---

## Thinking Process

1. Allocate `int[2*n]`.
2. For each `i` in `[0, n)`: set `res[i] = res[i+n] = nums[i]`.
3. Return `res`.

`submission-1` is the cleanest: `res[i+n] = res[i] = nums[i]` in one assignment per loop iteration.

---

## Why the Approach Works

Direct index mapping — no sorting, shifting, or extra structures needed.

---

## Pattern Recognition

| Role | Pattern |
|------|---------|
| Primary | Direct index mapping |
| Contrast | This is simpler than rotate-array which reverses in-place |

### Pattern Recognition Clues

- Output is a simple structural repeat of input
- Output length is a fixed multiple of input length

---

## Alternative Approaches

`System.arraycopy` twice — same O(n), more idiomatic Java.

---

## Critical Implementation Details

- Output array is length `2 * n`, NOT `n + 1`
- Both halves can be filled in a single loop pass
- No modular arithmetic needed — just `i` and `i + n`

---

## Edge Cases

- `n = 1` → `[x, x]`
- All same values
- Negative numbers (handled naturally)

---

## Common Mistakes

- Allocating array of size `n` instead of `2n`
- Using two separate loops instead of one

---

## Complexity

| | |
|--|--|
| Time | O(n) |
| Space | O(n) — output only |

---

## Similar Problems

- [rotate-array](../rotate-array/README.md) — more complex in-place manipulation
- [merge-sorted-array](../merge-sorted-array/README.md) — fills an array using two sources

---

## One-line Takeaway

**`res[i] = res[i+n] = nums[i]` — one pass, two writes.**

---

## Revision Checklist

- [ ] Output array size?
- [ ] Single-pass or two-pass?

---

## Revision History

| Date | Note |
|------|------|
| — | Documented from `submission-0` / `submission-1` (identical logic) |
