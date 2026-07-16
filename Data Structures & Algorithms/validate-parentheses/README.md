# Validate Parentheses

| Field | Value |
|-------|-------|
| Topic | Stack |
| Difficulty | Easy |
| Primary Pattern | Stack — matching pairs |
| Secondary Pattern | — |
| Confidence | — |
| Last Revision | Never |

---

## Problem Summary

Given a string of `(`, `)`, `{`, `}`, `[`, `]`, return `true` if it is valid: brackets are correctly opened and closed in the right order.

---

## Constraints (typical)

- `1 ≤ s.length ≤ 10⁴`
- Characters only from `()[]{}` set

---

## Brute Force

Repeatedly scan and remove matched adjacent pairs → O(n²). Viable but too slow.

---

## Core Observation

Push opening brackets onto a stack. On a closing bracket, the stack top must be the matching opener. If mismatch or stack is empty → invalid. At end, stack must be empty (no unmatched openers).

---

## Thinking Process

1. `Stack<Character> st`.
2. For each `ch`:
   - If closing `)`, `]`, `}`:
     - If `st.isEmpty()` → return `false`
     - Pop `top`. If `top` doesn't match → return `false`.
   - Else (opening): push `ch`.
3. Return `st.isEmpty()`.

---

## Why the Approach Works

The last opened bracket must be the first closed (LIFO). The stack's top always holds the most recently unmatched opener — it must match the next closing bracket.

---

## Pattern Recognition

| Role | Pattern |
|------|---------|
| Primary | Stack for LIFO matching of delimiters |
| Same family | evaluate-reverse-polish-notation, baseball-game |

### Pattern Recognition Clues

- "Matching pairs, nested"
- LIFO: most recent opener must match next closer

Cross-ref: [Stack](../Stack/README.md)

---

## Alternative Approaches

Counter (count of `(` minus `)`) — works for single bracket type but fails for mixed.

---

## Critical Implementation Details

- Check `st.isEmpty()` before popping — closing bracket with empty stack → invalid
- `submission-1` has a debug `System.out.println` — remove in clean submission
- Must return `st.isEmpty()` at end — unmatched openers make it invalid even if no mismatch

---

## Edge Cases

- Empty string → `true` (no brackets)
- All openers `(((` → `false` (stack non-empty at end)
- All closers `)))` → `false` (empty stack on first closer)
- Interleaved: `([)]` → `false`

---

## Common Mistakes

- Not checking `isEmpty()` before popping (NPE)
- Returning `true` without checking `st.isEmpty()` at the end (unmatched openers pass)
- Using a counter instead of a stack (fails for mixed brackets)

---

## Complexity

| | |
|--|--|
| Time | O(n) |
| Space | O(n) |

---

## Similar Problems

- [evaluate-reverse-polish-notation](../evaluate-reverse-polish-notation/README.md) — stack-based expression evaluation
- [minimum-stack](../minimum-stack/README.md) — stack design

---

## One-line Takeaway

**Push openers; on closer, pop and verify match; return `stack.isEmpty()` at end.**

---

## Revision Checklist

- [ ] Check `isEmpty()` before popping?
- [ ] Final `st.isEmpty()` check (unmatched openers)?
- [ ] Three closing bracket conditions in if statement?

---

## Revision History

| Date | Note |
|------|------|
| — | `submission-1` has debug print; logic correct |
