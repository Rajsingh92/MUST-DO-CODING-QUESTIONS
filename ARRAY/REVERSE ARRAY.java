
/**
class Solution:
    def reverse(self,arr):
        low = 0
        high = len(arr)-1

        while low<high:
            arr[low],arr[high] = arr[high],arr[low]
            low+=1
            high-=1
 */

public class Solution{
    private static void reverse(int[] arr, int i, int j) {
        while(i<j) {
            int temp=arr[i]^arr[j];
            arr[i]^=temp;
            arr[j]^=temp;
            i++;
            j--;
        }
    }
}