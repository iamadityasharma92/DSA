# First Missing Positive

| Field | Value |
|-------|-------|
| Topic | Arrays & Hashing |
| Difficulty | Hard |
| Primary Pattern | Index-as-hash (presence marking) |
| Secondary Pattern | HashSet lookup |
| Confidence | — |
| Last Revision | Never |

---

## Problem Summary

Given an unsorted integer array, return the smallest **positive** integer not present in the array. Must run in O(n) and O(1) extra space (ideally).

---

## Constraints (typical)

- `1 ≤ n ≤ 10⁵`
- Values can be any integer (negative, zero, large positive)
- Answer is always in `[1, n+1]`

---

## Brute Force

`submission-0`: HashSet of all elements, then scan `1, 2, 3, …` → O(n) time but O(n) space.

---

## Core Observation

The answer must be in `[1, n+1]`. Values outside `[1, n]` are irrelevant. Use a `boolean[n]` to mark which values in `[1, n]` are present; first `false` gives the answer. Return `n+1` if all are present.

`submission-3` (best): boolean array of size `n`, mark `num-1 = true` for valid nums, scan for first false.

---

## Thinking Process

1. `bool = new boolean[n]`.
2. For each `num`: if `1 <= num <= n` → `bool[num-1] = true`.
3. For `i = 0..n-1`: if `!bool[i]` → return `i+1`.
4. Return `n+1`.

---

## Why the Approach Works

Any value outside `[1, n]` cannot be the first missing positive (which is in `[1, n+1]`). The boolean array maps position `i` to presence of value `i+1` in O(1) per lookup. Worst case answer is `n+1` (all 1..n present).

---

## Pattern Recognition

| Role | Pattern |
|------|---------|
| Primary | Boolean array index = value−1 (presence marking) |
| Optimal upgrade | In-place negation on original array (O(1) space, mutates) |

### Pattern Recognition Clues

- "First missing positive"
- Answer bounded in [1, n+1] — only n slots to check

Cross-ref: [Arrays & Hashing](../Arrays%20%26%20Hashing/README.md) · [PATTERNS.md](../../PATTERNS.md#hashing--canonical-keys)

---

## Alternative Approaches

**O(1) space in-place:** repurpose original array as presence map via negation. For each value `v` in `[1, n]`, set `nums[v-1]` negative. Then scan for first non-negative index. Same O(n) time, O(1) space, but modifies array.

---

## Critical Implementation Details

- Only mark `num` if `1 <= num <= n` — negative values and 0 must be skipped
- `bool[num-1]` maps value `num` to index `num-1` (0-based)
- Return `n+1` if no false found (all 1..n present)
- `submission-2` over-allocates `bool[100001]` — wastes memory; `submission-3` uses tight size `n`

---

## Edge Cases

- All negative → answer is 1
- Array `[1, 2, 3]` → answer is 4 (`n+1`)
- Array `[2]` → answer is 1

---

## Common Mistakes

- Not filtering values outside `[1, n]` (index out of bounds)
- Returning wrong default (must return `n+1` not `n` or `maxi+1` arbitrarily)
- `submission-0` bug: `return maxi > 0 ? maxi+1 : 1` — wrong when maxi is large and gaps exist

---

## Complexity

| | |
|--|--|
| Time | O(n) |
| Space | O(n) — boolean array; O(1) with in-place negation |

---

## Similar Problems

- [find-duplicate-integer](../find-duplicate-integer/README.md) — similar index-as-value mapping
- [contains-duplicate-ii](../contains-duplicate-ii/README.md) — presence detection

---

## One-line Takeaway

**Answer in [1, n+1]; mark bool[num-1] for valid nums; first false slot is answer.**

---

## Revision Checklist

- [ ] Why is the answer guaranteed in `[1, n+1]`?
- [ ] Filter condition for which values to mark?
- [ ] What to return if all 1..n are present?
- [ ] Describe O(1) space in-place approach.

---

## Revision History

| Date | Note |
|------|------|
| — | `submission-0` (HashSet) → `submission-2` (wasteful bool) → `submission-3` (tight bool, best) |
