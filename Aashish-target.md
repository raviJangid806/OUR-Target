Here's the roadmap, adjusted for a fresher targeting SDE-1/L3 with Python as your primary language.

**Phase 1 (Months 1–3): Fundamentals + DSA foundation**
Core CS basics: OOP, OS (processes/threads, memory), DBMS (indexing, SQL, normalization), networking (TCP/UDP, HTTP, DNS). Start DSA: arrays, strings, hashing, two pointers, sliding window, recursion basics. Target: 100–150 easy/medium problems (NeetCode 150 / Blind 75 as base).

**Phase 2 (Months 3–6): DSA depth + Python internals**
Continue DSA: linked lists, stacks/queues, trees, BSTs, heaps, tries, graphs (BFS/DFS, Union-Find, topological sort, Dijkstra), DP, backtracking, greedy, bit manipulation, intervals. Target 300+ problems total, medium-weighted. Alongside this, go deep on Python internals: GIL and its implications, memory management (reference counting, garbage collection), mutable vs immutable types, decorators, generators/iterators, list/dict comprehensions, `*args`/`**kwargs`, context managers, multithreading vs multiprocessing vs asyncio.

**Phase 3 (Months 5–7): Projects (freshers need this more than experienced hires)**
Build 2–3 solid projects that show real engineering, not tutorials: a REST API (Flask/FastAPI/Django) with a database, a small system with authentication and tests, something deployed (even free-tier cloud). Include one project touching data structures/algorithms in a practical context (e.g., a search/recommendation feature) — this bridges DSA and real code for interviewers.

**Phase 4 (Months 6–7): Low-level design + light system design**
LLD: design patterns (factory, singleton, strategy, observer, builder), OOP-based problems (parking lot, library system, LRU cache, rate limiter) — implement these in Python, not just talk through them. HLD: basics only for fresher roles — caching, load balancing, database basics, CAP theorem — enough to hold a conversation, not deep expertise.

**Phase 5 (Months 6–8): Company-specific prep**
Google: DSA-heavy, 4–5 rounds, strong emphasis on optimal complexity and clean code, one "Googleyness" behavioral round. Microsoft: DSA + one design round + one culture/communication round, generally a slightly more forgiving bar for freshers. Study recent interview experiences on LeetCode Discuss/Blind for both, filtered by "new grad"/fresher threads specifically.

**Phase 6 (ongoing from month 4): Resume + outreach + mocks**
Resume built around projects and impact (not just "learned X"), since you won't have work experience to lean on. Apply through university/campus channels if available — freshers often have a separate, less competitive pipeline. Cold outreach to Google/Microsoft engineers on LinkedIn for referrals. Mock interviews starting 6–8 weeks before applying.

**Realistic timeline:** 8–10 months at 3–4 hrs/day, since as a fresher you likely have more free time than someone working full-time. Apply to Microsoft's new-grad program first — it typically has more fresher-specific openings than Google.

Want the DSA topic list broken down with Python-specific syntax/library notes (like `heapq`, `collections`, `bisect`) for each topic?


Here's the full DSA topic list with the Python-specific libraries/syntax to know for each.

**1. Arrays & Strings**
Two pointers, sliding window, prefix sums, sorting, in-place manipulation, Kadane's algorithm.
Python notes: slicing (`arr[::-1]`), `sorted()` vs `.sort()`, string immutability, `str.join()`, ASCII manipulation with `ord()`/`chr()`.

**2. Hashing**
Frequency counting, grouping, subarray sum problems, anagram checks.
Python notes: `dict`, `set`, `collections.Counter`, `collections.defaultdict`.

**3. Linked Lists**
Reversal, fast-slow pointers (Floyd's cycle detection), merging, deletion.
Python notes: implement your own `Node` class (no built-in linked list); watch pointer reassignment carefully since Python has no explicit pointers.

**4. Stacks & Queues**
Monotonic stack, valid parentheses, min-stack, next greater element, deque-based sliding window.
Python notes: `list` as a stack (`.append()`/`.pop()`), `collections.deque` for O(1) queue operations, avoid using `list.pop(0)` (O(n)).

**5. Binary Search**
On sorted arrays, on answer space (search space reduction), rotated array search.
Python notes: `bisect.bisect_left`, `bisect.bisect_right`, `bisect.insort`.

**6. Recursion & Backtracking**
Subsets, permutations, combinations, N-Queens, word search, Sudoku solver.
Python notes: recursion depth limit (`sys.setrecursionlimit`), `itertools.permutations`/`combinations` (know how to derive manually too — interviewers want the algorithm, not the shortcut).

**7. Trees (Binary Tree + BST)**
Traversals (inorder/preorder/postorder/level-order), depth/height, LCA, path sum, diameter, serialization/deserialization, BST insert/delete/search, balanced tree checks.
Python notes: build your own `TreeNode` class, `collections.deque` for level-order BFS, recursion for DFS.

**8. Heaps / Priority Queues**
Top-K elements, k-way merge, median in a data stream, k closest points.
Python notes: `heapq` (min-heap by default — negate values for max-heap), `heapq.heappush`/`heappop`/`heapify`, `heapq.nlargest`/`nsmallest`.

**9. Tries**
Prefix search, word dictionary, autocomplete, longest common prefix.
Python notes: implement with nested `dict` (`self.children = {}`) — no built-in trie structure.

**10. Graphs**
BFS, DFS, topological sort (Kahn's + DFS-based), Union-Find/Disjoint Set, Dijkstra, Bellman-Ford, cycle detection (directed/undirected), bipartite check, number of islands.
Python notes: `collections.deque` for BFS, adjacency list via `defaultdict(list)`, `heapq` for Dijkstra, implement Union-Find with path compression manually.

**11. Dynamic Programming**
1D DP (climbing stairs, house robber), knapsack (0/1 and unbounded), LCS, LIS, matrix DP (unique paths, min path sum), DP on trees, bitmask DP, edit distance.
Python notes: `functools.lru_cache` for memoization, or manual `dict`/2D `list` for tabulation.

**12. Greedy**
Interval scheduling, activity selection, jump game, gas station, task scheduling.
Python notes: usually paired with `sorted()` on a custom key (`key=lambda x: x[1]`).

**13. Bit Manipulation**
XOR tricks (single number problems), subsets via bitmask, counting set bits, power of two checks.
Python notes: `bin()`, bitwise operators (`&`, `|`, `^`, `~`, `<<`, `>>`), note Python ints are arbitrary precision (no overflow like Java/C++, but watch for negative-number bit quirks).

**14. Intervals**
Merge intervals, insert interval, meeting rooms I/II, non-overlapping intervals.
Python notes: sort by start/end with `sorted(intervals, key=lambda x: x[0])`.

Want a week-by-week calendar mapping these topics to specific weeks and problem counts?