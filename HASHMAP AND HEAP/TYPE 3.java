//                  HEAP BASED 
//                  HEAP BASED 
//                  HEAP BASED 
     

/**
| 215 | Kth Largest Element in an Array |  Medium | Facebook |

Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth 
distinct element.

Example 1:
Input: [3,2,1,5,6,4] and k = 2
Output: 5

Example 2:
Input: [3,2,3,1,2,4,5,5,6] and k = 4
Output: 4


import heapq
class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        min_heap = []
        for i in nums:
            heapq.heappush(min_heap,i)
            if len(min_heap)>k:
                heapq.heappop(min_heap)
        return heapq.heappop(min_heap)
 */

class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(); //min heap
        
        for(int i =0;i<nums.length;i++){
            pq.add(nums[i]);
            if(pq.size()>k){
                pq.remove();
            }
        }
        
        return pq.remove();
    }
}




/**
 * 
| 378 | Kth Smallest Element in a Sorted Matrix |  Medium | Apple |

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

        public int kthSmallest2(int[][] matrix, int k) {
            if(matrix.length == 0 || matrix[0].length == 0){
                return 0;
            }
            
            int n = matrix.length;
            int m = matrix[0].length;
            
            PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->{
                return matrix[a/m][a%m]-matrix[b/m][b%m];
            });
            
            for(int i = 0;i<n;i++){
                pq.add(i*m+0);
            }
            
            while(--k>0){
                int idx  = pq.remove();
                int r = idx/m;
                int c = idx%m;
                
                c++;
                if(c<m){
                    pq.add(r*m+c);
                }
            }
            
            
            int idx = pq.remove();
            int r = idx/m;
            int c = idx%m;
            
            return matrix[r][c];
            
            
        }
    }

}


/**
| 347 | Top K Frequent Elements |  Medium | Facebook, Google, Microsoft |
Given a non-empty array of integers, return the k most frequent elements.

Example 1:

Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]
Example 2:

Input: nums = [1], k = 1
Output: [1]
 */



class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int val : nums){
            map.put(val,map.getOrDefault(val,0)+1);
        }
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> {
            return a[0]-b[0];  //sort based on freq
        });
        
        for(Integer key : map.keySet()){
            pq.add(new int[]{map.get(key),key});
            if(pq.size()>k){
                pq.remove();
            }
        }
        
        int[] ans = new int[pq.size()];
        int i = 0;
        
        while(pq.size()!=0){
            int[] ar = pq.remove();
            ans[i++] = ar[1];
        }
        
        return ans;
    }


    public class pair implements Comparable<pair>{
        int val;
        int freq;
        
        pair(int val,int freq){
            this.val = val;
            this.freq = freq;
        }
        
        @Override
        public int compareTo(pair o){
            return this.freq - o.freq;
        }
    }
    
    public int[] topKFrequent2(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int val : nums){
            map.put(val,map.getOrDefault(val,0)+1);
        }
        
        PriorityQueue<pair> pq = new PriorityQueue<>();
        
        for(Integer key : map.keySet()){
            pq.add(new pair(key,map.get(key)));
            if(pq.size()>k){
                pq.remove();
            }
        }
        
        int[] ans = new int[pq.size()];
        int i = 0;
        
        while(pq.size()!=0){
            pair ar = pq.remove();
            ans[i++] = ar.val;
        }
        
        return ans;
    }
}






/**
 * 
| 973 | K Closest Points to Origin |  Medium | Amazon, Apple, Facebook, Google, Microsoft |
We have a list of points on the plane.  Find the K closest points to the origin (0, 0).

(Here, the distance between two points on a plane is the Euclidean distance.)

You may return the answer in any order.  The answer is guaranteed to be unique (except for the order that it is in.)

 

Example 1:

Input: points = [[1,3],[-2,2]], K = 1
Output: [[-2,2]]
Explanation: 
The distance between (1, 3) and the origin is sqrt(10).
The distance between (-2, 2) and the origin is sqrt(8).
Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin.
We only want the closest K = 1 points from the origin, so the answer is just [[-2,2]].
 */

class Solution {
    public class Pair implements Comparable<Pair>{
        int i = 0;
        int j = 0;
        
        Pair(int i,int j){
            this.i = i;
            this.j = j;
        }
        
        @Override
        public int compareTo(Pair o){
            int r1 = this.i*this.i  + this.j*this.j;
            int r2 = o.i*o.i + o.j*o.j;
            
            return r2-r1;
        }
    }
    
    
    public int[][] kClosest(int[][] points, int K) {
        PriorityQueue<Pair> pq=new PriorityQueue<>();
        
        for(int[] p : points){
            pq.add(new Pair(p[0],p[1]));
            if(pq.size()>K){
                pq.remove();
            }
        }
        
        int[][] ans= new int[K][2];
        int i = 0;
        
        while(pq.size()!=0){
            Pair p = pq.remove();
            ans[i][0] = p.i;
            ans[i][1] = p.j;
            i++;
        }
        
        return ans;
    }
}





/**
 * 
| 451 | Sort Characters By Frequency |  Medium | Amazon, Google, Microsoft |
Given a string, sort it in decreasing order based on the frequency of characters.

Example 1:

Input:
"tree"

Output:
"eert"

Explanation:
'e' appears twice while 'r' and 't' both appear once.
So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
 */

class Solution {
    public String frequencySort(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i = 0;i<s.length();i++){
            char ch = s.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        
        PriorityQueue<Character> pq = new PriorityQueue<>((a,b)->{
            return map.get(b)-map.get(a);
        });
        
        for(Character ch : map.keySet()){
            pq.add(ch);
        }
        
        StringBuilder sb = new StringBuilder();
        
        while(pq.size()!=0){
            char ch = pq.remove();
            int freq = map.get(ch);
            for(int i =0;i<freq;i++){
                sb.append(ch);
            }
        }
        
        return sb.toString();
    }
}



/**
 * 
Sort a nearly sorted (or K sorted) array
Given an array of n elements, where each element is at most k away from its target position, devise an algorithm that 
sorts in O(n log k) time. For example, let us consider k is 2, an element at index 7 in the sorted array, can be at 
indexes 5, 6, 7, 8, 9 in the given array.

Examples:
Input : arr[] = {6, 5, 3, 2, 8, 10, 9} k = 3 
Output : arr[] = {2, 3, 5, 6, 8, 9, 10}
 */

class GFG {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int T = scn.nextInt();

		for (int t = 0; t < T; t++) {
			int N = scn.nextInt();
			int K = scn.nextInt();

			int[] arr = new int[N];
			for (int i = 0; i < N; i++) {
				arr[i] = scn.nextInt();
			}

			PriorityQueue<Integer> pq = new PriorityQueue<>();
			for (int i = 0; i < arr.length; i++) {
				pq.add(arr[i]);
				if (pq.size() > K) {
					int temp = pq.remove();
					System.out.print(temp + " ");
				}
			}

			while (pq.size() > 0) {
				int temp = pq.remove();
				System.out.print(temp + " ");
			}
			System.out.println();
		}

	}

}



/**
| 373 | Find K Pairs with Smallest Sums |  Medium | Amazon, Apple, Google, Microsoft |

You are given two integer arrays nums1 and nums2 sorted in ascending order and an integer k.
Define a pair (u,v) which consists of one element from the first array and one element from the second array.
Find the k pairs (u1,v1),(u2,v2) ...(uk,vk) with the smallest sums.

Example 1:

Input: nums1 = [1,7,11], nums2 = [2,4,6], k = 3
Output: [[1,2],[1,4],[1,6]] 
Explanation: The first 3 pairs are returned from the sequence: [1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]
 */


class Solution {
    public static class Pair implements Comparable<Pair>{
        int sum;
        int i;
        int j;

        
        Pair(int sum,int i,int j){
            this.sum = sum;
            this.i = i;
            this.j = j;
        }
        
        public int compareTo(Pair o){
            return o.sum-this.sum;
        }
    }
    
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        
        PriorityQueue<Pair> pq = new PriorityQueue<>(); 
        
        for(int i=0;i<nums1.length;i++){
            for(int j=0;j<nums2.length;j++){
                pq.add(new Pair(nums1[i]+nums2[j],i,j));
                
                if(pq.size()>k){
                    pq.remove();
                }
            }
        }
        
        List<List<Integer>> ans = new ArrayList<>();
        while(pq.size()!=0){
            Pair rem = pq.remove();
            ArrayList<Integer> temp = new ArrayList<>();
            temp.add(nums1[rem.i]);
            temp.add(nums2[rem.j]);
            ans.add(temp);
        }
        
        return ans;
    }
}

/**
 
Print all elements in sorted order from row and column wise sorted matrix
Given an n x n matrix, where every row and column is sorted in non-decreasing order. Print all elements of 
matrix in sorted order.
Example:

Input: mat[][]  =  { {10, 20, 30, 40},
                     {15, 25, 35, 45},
                     {27, 29, 37, 48},
                     {32, 33, 39, 50},
                   };

Output: 10 15 20 25 27 29 30 32 33 35 37 39 40 45 48 50
 */

public class Solution {

	private static void sortmatrix(int[][] arr) {
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		for (int row = 0; row < arr.length; row++) {
			pq.add(new Pair(arr[row][0], row, 0));
		}

		while (!pq.isEmpty()) {
			Pair pair = pq.remove();
			System.out.print(pair.value+" ");
			if (pair.col+1 != arr[0].length)
				pq.add(new Pair(arr[pair.row][pair.col+1], pair.row, pair.col+1));
		}
	}

	static class Pair implements Comparable<Pair> {
		int value;
		int row;
		int col;

		public Pair(int value, int row, int col) {
			this.value = value;
			this.row = row;
			this.col = col;
		}

		public int compareTo(Pair o) {
			return this.value - o.value;
		}
	}

}


/**
Maximize Sum Of Array After K Negations

Given an array A of integers, we must modify the array in the following way: we choose an i and replace A[i] 
with -A[i], and we repeat this process K times in total.  (We may choose the same index i multiple times.)

Return the largest possible sum of the array after modifying it in this way.


Example 1:

Input: A = [4,2,3], K = 1
Output: 5
Explanation: Choose indices (1,) and A becomes [4,-2,3].
 */

class Solution {
    public int largestSumAfterKNegations(int[] A, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(); 
        
        for(Integer val: A){
            pq.add(val);
        }
        
        while(k-->0){
            int temp = pq.remove();
            temp = (-1)*temp;
            pq.add(temp);
        }
        
        int sum = 0;
        while(pq.size()!=0){
            int temp = pq.remove();
            sum+=temp;
        }
        
        return sum;
    }
}


/**
| 692 | Top K Frequent Words |  Medium | Amazon, Apple, Facebook, Google, Microsoft |
| 703 | Kth Largest Element in a Stream |  Easy | Amazon, Facebook, Google |
 */