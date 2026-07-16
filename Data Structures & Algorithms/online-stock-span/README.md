# Online Stock Span

| Field | Value |
|-------|-------|
| Topic | Stack |
| Difficulty | Medium |
| Primary Pattern | Monotonic Stack (accumulated span) |
| Secondary Pattern | — |
| Confidence | — |
| Last Revision | Never |

---

## Problem Summary

Design a class `StockSpanner` with `next(price)` that returns the **stock span** of today's price: the maximum number of consecutive days (including today) where the price was ≤ today's price.

---

## Constraints (typical)

- `1 ≤ price ≤ 10⁵`
- At most `10⁴` calls to `next`

---

## Brute Force

For each call, scan backward to count consecutive non-greater prices → amortized O(n) per call in worst case. O(n²) overall.

---

## Core Observation

Maintain a **monotonic decreasing stack** of `{price, span}` pairs. When today's price ≥ a popped price, absorb its accumulated span into today's span. This collapses multiple past days into a single stack entry, enabling O(1) amortized per call.

---

## Thinking Process

1. `Stack<int[]> s` of `{price, span}`.
2. `next(price)`:
   - `span = 1` (today itself).
   - While `!s.isEmpty() && s.peek()[0] <= price`: `span += s.pop()[1]`.
   - `s.push({price, span})`.
   - Return `span`.

---

## Why the Approach Works

Collapsed stack entries represent contiguous runs of days already "absorbed" — re-scanning is unnecessary. Each day is pushed once and popped at most once → amortized O(1) per call.

---

## Pattern Recognition

| Role | Pattern |
|------|---------|
| Primary | Monotonic stack + span accumulation (looking back) |
| Contrast | daily-temperatures uses `>` (strictly greater, looking forward); this uses `<=` (looking back) |

### Pattern Recognition Clues

- "Consecutive preceding days with price ≤ today"
- Online (streaming), can't look forward

Cross-ref: [Stack](../Stack/README.md) · [PATTERNS.md](../../PATTERNS.md#monotonic-stack)

---

## Alternative Approaches

Brute backward scan per call — O(n²) total. Only viable for small inputs.

---

## Critical Implementation Details

- Pop condition: `s.peek()[0] <= price` (not `<`) — equal prices are part of the span
- Store **accumulated span** in the stack entry, not raw day indices — this is the key that avoids re-traversal
- Initial `span = 1` (today counts regardless)

---

## Edge Cases

- Strictly increasing prices → each spans only itself (nothing popped)
- Strictly decreasing prices → stack grows with every call
- All same prices → each new price pops everything; spans grow as 1, 2, 3, …

---

## Common Mistakes

- Storing index instead of accumulated span (can't collapse correctly)
- Using `<` not `<=` in pop condition (misses equal-price spans)
- Comparing against `daily-temperatures` logic (`>` for future warmer day)

---

## Complexity

| | |
|--|--|
| Time | O(1) amortized — each price pushed/popped once |
| Space | O(n) |

---

## Similar Problems

- [daily-temperatures](../daily-temperatures/README.md) — same monotonic stack structure, opposite direction
- [minimum-stack](../minimum-stack/README.md) — auxiliary stack for O(1) aggregate

---

## One-line Takeaway

**Monotonic stack with accumulated spans: pop and absorb span when price ≤ today.**

---

## Revision Checklist

- [ ] Pop condition: `<=` not `<`?
- [ ] What is stored in the stack (price + accumulated span)?
- [ ] Why initial `span = 1`?
- [ ] Contrast with daily-temperatures (direction and comparison)?

---

## Revision History

| Date | Note |
|------|------|
| — | Documented from `submission-0.java` |
