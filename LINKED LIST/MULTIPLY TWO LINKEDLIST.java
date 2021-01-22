

public class Solution{
    public static long multiply(Node first,Node second){
        int num1 = 0;
        int num2 = 0;
        while(first!=null || second!=null){
            if(first!=null){
                num1 = num1*10+first.data;
                first = first.next;
            }
            if(second!=null){
                num2 = num2*10+second.data;
                second = second.next;
            }    
        }

        return num1*num2;
    } 
}