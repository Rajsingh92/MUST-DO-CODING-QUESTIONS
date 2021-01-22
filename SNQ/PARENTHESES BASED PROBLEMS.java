/**
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
 */

class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            
            if(ch == '(' || ch == '{' || ch == '['){
                st.push(ch);
            }else{
                if(st.size()==0){
                    return false;
                }
                
                char topBracket = st.pop();
                if(topBracket == '('){
                    if(ch!=')'){
                        return false;
                    }
                }else if(topBracket == '{'){
                    if(ch!='}'){
                        return false;
                    }
                }else if(topBracket == '['){
                    if(ch!=']'){
                        return false;
                    }
                }
            }
        }
        
        if(st.size()==0){
            return true;
        }else{
            return false;
        }
    }
}








/**
Remove Outermost Parentheses
A valid parentheses string is either empty (""), "(" + A + ")", or A + B, where A and B are valid parentheses strings,
and + represents string concatenation.  For example, "", "()", "(())()", and "(()(()))" are all valid parentheses 
strings.

A valid parentheses string S is primitive if it is nonempty, and there does not exist a way to split it into S = A+B, 
with A and B nonempty valid parentheses strings.
Given a valid parentheses string S, consider its primitive decomposition: S = P_1 + P_2 + ... + P_k, where P_i are 
primitive valid parentheses strings.
Return S after removing the outermost parentheses of every primitive string in the primitive decomposition of S.

Example 1:

Input: "(()())(())"
Output: "()()()"
Explanation: 
The input string is "(()())(())", with primitive decomposition "(()())" + "(())".
After removing outer parentheses of each part, this is "()()" + "()" = "()()()".
 */



class Solution {
    public String removeOuterParentheses(String S) {
        int n = S.length();
        StringBuilder sb = new StringBuilder();
        
        int count = 0;
        for(int i = 0;i<n;i++){
            char ch = S.charAt(i);
            
            if(ch == '(' && count++>0){
                sb.append('(');
            }else if(ch == ')' && count-->1){
                sb.append(")");
            }
        }
        
        return sb.toString();
    }
}









/**
Minimum Add to Make Parentheses Valid
Given a string S of '(' and ')' parentheses, we add the minimum number of parentheses ( '(' or ')', and in any positions ) so that the resulting parentheses string is valid.

Formally, a parentheses string is valid if and only if:

It is the empty string, or
It can be written as AB (A concatenated with B), where A and B are valid strings, or
It can be written as (A), where A is a valid string.
Given a parentheses string, return the minimum number of parentheses we must add to make the resulting string valid.

 

Example 1:

Input: "())"
Output: 1
 */

class Solution {
    public int minAddToMakeValid(String S) {
        Stack<Character> st = new Stack<>();
        
        for(int i= 0 ; i<S.length();i++){
            char ch = S.charAt(i);
            if(st.size()!=0 && st.peek() == '(' && ch == ')'){
                st.pop();
            }else{
                st.push(ch);
            }
        }
        
        return st.size();
    }
}







