/**
 * 
Kth Smallest Element in a Sorted Matrix

Given a n x n matrix where each of the rows and columns are sorted in ascending order, find the kth smallest element in the matrix.
Note that it is the kth smallest element in the sorted order, not the kth distinct element.

Example:

matrix = [
   [ 1,  5,  9],
   [10, 11, 13],
   [12, 13, 15]
],
k = 8,

return 13.

import heapq
class Solution:
    def kthSmallest(self, matrix: List[List[int]], k: int) -> int:
        max_heap = []
        
        for i in range(len(matrix)):
            for j in range(len(matrix[0])):
                heapq.heappush(max_heap,-1*matrix[i][j])
                if len(max_heap)>k:
                    heapq.heappop(max_heap)
                
        return -1*heapq.heappop(max_heap)
 */

public class Solution{
    class Solution {
        public int kthSmallest(int[][] matrix, int k) {
            PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
            
            for(int i = 0;i<matrix.length;i++){
                for(int j = 0;j<matrix[0].length;j++){
                    pq.add(matrix[i][j]);
                    if(pq.size()>k){
                        pq.remove();
                    }
                }
            }
            
            return pq.remove();
        }
    }
}