# Longest Substring Without Repeating Characters

| Field | Value |
|-------|-------|
| Topic | Sliding Window |
| Difficulty | Medium |
| Primary Pattern | Sliding Window + HashSet |
| Secondary Pattern | Two Pointers |
| Confidence | — |
| Last Revision | Never |

---

## Problem Summary

Given a string `s`, find the length of the longest substring without repeating characters.

---

## Constraints (typical)

- `0 ≤ s.length ≤ 5 × 10⁴`
- Characters: English letters, digits, symbols, spaces

---

## Brute Force

Check all `O(n²)` substrings with a set for uniqueness → O(n³) or O(n²). TLE.

---

## Core Observation

Maintain a sliding window `[l, r]` that always contains only unique characters. When `s[r]` would create a duplicate: remove `s[l]` from the set and advance `l` (shrink one step). This ensures the window never contains duplicates.

---

## Thinking Process

1. `l = r = 0`, `HashSet<Character> set`, `maxi = 0`.
2. While `r < n`:
   - If `set.contains(s[r])`: remove `s[l]`; `l++`. (Shrink, don't advance `r` yet.)
   - Else: `set.add(s[r])`; `r++`; `maxi = max(set.size(), maxi)`.
3. Return `maxi`.

---

## Why the Approach Works

By removing only the leftmost character and checking again, the window contracts until the duplicate is gone. Each character is added and removed at most once — amortized O(n).

---

## Pattern Recognition

| Role | Pattern |
|------|---------|
| Primary | Variable sliding window — shrink on violation |
| Tool | HashSet for O(1) membership check |
| Alternative | Map `char → last index` for O(1) jump instead of one-step shrink |

### Pattern Recognition Clues

- "Longest substring without repeating characters"
- Window validity = no duplicate character

Cross-ref: [Sliding Window](../Sliding%20Window/README.md) · [PATTERNS.md](../../PATTERNS.md#sliding-window-variable--fixed)

---

## Alternative Approaches

**Index map:** `map.put(char, index)`. On duplicate at `r`: `l = max(l, map.get(s[r]) + 1)` — jump directly past the old occurrence. O(n) without removing chars one by one.

---

## Critical Implementation Details

- Only advance `r` after successfully adding to set (else clause)
- Track `maxi` as `set.size()` at valid states, or as `r - l` in the index-map approach
- One-step shrink per iteration: `l++` once, then re-check on next iteration

---

## Edge Cases

- Empty string → 0
- Single character → 1
- All same character → 1
- All unique → entire string length

---

## Common Mistakes

- Advancing `r` even on duplicate (skips characters, produces wrong window)
- Not updating `maxi` after the window grows

---

## Complexity

| | |
|--|--|
| Time | O(n) amortized — each char added/removed ≤ once |
| Space | O(min(n, charset)) |

---

## Similar Problems

- [longest-repeating-substring-with-replacement](../longest-repeating-substring-with-replacement/README.md) — same window shape, different validity condition
- [contains-duplicate-ii](../contains-duplicate-ii/README.md) — also uses sliding set

---

## One-line Takeaway

**HashSet window: add-right on unique char, remove-left on duplicate; track max window size.**

---

## Revision Checklist

- [ ] When do you advance `r` vs only advance `l`?
- [ ] Where do you update `maxi`?
- [ ] Describe the O(n) index-map jump approach.

---

## Revision History

| Date | Note |
|------|------|
| — | Documented from `submission-1.java` |
