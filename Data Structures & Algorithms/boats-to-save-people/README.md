# Boats to Save People

| Field | Value |
|-------|-------|
| Topic | Two Pointers / Greedy |
| Difficulty | Medium |
| Primary Pattern | Sort + opposite-end greedy |
| Secondary Pattern | Two Pointers |
| Confidence | — |
| Last Revision | Never |

---

## Problem Summary

Each boat holds ≤2 people and weight ≤ `limit`. Min boats to rescue all.

---

## Brute Force

Try all pairings — exponential.

---

## Core Observation

Sort weights. Heaviest person either pairs with the lightest if possible, else goes alone. Never leave a heavy waiting while pairing two lights first (greedy exchange).

---

## Thinking Process

`l=0`, `r=n-1`; while `l <= r`: always take a boat for `people[r]`; if `people[l]+people[r] <= limit`, also take `l++`; always `r--`.

**Best understanding:** `submission-2` (cleaner). `submission-0` is equivalent in spirit but has a dead `sum < limit` branch.

---

## Why the Approach Works

Heaviest must board; pair with lightest if any partner fits — maximizes chance to free a seat without stranding heavier people.

---

## Pattern Recognition

| Role | Pattern |
|------|---------|
| Primary | Greedy + two pointers after sort |
| Clue | “At most two per boat” + weight limit |

See: [Two Pointers](../Two%20Pointers/README.md), [Greedy](../Greedy/README.md), [PATTERNS.md](../../PATTERNS.md#greedy--two-pointer-pairing).

---

## Critical Implementation Details

- Loop `l <= r` so the last person alone still counts a boat
- Every iteration increments boat count once

---

## Edge Cases

- All alone (each > limit/2); exact pairs; `n=1`

---

## Common Mistakes

- Forgetting the single remaining person
- Pairing two mediums while a heavy is stranded incorrectly

---

## Complexity

O(n log n) sort + O(n), O(1)/O(log n) space.

---

## Similar Problems

- Two-pointer container / k-sum style pairing
- [max-water-container](../max-water-container/README.md) — opposite ends, different goal

---

## One-line Takeaway

**Sort; always seat heaviest; add lightest only if they fit together.**

---

## Revision Checklist

- [ ] Write the `c++; if fit l++; r--;` loop
- [ ] Why heaviest-first?

---

## Revision History

| Date | Note |
|------|------|
| — | Best: `submission-2.java` |
