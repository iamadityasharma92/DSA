# Pattern Encyclopedia

Reusable interview patterns. Append insights; do not duplicate problem writeups.

Cross-links: [README](README.md) · [REVISION](REVISION.md)

---

# Two Pointers / k-Sum

## When to Think About It

- Find pairs / triplets / k-tuples with a target sum
- Answers must be unique combinations
- Array can be sorted or sorting is allowed

## Core Idea

Sort, fix `k-2` indices, search the rest with left/right pointers that move by comparing the current sum to the target. Skip adjacent duplicates so each combination is emitted once.

## Recognition Clues

- “All unique … that sum to”
- Nested loops feel natural but n is too large for O(nᵏ)
- Output is combinations, not permutations

## Common Variations

- 2-Sum II (already sorted)
- 3-Sum / 4-Sum
- Closest sum / count pairs with constraint (same skeleton)

## Complexity

| k | Time after sort |
|---|-----------------|
| 2 | O(n) |
| 3 | O(n²) |
| 4 | O(n³) |

## Common Mistakes

- `int` overflow on multi-element sums
- Incomplete duplicate skipping
- Forgetting both pointers move after a hit

## Related Problems

- [4sum](Data%20Structures%20%26%20Algorithms/4sum/README.md)
- three-integer-sum (pending doc)
- two-integer-sum-ii (pending doc)

## Key Takeaways

**Sort + fix + two pointers + skip equals** is the default unique k-Sum toolkit.

---

# Linked List Digit Addition

## When to Think About It

- Numbers stored as lists of digits
- Especially LSB at the head (classic Add Two Numbers)

## Core Idea

Walk both lists with a carry; emit `sum % 10` nodes; continue while either list or carry remains.

## Recognition Clues

- “Digits in reverse order”
- Unequal lengths + possible extra MSD from carry

## Common Variations

- MSD-first (Add Two Numbers II) → reverse or stack first
- Doubly linked / array digits — same carry logic

## Complexity

O(max(n, m)) time, O(1) extra besides output.

## Common Mistakes

- Omitting final carry
- Stopping at the shorter list

## Related Problems

- [add-two-numbers](Data%20Structures%20%26%20Algorithms/add-two-numbers/README.md)

## Key Takeaways

**Dummy + carry loop condition includes leftover carry.**

---

# Hashing / Canonical Keys

## When to Think About It

- Group or compare items that are equal under a transformation (anagrams, isomorphism)

## Core Idea

Map each item to a deterministic signature of its equivalence class; hash-map buckets collect groups.

## Recognition Clues

- “Group anagrams / isomorphic / same char counts”
- Equality after reorder or relabel

## Common Variations

- Sorted string key
- Frequency count key (better for small alphabets)
- Tuple of counts as key

## Complexity

Sort key: O(n L log L). Count key: O(n L) for fixed alphabet.

## Common Mistakes

- Unstable or mutating keys
- Prime-product fingerprints (overflow)

## Related Problems

- [anagram-groups](Data%20Structures%20%26%20Algorithms/anagram-groups/README.md)
- is-anagram (pending doc)

## Key Takeaways

**Pick the cheapest injective signature for the alphabet.**

---

# Stack Simulation / Collisions

## When to Think About It

- Items arrive in order and may destroy earlier unresolved items
- Rules depend on the nearest prior candidate (LIFO)

## Core Idea

Stack = current stable world. On each new item, while it conflicts with the top, resolve (pop / discard incoming / both). Push only if it survives.

## Recognition Clues

- Asteroids, car fleet, temperature wait times (monotonic variant)
- “Explode / survive / next greater”

## Common Variations

- Monotonic increasing/decreasing stack
- Pure matching (parentheses)

## Complexity

O(n) amortized.

## Common Mistakes

- Wrong conflict predicate (e.g. colliding same-direction asteroids)
- Pushing destroyed items

## Related Problems

- [asteroid-collision](Data%20Structures%20%26%20Algorithms/asteroid-collision/README.md)
- daily-temperatures (pending doc)

## Key Takeaways

**Encode the conflict rule in the while-condition; amortize pops.**

---

# Tree DFS / Aggregate Up

## When to Think About It

- Property depends on left/right subtree results (height, balance, diameter, validity)

## Core Idea

Post-order: recurse children, combine into parent answer. Optionally thread a global flag or sentinel for early failure.

## Recognition Clues

- “For every node…”
- Height/depth/balance/diameter wording

## Common Variations

- Return height; set boolean flag
- Return `-1` sentinel if invalid
- Return pair `(height, isBalanced)`

## Complexity

O(n) time, O(h) stack.

## Common Mistakes

- Separate height function per node → O(n²)
- Checking only the root

## Related Problems

- [balanced-binary-tree](Data%20Structures%20%26%20Algorithms/balanced-binary-tree/README.md)
- binary-tree-diameter (pending doc)
- depth-of-binary-tree (pending doc)

## Key Takeaways

**One post-order pass returning the aggregate beats repeated top-down scans.**

**Insight (diameter):** same skeleton as balance; track `lm+rm` instead of `|lm-rm|`.

---

# Greedy / Adjacent Gains

## When to Think About It

- Unlimited buy/sell stock (no cooldown/fee)
- Profit from every rising segment

## Core Idea

Take every positive adjacent difference; equals valley–peak trading.

## Recognition Clues

- “As many transactions as you like”
- Prices array, maximize profit

## Common Variations

- One transaction → track min price
- Cooldown / fee → DP

## Complexity

O(n) time, O(1) space.

## Common Mistakes

- Using this for the single-transaction problem

## Related Problems

- [best-time-to-buy-and-sell-stock-ii](Data%20Structures%20%26%20Algorithms/best-time-to-buy-and-sell-stock-ii/README.md)
- [buy-and-sell-crypto](Data%20Structures%20%26%20Algorithms/buy-and-sell-crypto/README.md) — **one** trade (prefix min), not adjacent-sum

## Key Takeaways

**Unlimited trades ⇒ sum of uphill edges. One trade ⇒ running minimum.**

---

# Binary Search Templates

## When to Think About It

- Sorted data or monotone predicate on a numeric range

## Core Idea

Maintain an invariant on a shrinking interval; mid decides which side dies.

## Recognition Clues

- Sorted array search
- “Minimum capacity such that…”

## Common Variations

- Half-open `[l,r)`: `r=m`, `l=m+1`
- Closed `[l,r]`: `r=m-1`, `l=m+1`
- Answer-space binary search

## Complexity

O(log n) or O(n log R) with linear checks.

## Common Mistakes

- Mixing templates; `l=m` loops; `(l+r)/2` overflow (rare in Java int but prefer safe mid)

## Related Problems

- [binary-search](Data%20Structures%20%26%20Algorithms/binary-search/README.md)

## Key Takeaways

**Pick one bound style; use `l + (r-l)/2`.**

---

# BFS Level Order

## When to Think About It

- Answers depend on depth/level (right side view, level lists, zigzag)

## Core Idea

Queue; process exactly `size` nodes per level; enqueue children in consistent L→R order.

## Recognition Clues

- “Per level”, “left/right view”, “average of levels”

## Common Variations

- Right view = last in level; left view = first
- DFS with depth index into result list

## Complexity

O(n) time, O(w) space.

## Common Mistakes

- Not snapshotting `q.size()` before the inner loop

## Related Problems

- [binary-tree-right-side-view](Data%20Structures%20%26%20Algorithms/binary-tree-right-side-view/README.md)
- level-order-traversal-of-binary-tree (pending doc)

## Key Takeaways

**Freeze level size; first/last node gives side views.**

---

# Greedy / Two-Pointer Pairing

## When to Think About It

- Pair people/items with a capacity; at most two per group

## Core Idea

Sort; repeatedly place the hardest item; accompany with the easiest if it fits.

## Recognition Clues

- Boats/weight limit; two per boat

## Common Variations

- k per boat (harder — often DP/greedy differently)

## Complexity

O(n log n) + O(n).

## Common Mistakes

- Forgetting the last singleton still needs a boat (`l <= r`)

## Related Problems

- [boats-to-save-people](Data%20Structures%20%26%20Algorithms/boats-to-save-people/README.md)

## Key Takeaways

**Heaviest first; lightest joins only if under limit.**

---

# Binary Search on Answer

## When to Think About It

- Minimize/maximize a numeric capacity, speed, or max-segment-sum
- Feasibility check is monotone in that number

## Core Idea

Binary search the answer value; for each mid run a greedy/linear `can(mid)`.

## Recognition Clues

- “Minimum speed / capacity / largest sum such that…”
- Days, workers, or partition count constraints

## Common Variations

- Koko eating bananas (ceil sums)
- Ship packages within D days
- Split array largest sum

## Complexity

O(n log R) with linear checks.

## Common Mistakes

- Wrong bounds (forget max-element lower bound)
- Non-ceiling division
- Incorrect shrink direction when feasible

## Related Problems

- capacity-to-ship-packages-within-d-days
- eating-bananas
- split-array-largest-sum

## Key Takeaways

**Prove monotonicity → BS the answer → greedy validate.**

---

# Monotonic Stack

## When to Think About It

- Next greater/smaller element
- Spans of dominance (stock span, temperatures)

## Core Idea

Keep stack monotone; pop dominated entries and resolve their answers using the current index.

## Recognition Clues

- “Days until warmer”
- “How many consecutive ≤ current”

## Common Variations

- Daily temperatures (next greater distance)
- Online stock span (aggregate spans)
- Histogram largest rectangle (advanced)

## Complexity

O(n) amortized.

## Common Mistakes

- Wrong comparison (`<` vs `<=`)
- Storing values without indices

## Related Problems

- daily-temperatures
- online-stock-span

## Key Takeaways

**Stack of unresolved indices; pop when current dominates.**

---

# Sliding Window (Variable / Fixed)

## When to Think About It

- Longest/shortest substring or subarray under a constraint
- Fixed-size anagram / permutation windows

## Core Idea

Expand right; shrink left while invariant broken; track best length or match.

## Recognition Clues

- “Longest substring without repeating”
- “At most k replacements”
- “Permutation of s1 in s2”
- “Minimum window covering t”

## Common Variations

- HashSet unique window
- `windowLen - maxFreq <= k`
- Fixed window frequency match
- Deficit counter for coverage

## Complexity

O(n) with O(alphabet) maps.

## Common Mistakes

- Not updating answer on expand/shrink
- Wrong fixed-window bound
- Forgetting final check after loop

## Related Problems

- longest-substring-without-duplicates
- longest-repeating-substring-with-replacement
- permutation-string
- minimum-window-with-characters
- minimum-size-subarray-sum
- contains-duplicate-ii

## Key Takeaways

**Maintain one invariant; expand/shrink amortized once each.**

---

# Prefix Sum + Hash Map

## When to Think About It

- Count subarrays with sum = k
- Range sums with many queries (1D/2D)

## Core Idea

`prefix[j] - prefix[i] = k` → count prior prefixes equal to `prefix - k`. Seed `{0:1}`.

## Recognition Clues

- Subarray sum equals k
- Immutable range sum queries

## Common Variations

- 1D frequency map
- 2D inclusion-exclusion table

## Complexity

O(n) count; O(1) query after O(nm) build for 2D.

## Common Mistakes

- Missing `{0:1}` seed
- Updating map before counting current prefix

## Related Problems

- subarray-sum-equals-k
- range-sum-query-2d-immutable

## Key Takeaways

**Prefix + map turns subarray conditions into prior-count lookups.**

---

# Floyd Cycle (Fast / Slow)

## When to Think About It

- Linked-list cycle detect/entry
- Array duplicate when values map to indices `[1..n]`

## Core Idea

Slow×1 / fast×2 meet in cycle; reset one to start; meet at entry (= duplicate).

## Recognition Clues

- Cycle detection
- Find duplicate in `[1..n]` with O(1) space

## Common Variations

- Detect only
- Find entrance / duplicate value

## Complexity

O(n) time, O(1) space.

## Common Mistakes

- Phase-2 both from meeting point
- Using `i++` instead of `nums[i]` as next

## Related Problems

- linked-list-cycle-detection
- find-duplicate-integer

## Key Takeaways

**Index→value graph + Floyd finds the repeated pointer.**

---

# Heap / Top-K

## When to Think About It

- Kth largest in stream
- Window maximum (lazy heap alternative to deque)
- Top-k frequent

## Core Idea

Size-k min-heap for kth largest; max-heap with index for sliding max; or freq + sort/heap.

## Recognition Clues

- Stream + kth
- Sliding window maximum

## Common Variations

- Min-heap size k
- Lazy deletion by index
- Bucket / sort frequencies

## Complexity

Often O(n log k) or O(n log n).

## Common Mistakes

- Max-heap when min-of-top-k needed
- Forgetting to trim heap size

## Related Problems

- kth-largest-integer-in-a-stream
- sliding-window-maximum
- top-k-elements-in-list

## Key Takeaways

**Heap size and sort direction encode the order statistic.**

---

# Design: Hash + Ordered Structure

## When to Think About It

- LRU / caches
- O(1) get/put with eviction order

## Core Idea

HashMap for lookup; DLL (or similar) for recency order; sentinels simplify edge splices.

## Recognition Clues

- Capacity + least-recently-used
- Move-to-front on access

## Common Variations

- LRU cache
- Time-based KV (map + BS on timestamps)

## Complexity

O(1) avg for LRU ops.

## Common Mistakes

- Forgetting map update on eviction
- Breaking DLL links

## Related Problems

- lru-cache
- time-based-key-value-store
- minimum-stack

## Key Takeaways

**Map for addressability; ordered structure for policy.**

---

# Bit Tricks

## When to Think About It

- Single number (pairs cancel)
- Popcount / clear lowest set bit

## Core Idea

XOR cancels duplicates; `n & (n-1)` drops one set bit; DP `res[i]=res[i>>1]+(i&1)`.

## Recognition Clues

- Every element twice except one
- Count bits / Hamming weight

## Common Variations

- XOR fold
- Brian Kernighan loop
- Counting-bits DP

## Complexity

O(n) or O(set bits).

## Common Mistakes

- Signed shift issues in Java for bitCount loops
- Using hash when XOR suffices

## Related Problems

- single-number
- number-of-one-bits
- counting-bits

## Key Takeaways

**XOR for unique; `n&(n-1)` for popcount loops.**

---

# Trapping Rain / Container (Two Pointers)

## When to Think About It

- Water trapped between bars
- Max area container

## Core Idea

Process from ends; water bounded by min of side maxima; move the shorter boundary.

## Recognition Clues

- Heights array + water/area

## Common Variations

- Container with most water (area)
- Trapping rain water (volume)

## Complexity

O(n) time, O(1) space.

## Common Mistakes

- Moving the taller side first
- Prefix arrays with off-by-one max

## Related Problems

- max-water-container
- trapping-rain-water

## Key Takeaways

**Shorter-side pointer move preserves the limiting height invariant.**
