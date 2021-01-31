 
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

class Solution:
    def isIsomorphic(self, s: str, t: str) -> bool:
        
        if len(s)!=len(t):
            return False
        
        hashMap1 = dict()  #char to char
        hashMap2 = dict()  #char to boolean
        
        for i in range(len(s)):
            x = s[i]
            y = t[i]
            
            if x in hashMap1:
                if hashMap1[x]!=y:
                    return False
            else:
                if y in hashMap2:
                    return False
                hashMap1[x] = y
                hashMap2[y] = True
        
        return True
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