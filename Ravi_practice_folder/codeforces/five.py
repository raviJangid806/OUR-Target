import sys

input = sys.stdin.readline


def solve():
    n, m = map(int, input().split())

    edges = []
    graph = [[] for _ in range(n)]

    for i in range(m):
        u, v = map(int, input().split())
        u -= 1
        v -= 1
        edges.append((u, v))
        graph[u].append((v, i))
        graph[v].append((u, i))

    parent = [-1] * n
    parent_edge = [-1] * n
    order = [0]
    parent[0] = 0

    for u in order:
        for v, eid in graph[u]:
            if parent[v] == -1:
                parent[v] = u
                parent_edge[v] = eid
                order.append(v)

    tree_edges = [False] * m

    for v in range(1, n):
        tree_edges[parent_edge[v]] = True

    extra = [i for i in range(m) if not tree_edges[i]]
    k = len(extra)

    if k == 0:
        return False

    extra_index = {e: i for i, e in enumerate(extra)}

    fundamental = []

    for eid in extra:
        u, v = edges[eid]

        x = u
        y = v
        mask = 1 << eid

        while x != y:
            if len(order) == 0:
                break

            if parent[x] == y:
                mask |= 1 << parent_edge[x]
                x = parent[x]
            elif parent[y] == x:
                mask |= 1 << parent_edge[y]
                y = parent[y]
            else:
                dx = 0
                dy = 0

                a = x
                while a != 0:
                    dx += 1
                    a = parent[a]

                b = y
                while b != 0:
                    dy += 1
                    b = parent[b]

                while dx > dy:
                    mask |= 1 << parent_edge[x]
                    x = parent[x]
                    dx -= 1

                while dy > dx:
                    mask |= 1 << parent_edge[y]
                    y = parent[y]
                    dy -= 1

                while x != y:
                    mask |= 1 << parent_edge[x]
                    x = parent[x]
                    mask |= 1 << parent_edge[y]
                    y = parent[y]

        fundamental.append(mask)

    for subset in range(1, 1 << k):
        mask = 0

        for i in range(k):
            if subset & (1 << i):
                mask ^= fundamental[i]

        degree = [0] * n
        edge_count = 0
        vertices = []

        temp = mask

        while temp:
            bit = temp & -temp
            eid = bit.bit_length() - 1
            temp -= bit

            u, v = edges[eid]
            degree[u] += 1
            degree[v] += 1
            edge_count += 1

            if degree[u] == 1:
                vertices.append(u)
            if degree[v] == 1:
                vertices.append(v)

        if edge_count < 3:
            continue

        valid_cycle = True

        for v in vertices:
            if degree[v] != 2:
                valid_cycle = False
                break

        if not valid_cycle:
            continue

        seen = [False] * n
        start = vertices[0]
        stack = [start]
        seen[start] = True
        count = 0

        while stack:
            u = stack.pop()
            count += 1

            for v, eid in graph[u]:
                if (mask >> eid) & 1:
                    if not seen[v]:
                        seen[v] = True
                        stack.append(v)

        if count != edge_count:
            continue

        seen = [False] * n
        stack = [0]
        seen[0] = True
        count = 0

        while stack:
            u = stack.pop()
            count += 1

            for v, eid in graph[u]:
                if (mask >> eid) & 1:
                    continue

                if not seen[v]:
                    seen[v] = True
                    stack.append(v)

        if count == n:
            return True

    return False


t = int(input())

for _ in range(t):
    print("YES" if solve() else "NO")