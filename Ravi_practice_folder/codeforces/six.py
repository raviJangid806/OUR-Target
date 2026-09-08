MOD = 998244353


def sieve(n):
    is_prime = [True] * (n + 1)

    if n >= 0:
        is_prime[0] = False
    if n >= 1:
        is_prime[1] = False

    for i in range(2, int(n ** 0.5) + 1):
        if is_prime[i]:
            for j in range(i * i, n + 1, i):
                is_prime[j] = False

    return is_prime


n = int(input())

if n == 1:
    print(1)
    exit()

fact = [1] * (n + 1)

for i in range(1, n + 1):
    fact[i] = fact[i - 1] * i % MOD

inv_fact = [1] * (n + 1)
inv_fact[n] = pow(fact[n], MOD - 2, MOD)

for i in range(n, 0, -1):
    inv_fact[i - 1] = inv_fact[i] * i % MOD


def perm(k):
    return fact[n] * inv_fact[n - k] % MOD


is_prime = sieve(n)

ans = perm(n // 2)

for p in range(3, n + 1, 2):

    if not is_prime[p]:
        continue

    q = n // p

    r = n // (2 * p)

    power = (q + 1) // 2
    boundary = 1

    if q % 2 == 1 and n % p == 0:
        power -= 1
        boundary = 2

    L = pow(3, power, MOD)
    L = L * boundary % MOD

    add = perm(q)

    overlap = perm(r) * L % MOD

    ans = (ans + add - overlap) % MOD

print(ans)