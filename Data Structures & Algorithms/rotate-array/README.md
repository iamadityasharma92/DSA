# Rotate Array

| Field | Value |
|-------|-------|
| Topic | Arrays & Hashing |
| Difficulty | Medium |
| Primary Pattern | Array Reversal |
| Secondary Pattern | Math |
| Confidence | — |
| Last Revision | Never |

---

## Problem Summary

Interview problem `rotate-array`. Documented from accepted Java submissions in this folder (best understanding across attempts).

---

## Core Observation

Three reversals cyclically shift array right by k in O(n) O(1) space.

---

## Thinking Process

1. k%=n
2. reverse(0,n-1)
3. reverse(0,k-1)
4. reverse(k,n-1)

**Best understanding:** Reverse whole, reverse first k, reverse rest; k%=n

---

## Why the Approach Works

Reversal algebra moves tail k elems to front without extra buffer.

---

## Pattern Recognition

| Role | Pattern |
|------|---------|
| Primary | Array Reversal |
| Secondary | Math |

### Pattern Recognition Clues

- Rotate right k steps
- O(1) space

Cross-ref: topic hub · [PATTERNS.md](../../PATTERNS.md)

---

## Alternative Approaches

GCD cyclic swaps or temp array O(n) space.

---

## Critical Implementation Details

- k mod n early
- Reverse index ranges correct

---

## Edge Cases

- k=0 noop
- k=n noop

---

## Common Mistakes

- Forgetting k%=n
- Wrong subarray reverse bounds

---

## Complexity

| | |
|--|--|
| Time | O(n) |
| Space | O(1) |

---

## Similar Problems

- [merge-sorted-array](../merge-sorted-array/README.md)
- [concatenation-of-array](../concatenation-of-array/README.md)

---

## One-line Takeaway

**Rotate right k → triple reverse trick.**

---

## Revision Checklist

- [ ] k%=n
- [ ] three reverses

---

## Revision History

| Date | Note |
|------|------|
| — | Initial documentation from submission-2 |
