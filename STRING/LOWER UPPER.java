/**
if(ch >= 'A' && ch <= 'Z'){
            System.out.print("UPPERCASE");
        }else if(ch >= 'a' && ch <= 'z'){
            System.out.print("lowercase");
        }else{
            System.out.print("Inavlid");
        }

If the ASCII value lies in the range of [65, 90], then it is an uppercase letter.
If the ASCII value lies in the range of [97, 122], then it is a lowercase letter.
If the ASCII value lies in the range of [48, 57], then it is a number.
If the ASCII value lies in the ranges [32, 47], [58, 64], [91, 96] or [123, 126], then it is a special character

 */
public class Main {
    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);
        char input = sc.next().charAt(0);
        int i = input;
        if (i >= 97 && i <= 122) {
            System.out.println("lowercase");
        } else if (i >= 65 && i <= 90) {
            System.out.println("UPPERCASE");
        } else {
            System.out.println("Invalid");
        }

    }
}