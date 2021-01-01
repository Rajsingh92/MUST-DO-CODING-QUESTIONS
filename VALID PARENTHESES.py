'''
Valid Parentheses
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:
Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
 

Example 1:
Input: s = "()"
Output: true
Example 2:

Input: s = "()[]{}"
Output: true

'''
class Solution:
    def isValid(self, s: str) -> bool:
        if not s:
            return True
        
        stack = []
        for b in s:
            if b in ['(','{','[']:
                stack.append(b)
            else:
                if not stack:
                    return False
                
                topBracket = stack.pop()
                if topBracket=='(':
                    if b !=')':
                        return False
                elif topBracket=='[':
                    if b !=']':
                        return False
                elif topBracket=='{':
                    if b !='}':
                        return False
            
                    
        if stack:
            return False
        
        return True

