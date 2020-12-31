from collections import deque

# BFS  O(V+E),O(V)
def BFS(graph, v, discovered):
    q = deque()
    discovered[v] = True
    q.append(v)

    while q:
        v = q.popleft()
        print(v, end=' ')

        for u in graph.adjList[v]:
            if not discovered[u]:
                discovered[u] = True
                q.append(u)

# DFS   O(V + E) , O(V)
def DFS(graph, v, discovered):
    discovered[v] = True  
    print(v, end=' ')  

    for u in graph.adjList[v]:
        if not discovered[u]: 
            DFS(graph, u, discovered)


#BFS for Disconnected Graph
def completeBFS(graph,V):
    visited = [False]*V
    for u in range(V):
        if visited[u]==False:
            BFS(graph,u,visited)