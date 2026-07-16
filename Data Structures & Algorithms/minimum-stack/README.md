# Minimum Stack

| Field | Value |
|-------|-------|
| Topic | Stack |
| Difficulty | Medium |
| Primary Pattern | Stack |
| Secondary Pattern | Design |
| Confidence | — |
| Last Revision | Never |

---

## Problem Summary

Interview problem `minimum-stack`. Documented from accepted Java submissions in this folder (best understanding across attempts).

---

## Core Observation

Each stack level knows minimum of all elements below including current.

---

## Thinking Process

1. push: append val and min(val, stackMinTop)
2. pop both stacks
3. top normal stack
4. getMin peek min stack

**Best understanding:** Parallel stack stores min-so-far at each push depth

---

## Why the Approach Works

Cached min per depth gives O(1) getMin without scanning.

---

## Pattern Recognition

| Role | Pattern |
|------|---------|
| Primary | Stack |
| Secondary | Design |

### Pattern Recognition Clues

- getMin O(1)
- Standard stack ops

Cross-ref: topic hub · [PATTERNS.md](../../PATTERNS.md)

---

## Alternative Approaches

Single stack store pairs (val,min).

---

## Critical Implementation Details

- Push min before val or pair together
- Pop sync both

---

## Edge Cases

- Duplicate mins
- pop until empty

---

## Common Mistakes

- Recomputing min on pop wrong
- Empty getMin undefined

---

## Complexity

| | |
|--|--|
| Time | O(1) all ops |
| Space | O(n) |

---

## Similar Problems

- [evaluate-reverse-polish-notation](../evaluate-reverse-polish-notation/README.md)
- [implement-stack-using-queues](../implement-stack-using-queues/README.md)

---

## One-line Takeaway

**Min stack → auxiliary min-stack mirroring push/pop.**

---

## Revision Checklist

- [ ] Sync push/pop
- [ ] min-so-far

---

## Revision History

| Date | Note |
|------|------|
| — | Initial documentation from submission-2 |
