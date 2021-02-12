//                      ANAGRAM BASED 
//                      ANAGRAM BASED 
//                      ANAGRAM BASED 



/**
 * 
Valid Anagram
Given two strings s and t , write a function to determine if t is an anagram of s.

Example 1:

Input: s = "anagram", t = "nagaram"
Output: true
Example 2:

Input: s = "rat", t = "car"
Output: false
 */

import java.util.HashMap;


public class Solution{
    public static boolean isAnagram(String s,String t){
        if(s.length() != t.length()){
            return false;
        }

        HashMap<Character,Integer> map = new HashMap<>();
        for(int i = 0;i<s.length();i++){
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0)+1);
        }

        for(int i = 0;i<t.length();i++){
            char ch = t.charAt(i);

            if(!map.containsKey(ch)){
                return false;
            }

            if(map.get(ch) == 1){
                map.remove(ch);
            }else{
                map.put(ch,map.get(ch)-1);
            }
        }

        return map.size() == 0;
    }
}






/**
 * 
K ANAGRAM
Check if two strings are k-anagrams or not
Two strings are called k-anagrams if following two conditions are true. 
Both have same number of characters.
Two strings can become anagram by changing at most k characters in a string.

Examples :  
Input:  str1 = "anagram" , str2 = "grammar" , k = 3
Output:  Yes
Explanation: We can update maximum 3 values and it can be done in changing only 'r' to 'n'  and 'm' to 'a' in str2.
 */

public class Solution {
    public static boolean areKAnagrams(String s1, String s2, int k) {
        if(s1.length()!=s2.length()){
            return false;
        }

        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            char ch = s1.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        for (int i = 0; s2.length(); i++) {
            char ch = s2.charAt(i);
            if (map.getOrDefault(ch, 0) > 0) {
                map.put(ch, map.get(ch) - 1);
            }
        }

        int count = 0;

        for (char ch : map.keySet()) {
            count += map.get(ch);
        }

        if (count > k) {
            return false;
        } else {
            return true;
        }
    }


    public static boolean areKAnagrams2(String str1, String str2, int k) {
        if (str1.length() != str2.length()) {
            return false;
        }
        int[] farr = new int[26];
        for (int i = 0; i < str1.length(); i++) {
            char ch = str1.charAt(i);
            farr[ch - 'a']++;
        }
        for (int i = 0; i < str2.length(); i++) {
            char ch = str2.charAt(i);
            if (farr[ch - 'a'] != 0)
                farr[ch - 'a']--;
        }

        int diff = 0;
        for (int i = 0; i < 26; i++) {
            diff += farr[i];
        }

        if (diff <= k) {
            return true;
        } else {
            return false;
        }
    }
}



/**
 * 
Anagram Mapping
For every element in A, you have to print the index of that element in B.
arr1 : 1 2 3 4 5 2    arr2: 4 3 2 1 5 2
op: 3 2 1 0 4 5 
 */


public class Main {
    public static int[] anagramMappings(int[] arr1, int[] arr2) {
        
        HashMap<Integer,ArrayList<Integer>> map  = new HashMap<>();
        for(int i = 0;i<arr2.length;i++){
            if(map.containsKey(arr2[i])){
               map.get(arr2[i]).add(i);
            }else{
                ArrayList<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(arr2[i],list);
            }
        }
        
        int[] ans = new int[arr1.length];
        for(int i = 0;i<arr1.length;i++){
            ans[i] = map.get(arr1[i]).remove(0);
        }
        
        return ans;
    }

}




/**
 * 
Group Anagrams
Given an array of strings strs, group the anagrams together. You can return the answer in any order.
An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all 
the original letters exactly once.

Example 1:

Input: strs = ["eat","tea","tan","ate","nat","bat"]
Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
 */

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<HashMap<Character,Integer>,ArrayList<String>> map = new HashMap<>();
        
        for(String str: strs){
            HashMap<Character,Integer> fmap =  new HashMap<>();
            for(int i = 0;i<str.length();i++){
                char ch = str.charAt(i);
                fmap.put(ch,fmap.getOrDefault(ch,0)+1);
            }
            
            if(map.containsKey(fmap) == false){
                ArrayList<String> list = new ArrayList<>();
                list.add(str);
                map.put(fmap,list);
            }else{
                ArrayList<String> list = map.get(fmap);
                list.add(str);
            }
        }
        
        List<List<String>> res = new ArrayList<>();
        for(ArrayList<String> list : map.values()){
            res.add(list);
        }
        
        return res;
    }
}

 
/**
 * 
Isomorphic Strings
Given two strings s and t, determine if they are isomorphic.
Two strings s and t are isomorphic if the characters in s can be replaced to get t.
All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character, but a character may map to itself.

 

Example 1:

Input: s = "egg", t = "add"
Output: true
Example 2:

Input: s = "foo", t = "bar"
Output: false
 */

class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s.length()!=t.length()){
            return false;
        }
        
        HashMap<Character,Character> map1 = new HashMap<>();
        HashMap<Character,Boolean> map2 = new HashMap<>();
        
        for(int i = 0;i<s.length();i++){
            char ch1 = s.charAt(i);
            char ch2 = t.charAt(i);
            if(map1.containsKey(ch1)){
                if(map1.get(ch1)!=ch2){
                    return false;
                }
            }else{
                if(map2.containsKey(ch2)){
                    return false;
                }
                map1.put(ch1,ch2);
                map2.put(ch2,true);
            }
        }
        
        return true;
    }
}


/**
 * 
Word Pattern
Given a pattern and a string s, find if s follows the same pattern.
Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in s.

Example 1:

Input: pattern = "abba", s = "dog cat cat dog"
Output: true
 */

class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        if(words.length!=pattern.length()){
            return false;
        }
        
        HashMap<Character,String> map = new HashMap<>();
        HashMap<String,Boolean> used = new HashMap<>();
        
        for(int i = 0;i<pattern.length();i++){
            char ch = pattern.charAt(i);
            
            if(map.containsKey(ch) == false){
                if(used.containsKey(words[i]) == true){
                    return false;
                }
                map.put(ch,words[i]);
                used.put(words[i],true);
            }else{
                String mappedWith = map.get(ch);
                if(mappedWith.equals(words[i]) == false){
                    return false;
                }
            }
        }
        
        return true;
        
    }
}


/**
Anagram Palindrome 
Given a string S, Check if characters of the given string can be rearranged to form a palindrome. 
For example characters of “geeksogeeks” can be rearranged to form a palindrome “geeksoskeeg”, 
but characters of “geeksforgeeks” cannot be rearranged to form a palindrome.
 */

/*package whatever //do not write package name here */



class GFG {
    static final int NO_OF_CHARS = 26;
    public static boolean anagramPalindrome(String str){
        int n = str.length();
        int[] freq = new int[26];
        for(int i=0;i<n;i++) freq[str.charAt(i) - 'a']++;

        int oddCount = 0;
        for(int i=0;i<26;i++){
            if((freq[i] % 2) != 0 && ++oddCount > 1) return false;   
        }

        return true;
    }
}



/**
 * 
Group Shifted String 
Two strings s1 and s2 are shifted if -
   -> Length of both the strings is the same.
   -> The difference between ASCII values of every character of s1 and s2 is constant.

Input : acd dfg wyz yab mop bdfh a x moqs
output: 
    acd dfg mop wyz yab 
    a x 
    bdfh moqs 
 */


public class Main {
    
    public static String getKey(String str){
        String key = " ";
        
        for(int i = 1;i<str.length();i++){
            char curr = str.charAt(i);
            char prev = str.charAt(i-1);
            int diff = curr-prev;
            if(diff<0){
                diff+=26;
            }
            
            key += diff+"#";
        }
        
        key+=".";
        return key;
    }

    public static ArrayList < ArrayList < String >> groupShiftedStrings(String[] strs) {
        HashMap<String,ArrayList<String>> map = new HashMap<>();
        
        for(String str: strs){
            String key = getKey(str);
            
            if(map.containsKey(key) == false){
                ArrayList<String> list = new ArrayList<>();
                list.add(str);
                map.put(key,list);
            }else{
                ArrayList<String> list = map.get(key);
                list.add(str);
            }
        }
        
        ArrayList<ArrayList<String>> res = new ArrayList<>();
        
        for(ArrayList<String> list: map.values()){
            res.add(list);
        }
        
        return res;
    }

}



