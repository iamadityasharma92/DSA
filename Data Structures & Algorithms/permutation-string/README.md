# Permutation in String

| Field | Value |
|-------|-------|
| Topic | Sliding Window |
| Difficulty | Medium |
| Primary Pattern | Fixed-size Sliding Window + frequency comparison |
| Secondary Pattern | — |
| Confidence | — |
| Last Revision | Never |

---

## Problem Summary

Given strings `s1` and `s2`, return `true` if any permutation of `s1` is a substring of `s2`.

---

## Constraints (typical)

- `1 ≤ s1.length, s2.length ≤ 10⁴`
- Lowercase English letters only

---

## Brute Force

Generate all permutations of `s1` and check each in `s2` → O(n1! × n2). Completely infeasible.

---

## Core Observation

A permutation of `s1` is a rearrangement of the same characters — i.e., a substring of `s2` with the same length and the same character frequencies as `s1`. Slide a window of length `n1` over `s2` and compare frequency arrays at each position.

---

## Thinking Process

1. `c1[26]`, `c2[26]`. Populate both from first window (`s2[0..n1-1]`).
2. `l = 0`, `r = n1` (slide from the first window forward).
3. While `r < n2`:
   - If `matches(c1, c2)` → return `true`.
   - Else: `c2[s2[l++] - 'a']--`; `c2[s2[r++] - 'a']++`.
4. Return `matches(c1, c2)` (check last window).

---

## Why the Approach Works

The window always has size `n1`. Sliding one step: remove the leftmost character, add the rightmost new one. Each of the `n2 - n1 + 1` windows is checked with O(26) comparison → O(26 × n2) = O(n2).

---

## Pattern Recognition

| Role | Pattern |
|------|---------|
| Primary | Fixed-size sliding window with frequency fingerprint |
| Contrast | Minimum window substring is variable size; this is fixed size |
| Related | is-anagram: same-length comparison; this slides it over s2 |

### Pattern Recognition Clues

- "Permutation as substring"
- Fixed window size = len(s1)

Cross-ref: [Sliding Window](../Sliding%20Window/README.md) · [PATTERNS.md](../../PATTERNS.md#sliding-window-variable--fixed)

---

## Alternative Approaches

**Track `matches` count (26 chars):** increment/decrement an integer count instead of comparing all 26 entries each time → O(n2) with O(1) per slide. More optimal than O(26) per slide.

---

## Critical Implementation Details

- Fill `c2` with the **first** window (`i < n1`) before starting the slide
- The slide starts `r = n1` (already have the first window)
- Check `matches` before sliding (checking current window) then slide
- Final `matches(c1, c2)` checks the **last** window after `r` exits the loop

---

## Edge Cases

- `n1 > n2` → return `false` immediately
- `n1 == n2` → only one window to check
- `s1` is entirely repeated characters

---

## Common Mistakes

- Forgetting the final `matches(c1, c2)` after the loop (misses the last window)
- Sliding `r` but forgetting to slide `l` (window grows instead of shifts)
- Checking after sliding instead of before (checks next window, not current)

---

## Complexity

| | |
|--|--|
| Time | O(26 × n2) = O(n2) |
| Space | O(26) = O(1) |

---

## Similar Problems

- [is-anagram](../is-anagram/README.md) — same-length frequency check
- [minimum-window-with-characters](../minimum-window-with-characters/README.md) — variable window, superset check
- [longest-repeating-substring-with-replacement](../longest-repeating-substring-with-replacement/README.md) — variable window, frequency tracking

---

## One-line Takeaway

**Fixed window of len(s1) sliding over s2; compare char frequency arrays for anagram match.**

---

## Revision Checklist

- [ ] Window size is always `n1` — fixed, not variable?
- [ ] Final `matches` call after loop — why needed?
- [ ] Slide: remove `s2[l++]`, add `s2[r++]`?

---

## Revision History

| Date | Note |
|------|------|
| — | Documented from `submission-7.java` (cleanest version) |
