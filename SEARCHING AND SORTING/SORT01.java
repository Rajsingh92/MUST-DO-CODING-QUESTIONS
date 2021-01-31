/**
Sort a binary array using one traversal
Given a binary array, sort it using one traversal and no extra space.

Examples :

Input : 1 0 0 1 0 1 0 1 1 1 1 1 1 0 0 1 1 0 1 0 0 
Output : 0 0 0 0 0 0 0 0 0 1 1 1 1 1 1 1 1 1 1 1 1
Explanation: The output is a sorted array of 0 and 1
 */


class Solution{
    public static void sort(int[] arr){
        int czero = 0;
        for(int i = 0;i<arr.length;i++){
            if(arr[i] == 0){
                czero++;
            }
        }

        int k = 0;
        while(k<czero){
            arr[k] = 0;
            k++;
        }

        while(k<arr.length){
            arr[k] = 1;
            k++;
        }
    }

    public static void sort2(int[] arr){
        int pivot = 1;
        int j = 0;

        for(int i = 0;i<arr.length;i++){
            if(arr[i]<pivot){
                swap(arr,i,j);
                j++;
            }
        }
    }


    public static void swap(int[] arr, int fp, int sp) {
		int temp_var=arr[fp]^arr[sp];
		arr[fp]^=temp_var;
		arr[sp]^=temp_var;
	}
}