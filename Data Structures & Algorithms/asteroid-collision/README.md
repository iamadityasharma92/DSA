# Asteroid Collision

| Field | Value |
|-------|-------|
| Topic | Stack |
| Difficulty | Medium |
| Primary Pattern | Stack simulation |
| Secondary Pattern | Collision resolution while top opposes |
| Confidence | — |
| Last Revision | Never |

---

## Problem Summary

Asteroids on a line: positive = right, negative = left. Same absolute value → both explode; larger absolute value survives. Return the state after all collisions.

---

## Constraints (typical)

- Collisions only when a **right-moving** asteroid is followed later by a **left-moving** one (stack top `> 0`, incoming `< 0`)

---

## Brute Force

Repeatedly scan and resolve adjacent opposing pairs → messy O(n²) simulations.

---

## Core Observation

A stack holds the **current stable suffix**. Only push after resolving all collisions between the incoming asteroid and the stack top while they face each other.

Same-direction or empty stack → no collision.

---

## Thinking Process

1. For each asteroid `i`:
2. While stack not empty, `i < 0`, and `peek > 0`:
   - Compare `i + peek` (or abs sizes)
   - Top smaller → pop, keep considering `i`
   - Top larger → destroy `i` (set to 0 / skip push)
   - Equal → pop and destroy `i`
3. If `i` survived, push it
4. Stack (bottom→top) is the answer

---

## Why the Approach Works

Earlier asteroids are already mutually stable. A new left-mover can only hit the nearest unresolved right-movers, which sit on the stack top — classic monotonic collision stack.

---

## Pattern Recognition

| Role | Pattern |
|------|---------|
| Primary | Stack simulation |
| Secondary | Resolve while conflict with top |
| Related | Monotonic stack (daily temperatures) — different goal, same “while top conflicts” shape |

See: [Stack](../Stack/README.md), [PATTERNS.md](../../PATTERNS.md#stack-simulation--collisions).

---

## Alternative Approaches

| Approach | Notes |
|----------|-------|
| Two stacks / queues | Unnecessary |
| Linked list splice | Same logic, more boilerplate |

Final understanding: **one stack; collide only `+` top vs incoming `-`**.

---

## Critical Implementation Details

- Do **not** collide two negatives or two positives
- Mark destroyed incoming (e.g. `i = 0`) so it is not pushed
- Equal size: both gone

---

## Edge Cases

- All moving same direction → unchanged order
- `[10, -10]` → empty
- Chain reaction: `[-2, -1, 1, -2]` style multi-pop

---

## Common Mistakes

- Colliding whenever signs differ regardless of order
- Pushing a destroyed asteroid
- Using queue order instead of stack (wrong survivor order)

---

## Complexity

| | |
|--|--|
| Time | O(n) amortized (each asteroid pushed/popped ≤ once) |
| Space | O(n) |

---

## Similar Problems

- [daily-temperatures](../daily-temperatures/README.md) — monotonic stack
- [validate-parentheses](../validate-parentheses/README.md) — stack matching
- Car Fleet — stack of collisions on a road

---

## One-line Takeaway

**Stack of survivors; resolve only while top goes right and incoming goes left.**

---

## Revision Checklist

- [ ] Can I state the exact while-condition for collision?
- [ ] Three outcomes: pop / destroy incoming / both destroy?
- [ ] Amortized O(n) argument?

---

## Revision History

| Date | Note |
|------|------|
| — | Documented from `submission-0.java` |
