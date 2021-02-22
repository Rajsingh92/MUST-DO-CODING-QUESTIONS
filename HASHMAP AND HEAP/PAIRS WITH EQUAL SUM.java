/**
 * 
Print all pairs in an unsorted array with equal sum
Given an unsorted array A[]. The task is to print all unique pairs in the unsorted array with equal sum.
Note: Print the result in the format as shown in the below examples. 
Examples: 
 

Input: A[] = { 6, 4, 12, 10, 22, 54, 32, 42, 21, 11}
Output:
Pairs : ( 4, 12) ( 6, 10)  have sum : 16
Pairs : ( 10, 22) ( 21, 11)  have sum : 32
Pairs : ( 12, 21) ( 22, 11)  have sum : 33
Pairs : ( 22, 21) ( 32, 11)  have sum : 43
Pairs : ( 32, 21) ( 42, 11)  have sum : 53
Pairs : ( 12, 42) ( 22, 32)  have sum : 54
Pairs : ( 10, 54) ( 22, 42)  have sum : 64
 */



public class Solution {
    public static void printPairs(int[] arr){
        HashMap<Integer> map = new HashMap<>();

        for(int i = 0;i<arr.length;i++){
            for(int j = i+1;j<arr.length;j++){
                int sum =arr[i]+arr[j];
                if(map.get(sum)!=null){
                    int ele = map.get(sum);
                    System.out.println("(" + arr[i] +  "," + arr[j] + ") (" +  ele + "," +  (sum - ele) + ") sum=" + sum); 
                }else{
                    map.put(sum,arr[i]);
                }
            }
        }
    }
}


/**
 * 
Find four elements a, b, c and d in an array such that a+b = c+d
Given an array of distinct integers, find if there are two pairs (a, b) and (c, d) such that a+b = c+d, 
and a, b, c and d are distinct elements. If there are multiple answers, then print any of them.

Example:

Input:   {3, 4, 7, 1, 2, 9, 8}
Output:  (3, 8) and (4, 7)
 */


class Solution
{ 
    public static class Pair{
        int x;
        int y;
        
        Pair(int x,int y){
            this.x = x;
            this.y = y;
        }
    }
    
    public int findPairs(int arr[],int n) 
    { 
        //code here.
        HashMap<Integer,Pair> map = new HashMap<>();
        
        for(int i = 0;i<arr.length;i++){
            for(int j =i+1;j<arr.length;j++){
                int sum = arr[i]+arr[j];
                
                if(map.containsKey(sum)){
                    Pair p = map.get(sum);
                    System.out.println("("+arr[p.x]+", "+arr[p.y]+") and ("+arr[i]+", "+arr[j]+")");
                    return 1;
                }else{
                    map.put(sum,new Pair(i,j));
                }
            }
        }
        
        return 0;
    }
}

