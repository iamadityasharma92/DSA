# Daily Temperatures

| Field | Value |
|-------|-------|
| Topic | Stack |
| Difficulty | Medium |
| Primary Pattern | Monotonic Stack |
| Secondary Pattern | Array |
| Confidence | — |
| Last Revision | Never |

---

## Problem Summary

Interview problem `daily-temperatures`. Documented from accepted Java submissions in this folder (best understanding across attempts).

---

## Core Observation

Next greater temperature to the right—unresolved cooler days wait on stack.

---

## Thinking Process

1. Scan i left to right
2. While T[i] > stack top temp: pop, set wait days
3. Push (T[i],i)
4. Unpopped stay 0

**Best understanding:** Decreasing stack of (temp,index); pop when warmer, ans= i - idx

---

## Why the Approach Works

Each index pushed/popped once—amortized O(n) next-greater resolution.

---

## Pattern Recognition

| Role | Pattern |
|------|---------|
| Primary | Monotonic Stack |
| Secondary | Array |

### Pattern Recognition Clues

- Wait until strictly warmer day
- Next greater element right

Cross-ref: topic hub · [PATTERNS.md](../../PATTERNS.md)

---

## Alternative Approaches

Brute O(n²) inner scan.

---

## Critical Implementation Details

- Store index for distance
- Strict > comparison

---

## Edge Cases

- Decreasing temps all 0
- Last day 0

---

## Common Mistakes

- >= vs >
- Stack without indices

---

## Complexity

| | |
|--|--|
| Time | O(n) |
| Space | O(n) |

---

## Similar Problems

- [online-stock-span](../online-stock-span/README.md)
- [sliding-window-maximum](../sliding-window-maximum/README.md)

---

## One-line Takeaway

**Next greater right → decreasing monotonic stack with indices.**

---

## Revision Checklist

- [ ] Pop on warmer
- [ ] ans = i - popped index

---

## Revision History

| Date | Note |
|------|------|
| — | Initial documentation from submission-3 |
