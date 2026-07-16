# Reorder Linked List

| Field | Value |
|-------|-------|
| Topic | Linked List |
| Difficulty | Medium |
| Primary Pattern | Find midpoint + reverse second half + merge |
| Secondary Pattern | Three-step technique |
| Confidence | — |
| Last Revision | Never |

---

## Problem Summary

Given a linked list `L0 → L1 → … → Ln`, reorder it in-place to `L0 → Ln → L1 → Ln-1 → L2 → Ln-2 → …`. Do not modify values, only the `next` pointers.

---

## Constraints (typical)

- `1 ≤ n ≤ 5 × 10⁴`
- In-place, modify pointers only

---

## Brute Force

Collect all nodes in an array, use two pointers to interleave → O(n) time but O(n) space.

---

## Core Observation

Three-step technique:
1. **Find midpoint** (slow/fast pointers).
2. **Reverse the second half** (from `slow.next` onward).
3. **Merge interleave** first half and reversed second half.

---

## Thinking Process

**Step 1 — find mid:**
- `slow = fast = head`; `while(fast && fast.next): slow=slow.next, fast=fast.next.next`
- `slow` = midpoint

**Step 2 — reverse second half:**
- `second = slow.next; slow.next = null` (detach)
- Standard iterative reversal of `second` → `prev` is new head

**Step 3 — merge:**
- `l1 = head`, `l2 = prev`
- While `l2 != null`: save `tmp1 = l1.next`, `tmp2 = l2.next`; wire `l1.next = l2`, `l2.next = tmp1`; advance `l1 = tmp1`, `l2 = tmp2`

---

## Why the Approach Works

Reversing the second half makes the interleave trivial: the reversed-half nodes come in the exact order needed for the reorder pattern. Merging alternately produces the target structure.

---

## Pattern Recognition

| Role | Pattern |
|------|---------|
| Primary | Three-step: mid + reverse half + merge |
| Components | slow/fast (mid), three-pointer reverse, two-pointer merge |

### Pattern Recognition Clues

- "Reorder: alternate from front and back"
- Result is interleave of first half and reversed second half

Cross-ref: [Linked List](../Linked%20List/README.md)

---

## Alternative Approaches

Collect all nodes in `ArrayList`, two-pointer write back. O(n) space but simpler to code.

---

## Critical Implementation Details

- `slow.next = null` — must detach first half before reversing second; otherwise `slow.next` = head of reversed = circular reference
- Merge loop runs while `l2 != null` (second half may be shorter for odd lists)
- Save both `l1.next` and `l2.next` before wiring (both get overwritten)

---

## Edge Cases

- 1 or 2 nodes → no rearrangement needed (loop handles naturally)
- Odd vs even length: `slow` lands at middle node; second half is one element shorter for even

---

## Common Mistakes

- Not detaching first half (`slow.next = null`) — reversal pollutes into first half
- Not saving `tmp2 = l2.next` before wiring (second half reference lost)
- Merging loop `while l1 != null` instead of `while l2 != null` (second half may be shorter)

---

## Complexity

| | |
|--|--|
| Time | O(n) |
| Space | O(1) |

---

## Similar Problems

- [reverse-a-linked-list](../reverse-a-linked-list/README.md) — core step 2
- [linked-list-cycle-detection](../linked-list-cycle-detection/README.md) — slow/fast pointer for midpoint

---

## One-line Takeaway

**Find mid (slow/fast) → reverse second half → merge-interleave first and reversed second.**

---

## Revision Checklist

- [ ] Three steps in order?
- [ ] Why `slow.next = null` before reversing second half?
- [ ] Merge loop: while `l2 != null`, save both `tmp1` and `tmp2`?

---

## Revision History

| Date | Note |
|------|------|
| — | Documented from `submission-0.java` |
