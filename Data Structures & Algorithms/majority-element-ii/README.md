# Majority Element II

| Field | Value |
|-------|-------|
| Topic | Arrays & Hashing |
| Difficulty | Medium |
| Primary Pattern | Extended Boyer-Moore Voting (2 candidates) |
| Secondary Pattern | Two-pass verification |
| Confidence | — |
| Last Revision | Never |

---

## Problem Summary

Return all elements appearing more than `⌊n/3⌋` times. Result may have 0, 1, or 2 elements (at most 2 elements can exceed n/3).

---

## Constraints (typical)

- `n ≥ 1`
- At most 2 valid results
- Must be O(n) time, O(1) space

---

## Brute Force

HashMap frequency count → O(n) time, O(n) space. Count, then filter.

---

## Core Observation

There can be at most 2 elements with frequency > n/3. Extended Boyer-Moore maintains **two** candidates and **two** counters. After one pass, candidates are found; a second pass verifies their actual frequency.

---

## Thinking Process

**Pass 1 — find candidates:**
1. `cand1 = cand2 = -1`, `c1 = c2 = 0`.
2. For each `num`:
   - If `cand1 == num` → `c1++`
   - Else if `cand2 == num` → `c2++`
   - Else if `c1 == 0` → `cand1 = num`, `c1 = 1`
   - Else if `c2 == 0` → `cand2 = num`, `c2 = 1`
   - Else → `c1--; c2--` (cancel both)

**Pass 2 — verify:**
3. Count actual occurrences of `cand1` and `cand2`.
4. Add to result if `count > n/3`.

---

## Why the Approach Works

Any element with frequency > n/3 will survive the two-candidate cancellation — it has more votes than the combined minority. At most 2 such elements can exist (3 × (n/3 + 1) > n). Verification pass handles edge cases where candidates are not truly majority.

---

## Pattern Recognition

| Role | Pattern |
|------|---------|
| Primary | Extended Boyer-Moore: k-1 candidates for > n/k threshold |
| Contrast | majority-element (> n/2) uses 1 candidate |

### Pattern Recognition Clues

- "> n/3 majority" or "> n/k majority"
- O(1) space required

Cross-ref: [Arrays & Hashing](../Arrays%20%26%20Hashing/README.md)

---

## Alternative Approaches

**HashMap:** count all, filter > n/3 — O(n) time, O(n) space.

---

## Critical Implementation Details

- Order of checks in pass 1 matters: check equality before checking `c == 0` (prevents duplicate candidates)
- `cand1 == i` before `c1 == 0` ensures an existing candidate gets votes rather than being replaced
- Verification pass is mandatory — Boyer-Moore finds candidates but doesn't guarantee they are actual majority

---

## Edge Cases

- Array with all same values → one result
- No element > n/3 → empty result
- Exactly two elements each appearing exactly n/3 + 1 times → two results

---

## Common Mistakes

- Checking `c1 == 0` before `cand1 == i` — candidate loses priority, wrong result
- Skipping the verification pass — picks wrong candidates

---

## Complexity

| | |
|--|--|
| Time | O(n) — two passes |
| Space | O(1) |

---

## Similar Problems

- [majority-element](../majority-element/README.md) — same voting, single candidate

---

## One-line Takeaway

**Two-candidate Boyer-Moore + verification pass: order of checks (equality before c==0) is critical.**

---

## Revision Checklist

- [ ] Why at most 2 elements can exceed n/3?
- [ ] Priority of checks in pass 1 (equality before c==0)?
- [ ] Why must you verify candidates in pass 2?

---

## Revision History

| Date | Note |
|------|------|
| — | Documented from `submission-2.java` |
