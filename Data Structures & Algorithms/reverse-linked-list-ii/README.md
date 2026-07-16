# Reverse Linked List II

| Field | Value |
|-------|-------|
| Topic | Linked List |
| Difficulty | Medium |
| Primary Pattern | In-place reversal of subrange |
| Secondary Pattern | Dummy head + reconnection |
| Confidence | — |
| Last Revision | Never |

---

## Problem Summary

Given the head of a singly linked list and two integers `l` and `r`, reverse the nodes from position `l` to `r` (1-indexed) in-place. Return the modified list.

---

## Constraints (typical)

- `1 ≤ l ≤ r ≤ n ≤ 500`
- Return the new head (may change if `l == 1`)

---

## Brute Force

Extract nodes `l..r` into an array, reverse, reinsert → O(n) but conceptually messy.

---

## Core Observation

Navigate to position `l-1` (the node just before the subrange). Reverse `r-l+1` nodes using the standard three-pointer technique. Then reconnect: `pre.next = reversed_head`, `prevNode.next = current` (where `prevNode` = original `l`-th node, now tail of reversed; `current` = node after `r`).

---

## Thinking Process

1. `dummy.next = head`, `pre = dummy`.
2. Navigate: `for i = 1 to l-1: pre = pre.next`.
3. `prevNode = pre.next` (will become tail of reversed segment).
4. Reverse `r-l+1` nodes from `pre.next`: standard `prev=null, current=pre.next`.
5. Reconnect: `pre.next = prev` (new head of reversed segment); `prevNode.next = current` (node after `r`).
6. Return `dummy.next`.

---

## Why the Approach Works

- `pre` anchors the node before the subrange so we can reattach the reversed head.
- `prevNode` = original first node of subrange, which after reversal is the **tail** → it should point to `current` (node after `r`).
- Dummy avoids special-casing `l == 1` (no node before position 1).

---

## Pattern Recognition

| Role | Pattern |
|------|---------|
| Primary | Subrange reversal with reconnection |
| Component | Standard three-pointer reversal for the inner segment |
| Helper | Dummy head to handle `l == 1` uniformly |

### Pattern Recognition Clues

- "Reverse subrange [l, r] of linked list"
- Must reconnect before and after segments

Cross-ref: [Linked List](../Linked%20List/README.md)

---

## Alternative Approaches

Multiple passes — identify, extract, reverse, reinsert. More code, same complexity.

---

## Critical Implementation Details

- Dummy head essential when `l = 1` (no real predecessor)
- `prevNode = pre.next` BEFORE reversal — this stores the original `l`-th node (future tail)
- Reverse exactly `r-l+1` nodes: `for(int i=0; i<r-l+1; i++)` iterations
- After reversal: `pre.next = prev` (reversed head); `prevNode.next = current` (chain continuation)

---

## Edge Cases

- `l == r` → nothing to reverse; return head
- `l == 1` → dummy ensures reconnection works without special case
- Entire list `l=1, r=n`

---

## Common Mistakes

- Not using dummy (crashes when `l == 1` — no node before it)
- Forgetting `prevNode` variable (can't reconnect the reversed tail to the rest)
- Reversing `r-l` instead of `r-l+1` nodes (misses one node)

---

## Complexity

| | |
|--|--|
| Time | O(n) |
| Space | O(1) |

---

## Similar Problems

- [reverse-a-linked-list](../reverse-a-linked-list/README.md) — full reversal (foundation)
- [reorder-linked-list](../reorder-linked-list/README.md) — uses partial reversal as a step

---

## One-line Takeaway

**Navigate to l-1 (pre), save l-th node (prevNode), reverse r-l+1 nodes, reconnect pre and prevNode.**

---

## Revision Checklist

- [ ] Why dummy head?
- [ ] What does `prevNode` point to, and what becomes its `next` after reversal?
- [ ] How many nodes to reverse: `r-l+1` not `r-l`?
- [ ] Reconnection: `pre.next = prev`, `prevNode.next = current`?

---

## Revision History

| Date | Note |
|------|------|
| — | Documented from `submission-3.java` |
