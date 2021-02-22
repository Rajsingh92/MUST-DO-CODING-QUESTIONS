//                      ACQUIRE RELEASE BASED      
//                      ACQUIRE RELEASE BASED   
//                      ACQUIRE RELEASE BASED   



/**
 * 
Count distinct elements in every window 
Given an array of integers and a number K. Find the count of distinct elements in every window of 
size K in the array.

Example 1:

Input:
N = 7, K = 4
A[] = {1,2,1,3,4,2,3}
Output: 3 4 4 3
 */


class Solution {
    ArrayList<Integer> countDistinct(int A[], int n, int k) {

        ArrayList<Integer> res = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        int i = 0;

        while (i < k - 1) {
            map.put(A[i], map.getOrDefault(A[i], 0) + 1);
            i++;
        }

        i--;
        int j = -1;

        while (i < A.length - 1) {
            // acquire
            i++;
            map.put(A[i], map.getOrDefault(A[i], 0) + 1);
            res.add(map.size());

            // release
            j++;
            int freq = map.get(A[j]);
            if (freq == 1) {
                map.remove(A[j]);
            } else {
                map.put(A[j], freq - 1);
            }
        }

        return res;
    }
}
    
    

/**
 * 
Find the smallest window in a string containing all characters of another string 

Given two strings s and t, return the minimum window in s which will contain all the characters in t. 
If there is no such window in s that covers all characters in t, return the empty string "".

Note that If there is such a window, it is guaranteed that there will always be only one unique minimum 
window in s.

 

Example 1:

Input: s = "ADOBECODEBANC", t = "ABC"
Output: "BANC"
 */

class Solution {
    public String minWindow(String s, String t) {
        if(t.length()>s.length()){
            return "";
        }
        
        HashMap<Character,Integer> map2 = new HashMap<>();
        for(int i = 0;i<t.length();i++){
            char ch = t.charAt(i);
            map2.put(ch,map2.getOrDefault(ch,0)+1);
        }
        
        HashMap<Character,Integer> map1 = new HashMap<>();
        int i = -1;
        int j = -1;
        int matchCount = 0;
        int desiredCount = t.length();
        String ans = "";
        
        
        while(true){
            boolean f1 = false;
            boolean f2 = false;
             // acquire
             while(i<s.length()-1 && matchCount<desiredCount){
                i++;
                char ch = s.charAt(i);
                map1.put(ch,map1.getOrDefault(ch,0)+1);
                
                if(map1.getOrDefault(ch,0)<=map2.getOrDefault(ch,0)){
                    matchCount++;
                }
                f1 = true;
             }
             
             // collect ans and release
            while(j<i && matchCount==desiredCount){
                // collect
                String potentialRes = s.substring(j+1,i+1);
                if(ans.length() == 0 || ans.length()>potentialRes.length()){
                    ans = potentialRes;
                }
                
                
                //release
                j++;
                char ch = s.charAt(j);
                if(map1.get(ch) == 1){
                    map1.remove(ch);
                }else{
                    map1.put(ch,map1.get(ch)-1);
                }
                
                if(map1.getOrDefault(ch,0)< map2.getOrDefault(ch,0)){
                    matchCount--;
                }
                
                
                f2 = true;
            }
            
            if( f1 ==false && f2 == false){
                break;
            }
         }
        return ans;
    }
    
}





/**
 * 
Longest Substring Without Repeating Characters
Given a string s, find the length of the longest substring without repeating characters.

 

Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
 */

class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        int i = -1;
        int j = -1;
        int ans = 0;
        
        HashMap<Character,Integer> map = new HashMap<>();
        
        
        while(true){
            boolean f1 = false;
            boolean f2 = false;
            
            //acquire
            while(i<s.length()-1){
                f1 = true;
                i++;
                char ch  = s.charAt(i);
                map.put(ch,map.getOrDefault(ch,0)+1);
                
                if(map.get(ch) == 2){
                    break;
                }else{
                    int len = i-j;
                    ans = Math.max(ans,len);
                }
            }
            
            //release
            while(j<i){
                f2 = true;
                j++;
                char ch = s.charAt(j);
                map.put(ch,map.get(ch)-1);
                
                if(map.get(ch) == 1){
                    break;
                }
            }
            
            if(f1 == false && f2 == false){
                break;
            }
        }
        
        return ans;
    }
}




/**
 * 
Count of all unique substrings with non-repeating characters
Given a string str consisting of lowercase characters, the task is to find the total numbers of unique 
substrings with non-repeating characters.

Examples:

Input: str = “abba”
Output: 4
Explanation:
There are 4 unique substrings. They are: “a”, “ab”, “b”, “ba”.
 */

public class Main {

    public static int solution(String str) {
        int ans = 0;
        int i =-1;
        int j = -1;
        
        HashMap<Character,Integer> map = new HashMap<>();
        
        while(true){
            boolean f1 = false;
            boolean f2 = false;
           // acquire
           while(i<str.length()-1){
               f1 = true;
               
               i++;
               char ch = str.charAt(i);
               map.put(ch,map.getOrDefault(ch,0)+1);
               
               if(map.get(ch) == 2){
                   break;
               }else{
                   ans += i-j;
               }
               
           }
           
           //release
           while(j<i){
               f2 = true;
               
               j++;
               char ch = str.charAt(j);
               map.put(ch,map.get(ch)-1);
               
               if(map.get(ch) == 1){
                   ans += i-j;
                   break;
               }
           }
           
           if(f1 == false && f2 == false){
               break;
           }
        }
        
        return ans;
    }


}




/**
 * 
Find the longest substring with k unique characters in a given string
Given a string you need to print longest possible substring that has exactly M unique characters. If there are more than one substring of longest possible length, then print any one of them.
Examples:

"aabbcc", k = 1
Max substring can be any one from {"aa" , "bb" , "cc"}.

"aabbcc", k = 2
Max substring can be any one from {"aabb" , "bbcc"}.

"aabbcc", k = 3
There are substrings with exactly 3 unique characters
{"aabbcc" , "abbcc" , "aabbc" , "abbc" }
Max is "aabbcc" with length 6.
 */


public class Main {

    public static int solution(String str, int k) {
        int ans = 0;
        int i  = -1;
        int j =  -1;
        HashMap<Character,Integer> map  = new HashMap<>();
        
        while(true){
            boolean f1 = false;
            boolean f2 = false;
            
            //acquire
            while(i<str.length()-1){
                f1 = true;
                
                i++;
                char ch = str.charAt(i);
                map.put(ch,map.getOrDefault(ch,0)+1);
                
                if(map.size()<k){
                    continue;
                }else if(map.size() == k){
                    int len = i-j;
                    ans = Math.max(ans,len);
                }else{
                    break;
                }
            }
            //release
            while(j<i){
                f2 = true;
                
                j++;
                char ch = str.charAt(j);
                
                if(map.get(ch) == 1){
                    map.remove(ch);
                }else{
                    map.put(ch,map.get(ch)-1);
                }
                
                if(map.size()>k){
                    continue;
                }else if(map.size() == k){
                    int len = i-j;
                    ans = Math.max(ans,len);
                    break;
                }
                
            }
            
            if(f1 == false && f2 == false){
                break;
            }
            
        }
        return ans;
    }



}

/**
 * 
Longest Substring With At Most K Unique Characters
 */


public class Main {

    public static int solution(String s, int k) {
        int i = -1;
        int j = -1;
        int ans = 0;
        
        HashMap<Character,Integer> map = new HashMap<>();
        
        
        while(true){
            boolean f1 = false;
            boolean f2 = false;
            
            //acquire
            while(i<s.length()-1){
                f1 = true;
                i++;
                char ch  = s.charAt(i);
                map.put(ch,map.getOrDefault(ch,0)+1);
                
                if(map.size()<=k){
                    ans = Math.max(ans,i-j);
                }else{
                    break;
                }
            }
            
            //release
            while(j<i){
                f2 = true;
                j++;
                char ch = s.charAt(j);
                
                if(map.get(ch) == 1){
                    map.remove(ch);
                }else{
                    map.put(ch,map.get(ch)-1);
                }
                
                if(map.size()>k){
                    continue;
                }else if(map.size() == k){
                    ans = Math.max(ans,i-j);
                    break;
                }
                
                
            }
            
            if(f1 == false && f2 == false){
                break;
            }
        }
        
        return ans;
    }

}


/**
 * 
Count Of Substrings Having At Most K Unique Characters
 */


public class Main {

    public static int solution(String s, int k) {
        int i = -1;
        int j = -1;
        int ans = 0;
        
        HashMap<Character,Integer> map = new HashMap<>();
        
        
        while(true){
            
            //acquire
            while(i<s.length()-1){
                
                i++;
                char ch  = s.charAt(i);
                map.put(ch,map.getOrDefault(ch,0)+1);
                
                if(map.size()<=k){
                    ans += i-j;
                }else{
                    break;
                }
            }
            
            if(i == s.length()-1 && map.size() <= k){
                break;
            }
            
            //release
            while(j<i){
                
                j++;
                char ch = s.charAt(j);
                
                if(map.get(ch) == 1){
                    map.remove(ch);
                }else{
                    map.put(ch,map.get(ch)-1);
                }
                
                if(map.size()>k){
                    continue;
                }else if(map.size() == k){
                    ans += i-j;
                    break;
                }
                
                
            }
            
         
        }
        
        return ans;
    }

}



/**
 * 
Max Consecutive Ones III
Given an array A of 0s and 1s, we may change up to K values from 0 to 1.

Return the length of the longest (contiguous) subarray that contains only 1s. 

 

Example 1:

Input: A = [1,1,1,0,0,0,1,1,1,1,0], K = 2
Output: 6
Explanation: 
[1,1,1,0,0,1,1,1,1,1,1]
Bolded numbers were flipped from 0 to 1.  The longest subarray is underlined.
 */

class Solution {
    public int longestOnes(int[] A, int K) {
        int count = 0 ;
        int ans  = 0;
        int j = -1;
        
        for(int i = 0;i<A.length;i++){

            //acquire
            if(A[i] ==0){
                count++;
            }
            
            // release
            while(count>K){
                j++;
                if(A[j] == 0){
                    count--;
                }
            }

            int len = i-j;
            ans = Math.max(ans,len);
        }
        
        return ans;
    }
}


/**
| 487 | Max Consecutive Ones II |  Medium | Google |
 */
