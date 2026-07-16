# Daily Temperatures

| Field | Value |
|-------|-------|
| Topic | Stack |
| Difficulty | Medium |
| Primary Pattern | Monotonic Stack |
| Secondary Pattern | Next greater element |
| Confidence | — |
| Last Revision | Never |

---

## Problem Summary

Given an array `temperatures`, return an array `answer` where `answer[i]` is the number of days you have to wait after day `i` to get a warmer temperature. If no such day exists, `answer[i] = 0`.

---

## Constraints (typical)

- `1 ≤ temperatures.length ≤ 10⁵`
- `30 ≤ temperatures[i] ≤ 100`

---

## Brute Force

For each day, scan rightward for the first warmer day → O(n²). Exceeds time limit.

---

## Core Observation

This is a **next greater element** problem. A monotonic decreasing stack holds days that have not yet found a warmer day. When a warmer day `i` arrives, every cooler stack entry is resolved: `answer[poppedIndex] = i - poppedIndex`.

---

## Thinking Process

1. `Stack<int[]>` of `{temperature, index}`.
2. For each day `i` with temperature `t`:
   - While stack not empty and `t > stack.peek()[0]`: pop `pair`, set `res[pair[1]] = i - pair[1]`
   - Push `{t, i}`
3. Unresolved stack entries remain 0 (default array).

`submission-0` and `submission-3` are identical — the final version.

---

## Why the Approach Works

Each index is pushed once and popped at most once → amortized O(n). The stack stays strictly decreasing: any incoming temperature that beats the top resolves all topped-by temperatures in one while-loop sweep.

---

## Pattern Recognition

| Role | Pattern |
|------|---------|
| Primary | Monotonic decreasing stack |
| Contrast | Online Stock Span uses ≤ (non-strictly), accumulating spans |

### Pattern Recognition Clues

- "How many days until a warmer / larger value"
- "Next greater element to the right"
- Answer depends on future events → defer resolution with a stack

Cross-ref: [Stack](../Stack/README.md) · [PATTERNS.md](../../PATTERNS.md#monotonic-stack)

---

## Alternative Approaches

**Right-to-left scan with jumping:** For each `i` from right, jump by recorded distances to find next warmer — O(n) amortized, same result. Less intuitive.

---

## Critical Implementation Details

- Store **both** temperature and index on the stack — index is needed to compute the distance
- Pop condition is strictly `t > stack.peek()[0]` (equal temperature = not warmer)
- Result array initialized to 0; only resolved entries are written

---

## Edge Cases

- Strictly decreasing temps → all 0s (nothing ever popped)
- Single element → `[0]`
- Last day → always 0

---

## Common Mistakes

- Using `>=` instead of `>` in the pop condition (equal temp is not warmer)
- Storing only temperature without index → can't compute distance
- Using an increasing instead of decreasing monotonic stack

---

## Complexity

| | |
|--|--|
| Time | O(n) amortized |
| Space | O(n) for the stack |

---

## Similar Problems

- [online-stock-span](../online-stock-span/README.md) — monotonic stack accumulating backwards spans
- [asteroid-collision](../asteroid-collision/README.md) — stack collision simulation

---

## One-line Takeaway

**Monotonic decreasing stack of (temp, index); pop on warmer day, answer = i − popped index.**

---

## Revision Checklist

- [ ] What is stored on the stack (value + index, not just value)?
- [ ] Pop condition: `>` not `≥`?
- [ ] Why does every index get pushed/popped at most once?
- [ ] Difference vs Online Stock Span (direction, `≤` vs `>`)?

---

## Revision History

| Date | Note |
|------|------|
| — | Documented from `submission-0` / `submission-3` (identical optimal solutions) |
