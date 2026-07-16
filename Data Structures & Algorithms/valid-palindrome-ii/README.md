# Valid Palindrome II

| Field | Value |
|-------|-------|
| Topic | Two Pointers |
| Difficulty | Easy |
| Primary Pattern | Two Pointers + branching palindrome check |
| Secondary Pattern | — |
| Confidence | — |
| Last Revision | Never |

---

## Problem Summary

Given a string `s`, return `true` if it can be a palindrome after deleting **at most one** character.

---

## Constraints (typical)

- `1 ≤ s.length ≤ 5 × 10⁵`
- Lowercase English letters only
- At most ONE deletion

---

## Brute Force

Try deleting each character and check if the remaining is a palindrome → O(n²). TLE.

---

## Core Observation

Two-pointer palindrome scan. When a mismatch is found at `l` and `r`, try deleting either: check if `s[l+1..r]` or `s[l..r-1]` is a palindrome. Either valid → return `true`.

---

## Thinking Process

1. `l = 0`, `r = n-1`.
2. While `l < r`:
   - If `s[l] == s[r]` → `l++`, `r--`.
   - Else → `return isPalin(s, l+1, r) || isPalin(s, l, r-1)`.
3. Return `true` (no mismatch → already palindrome).

**`isPalin(s, l, r)`:** standard two-pointer palindrome check on substring.

---

## Why the Approach Works

When we first encounter a mismatch, we've used 0 deletions. We must delete one of `s[l]` or `s[r]`. Checking both branches covers all possibilities. Beyond the first mismatch, no more deletions allowed — hence a standard palindrome check for each branch.

---

## Pattern Recognition

| Role | Pattern |
|------|---------|
| Primary | Two pointer + try-one-deletion branching |
| Contrast | is-palindrome has no deletions; this has one |

### Pattern Recognition Clues

- "Palindrome with at most k deletions" (here k=1)
- On first mismatch, try deleting left or right character

Cross-ref: [Two Pointers](../Two%20Pointers/README.md)

---

## Alternative Approaches

Brute force with all deletions — O(n²). DP for k > 1 deletions using longest palindromic subsequence.

---

## Critical Implementation Details

- Only branch on the **first** mismatch — both branches use a helper that allows no further deletions
- `isPalin` is a clean helper (no class state needed)
- `return true` at the end (no mismatches → already palindrome, 0 deletions used)

---

## Edge Cases

- Already a palindrome → return `true` (loop completes without branching)
- Single character → `true`
- Two characters: `"ab"` → delete either → `true`
- "aba" style → palindrome directly

---

## Common Mistakes

- Allowing a second deletion in `isPalin` (recursion or flag)
- Forgetting the final `return true` after the while loop

---

## Complexity

| | |
|--|--|
| Time | O(n) |
| Space | O(1) |

---

## Similar Problems

- [is-palindrome](../is-palindrome/README.md) — zero deletions, same two-pointer

---

## One-line Takeaway

**Two pointers until mismatch; try deleting left OR right; standard palindrome check for each.**

---

## Revision Checklist

- [ ] What happens at a mismatch — branch or continue?
- [ ] Does the `isPalin` helper allow further deletions?
- [ ] Final `return true` after loop — when does it trigger?

---

## Revision History

| Date | Note |
|------|------|
| — | Documented from `submission-1.java` |
