# Two Integer Sum

| Field | Value |
|-------|-------|
| Topic | Arrays & Hashing |
| Difficulty | Easy |
| Primary Pattern | Hashing |
| Secondary Pattern | Array |
| Confidence | — |
| Last Revision | Never |

---

## Problem Summary

Interview problem `two-integer-sum`. Documented from accepted Java submissions in this folder (best understanding across attempts).

---

## Core Observation

Complement lookup in one pass finds pair summing to target.

---

## Thinking Process

1. map empty
2. For each nums[i] need=target-nums[i]
3. If need in map return [map[need],i]
4. Else map[nums[i]]=i

**Best understanding:** Map value→index; for x check if target-x seen return indices

---

## Why the Approach Works

Hash gives O(1) complement test while building map.

---

## Pattern Recognition

| Role | Pattern |
|------|---------|
| Primary | Hashing |
| Secondary | Array |

### Pattern Recognition Clues

- Two sum unsorted
- Return indices

Cross-ref: topic hub · [PATTERNS.md](../../PATTERNS.md)

---

## Alternative Approaches

Sort + two pointers if need values not indices.

---

## Critical Implementation Details

- Check complement before insert
- Single solution guaranteed

---

## Edge Cases

- Negative numbers
- Same value used twice different indices

---

## Common Mistakes

- Adding before checking
- Returning values not indices

---

## Complexity

| | |
|--|--|
| Time | O(n) |
| Space | O(n) |

---

## Similar Problems

- [two-integer-sum-ii](../two-integer-sum-ii/README.md)
- [three-integer-sum](../three-integer-sum/README.md)

---

## One-line Takeaway

**Two sum unsorted → hash complement before insert.**

---

## Revision Checklist

- [ ] target-x lookup
- [ ] store index

---

## Revision History

| Date | Note |
|------|------|
| — | Initial documentation from submission-2 |
