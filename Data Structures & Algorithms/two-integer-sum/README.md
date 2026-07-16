# Two Integer Sum

| Field | Value |
|-------|-------|
| Topic | Arrays & Hashing |
| Difficulty | Easy |
| Primary Pattern | HashMap complement lookup |
| Secondary Pattern | — |
| Confidence | — |
| Last Revision | Never |

---

## Problem Summary

Given an array of integers and a target, return the indices of the two numbers that add up to the target. Exactly one solution guaranteed.

---

## Constraints (typical)

- `2 ≤ nums.length ≤ 10⁴`
- Exactly one solution; cannot use same element twice
- Return indices (not values)

---

## Brute Force

All pairs O(n²) — try every combination until `nums[i] + nums[j] == target`. TLE.

---

## Core Observation

For each `nums[i]`, the complement `target - nums[i]` must also be in the array at some other index. A HashMap `{value → index}` gives O(1) complement lookup.

---

## Thinking Process

1. `map = HashMap<Integer, Integer>`.
2. For each `i`:
   - If `map.containsKey(target - nums[i])`: return `{map.get(target - nums[i]), i}`.
   - `map.put(nums[i], i)`.
3. Return empty (never reached if solution guaranteed).

---

## Why the Approach Works

By adding to the map AFTER checking, we ensure we don't use the same index twice. The complement check finds the earlier occurrence in the map, and `i` is the current (later) occurrence — forming the pair.

---

## Pattern Recognition

| Role | Pattern |
|------|---------|
| Primary | HashMap complement lookup |
| Extension | Two-integer-sum-ii (sorted array → two pointers) |

### Pattern Recognition Clues

- "Two numbers summing to target, return indices"
- Unsorted array → HashMap O(n)

Cross-ref: [Arrays & Hashing](../Arrays%20%26%20Hashing/README.md) · [PATTERNS.md](../../PATTERNS.md#hashing--canonical-keys)

---

## Alternative Approaches

**Sort + two pointers:** destroys original indices. Only works when indices aren't needed.

---

## Critical Implementation Details

- Check complement **before** inserting `nums[i]` into map — avoids using same index twice
- `submission-2` adds the guard `i != j` which is redundant since complement is checked before insert
- Returns `{j, i}` where `j < i` — smaller index first

---

## Edge Cases

- Duplicate values: `nums = [3, 3]`, `target = 6` → first 3 stored, second 3 finds its complement at index 0
- Negative numbers — handled naturally by subtraction

---

## Common Mistakes

- Inserting before checking (can return the same index twice for `target = 2 * nums[i]`)
- Not returning immediately on first match (problem guarantees unique solution)

---

## Complexity

| | |
|--|--|
| Time | O(n) expected |
| Space | O(n) |

---

## Similar Problems

- [two-integer-sum-ii](../two-integer-sum-ii/README.md) — sorted array, O(1) space with two pointers
- [three-integer-sum](../three-integer-sum/README.md) — 3-sum with sorted + two-pointer inner loop
- [4sum](../4sum/README.md) — 4-sum extension

---

## One-line Takeaway

**HashMap: check complement before insert; on match return {map[complement], i}.**

---

## Revision Checklist

- [ ] Insert before or after complement check?
- [ ] How are duplicate values with same sum handled?
- [ ] Why not sort + two-pointers here?

---

## Revision History

| Date | Note |
|------|------|
| — | Documented from `submission-2.java` |
