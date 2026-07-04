class Solution(object):
    def minScore(self, n, roads):
        """
        :type n: int
        :type roads: List[List[int]]
        :rtype: int
        """

        graph = [[] for _ in range(n + 1)]

        # Build graph
        for u, v, d in roads:
            graph[u].append((v, d))
            graph[v].append((u, d))

        visited = set()
        self.ans = float("inf")

        def dfs(node):
            visited.add(node)

            for nei, dist in graph[node]:
                self.ans = min(self.ans, dist)

                if nei not in visited:
                    dfs(nei)

        dfs(1)

        return self.ans