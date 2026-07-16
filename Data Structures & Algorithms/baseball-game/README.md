# Baseball Game

| Field | Value |
|-------|-------|
| Topic | Stack |
| Difficulty | Easy |
| Primary Pattern | Stack simulation |
| Secondary Pattern | Operation parsing |
| Confidence | — |
| Last Revision | Never |

---

## Problem Summary

Process score operations: integer record, `+` (sum of last two), `D` (double last), `C` (invalidate last). Return sum of all valid scores.

---

## Brute Force

Rebuild history with a list and recompute — stack is the natural structure.

---

## Core Observation

Only the **recent valid scores** matter; `C` undoes the last push → classic stack.

---

## Thinking Process

1. For each op: push int / push peek×2 / pop / push sum of top two (pop-peek-push carefully).
2. Sum remaining stack values.

---

## Why the Approach Works

Each op mutates only the top of the score history; LIFO matches invalidate/double/sum-last-two.

---

## Pattern Recognition

| Role | Pattern |
|------|---------|
| Primary | Stack simulation |
| Clue | “Previous”, “invalidate last”, “last two” |

See: [Stack](../Stack/README.md), [PATTERNS.md](../../PATTERNS.md#stack-simulation--collisions).

---

## Alternative Approaches

ArrayList as stack — same idea. Final: **explicit stack + final sum**.

---

## Critical Implementation Details

- For `+`: pop top, peek next, push top back, then push sum (or peek two without corrupting order)
- Parse integers only in the else-branch

---

## Edge Cases

- `C` when stack size 1; `+`/`D` need enough prior scores (guaranteed by problem usually)

---

## Common Mistakes

- Losing the top when computing `+`
- Case sensitivity on op strings

---

## Complexity

Time O(n), Space O(n).

---

## Similar Problems

- [evaluate-reverse-polish-notation](../evaluate-reverse-polish-notation/README.md)
- [asteroid-collision](../asteroid-collision/README.md)

---

## One-line Takeaway

**Score history is a stack; ops only touch the top.**

---

## Revision Checklist

- [ ] Implement `+` without losing order
- [ ] Final sum over stack

---

## Revision History

| Date | Note |
|------|------|
| — | From `submission-1.java` |
