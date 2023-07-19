from collections import deque, defaultdict
def solution(n, wires):
    answer = 1000000001
    graph = defaultdict(list)
    
    for start, end in wires:
        graph[start].append(end)
        graph[end].append(start)
        
    
    def bfs(start, end, n):
        q = deque([start])
        count = 1
        visited = [False] * (n+1)
        
        while q:
            now = q.popleft()
            visited[now] = True
            
            for nextNode in graph[now]:
                if nextNode != end and not visited[nextNode]:
                    count += 1
                    q.append(nextNode)
        return count
        
    for start, end in wires:
        a = bfs(start, end, n)
        b = n-a
        answer = min(answer, abs(a-b))
    return answer