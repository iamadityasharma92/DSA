# Valid Anagram

| Field | Value |
|-------|-------|
| Topic | Arrays & Hashing |
| Difficulty | Easy |
| Primary Pattern | Frequency count array |
| Secondary Pattern | — |
| Confidence | — |
| Last Revision | Never |

---

## Problem Summary

Given two strings `s` and `t`, return `true` if `t` is an anagram of `s` (same characters with the same frequencies), `false` otherwise.

---

## Constraints (typical)

- `1 ≤ s.length, t.length ≤ 5 × 10⁴`
- Strings consist of lowercase English letters

---

## Brute Force

Sort both strings and compare — O(n log n). Valid but slower than counting.

---

## Core Observation

Anagrams have identical character frequencies. A `int[26]` array tracks the difference: increment for `s`, decrement for `t`. If any count goes negative during the `t` scan, `t` has an excess of some character — not an anagram.

---

## Thinking Process

1. Early return `false` if `s.length() != t.length()`.
2. `freq[26]` — increment for each char in `s`: `freq[ch - 97]++`.
3. Decrement for each char in `t`: `freq[ch - 97]--`. If result `< 0` → return `false`.
4. Return `true`.

---

## Why the Approach Works

If the strings are the same length and the frequency count of `t` never goes below zero, then `t` has exactly the same frequency for every character as `s`. The early length check filters cases like `s = "ab"`, `t = "a"`.

---

## Pattern Recognition

| Role | Pattern |
|------|---------|
| Primary | Frequency array fingerprint |
| Upgrade | HashMap for unicode / large alphabets |
| Compare | `anagram-groups` uses sorted key as fingerprint; this counts directly |

### Pattern Recognition Clues

- "Same character counts?"
- Fixed lowercase alphabet → int[26] beats HashMap

Cross-ref: [Arrays & Hashing](../Arrays%20%26%20Hashing/README.md) · [PATTERNS.md](../../PATTERNS.md#hashing--canonical-keys)

---

## Alternative Approaches

**Sort:** `Arrays.sort(s.toCharArray())`, compare to sorted `t` → O(n log n), simple.

**HashMap:** works for any alphabet; `O(n)` but higher constant.

---

## Critical Implementation Details

- Length check first — avoids false positives from prefix matches
- Check `< 0` (not `!= 0`) during the `t` scan — going below zero means `t` has a character `s` doesn't have
- `ch - 97` maps `'a'` to 0, `'z'` to 25

---

## Edge Cases

- Same string → true
- `s = "a"`, `t = "b"` → false (same length, different char)
- Empty strings (equal length 0) → true

---

## Common Mistakes

- Checking `!= 0` after both passes instead of `< 0` during `t` pass (same result but less clean)
- Forgetting the length check at the start

---

## Complexity

| | |
|--|--|
| Time | O(n) |
| Space | O(1) — 26-element array |

---

## Similar Problems

- [anagram-groups](../anagram-groups/README.md) — group anagrams using sorted key
- [permutation-string](../permutation-string/README.md) — sliding window anagram in a larger string

---

## One-line Takeaway

**Count chars in s (+1), uncount in t (-1); negative freq = not anagram.**

---

## Revision Checklist

- [ ] Why length check before counting?
- [ ] Check `< 0` during `t` scan — what does it mean?
- [ ] When to upgrade from `int[26]` to HashMap?

---

## Revision History

| Date | Note |
|------|------|
| — | Documented from `submission-0.java` |
