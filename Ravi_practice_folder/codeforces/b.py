import sys

input = sys.stdin.readline

t = int(input())

for _ in range(t):
    x, y, k = map(int, input().split())

    d = y - x

    if d == 0:
        print(0)
        continue

    last = min(x + k - 1, d)

    ans = 0

    for employees in range(x, last + 1):
        ans += d % employees

    cnt = last - x + 1

    if k > cnt:
        ans += (k - cnt) * d

    print(ans)