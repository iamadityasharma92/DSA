# Valid Palindrome II

| Field | Value |
|-------|-------|
| Topic | Two Pointers |
| Difficulty | Easy |
| Primary Pattern | Two Pointers |
| Secondary Pattern | Greedy |
| Confidence | — |
| Last Revision | Never |

---

## Problem Summary

Interview problem `valid-palindrome-ii`. Documented from accepted Java submissions in this folder (best understanding across attempts).

---

## Core Observation

At most one deletion—branch into two checks excluding mismatched side.

---

## Thinking Process

1. l,r inward compare
2. If match continue
3. On mismatch return isPal(l+1,r) or isPal(l,r-1)
4. Helper linear scan

**Best understanding:** Two pointers; on mismatch try skip left or skip right char; check palindrome once

---

## Why the Approach Works

Only two candidates for single removal at first mismatch.

---

## Pattern Recognition

| Role | Pattern |
|------|---------|
| Primary | Two Pointers |
| Secondary | Greedy |

### Pattern Recognition Clues

- Delete at most one char
- Palindrome check

Cross-ref: topic hub · [PATTERNS.md](../../PATTERNS.md)

---

## Alternative Approaches

Reverse substring checks—more work.

---

## Critical Implementation Details

- Only one skip allowed total
- Helper without further skips

---

## Edge Cases

- Already palindrome
- Mismatch at ends

---

## Common Mistakes

- Allowing two skips
- Not branching both sides

---

## Complexity

| | |
|--|--|
| Time | O(n) |
| Space | O(1) |

---

## Similar Problems

- [is-palindrome](../is-palindrome/README.md)
- [reverse-string](../reverse-string/README.md)

---

## One-line Takeaway

**Palindrome with one skip → two-pointer branch on mismatch.**

---

## Revision Checklist

- [ ] first mismatch branch
- [ ] single skip helper

---

## Revision History

| Date | Note |
|------|------|
| — | Initial documentation from submission-1 |
