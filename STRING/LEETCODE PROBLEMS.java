
// | 344 | Reverse String |  Easy | Adobe, Amazon, Apple, Facebook, Google, Microsoft |
class Solution {
    public void reverseString(char[] s) {

        int i = 0;
        int j = s.length - 1;

        while (i < j) {
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;

            i++;
            j--;
        }

    }
}

// | 709 | To Lower Case | Easy | Adobe, Amazon, Apple |
class Solution {
    public String toLowerCase(String str) {
        return str.toLowerCase();
    }

    public String toLowerCase2(String str) {
        char[] a = str.toCharArray();

        for (int i = 0; i < a.length; i++)
            if ('A' <= a[i] && a[i] <= 'Z')
                a[i] = (char) (a[i] - 'A' + 'a');

                
        return new String(a);
    }
}







