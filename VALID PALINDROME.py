'''
Valid Palindrome
Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
Note: For the purpose of this problem, we define empty string as valid palindrome.

Example 1:
Input: "A man, a plan, a canal: Panama"
Output: true
Example 2:

Input: "race a car"
Output: false

'''

class Solution:
    def isPalindrome(self, s: str) -> bool:
   
        low = 0
        high = len(s)-1
        
        while low<high:
            
            while low<high and not s[low].isalnum() :
                low+=1
                
            while low<high and not s[high].isalnum():
                high-=1
                
            if s[low].lower() != s[high].lower():
                return False
            
            low+=1
            high-=1
        
        return True



'''
Valid Palindrome II
Given a non-empty string s, you may delete at most one character. Judge whether you can make it a palindrome.

Example 1:
Input: "aba"
Output: True

Example 2:
Input: "abca"
Output: True
Explanation: You could delete the character 'c'.

'''
class Solution:
    def validPalindrome(self, s: str) -> bool:
        low = 0
        high = len(s)-1

        while low<high:
            if s[low] != s[high]:
                return self.isPalindrome(s,low,high-1) or self.isPalindrome(s,low+1,high)
            
            low+=1
            high-=1
        
        return True
    
    def isPalindrome(self, s,i,j) :
   
        low = i
        high = j
        
        while low<high:
            if s[low] != s[high]:
                return False
            
            low+=1
            high-=1
        
        return True