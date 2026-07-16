# Merge Strings Alternately

| Field | Value |
|-------|-------|
| Topic | Two Pointers |
| Difficulty | Easy |
| Primary Pattern | Two Pointers advancing independently |
| Secondary Pattern | — |
| Confidence | — |
| Last Revision | Never |

---

## Problem Summary

Merge two strings `words1` and `words2` by alternating characters (one from each), starting with `words1`. If one string is longer, append the remaining characters at the end.

---

## Constraints (typical)

- `1 ≤ words1.length, words2.length ≤ 100`

---

## Brute Force

No brute force — the simple two-pointer approach IS optimal.

---

## Core Observation

One pass with two pointers: each iteration appends one char from `words1` (if available) then one from `words2` (if available). The loop runs while **either** pointer has characters remaining.

---

## Thinking Process

1. `l = r = 0`, `StringBuilder ans`.
2. While `l < m || r < n`:
   - If `l < m`: append `words1.charAt(l++)`.
   - If `r < n`: append `words2.charAt(r++)`.
3. Return `ans.toString()`.

---

## Why the Approach Works

The while condition `||` ensures we don't stop until both strings are exhausted. The `if` guards inside safely append only when characters remain, so the longer string's tail is automatically appended.

---

## Pattern Recognition

| Role | Pattern |
|------|---------|
| Primary | Dual pointer advancing with independent guards |
| Contrast | Merge sorted array uses `&&` in the outer loop (stops when one is done) |

### Pattern Recognition Clues

- "Merge/interleave two sequences of possibly different lengths"
- Append remainder after one is exhausted

---

## Alternative Approaches

`submission-1`'s commented-out block: handle remainder after main loop with `words1.substring(l, m)` / `words2.substring(r, n)`. Same result, slightly different structure.

---

## Critical Implementation Details

- Outer condition is `||` not `&&` — must not stop until both are exhausted
- Two `if` statements (not `if-else`) inside the loop — both must append per iteration
- Use `StringBuilder` not `String` concatenation (O(n) total vs O(n²))

---

## Edge Cases

- `words1.length > words2.length` → extra `words1` chars appended
- `words2.length > words1.length` → extra `words2` chars appended
- Equal lengths → pure alternation, no remainder

---

## Common Mistakes

- `&&` instead of `||` in loop condition (stops early when shorter string is done)
- `if-else` instead of two `if`s (appends only one char per iteration)

---

## Complexity

| | |
|--|--|
| Time | O(m + n) |
| Space | O(m + n) — output |

---

## Similar Problems

- [merge-sorted-array](../merge-sorted-array/README.md) — merge two sorted arrays

---

## One-line Takeaway

**`||` loop: append from each if available — both strings drain completely.**

---

## Revision Checklist

- [ ] `||` vs `&&` in while condition?
- [ ] Two `if` statements or `if-else`?
- [ ] Why use `StringBuilder`?

---

## Revision History

| Date | Note |
|------|------|
| — | Documented from `submission-1.java` |
