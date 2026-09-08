import sys

input = sys.stdin.readline

INF = 10**9

def solve(s):
    dp = [INF] * 7
    dp[3] = 0

    for ch in s:
        ndp = [INF] * 7

        for i in range(7):
            if dp[i] == INF:
                continue

            prev = i - 3

            for j in range(7):
                cur = j - 3

                if cur == prev:
                    continue

                if ch == '+' and cur <= 0:
                    continue

                if ch == '-' and cur >= 0:
                    continue

                if ch == '0' and cur != 0:
                    continue

                cost = max(dp[i], abs(cur - prev))
                ndp[j] = min(ndp[j], cost)

        dp = ndp

    ans = min(dp)

    return -1 if ans == INF else ans


t = int(input())

for _ in range(t):
    n = int(input())
    s = input().strip()
    print(solve(s))