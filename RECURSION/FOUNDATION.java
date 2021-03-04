//                      NUMBER BASED QUESTIONS
//                      NUMBER BASED QUESTIONS
//                      NUMBER BASED QUESTIONS

public class Solution {
    public static void printIncreasing(int n) {
        if (n == 1) {
            System.out.println(n);
            return;
        }

        printIncreasing(n - 1);
        System.out.println(n);

    }

    public static void printDecreasing(int n) {
        if (n == 1) {
            System.out.println(n);
            return;
        }

        System.out.println(n);
        printDecreasing(n - 1);
    }

    public static void printIncreasingDecreasing(int n) {
        if (n == 0) {
            return;
        }

        System.out.println(n);
        printIncreasingDecreasing(n - 1);
        System.out.println(n);
    }

    // print zig zag
    public static void pzz(int n) {
        if(n == 0){
          return;
        }
        
        System.out.print(n + " ");
        pzz(n - 1);
        System.out.print(n + " ");
        pzz(n - 1);
        System.out.print(n + " ");
      }

    public static int factorial(int n) {
        if (n == 1 || n == 0) {
            return 1;
        }

        return n * factorial(n - 1);
    }

    // linear solution
    public static int power(int x, int n) {
        if (n == 0) {
            return 1;
        }

        return x * power(x, n - 1);
    }

    // logrithmic solution
    public static int power2(int x, int n) {
        if (n == 0) {
            return 1;
        }

        if (n % 2 == 0) {
            return power(x, n / 2) * power(x, n / 2);
        } else {
            return x * power(x, n / 2) * power(x, n / 2);
        }
    }

    // tower of hanoi
    public static void toh(int n, int t1id, int t2id, int t3id) {
        if (n == 0) {
            return;
        }

        toh(n - 1, t1id, t3id, t2id);
        System.out.println(n + "[" + t1id + " -> " + t2id + "]");
        toh(n - 1, t3id, t2id, t1id);
    }
}









//              RECURSION IN AN ARRAY
//              RECURSION IN AN ARRAY
//              RECURSION IN AN ARRAY



public class Solution {

    public static void displayArr(int[] arr, int idx) {
        if (idx == arr.length) {
            return;
        }
        System.out.println(arr[idx]);
        displayArr(arr, idx + 1);
    }

    public static void displayArrReverse(int[] arr, int idx) {
        if (idx < 0) {
            return;
        }
        System.out.println(arr[idx]);
        displayArrReverse(arr, idx - 1);

    }

    public static int maxOfArray(int[] arr, int idx) {
        if (idx == 0) {
            return arr[idx];
        }
        int res = maxOfArray(arr, idx - 1);
        int max = Math.max(arr[idx], res);
        return max;
    }

    public static int firstIndex(int[] arr, int idx, int x) {
        if (idx == arr.length) {
            return -1;
        }

        if (arr[idx] == x) {
            return idx;
        } else {
            return firstIndex(arr, idx + 1, x);
        }
    }

    public static int lastIndex(int[] arr, int idx, int x) {
        if (idx == arr.length) {
            return -1;
        }

        int res = lastIndex(arr, idx + 1, x);
        if (res == -1) {
            if (arr[idx] == x) {
                return idx;
            } else {
                return -1;
            }
        } else {
            return res;
        }

    }

    public static int[] allIndices(int[] arr, int x, int idx, int fsf) {
        if (idx == arr.length) {
            return new int[fsf];
        }

        if (arr[idx] == x) {
            int[] iarr = allIndices(arr, x, idx + 1, fsf + 1);
            iarr[fsf] = idx;
            return iarr;
        } else {
            int[] iarr = allIndices(arr, x, idx + 1, fsf);
            return iarr;
        }
    }

}






//                  RECURSION IN AN ARRAYLIST
//                  RECURSION IN AN ARRAYLIST
//                  RECURSION IN AN ARRAYLIST

public class ArrayListQuestions {
    // Get Subsequence Of String
    public static ArrayList<String> getSubsequence(String str) {

        if (str.length() == 0) {
            ArrayList<String> bres = new ArrayList<>();
            bres.add("");
            return bres;
        }

        char ch = str.charAt(0); // a
        String ros = str.substring(1); // bc
        ArrayList<String> rres = getSubsequence(ros);

        ArrayList<String> res = new ArrayList<>();

        for (String s : rres) {
            res.add("" + s);
        }
        for (String s : rres) {
            res.add(ch + s);
        }

        return res;
    }
}



/**
 recursion-with-arraylists:
 Get Kpc Easy
 Get Stair Paths Easy
 Get Maze Paths Easy
 Get Maze Path With Jumps Easy
 Print Subsequence Easy
 Print Kpc Easy
 Print Stair Paths Easy
 Print Maze Paths Easy
 Print Maze Paths With Jumps Easy
 Print Encodings Easy
 */