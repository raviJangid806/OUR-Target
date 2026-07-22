Solid goal. At 1.5 YOE, you're aiming for SDE-1/L3 roles at both — process is DSA-heavy with a system design/LLD component. Here's the roadmap.

**Phase 1 (Months 1–3): Fundamentals + DSA foundation**
Lock down core CS: OOP, OS (threads, deadlocks, memory), DBMS (indexing, transactions, normalization), computer networks (TCP/UDP, HTTP, DNS). Parallel to this, start DSA on arrays, strings, hashing, two pointers, sliding window, recursion, and basic trees/graphs. Target: 150–200 easy/medium LeetCode problems (NeetCode 150 is a good base).

**Phase 2 (Months 3–6): DSA depth + Java internals**
Move to harder patterns: DP, backtracking, graphs (BFS/DFS, Dijkstra, Union-Find), heaps, tries, intervals. Aim for 300+ total problems solved, with a mix of medium/hard weighted toward medium (that's the actual interview bar). Simultaneously go deep on Java: JVM internals (memory model, GC), collections framework internals, multithreading/concurrency (this is a common differentiator for Java devs), Spring Boot if you use it at work.

**Phase 3 (Months 5–7): System design (LLD + HLD)**
Low-level design: design patterns (factory, strategy, observer, singleton), and practice designing systems like a parking lot, elevator, rate limiter — these show up for SDE-1/2. High-level design: start with basics (load balancing, caching, sharding, CAP theorem) even though HLD is lighter at your level — Microsoft sometimes asks it even for early-career loops.

**Phase 4 (Months 6–8): Company-specific prep**
Google: leetcode-style DSA with strong emphasis on optimal complexity and clean code, 4-5 rounds (mostly coding, one behavioral "Googleyness" round). Microsoft: DSA + one LLD round + one "as appropriate" round on communication/culture fit. Study each company's actual recent interview experiences (Blind, LeetCode discuss, Glassdoor) — patterns shift.

**Phase 5 (ongoing, months 4 onward): Resume + referrals + mocks**
Rebuild resume around metrics and impact, not just tech stack. Get referrals — cold LinkedIn outreach to Google/Microsoft engineers works better than portals. Start mock interviews (Pramp, peers, or paid) at least 4–6 weeks before you start applying, not after.

**Realistic timeline:** 8–10 months of consistent 2–3 hrs/day if you're working full-time. Apply to Microsoft first — its bar and process are typically a notch more forgiving for 1.5–2 YOE than Google's.

Want me to turn this into a week-by-week tracker (spreadsheet) so you can check off progress?
Here's the full topic list, organized by category.

**Data Structures & Algorithms**
- Arrays & Strings: two pointers, sliding window, prefix sums, sorting, in-place manipulation
- Hashing: hash maps/sets, frequency counting, anagram/subarray problems
- Linked Lists: singly/doubly, reversal, cycle detection, merge operations
- Stacks & Queues: monotonic stack, min-stack, queue via stacks, deque
- Recursion & Backtracking: permutations, combinations, subsets, N-Queens, Sudoku
- Trees: binary trees, BST, traversals (in/pre/post/level order), balanced trees, LCA, serialization
- Heaps/Priority Queues: top-K problems, merge K lists, median finder
- Graphs: BFS, DFS, topological sort, Union-Find, Dijkstra, Bellman-Ford, cycle detection, bipartite check
- Tries: prefix matching, word search, autocomplete
- Dynamic Programming: knapsack, LCS/LIS, matrix DP, DP on trees/graphs, bitmask DP
- Greedy algorithms: interval scheduling, activity selection
- Binary search: on sorted arrays, on answer space
- Bit manipulation: XOR tricks, bitmasks

**Computer Science Fundamentals**
- Operating Systems: process vs thread, scheduling, deadlocks, memory management (paging, segmentation), synchronization (mutex, semaphore)
- DBMS: normalization, indexing (B-tree, hash index), transactions (ACID), joins, locking, SQL query writing
- Computer Networks: OSI/TCP-IP model, TCP vs UDP, HTTP/HTTPS, DNS, load balancing basics, REST
- OOP: encapsulation, inheritance, polymorphism, abstraction, SOLID principles

**Java-Specific (your differentiator)**
- Core language: collections framework internals (HashMap, ArrayList, TreeMap implementation), generics, exceptions
- JVM internals: memory model (heap/stack/metaspace), garbage collection algorithms, class loading
- Concurrency: threads, executors, synchronized/locks, volatile, concurrent collections, CompletableFuture, deadlock scenarios
- Streams & functional features: lambdas, Stream API, Optional
- Spring/Spring Boot (if used at work): dependency injection, REST controllers, transaction management, JPA/Hibernate basics

**System Design**
- Low-Level Design (LLD): design patterns (factory, singleton, strategy, observer, builder, decorator), OOP-based design problems (parking lot, elevator, library system, rate limiter, LRU cache)
- High-Level Design (HLD) — lighter for your level but still asked: scalability basics, load balancing, caching (Redis, CDN), database sharding/replication, CAP theorem, message queues, designing simple systems (URL shortener, chat app)

**Behavioral / Non-Technical**
- STAR-format stories: conflict resolution, ownership, failure/learning, leadership/initiative
- Company-specific values: Google's "Googleyness," Microsoft's growth mindset/collaboration
- Questions to ask interviewers

**Practical/Process**
- Resume: metrics-driven bullet points, ATS-friendly formatting
- Mock interviews and timed practice (45-min constraint per problem)
- Reading recent interview experiences for both companies (patterns shift over time)

Want this as a checklist spreadsheet you can track progress against?




Here's the deep dive on DSA — order, volume, and how to practice it.

**Study order (roughly sequential, each builds on the last)**

1. Arrays & Strings — two pointers, sliding window, prefix sum, sorting-based tricks (~30-40 problems)
2. Hashing — maps/sets for frequency, lookups, grouping (~20-25 problems)
3. Linked Lists — reversal, fast-slow pointers, merging, cycle detection (~15-20 problems)
4. Stacks & Queues — monotonic stack, min-stack, valid parentheses patterns, deque (~15-20 problems)
5. Binary Search — on arrays and on answer space (~15-20 problems)
6. Recursion & Backtracking — subsets, permutations, combinations, N-Queens, word search (~20-25 problems)
7. Trees (Binary Tree + BST) — traversals, depth/height, LCA, path sums, serialization, BST operations (~35-40 problems)
8. Heaps / Priority Queues — top-K, k-way merge, median in stream (~15-20 problems)
9. Tries — prefix search, word dictionary, autocomplete (~10 problems)
10. Graphs — BFS/DFS, topological sort, Union-Find, Dijkstra, Bellman-Ford, cycle detection, bipartite (~35-40 problems)
11. Dynamic Programming — 1D DP, knapsack variants, LCS/LIS, matrix DP, DP on trees, bitmask DP (~40-50 problems)
12. Greedy — interval scheduling, activity selection, jump game (~15 problems)
13. Bit Manipulation — XOR tricks, subsets via bitmask, single number variants (~10 problems)
14. Intervals — merge/insert intervals, meeting rooms (~10 problems)

Total target: 300–350 problems, weighted toward medium (medium is the actual bar for Google/Microsoft SDE-1/L3; hards matter more for Google).

**Resources**
- NeetCode 150 / Blind 75 — pattern coverage, do this first
- LeetCode — company-tagged lists for Google and Microsoft (filter by "Google" and "Microsoft" tags, sort by frequency)
- Grokking the Coding Interview — good for pattern recognition if you like structured courses

**How to practice (matters as much as what)**
- Timebox: 30–45 min per problem before looking at the solution. Note the pattern you missed, don't just memorize the answer.
- Redo problems: revisit a problem 1 week and 1 month later without looking at your old solution.
- Always state and optimize time/space complexity out loud — Google/Microsoft interviewers grade on this explicitly.
- Practice explaining your approach before coding (dry-run on a whiteboard or in your head) — this is often weighted as high as correctness.
- Last 4–6 weeks before applying: switch fully to timed mock interviews (45 min, unfamiliar problems, verbalize while solving).

**Weak-topic priority for a Java dev with 1.5 YOE**
Most candidates at your stage are weakest in graphs, DP, and backtracking — allocate extra time there rather than over-indexing on arrays/strings, which you likely already have decent intuition for from work.

Want this broken into a week-by-week study calendar with problem counts per week?