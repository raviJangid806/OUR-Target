n, q = map(int, input().split())
s = input().strip()

p0 = [0] * (n + 1)
p1 = [0] * (n + 1)
p00 = [0] * (n + 1)
p01 = [0] * (n + 1)
p10 = [0] * (n + 1)
p11 = [0] * (n + 1)
trans = [0] * (n + 1)

for i in range(1, n + 1):
    p0[i] = p0[i - 1] + (s[i - 1] == '0')
    p1[i] = p1[i - 1] + (s[i - 1] == '1')
    p00[i] = p00[i - 1]
    p01[i] = p01[i - 1]
    p10[i] = p10[i - 1]
    p11[i] = p11[i - 1]
    trans[i] = trans[i - 1]

    if i > 1:
        pair = s[i - 2:i]

        if pair == '00':
            p00[i] += 1
        elif pair == '01':
            p01[i] += 1
        elif pair == '10':
            p10[i] += 1
        else:
            p11[i] += 1

        if s[i - 2] != s[i - 1]:
            trans[i] += 1


for _ in range(q):
    l, r = map(int, input().split())

    length = r - l + 1

    c0 = p0[r] - p0[l - 1]
    c1 = p1[r] - p1[l - 1]

    c00 = p00[r] - p00[l - 1]
    c01 = p01[r] - p01[l - 1]
    c10 = p10[r] - p10[l - 1]
    c11 = p11[r] - p11[l - 1]

    changes = trans[r] - trans[l - 1]

    def possible(k):
        if c0 > 2 * k or c1 > 2 * k:
            return False

        if changes > 2 * k:
            return False

        extra = (
            max(0, c00 - k) +
            max(0, c01 - k) +
            max(0, c10 - k) +
            max(0, c11 - k)
        )

        return extra <= 4 * k - length

    low = 1
    high = length
    answer = high

    while low <= high:
        mid = (low + high) // 2

        if possible(mid):
            answer = mid
            high = mid - 1
        else:
            low = mid + 1

    print(4 * answer - length)