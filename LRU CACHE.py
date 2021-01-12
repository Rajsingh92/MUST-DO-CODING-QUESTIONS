'''
LRU Cache
Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.

Implement the LRUCache class:
LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
int get(int key) Return the value of the key if the key exists, otherwise return -1.
void put(int key, int value) Update the value of the key if the key exists. Otherwise, add the key-value pair to the cache. 
If the number of keys exceeds the capacity from this operation, evict the least recently used key.
Follow up:
Could you do get and put in O(1) time complexity?

 

Example 1:

Input
["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
[[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
Output
[null, null, null, 1, null, -1, null, -1, 3, 4]

Explanation
LRUCache lRUCache = new LRUCache(2);
lRUCache.put(1, 1); // cache is {1=1}
lRUCache.put(2, 2); // cache is {1=1, 2=2}
lRUCache.get(1);    // return 1
lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
lRUCache.get(2);    // returns -1 (not found)
lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
lRUCache.get(1);    // return -1 (not found)
lRUCache.get(3);    // return 3
lRUCache.get(4);    // return 4

'''

class Node:
    def __init__(self,key,val):
        self.key = key 
        self.val = val 
        self.prev = None
        self.next = None

class  LRUCache:
    def __init__(self,capacity):
        self.capacity = capacity
        self.dict = dict()
        self.head = Node(0,0)
        self.tail = Node(0,0)
        self.head.next = self.tail
        self.tail.prev = self.head

    def get(self,key):
        if key in self.dict:
            n = self.dict[key]
            self.remove(n)
            self.insert(n)
            return n.val

        return -1


    def put(self,key,value):
        if key in self.dict:
            self.remove(self.dict[key])
        n = Node(key,value)
        self.insert(n)
        self.dict[key] = n
        if len(self.dict)>self.capacity:
            n = self.head.next
            self.remove(n)
            del self.dict[n.key]


    def remove(self,node):
        p = node.prev
        n = node.next
        p.next = n
        n.prev = p
    
    def insert(self,node):
        p = self.tail.prev
        p.next = node
        self.tail.prev = node
        node.prev = p
        node.next = self.tail

