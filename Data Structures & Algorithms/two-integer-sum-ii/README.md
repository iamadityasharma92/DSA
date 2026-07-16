# Two Integer Sum II

| Field | Value |
|-------|-------|
| Topic | Two Pointers |
| Difficulty | Medium |
| Primary Pattern | Two Pointers |
| Secondary Pattern | Array |
| Confidence | — |
| Last Revision | Never |

---

## Problem Summary

Interview problem `two-integer-sum-ii`. Documented from accepted Java submissions in this folder (best understanding across attempts).

---

## Core Observation

Monotonic sum movement toward target on sorted array.

---

## Thinking Process

1. l left r right
2. sum = numbers[l]+numbers[r]
3. Too small l++ too big r--
4. Match return [l+1,r+1]

**Best understanding:** Sorted array: l=0,r=n-1; if sum<target l++ else if >target r-- else return 1-indexed

---

## Why the Approach Works

Increasing l raises sum; decreasing r lowers sum—converges to target.

---

## Pattern Recognition

| Role | Pattern |
|------|---------|
| Primary | Two Pointers |
| Secondary | Array |

### Pattern Recognition Clues

- Sorted input 1-indexed answer
- Exactly one solution

Cross-ref: topic hub · [PATTERNS.md](../../PATTERNS.md)

---

## Alternative Approaches

HashMap works but wastes sorted property.

---

## Critical Implementation Details

- 1-indexed output
- Single solution moves uniquely

---

## Edge Cases

- Two elements
- Large gap pointers

---

## Common Mistakes

- 0-indexed return
- Using hash ignoring sorted

---

## Complexity

| | |
|--|--|
| Time | O(n) |
| Space | O(1) |

---

## Similar Problems

- [two-integer-sum](../two-integer-sum/README.md)
- [three-integer-sum](../three-integer-sum/README.md)

---

## One-line Takeaway

**Two sum sorted → opposite pointers adjust sum.**

---

## Revision Checklist

- [ ] l r pointers
- [ ] 1-indexed pair

---

## Revision History

| Date | Note |
|------|------|
| — | Initial documentation from submission-1 |
