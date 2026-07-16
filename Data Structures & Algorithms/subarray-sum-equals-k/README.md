# Subarray Sum Equals K

| Field | Value |
|-------|-------|
| Topic | Arrays & Hashing |
| Difficulty | Medium |
| Primary Pattern | Prefix Sum + HashMap |
| Secondary Pattern | — |
| Confidence | — |
| Last Revision | Never |

---

## Problem Summary

Given an integer array `nums` and integer `k`, return the total count of contiguous subarrays whose sum equals `k`.

---

## Constraints (typical)

- `-10⁴ ≤ nums[i] ≤ 10⁴`, `1 ≤ nums.length ≤ 2 × 10⁴`
- `k` can be any integer
- Array elements can be negative — sliding window won't work

---

## Brute Force

All O(n²) subarrays with running sum → O(n²). TLE.

---

## Core Observation

`sum[i..j] = prefixSum[j] - prefixSum[i-1]`. For `sum[i..j] == k`: `prefixSum[j] - k == prefixSum[i-1]`. Track prefix sum frequencies in a HashMap. For each new prefix sum, look up how many previous prefix sums equal `currentSum - k`.

---

## Thinking Process

1. `map.put(0, 1)` — prefix sum of 0 exists once (empty prefix before index 0).
2. `sum = 0`, `ans = 0`.
3. For each `n` in `nums`: `sum += n`; `ans += map.getOrDefault(sum - k, 0)`; `map.put(sum, map.getOrDefault(sum, 0) + 1)`.
4. Return `ans`.

---

## Why the Approach Works

`map.get(sum - k)` counts how many previous prefix sums differ from the current by exactly `k` — each such previous sum corresponds to a valid subarray ending at the current index. `map.put(0, 1)` handles subarrays starting at index 0 (where the entire prefix sum = k).

---

## Pattern Recognition

| Role | Pattern |
|------|---------|
| Primary | Prefix sum + complement lookup in HashMap |
| Contrast | Two-pointer sliding window only works for all-positive arrays |

### Pattern Recognition Clues

- "Count subarrays with sum == k"
- Array has negative values → can't use sliding window

Cross-ref: [Arrays & Hashing](../Arrays%20%26%20Hashing/README.md) · [PATTERNS.md](../../PATTERNS.md#prefix-sum)

---

## Alternative Approaches

Two-pointer — only valid for all-positive arrays. Brute force O(n²) — always correct but slow.

---

## Critical Implementation Details

- `map.put(0, 1)` is essential — without it, subarrays starting from index 0 are missed
- Look up **before** adding current sum to map (current index doesn't count as a "previous" prefix)
- This works for negative elements — prefix sum can decrease

---

## Edge Cases

- `k = 0` → counts subarrays summing to 0 (handled correctly)
- Single element `== k` → found
- All negative elements with negative `k`

---

## Common Mistakes

- Forgetting `map.put(0, 1)` at initialization (misses subarrays starting from index 0)
- Adding current sum to map before the lookup (overcounts by 1)
- Using sliding window when elements can be negative

---

## Complexity

| | |
|--|--|
| Time | O(n) |
| Space | O(n) — map |

---

## Similar Problems

- [range-sum-query-2d-immutable](../range-sum-query-2d-immutable/README.md) — 2D prefix sum
- [minimum-size-subarray-sum](../minimum-size-subarray-sum/README.md) — min length, all positive (sliding window)

---

## One-line Takeaway

**Prefix sum + HashMap: `ans += map[sum - k]`; init `map[0] = 1` for full-prefix subarrays.**

---

## Revision Checklist

- [ ] Why `map.put(0, 1)` before the loop?
- [ ] Order: lookup before insert or insert before lookup?
- [ ] Why can't we use sliding window here?

---

## Revision History

| Date | Note |
|------|------|
| — | Documented from `submission-1.java` |
