/**
Words - K Selection 
1. You are given a word (may have one character repeat more than once).
2. You are given an integer k.
3. You are required to generate and print all ways you can select k distinct characters out of the word.

aabbbccdde
3

output : 

abc
abd
abe
acd
ace
ade
bcd
bce
bde
cde
 */

import java.io.*;
import java.util.*;

public class Main {

  public static void generateSelection(int i, String ustr, int ssf, int ts, String asf) {
      
    if(i == ustr.length()){
        if(ssf == ts){
            System.out.println(asf);
        }
        return;
    }
    
    char ch = ustr.charAt(i);
    generateSelection( i+1,  ustr,  ssf+1,  ts,  asf+ch);  // Yes
    generateSelection( i+1,  ustr,  ssf,  ts,  asf);  // No
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str = br.readLine();
    int k = Integer.parseInt(br.readLine());

    HashSet<Character> unique = new HashSet<>();
    String ustr = "";
    for (char ch : str.toCharArray()) {
      if (unique.contains(ch) == false) {
        unique.add(ch);
        ustr += ch;
      }
    }

    generateSelection(0, ustr, 0, k, "");
  }

}


/**
 Words - K Selection - 2 Easy
 Words - K Length Words - 1 Easy
 Words - K Length Words - 2 Easy
 Words - K Selection - 3 Easy
 Words - K Selection - 4 Easy
 Words - K Length Words - 3 Easy
 Words - K Length Words - 4 Easy
 */