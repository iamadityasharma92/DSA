# Trapping Rain Water

| Field | Value |
|-------|-------|
| Topic | Two Pointers |
| Difficulty | Hard |
| Primary Pattern | Two Pointers (from both ends) |
| Secondary Pattern | Running max tracking |
| Confidence | — |
| Last Revision | Never |

---

## Problem Summary

Given an array of non-negative heights representing a bar chart, compute how much water it can trap after raining.

---

## Constraints (typical)

- `n ≥ 2`
- `0 ≤ height[i] ≤ 10⁴`

---

## Brute Force

For each position `i`: water trapped = `min(maxLeft, maxRight) - height[i]`. Precompute two prefix arrays for left and right max → O(n) time, O(n) space.

---

## Core Observation

**Two-pointer O(1) space:** advance from the side with the smaller running max. The water at the advancing side is `max_side - height[advancing]` — guaranteed safe because the other side's max is taller.

---

## Thinking Process

1. `l = 0`, `r = n-1`, `lm = height[0]`, `rm = height[n-1]`, `ans = 0`.
2. While `l < r`:
   - If `lm < rm` → process left: `l++`; `lm = max(lm, height[l])`; `ans += lm - height[l]`.
   - Else → process right: `r--`; `rm = max(rm, height[r])`; `ans += rm - height[r]`.
3. Return `ans`.

---

## Why the Approach Works

Water at position `i` = `min(maxLeft, maxRight) - height[i]`. We process the side with the smaller max — for that side, we know the other side's max is at least as large, so `min(maxLeft, maxRight) = current_side_max`. The contribution is `current_max - height[current]`, always ≥ 0 (max never drops below height due to the `max` update).

---

## Pattern Recognition

| Role | Pattern |
|------|---------|
| Primary | Two pointers from both ends, process the shorter side |
| Contrast | Container-with-most-water: max area; this: total trapped water (different formulas) |

### Pattern Recognition Clues

- "Trap water between bars"
- Contribution of each bar depends on both-side maxima

Cross-ref: [Two Pointers](../Two%20Pointers/README.md) · [PATTERNS.md](../../PATTERNS.md#two-pointers)

---

## Alternative Approaches

**Prefix arrays:** `leftMax[i]` + `rightMax[i]` computed separately, then scan once. O(n) time, O(n) space. More intuitive.

**Monotonic stack:** process bars using a stack to find left/right boundaries. O(n) time, O(n) space.

---

## Critical Implementation Details

- Advance `l` or `r` **before** reading new height (update max and add water after advance)
- Update `lm = max(lm, height[l])` **before** computing `ans += lm - height[l]` — max is monotone, difference always ≥ 0
- `lm` and `rm` initialized to `height[l]` and `height[r]` respectively

---

## Edge Cases

- `n < 3` → no water possible (no "valley")
- Monotone increasing/decreasing → no trapped water
- All same height → no trapped water

---

## Common Mistakes

- Computing `ans += lm - height[l]` before `lm = max(lm, height[l])` — `lm` might be less than `height[l]`, giving negative contribution
- Confusing with max-water-container (different problem: area vs trapped water)

---

## Complexity

| | |
|--|--|
| Time | O(n) |
| Space | O(1) with two pointers; O(n) with prefix arrays |

---

## Similar Problems

- [max-water-container](../max-water-container/README.md) — maximize area, same two-pointer from ends idea

---

## One-line Takeaway

**Process the side with smaller max; water = max - height; update max before adding water.**

---

## Revision Checklist

- [ ] Why process the smaller-max side?
- [ ] Update `lm` BEFORE or AFTER adding water?
- [ ] How is this different from max-water-container?

---

## Revision History

| Date | Note |
|------|------|
| — | Documented from `submission-3.java` |
