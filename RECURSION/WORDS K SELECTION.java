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


public class Main {
  // method 1
  public static void generateSelection1(int i, String ustr, int ssf, int ts, String asf) {
      
    if(i == ustr.length()){
        if(ssf == ts){
            System.out.println(asf);
        }
        return;
    }
    
    char ch = ustr.charAt(i);
    generateSelection1( i+1,  ustr,  ssf+1,  ts,  asf+ch);  // Yes
    generateSelection1( i+1,  ustr,  ssf,  ts,  asf);  // No
  }
  
  // method 2
  public static void generateSelection2(String ustr, int cs, int ts, int lc, String asf) {
    if(cs>ts){   //cs - count selection  // lc- last count
        System.out.println(asf);
        return;
    }
    
    for(int i = lc+1;i<ustr.length();i++){
        char ch  = ustr.charAt(i);
        generateSelection2(ustr,cs+1,ts,i,asf+ch);
    }
  }

  public static void main(String[] args) throws Exception {

    String str = "abcabc";
    int k = 2;

    HashSet<Character> unique = new HashSet<>();
    String ustr = "";
    for (char ch : str.toCharArray()) {
      if (unique.contains(ch) == false) {
        unique.add(ch);
        ustr += ch;
      }
    }

    generateSelection1(0, ustr, 0, k, "");   // method1
    generateSelection2(ustr, 1, k, -1, "");    // method2
  }

}


/**
Words - K Length Words 
1. You are given a word (may have one character repeat more than once).
2. You are given an integer k.
3. You are required to generate and print all k length words (of distinct chars) by using chars of the 
     word.

abab
2

output:
ab
ba
bc
cb
ca
ac
 */



public class Main {
  // method 1
  public static void generateWords(int cc, String ustr, int ssf, int ts, Character[] spots) {
    
    if(cc == ustr.length()){
        if(ssf==ts){
            for(int i=0;i<spots.length;i++){
                 System.out.print(spots[i]);
            }
            System.out.println();
        }
        return;
    }
    
    // yes
    char ch = ustr.charAt(cc);
    for(int i=0;i<spots.length;i++){
        if(spots[i] == null){
            spots[i] = ch;
            generateWords(cc+1,ustr,ssf+1,ts,spots);
            spots[i] = null;
        }
    }
    
    // no
    generateWords(cc+1,ustr,ssf,ts,spots);
  }
  // method 2
  public static void generateWords2(int cs, int ts, String ustr, HashSet<Character> used, String asf) {

    if(cs>ts){
        System.out.println(asf);
        return;
    }
    
    for(int i=0;i<ustr.length();i++){
        char ch = ustr.charAt(i);
        if(used.contains(ch)==false){
            used.add(ch);
            generateWords2(cs+1,ts,ustr,used,asf+ch);
            used.remove(ch);
        }
    }
  }


  public static void main(String[] args) throws Exception {
    String str = "abcabc";
    int k = 2;

    HashSet<Character> unique = new HashSet<>();
    String ustr = "";
    for (char ch : str.toCharArray()) {
      if (unique.contains(ch) == false) {
        unique.add(ch);
        ustr += ch;
      }
    }

    Character[] spots = new Character[k];
    generateWords(0, ustr, 0, k, spots);
    generateWords2(1, k, ustr, new HashSet<>(), "");
  }

}






/**
 Words - K Selection - 3 Easy
 Words - K Selection - 4 Easy
 Words - K Length Words - 3 Easy
 Words - K Length Words - 4 Easy
 */