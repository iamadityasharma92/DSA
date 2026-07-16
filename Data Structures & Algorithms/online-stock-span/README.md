# Online Stock Span

| Field | Value |
|-------|-------|
| Topic | Stack |
| Difficulty | Medium |
| Primary Pattern | Monotonic Stack |
| Secondary Pattern | Design |
| Confidence | — |
| Last Revision | Never |

---

## Problem Summary

Interview problem `online-stock-span`. Documented from accepted Java submissions in this folder (best understanding across attempts).

---

## Core Observation

Previous greater price boundary defines consecutive span accumulation.

---

## Thinking Process

1. On next(price)
2. While stack top price ≤ price pop accumulate span
3. Push (price, span)
4. Return span

**Best understanding:** Stack of (price, span); pop while price ≤ current; span = 1 + sum popped spans

---

## Why the Approach Works

Monotonic decreasing stack stores prior days with unresolved greater search.

---

## Pattern Recognition

| Role | Pattern |
|------|---------|
| Primary | Monotonic Stack |
| Secondary | Design |

### Pattern Recognition Clues

- Consecutive days before lower price
- Streaming design

Cross-ref: topic hub · [PATTERNS.md](../../PATTERNS.md)

---

## Alternative Approaches

Scan backward each call O(n²) total worst.

---

## Critical Implementation Details

- Pop while ≤ not < per problem
- Accumulate popped spans

---

## Edge Cases

- First day span 1
- Monotonic increasing prices

---

## Common Mistakes

- Strict vs non-strict compare
- Not summing popped spans

---

## Complexity

| | |
|--|--|
| Time | O(1) amortized per call |
| Space | O(n) |

---

## Similar Problems

- [daily-temperatures](../daily-temperatures/README.md)
- [sliding-window-maximum](../sliding-window-maximum/README.md)

---

## One-line Takeaway

**Stock span → decreasing stack accumulate spans on pop.**

---

## Revision Checklist

- [ ] Pop ≤ prices
- [ ] Sum spans

---

## Revision History

| Date | Note |
|------|------|
| — | Initial documentation from submission-0 |
