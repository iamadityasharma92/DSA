# Valid Palindrome

| Field | Value |
|-------|-------|
| Topic | Two Pointers |
| Difficulty | Easy |
| Primary Pattern | Two Pointers (converging) |
| Secondary Pattern | String normalization |
| Confidence | — |
| Last Revision | Never |

---

## Problem Summary

Given string `s`, return `true` if it is a palindrome considering only alphanumeric characters and ignoring case.

---

## Constraints (typical)

- `1 ≤ s.length ≤ 2 × 10⁵`
- May contain spaces, punctuation, mixed case

---

## Brute Force

Extract only alphanumeric chars into a new string, reverse, compare — O(n) but O(n) extra space for the cleaned string.

---

## Core Observation

Strip non-alphanumeric characters (regex), lowercase, then apply the classic two-pointer palindrome check from both ends.

---

## Thinking Process

1. `s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase()`.
2. `l = 0`, `r = s.length() - 1`.
3. While `l < r`: if `s.charAt(l++) != s.charAt(r--)` → return `false`.
4. Return `true`.

---

## Why the Approach Works

Normalization reduces the problem to a standard palindrome check. Two-pointer comparison from both ends finds any mismatch in O(n) with O(1) pointer ops after the O(n) cleaning.

---

## Pattern Recognition

| Role | Pattern |
|------|---------|
| Primary | Two pointers converging from both ends |
| Alternative | Inline skip: advance pointers past non-alphanum without separate cleaning |

### Pattern Recognition Clues

- "Palindrome ignoring non-alphanumeric"
- Two-character symmetry check

Cross-ref: [Two Pointers](../Two%20Pointers/README.md)

---

## Alternative Approaches

**In-place skip (space-efficient):** advance `l` and `r` while non-alphanumeric, then compare characters directly. O(n) time, O(1) extra space (no cleaned string needed).

---

## Critical Implementation Details

- `replaceAll("[^a-zA-Z0-9]", "")` removes all non-alphanumeric — the second `replaceAll(" ", "")` in the submission is redundant (spaces already removed by first regex)
- `toLowerCase()` before comparison
- Post-increment/decrement: `s.charAt(l++) != s.charAt(r--)` in one expression

---

## Edge Cases

- Empty string after cleaning → palindrome (true)
- Single character → true
- All non-alphanumeric → empty after clean → true
- Case differences: `"A man a plan"` must lowercase correctly

---

## Common Mistakes

- Not lowercasing before comparison
- Comparing characters before skipping non-alphanumeric (if using in-place approach)
- Off-by-one: loop condition `l < r` not `l <= r`

---

## Complexity

| | |
|--|--|
| Time | O(n) |
| Space | O(n) — cleaned string; O(1) with in-place pointer skip |

---

## Similar Problems

- [valid-palindrome-ii](../valid-palindrome-ii/README.md) — at most one deletion allowed

---

## One-line Takeaway

**Normalize (strip non-alnum, lowercase), then two pointers from both ends.**

---

## Revision Checklist

- [ ] Regex pattern to keep only alphanumeric?
- [ ] Why `l < r` not `l <= r`?
- [ ] Describe the O(1) space in-place pointer approach.

---

## Revision History

| Date | Note |
|------|------|
| — | Documented from `submission-1.java` |
