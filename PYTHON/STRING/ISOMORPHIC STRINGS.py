'''
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
'''

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
 