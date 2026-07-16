# Longest Repeating Character Replacement

| Field | Value |
|-------|-------|
| Topic | Sliding Window |
| Difficulty | Medium |
| Primary Pattern | Sliding Window + max-frequency tracking |
| Secondary Pattern | — |
| Confidence | — |
| Last Revision | Never |

---

## Problem Summary

Given a string `s` and integer `k`, you can replace at most `k` characters. Find the length of the longest substring containing the same letter after at most `k` replacements.

---

## Constraints (typical)

- `1 ≤ s.length ≤ 10⁵`, `0 ≤ k ≤ s.length`
- Uppercase letters only

---

## Brute Force

`submission-0`: nested loops expanding every window and tracking `maxFreq` — O(n²). TLE.

---

## Core Observation

A window is valid iff `windowLen - maxFreq <= k` (the number of non-dominant characters ≤ replacements allowed). To maximize window length, track the maximum frequency character lazily.

**Key trick (`submission-2`):** never shrink `maxf` when shrinking the window — if `maxf` doesn't decrease, the window can only grow or stay the same, so we never record a worse answer.

---

## Thinking Process

1. `l = r = 0`, `maxf = 0`, `hash[26]`, `ans = 0`.
2. Expand: `hash[s[r]-'A']++`; update `maxf = max(maxf, hash[s[r]-'A'])`.
3. If `(r-l+1) - maxf > k`: shrink — `hash[s[l]-'A']--`; `l++`. (Do NOT recompute `maxf`.)
4. `ans = max(ans, r-l+1)`.
5. `r++`.

`submission-1` recomputes `maxf` on shrink (correct but slower). `submission-2` skips the recompute (key optimization).

---

## Why the Approach Works

The invariant `windowLen - maxf <= k` tracks valid windows. By not shrinking `maxf`, we guarantee the answer never decreases — the window monotonically grows or shifts. The lazy `maxf` is a safe upper bound that doesn't break correctness.

---

## Pattern Recognition

| Role | Pattern |
|------|---------|
| Primary | Variable sliding window with dominant char frequency |
| Key invariant | `windowLen - maxFreq <= k` |
| Contrast | Fixed-size windows (permutation-string) vs variable (this) |

### Pattern Recognition Clues

- "Longest substring with at most k replacements"
- Windows can shrink and grow; track character dominance

Cross-ref: [Sliding Window](../Sliding%20Window/README.md) · [PATTERNS.md](../../PATTERNS.md#sliding-window-variable--fixed)

---

## Alternative Approaches

`submission-1` recomputes `maxf` on shrink — correct, O(26n). `submission-2` skips recompute — O(n). Both pass.

---

## Critical Implementation Details

- Do NOT recompute `maxf` on shrink (key optimization of `submission-2`)
- `(r-l+1) - maxf` is changes needed; valid when `<= k`
- `maxf` is a running max — it can only grow, never decrease in the optimal approach

---

## Edge Cases

- `k >= s.length()` → entire string (all replacements)
- All same character → entire string (no replacements)
- `k = 0` → longest run of a single character

---

## Common Mistakes

- Recomputing `maxf` on shrink (wastes O(26) per shrink step)
- Using `>` instead of strict `>` in the shrink condition
- Confusing `windowLen - maxf` with `maxf - windowLen`

---

## Complexity

| | |
|--|--|
| Time | O(n) with lazy maxf; O(26n) with recompute |
| Space | O(1) — 26-char array |

---

## Similar Problems

- [longest-substring-without-duplicates](../longest-substring-without-duplicates/README.md) — variable window, different validity condition
- [permutation-string](../permutation-string/README.md) — fixed-size window, anagram check

---

## One-line Takeaway

**windowLen - maxFreq > k → shrink; never recompute maxFreq on shrink.**

---

## Revision Checklist

- [ ] What is the window validity condition?
- [ ] Why is it safe to not recompute `maxf` after shrinking?
- [ ] Contrast with recomputing variant?

---

## Revision History

| Date | Note |
|------|------|
| — | `submission-0` (brute O(n²)) → `submission-1` (recompute maxf) → `submission-2` (lazy maxf, optimal) |
