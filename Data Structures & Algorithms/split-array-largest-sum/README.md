# Split Array Largest Sum

| Field | Value |
|-------|-------|
| Topic | Binary Search |
| Difficulty | Hard |
| Primary Pattern | Binary Search on Answer |
| Secondary Pattern | Greedy feasibility check |
| Confidence | — |
| Last Revision | Never |

---

## Problem Summary

Split an array into exactly `k` non-empty contiguous subarrays to minimize the largest subarray sum. Return that minimum value.

---

## Constraints (typical)

- `1 ≤ k ≤ nums.length ≤ 1000`
- `0 ≤ nums[i] ≤ 10⁶`

---

## Brute Force

Try all ways to split into `k` subarrays → O(n^k). Infeasible.

---

## Core Observation

The answer is monotone: if we can split with max sum ≤ `m`, we can also do it with max sum ≤ `m+1`. Binary search on `m` in `[max(nums), sum(nums)]`.

---

## Thinking Process

1. `l = max(nums)`, `r = sum(nums)`.
2. While `l <= r`: `m = l + (r-l)/2`.
3. `canSplit(nums, m, k)`: greedily partition — accumulate sum; when `sum > m`, start new partition (`c++`, `sum = nums[i]`). Return `c <= k`.
4. If feasible: `res = m`, `r = m-1`; else `l = m+1`.
5. Return `res`.

---

## Why the Approach Works

The lower bound `max(nums)` ensures each element fits in at least one partition. Upper bound `sum` is all one partition. The greedy check counts minimum partitions needed for max sum ≤ `m` — if that count ≤ `k`, it's feasible.

---

## Pattern Recognition

| Role | Pattern |
|------|---------|
| Primary | Binary Search on Answer |
| Check | Greedy: minimize partition count for given max |
| Same family | eating-bananas, capacity-to-ship |

### Pattern Recognition Clues

- "Minimize the maximum" of subarrays
- Monotone feasibility on the answer value

Cross-ref: [Binary Search](../Binary%20Search/README.md) · [PATTERNS.md](../../PATTERNS.md#binary-search-on-answer)

---

## Alternative Approaches

DP: `dp[i][j]` = min largest sum to split `nums[0..i]` into `j` parts → O(n² × k). Binary search is O(n log(sum)).

---

## Critical Implementation Details

- `l = max(nums)` not 0 or 1 — each element must fit in its partition
- In `canSplit`: `sum = nums[i]` (not 0) when starting new partition — the overflowing element goes to the new partition
- Return `res` (last feasible `m`), not `l` (may be infeasible)

---

## Edge Cases

- `k = 1` → answer is `sum(nums)`
- `k = n` → answer is `max(nums)`
- `nums.length < k` → impossible (submission handles with `return -1`)

---

## Common Mistakes

- Lower bound 0 or 1 (elements don't fit)
- `sum = 0` instead of `sum = nums[i]` when starting new partition (element is missed)
- Checking `c > k` too late (should return false immediately)

---

## Complexity

| | |
|--|--|
| Time | O(n log(sum)) |
| Space | O(1) |

---

## Similar Problems

- [capacity-to-ship-packages-within-d-days](../capacity-to-ship-packages-within-d-days/README.md) — identical skeleton
- [eating-bananas](../eating-bananas/README.md) — same BS-on-answer template

---

## One-line Takeaway

**BS in [max, sum]; greedy count partitions for mid; feasible → try smaller; infeasible → try larger.**

---

## Revision Checklist

- [ ] Lower bound `max(nums)`, not 1?
- [ ] `canSplit`: when starting new partition, `sum = nums[i]` not 0?
- [ ] Return `res` (last valid `m`) vs return `l`?

---

## Revision History

| Date | Note |
|------|------|
| — | Documented from `submission-0.java` |
