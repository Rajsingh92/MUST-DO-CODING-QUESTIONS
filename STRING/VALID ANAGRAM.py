'''
Valid Anagram
Given two strings s and t , write a function to determine if t is an anagram of s.

Example 1:

Input: s = "anagram", t = "nagaram"
Output: true
Example 2:

Input: s = "rat", t = "car"
Output: false
'''


class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        if len(s)!=len(t):
            return False
        
        freq1 = dict()
        freq2 = dict()
        
        for i in s:
            if i not in freq1:
                freq1[i] = 1
            else:
                freq1[i]+=1
                
        for i in t:
            if i not in freq2:
                freq2[i] = 1
            else:
                freq2[i] +=1
                
        return freq1==freq2

'''
Minimum Number of Steps to Make Two Strings Anagram
Given two equal-size strings s and t. In one step you can choose any character of t and replace it with another character.

Return the minimum number of steps to make t an anagram of s.
An Anagram of a string is a string that contains the same characters with a different (or the same) ordering.

Example 1:

Input: s = "bab", t = "aba"
Output: 1
Explanation: Replace the first 'a' in t with b, t = "bba" which is anagram of s.
Example 2:

Input: s = "leetcode", t = "practice"
Output: 5
Explanation: Replace 'p', 'r', 'a', 'i' and 'c' from t with proper characters to make t anagram of s.
'''


class Solution:
    def minSteps(self, s: str, t: str) -> int:
        if len(s)!=len(t):
            return 0
        
        temp = 0
        my_dict = dict()
        k = 0
                
        for i in s:
            if i not in my_dict:
                my_dict[i]=1
            else:
                my_dict[i]+=1
        
        
        for i in t:
            if i in my_dict and my_dict[i]>0:
                my_dict[i] -= 1

                
        for key,val in my_dict.items():
            if val>0:
                k+=val
        
        
                
        return (k)