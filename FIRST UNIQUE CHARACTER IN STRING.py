'''
# AMAZON

First Unique Character in a String
Given a string, find the first non-repeating character in it and return its index. If it doesn't exist, 
return -1.

Examples:

s = "leetcode"
return 0.

s = "loveleetcode"
return 2.

'''

from collections import Counter

class Solution:
    def firstUniqChar(self, s: str) -> int:
        
        hashMap = Counter(s)
        
        print(hashMap)
        for i in range(len(s)):
            ch = s[i]
            if hashMap[ch]==1:
                return i
            
        return -1