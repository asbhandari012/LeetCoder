class Solution(object):
    def findMaxPathScore(self, edges, online, k):
        """
        :type edges: List[List[int]]
        :type online: List[bool]
        :type k: int
        :rtype: int
        """
        from heapq import heappush, heappop

        n = len(online)
        graph = [[] for _ in range(n)]

        low = float("inf")
        high = 0

        for u, v, w in edges:
            if not online[u] or not online[v]:
                continue
            graph[u].append((v, w))
            low = min(low, w)
            high = max(high, w)

        if low == float("inf"):
            return -1

        def check(limit):
            dist = [float("inf")] * n
            dist[0] = 0

            pq = [(0, 0)]

            while pq:
                d, u = heappop(pq)

                if d > k:
                    return False

                if u == n - 1:
                    return True

                if d > dist[u]:
                    continue

                for v, w in graph[u]:
                    if w < limit:
                        continue

                    nd = d + w

                    if nd < dist[v]:
                        dist[v] = nd
                        heappush(pq, (nd, v))

            return False

        left, right = low, high

        while left < right:
            mid = (left + right + 1) // 2

            if check(mid):
                left = mid
            else:
                right = mid - 1

        if check(left):
            return left
        return -1