//              BRACKETS BASED PROBLEMS
//              BRACKETS BASED PROBLEMS
//              BRACKETS BASED PROBLEMS



/**
| 20 | Valid Parentheses |  Easy | Adobe, Akuna Capital, Amazon, Apple, Facebook, Google, Microsoft |
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
| 921 | Minimum Add to Make Parentheses Valid |  Medium | Facebook |
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

    public int minAddToMakeValid2(String S) {
        int left = 0, right = 0;
        for (int i = 0; i < S.length(); ++i) {
            if (S.charAt(i) == '(') {
                right++;
            } else if (right > 0) {
                right--;
            } else {
                left++;
            }
        }
        return left + right;
    }
}









/**
Minimum Insertions to Balance a Parentheses String

Given a parentheses string s containing only the characters '(' and ')'. A parentheses string is balanced if:

Any left parenthesis '(' must have a corresponding two consecutive right parenthesis '))'.
Left parenthesis '(' must go before the corresponding two consecutive right parenthesis '))'.
In other words, we treat '(' as openning parenthesis and '))' as closing parenthesis.

For example, "())", "())(())))" and "(())())))" are balanced, ")()", "()))" and "(()))" are not balanced.

You can insert the characters '(' and ')' at any position of the string to balance it if needed.

Return the minimum number of insertions needed to make s balanced.

 

Example 1:

Input: s = "(()))"
Output: 1
Explanation: The second '(' has two matching '))', but the first '(' has only ')' matching. We need to to add one 
more ')' at the end of the string to be "(())))" which is balanced.
 */



public class Solution{
    public int minInsertions(String s) {
        int res = 0, right = 0;
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == '(') {
                if (right % 2 > 0) {
                    right--;
                    res++;
                }
                right += 2;
            } else {
                right--;
                if (right < 0) {
                    right += 2;
                    res++;
                }
            }
        }
        return right + res;
    }
}




/**
Minimum number of bracket reversals needed to make an expression balanced.
Minimum number of swaps for bracket balancing.
Find duplicate parenthesis in an expressionMedium
Duplicate brackets
Score of Parentheses
minRemoveToMakeValid
Find Expression Duplicate Parenthesis Not
Valid Parenthesis String					https://leetcode.com/problems/valid-parenthesis-string
 */