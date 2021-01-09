class Graph:
    def __init__(self,edges,N):
        self.adjList = [[] for _ in range(N)]

        for (src,dest) in edges:
            self.adjList.append[src].append(dest)


    def isCyclic_DIRECTED(self):
        visited = [False]*(len(self.adjList))
        stack = [False]*(len(self.adjList))

        for i in range(len(self.adjList)):
            if visited[i] == False:
                if self.isCyclicUtil_DIRECTED(i,visited,stack)==True:
                    return True
        return False

    def isCyclicUtil_DIRECTED(self,v,visited,stack):
        visited[v] = True
        stack[v] = True

        for nbr in self.adjList[v]:
            if visited[nbr]==False:
                if self.isCyclicUtil_DIRECTED(nbr,visited,stack)==True:
                    return True
            elif stack[nbr] == True:
                return True

        stack[v] = False
        return False

    def isCyclic_UNDIRECTED(self):
        visited = [False]*len(self.adjList)

        for node in range(len(self.adjList)):
            if visited[node] == False:
                if self.isCyclicUtil_UNDIRECTED(node,visited,-1)==True:
                    return True
        
        return False
            

    def isCyclicUtil_UNDIRECTED(self,v,visited,parent):
        visited[v] = True
    
        for nbr in self.adjList[v]:
            if visited[nbr]==False:
                if self.isCyclicUtil_UNDIRECTED(nbr,visited,v)==True:
                    return True
            elif parent!=nbr:
                return True

        return False

    def isCyclic_UNDIRECTED_BFS(self,src):
        visited = [False]*len(self.adjList)
        visited[src] = True
        queue = []
        queue.append((src,-1))

        while queue:
            node,parent = queue.pop(0)

            for nbr in self.adjList[node]:
                if visited[nbr] == False:
                    visited[nbr] = True
                    queue.append((nbr,parent))
                elif nbr!=parent:
                    return True

        return False