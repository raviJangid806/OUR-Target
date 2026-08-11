# Introduction to Hashing

Hashing is a method of storing and retrieving data efficiently from a database. Suppose we want to design a system for storing employee records keyed by phone numbers. We need to support the following operations efficiently:

1. Insert a phone number and the corresponding information.
2. Search for a phone number and fetch the record.
3. Delete a phone number and the related information.

## Possible data structures

We can consider the following options to maintain records for different phone numbers:

- An array of phone numbers and records
- A linked list of phone numbers and records
- A balanced binary search tree with phone numbers as keys
- A direct access table

### Comparison

- For arrays and linked lists, searching is linear, which can be costly in practice.
- If an array is kept sorted, we can search in $O(\log n)$ time using binary search, but insertion and deletion become expensive because the order must be maintained.
- A balanced binary search tree gives moderate search, insert, and delete times, and all operations are guaranteed in $O(\log n)$ time.
- A direct access table uses phone numbers as indexes in a big array. If a phone number is present, the array entry stores a pointer to the record; otherwise it stores `NIL`.

This approach is theoretically best because all operations can be done in $O(1)$ time. However, it has major practical limitations:

- It requires a very large amount of extra space.
- If a phone number has $n$ digits, the table may need $O(m \times 10^n)$ space, where $m$ is the pointer size.
- Some programming languages cannot store very large integers.

Because of these limitations, a direct access table cannot always be used.

## Why hashing?

Hashing is an improvement over the direct access table. The key idea is to use a hash function that converts a large key such as a phone number into a smaller integer value, which is then used as an index in a hash table.

## Hash function

A hash function is a function that converts a large key, such as a phone number or string, into a smaller practical integer value. This mapped value is used as an index in the hash table.

In simple terms, a hash function maps a large input to a smaller integer that can be used as an index.

A good hash function should have the following properties:

- It should be efficiently computable.
- It should uniformly distribute the keys so that each table position is equally likely for each key.

### Example

For phone numbers, a poor hash function may take the first three digits. A better approach may consider the last three digits. This is only an example; there may be better hash functions depending on the use case.

## Hash table

A hash table is an array that stores pointers to records corresponding to a given phone number. An entry in the hash table is `NIL` if no phone number maps to that index.

## Collision handling

Since a hash function maps a large key to a smaller integer, two different keys may produce the same value. This situation is called a collision. A collision must be handled using a collision resolution technique.

There are two common ways to handle collisions:

### 1. Chaining

The idea is to make each cell of the hash table point to a linked list of records whose keys hash to the same value.

- Chaining is simple to implement.
- It requires extra memory outside the table.

### 2. Open addressing

In open addressing, all elements are stored inside the hash table itself. Each table entry contains either a record or `NIL`.

When searching for an element, we examine table slots one by one until:

- the element is found, or
- it is clear that the element is not present.

## Summary

Hashing is a practical and efficient technique for storing and retrieving data when direct indexing is not feasible. It provides average-case $O(1)$ search time under reasonable assumptions, although worst-case performance can be $O(n)$ depending on collisions and the chosen strategy.
