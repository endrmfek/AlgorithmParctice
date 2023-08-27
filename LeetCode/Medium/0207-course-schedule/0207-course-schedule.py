from collections import deque
class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        #그래프의 순환이 있는지 체크하는거.
        #위상 정렬

        indegree = [0] * numCourses
        adj = [[] for _ in range(numCourses)]

        for pre in prerequisites:
            start,end = pre[1], pre[0]
            
            adj[start].append(end)
            indegree[end] += 1

        q = deque()
        for i in range(numCourses):
            if indegree[i] == 0:
                q.append(i)

        visited = 0
        while q:
            node = q.popleft()
            visited += 1

            for neighbor in adj[node]:
                indegree[neighbor] -= 1
                if indegree[neighbor] == 0:
                    q.append(neighbor)

        return numCourses == visited

