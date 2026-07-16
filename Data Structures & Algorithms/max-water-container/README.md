# Container with Most Water

| Field | Value |
|-------|-------|
| Topic | Two Pointers |
| Difficulty | Medium |
| Primary Pattern | Two Pointers (converging) |
| Secondary Pattern | Greedy: advance the shorter side |
| Confidence | — |
| Last Revision | Never |

---

## Problem Summary

Given `n` vertical lines, find two lines that together with the x-axis form a container holding the most water. Return the maximum area.

---

## Constraints (typical)

- `n ≥ 2`
- `0 ≤ height[i] ≤ 10⁴`

---

## Brute Force

Try all pairs → O(n²). TLE.

---

## Core Observation

Area = `min(h[l], h[r]) × (r - l)`. Two pointers start at maximum width. The only way to potentially increase area is to move the shorter pointer inward (the taller pointer staying can't help — width decreases).

---

## Thinking Process

1. `l = 0`, `r = n - 1`, `ans = 0`.
2. While `l < r`:
   - `area = (r - l) × min(h[l], h[r])`
   - `ans = max(ans, area)`
   - Advance the shorter pointer: if `h[l] <= h[r]` → `l++`; else `r--`.
3. Return `ans`.

---

## Why the Approach Works

When we advance the shorter pointer, we correctly discard its pairings with all interior lines — none of those could exceed the current area (smaller width, bounded by the shorter height). The greedy choice is provably optimal.

---

## Pattern Recognition

| Role | Pattern |
|------|---------|
| Primary | Two pointers converging — advance the limiting side |
| Contrast | `trapping-rain-water` also uses two pointers but accumulates trapped water differently |

### Pattern Recognition Clues

- "Maximum area / water between boundaries"
- Start at widest gap and squeeze inward

Cross-ref: [Two Pointers](../Two%20Pointers/README.md)

---

## Alternative Approaches

O(n²) brute force — all pairs. No other known O(n) approach.

---

## Critical Implementation Details

- Area computed **before** advancing the pointer — after advance the pair no longer exists
- `h[l] <= h[r]` → advance `l` (equal heights → advance either; advancing `l` is fine)
- Width is `r - l`, not `r - l + 1`

---

## Edge Cases

- Two elements → single pair
- All same height → widest pair wins
- Monotonically increasing heights → last pair wins

---

## Common Mistakes

- Advancing the taller pointer instead of shorter (suboptimal, may miss the answer)
- Computing area after the pointer move (pointer has already changed, wrong pair)
- `r - l + 1` width (off by one — no containers at same index)

---

## Complexity

| | |
|--|--|
| Time | O(n) |
| Space | O(1) |

---

## Similar Problems

- [trapping-rain-water](../trapping-rain-water/README.md) — two pointer accumulation of trapped water

---

## One-line Takeaway

**Two pointers from ends; advance the shorter side; area = min(h) × width.**

---

## Revision Checklist

- [ ] Why advance the shorter pointer, not the taller?
- [ ] Compute area before or after advancing?
- [ ] How does this differ from trapping-rain-water?

---

## Revision History

| Date | Note |
|------|------|
| — | Documented from `submission-3.java` |
