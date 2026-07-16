# Minimum Size Subarray Sum

| Field | Value |
|-------|-------|
| Topic | Sliding Window |
| Difficulty | Medium |
| Primary Pattern | Variable Sliding Window |
| Secondary Pattern | Two Pointers |
| Confidence | — |
| Last Revision | Never |

---

## Problem Summary

Given a positive integer array and a target, find the minimum length of a contiguous subarray whose sum is ≥ target. Return 0 if no such subarray exists.

---

## Constraints (typical)

- All elements positive — key property enabling sliding window
- `1 ≤ nums[i] ≤ 10⁴`, `1 ≤ target ≤ 10⁹`

---

## Brute Force

All O(n²) subarrays with prefix sum check — O(n²). Binary search on prefix sums can do O(n log n).

---

## Core Observation

Since all elements are positive, adding more elements increases the sum and removing decreases it — the monotone property that makes sliding window valid. Expand right until sum ≥ target, then shrink left while maintaining it.

---

## Thinking Process

`submission-1` uses two phases:
1. **Phase 1 (expand):** while `r < n`, if `sum < target` → add `nums[r++]`; else → record `mini = min(mini, r-l)`, subtract `nums[l++]`.
2. **Phase 2 (drain left):** when `r == n`, keep shrinking while `sum >= target`.

Simpler standard pattern:
1. Expand `r`, add to `sum`.
2. While `sum >= target`: record `min(mini, r-l+1)`, subtract `nums[l++]`.

---

## Why the Approach Works

All elements positive → sum is monotone in window size. Expanding right and shrinking left when valid guarantees every subarray is checked. The shortest valid window is captured at the tightest shrink point.

---

## Pattern Recognition

| Role | Pattern |
|------|---------|
| Primary | Variable sliding window — expand right, shrink left on validity |
| Key constraint | All positive (enables monotone sum property) |

### Pattern Recognition Clues

- "Minimum subarray with sum ≥ target"
- All elements positive — shrinking is safe

Cross-ref: [Sliding Window](../Sliding%20Window/README.md) · [PATTERNS.md](../../PATTERNS.md#sliding-window-variable--fixed)

---

## Alternative Approaches

**Binary search on prefix sums:** O(n log n). Useful when elements can be negative (though sliding window fails then anyway).

---

## Critical Implementation Details

- `submission-1`'s two-phase structure handles the remaining valid windows after `r` reaches `n`
- Return `0` if `mini == Integer.MAX_VALUE` (no valid subarray)
- Window length at shrink point: `r - l` in `submission-1`'s notation (since `r` has already been incremented) vs `r - l + 1` in standard style
- Positive elements only — sliding window breaks for negative values

---

## Edge Cases

- No valid subarray → return 0
- Single element ≥ target → return 1
- Entire array needed → return n

---

## Common Mistakes

- Applying sliding window when elements can be negative (wrong)
- Off-by-one in window length calculation (depends on when `r` is incremented)
- Not handling the "remaining valid windows after r = n" case

---

## Complexity

| | |
|--|--|
| Time | O(n) — each element added and removed at most once |
| Space | O(1) |

---

## Similar Problems

- [longest-substring-without-duplicates](../longest-substring-without-duplicates/README.md) — variable window with set
- [minimum-window-with-characters](../minimum-window-with-characters/README.md) — variable window with frequency map

---

## One-line Takeaway

**Positive elements → sliding window: expand right, shrink left while sum ≥ target; track min length.**

---

## Revision Checklist

- [ ] Why must all elements be positive for sliding window to work?
- [ ] When to record `mini`: before or after shrinking `l`?
- [ ] What to return when no subarray satisfies the condition?

---

## Revision History

| Date | Note |
|------|------|
| — | Documented from `submission-1.java` |
