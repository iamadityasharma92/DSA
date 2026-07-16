# Validate Parentheses

| Field | Value |
|-------|-------|
| Topic | Stack |
| Difficulty | Easy |
| Primary Pattern | Stack |
| Secondary Pattern | String |
| Confidence | — |
| Last Revision | Never |

---

## Problem Summary

Interview problem `validate-parentheses`. Documented from accepted Java submissions in this folder (best understanding across attempts).

---

## Core Observation

LIFO stack matches most recent unmatched opener.

---

## Thinking Process

1. stack for openers
2. Map pairs )]} to ({[
3. Mismatch or pop empty → false
4. End empty stack true

**Best understanding:** Push opening; on closing pop must match top; end stack empty

---

## Why the Approach Works

Nested structure requires last opened closed first.

---

## Pattern Recognition

| Role | Pattern |
|------|---------|
| Primary | Stack |
| Secondary | String |

### Pattern Recognition Clues

- Only brackets valid nesting
- Classic stack

Cross-ref: topic hub · [PATTERNS.md](../../PATTERNS.md)

---

## Alternative Approaches

Counter only works for single bracket type.

---

## Critical Implementation Details

- Check stack empty before pop
- Only bracket chars

---

## Edge Cases

- Empty string true
- Single pair

---

## Common Mistakes

- Not checking empty pop
- Wrong closing map

---

## Complexity

| | |
|--|--|
| Time | O(n) |
| Space | O(n) |

---

## Similar Problems

- [evaluate-reverse-polish-notation](../evaluate-reverse-polish-notation/README.md)
- [minimum-stack](../minimum-stack/README.md)

---

## One-line Takeaway

**Valid parentheses → stack match closes.**

---

## Revision Checklist

- [ ] push open
- [ ] pop match

---

## Revision History

| Date | Note |
|------|------|
| — | Initial documentation from submission-1 |
