def possible(s, k):
    low = 0
    high = 0

    for c in s:
        if c == '+':
            low = max(low + 1, 1)
            high += k

            if low > high:
                return False

        elif c == '-':
            low -= k
            high = min(high - 1, -1)

            if low > high:
                return False

        else:
            if low > 0 or high < 0:
                return False

            low = 0
            high = 0

    return True


qrTNum = int(input())

for _ in range(qrTNum):
    n = int(input())
    s = input().strip()

    invalid = False

    for i in range(1, n):
        if s[i] == '0' and s[i - 1] == '0':
            invalid = True
            break

    if invalid:
        print(-1)
        continue

    left = 1
    right = n
    ans = -1

    while left <= right:
        mid = (left + right) // 2

        if possible(s, mid):
            ans = mid
            right = mid - 1
        else:
            left = mid + 1

    print(ans)