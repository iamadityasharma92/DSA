# Contains Duplicate II

| Field | Value |
|-------|-------|
| Topic | Sliding Window |
| Difficulty | Easy |
| Primary Pattern | Sliding Window |
| Secondary Pattern | Hashing |
| Confidence | — |
| Last Revision | Never |

---

## Problem Summary

Interview problem `contains-duplicate-ii`. Documented from accepted Java submissions in this folder (best understanding across attempts).

---

## Core Observation

Duplicate within distance k means same value reappears inside a k-wide index window.

---

## Thinking Process

1. Scan with index i
2. If nums[i] seen and i - map[nums[i]] ≤ k → true
3. Update last index for nums[i]
4. Finish → false

**Best understanding:** Map value → last index; if i - last ≤ k return true

---

## Why the Approach Works

Only latest index matters for future distance checks.

---

## Pattern Recognition

| Role | Pattern |
|------|---------|
| Primary | Sliding Window |
| Secondary | Hashing |

### Pattern Recognition Clues

- Equal values at most k indices apart
- Streaming index constraint

Cross-ref: topic hub · [PATTERNS.md](../../PATTERNS.md)

---

## Alternative Approaches

HashSet window of size k+1 with eviction.

---

## Critical Implementation Details

- Index distance not value distance
- Update map after check

---

## Edge Cases

- k = 0
- No pair exists

---

## Common Mistakes

- Using value difference
- Not updating stored index

---

## Complexity

| | |
|--|--|
| Time | O(n) |
| Space | O(min(n,k)) |

---

## Similar Problems

- [duplicate-integer](../duplicate-integer/README.md)
- [longest-substring-without-duplicates](../longest-substring-without-duplicates/README.md)

---

## One-line Takeaway

**Index-distance duplicate check → last-seen map or size-(k+1) window.**

---

## Revision Checklist

- [ ] i - prevIndex ≤ k
- [ ] Update on each step

---

## Revision History

| Date | Note |
|------|------|
| — | Initial documentation from submission-1 |
