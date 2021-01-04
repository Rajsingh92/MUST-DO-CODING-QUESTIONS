'''
Sort a nearly sorted (or K sorted) array
Given an array of n elements, where each element is at most k away from its target position, devise an algorithm that 
sorts in O(n log k) time. For example, let us consider k is 2, an element at index 7 in the sorted array, can be at 
indexes 5, 6, 7, 8, 9 in the given array.

Examples:
Input : arr[] = {6, 5, 3, 2, 8, 10, 9} k = 3 
Output : arr[] = {2, 3, 5, 6, 8, 9, 10}
'''


import heapq

def sortArray(arr,k):
    heap = []
    res = []
    for i in arr:
        heapq.heappush(heap,i)
        if len(heap)>k:
            res.append(heapq.heappop(heap))
    
    while heap:
        res.append(heapq.heappop(heap))
        
    for i in res:
        print(i,end=" ")