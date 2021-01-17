from collections import deque

# Topological Sorting in a DAG
def topologicalSortUtil(graph,v,stack,visited):
    visited[v]= True

    for u in graph.adjList[v]:
        if  visited[u] == False:
            topologicalSortUtil(graph,u,stack,visited)

    stack.append(v)

def topologicalSort(graph,V):
    visited = [False]*V
    stack = []

    for v in range(V):
        if visited[v]==False:
            topologicalSortUtil(graph,v,stack,visited)

    print(stack[::-1])

# Kahn’s Topological Sort Algorithm
def KahnsAlgo(graph,V):
    indegree = [0]*V
    for i in range(V):
        for j in graph.adjList[i]:
            indegree[j]+=1

    queue = deque()
    stack = []

    for i in range(V):
        if indegree[i]==0:
            queue.append(i)

    while queue:
        node = queue.popleft()
        stack.append(node)

        for u in graph.adjList[node]:
            indegree[u]-=1
            if indegree[u] == 0:
                queue.append(u)
    
    for i in range(V):
        if indegree[i]:
            return None

    print(stack)


