# Contains Duplicate II

| Field | Value |
|-------|-------|
| Topic | Sliding Window |
| Difficulty | Easy |
| Primary Pattern | Sliding Window + HashSet |
| Secondary Pattern | Hashing |
| Confidence | — |
| Last Revision | Never |

---

## Problem Summary

Given an integer array `nums` and an integer `k`, return `true` if there exist two distinct indices `i` and `j` such that `nums[i] == nums[j]` and `|i - j| <= k`.

---

## Constraints (typical)

- `1 ≤ nums.length ≤ 10⁵`, `0 ≤ k ≤ 10⁵`
- Values can be any integer

---

## Brute Force

`submission-0`: nested loop comparing all pairs within distance `k` → O(n·k). Too slow for large inputs.

---

## Core Observation

Only indices within distance `k` matter. A sliding window of size at most `k+1` with a set is enough — if the incoming value is already in the set, the two occurrences are within distance `k`.

---

## Thinking Process

1. `l = 0, r = 0`, empty `HashSet`.
2. While `r < n`:
   - If `r - l > k`: remove `nums[l]`, `l++` (shrink to window ≤ k+1)
   - If `set.contains(nums[r])`: return `true`
   - `set.add(nums[r])`; `r++`
3. Return `false`.

---

## Why the Approach Works

The set always holds the last `≤ k+1` distinct-position values. Membership in this window guarantees the two equal values are at most `k` apart.

---

## Pattern Recognition

| Role | Pattern |
|------|---------|
| Primary | Fixed-bound sliding window (at most `k+1` elements) |
| Secondary | HashSet for O(1) membership |
| Alternative | HashMap `value → last index`; check `i - map.get(val) ≤ k` |

### Pattern Recognition Clues

- "Duplicate within distance k"
- Need to detect repetition in a recent window of values

Cross-ref: [Sliding Window](../Sliding%20Window/README.md) · [PATTERNS.md](../../PATTERNS.md#sliding-window-variable--fixed)

---

## Alternative Approaches

**Map approach:** `map.put(nums[i], i)` — on collision check `i - map.get(nums[i]) ≤ k`. O(n) time, same space. Slightly simpler code than the window set.

---

## Critical Implementation Details

- Shrink condition is `r - l > k` (window size `> k+1`), so remove before checking
- Check membership **before** `set.add` — adding first would hide the collision check
- `l` advances only when window exceeds `k`

---

## Edge Cases

- `k = 0` → no two equal values at distance 0 are valid (`i ≠ j` required), always `false`
- All elements unique → `false`
- Array with one element → `false`

---

## Common Mistakes

- Using `r - l >= k` instead of `> k` (off-by-one, misses valid pairs at exactly distance `k`)
- Checking membership after `add` (the new element overwrites the duplicate signal)
- Removing `nums[r]` instead of `nums[l]` when shrinking

---

## Complexity

| | |
|--|--|
| Time | O(n) |
| Space | O(min(n, k)) — window set size |

---

## Similar Problems

- [duplicate-integer](../duplicate-integer/README.md) — simpler: any duplicate anywhere
- [longest-substring-without-duplicates](../longest-substring-without-duplicates/README.md) — same window set mechanics

---

## One-line Takeaway

**Slide a k+1-wide set; if the incoming value is already in it, found duplicate within k.**

---

## Revision Checklist

- [ ] Why shrink when `r - l > k`, not `≥ k`?
- [ ] Why check `contains` before `add`?
- [ ] Alternative: index map instead of window set?

---

## Revision History

| Date | Note |
|------|------|
| — | Documented from `submission-0` (brute) → `submission-1` (sliding window) |
