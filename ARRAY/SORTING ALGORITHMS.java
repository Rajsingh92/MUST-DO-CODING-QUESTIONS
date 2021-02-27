// bubble sort
class Solution{
    public static void bubble_sort(int[] arr){
        for(int i=0;i<arr.length;i++){
            for(int j=i+1;j<arr.length-i-1;j++){  // Last i elements are already in place 
                if(arr[j+1]>arr[j]){
                    swap(arr,j,j+1);
                }
            }
        }
    }

    public static void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}



// selection sort
class Solution{
    public static void  selection_sort(int[] arr) {
        for(int i=0;i<arr.length;i++){
            int min = i;
            for(int j=i+1;j<arr.length;j++){
                if(arr[j]<arr[min]){
                    min = j;
                }
            }

            swap(arr,i,min);
        }
    }

    public static void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}



// insertion sort
class Solution{
    public  static void insertion_sort(int[] arr) {
        for(int i=1;i<arr.length;i++){
            int val = arr[i];
            int j = i;

            while(j>0 && arr[j-1]>val){
                arr[j] = arr[j-1];
                j--;
            }
            arr[j] = val;
        }
    }
}


// Count Sort
public class Main {

    public static int[] countSort(int[] arr, int min, int max) {
        int range = max - min + 1;
        int[] farr = new int[range];
        for (int i = 0; i < arr.length; i++) {
            farr[arr[i] - min]++;
        }

        for (int i = 1; i < farr.length; i++) {
            farr[i] += farr[i - 1];
        }

        int[] ans = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            int idx = farr[arr[i] - min] - 1;
            ans[idx] = arr[i];
            farr[arr[i] - min]--;
        }

        return ans;
    }

    // Sort an character array
    public static void countSort2(char[] arr) {
        
		int[] farr = new int[26];

		for (int i = 0; i < arr.length; i++) {
			farr[arr[i]-'a']++;
		}

		for (int i = 1; i < farr.length; i++) {
			farr[i] += farr[i - 1];
		}

        char[] ans= new char[arr.length];
		for (int i = 0; i < arr.length; i++) {
			if (farr[arr[i]-'a'] >= 1) {
				ans[farr[arr[i]-'a']-1] = (char) arr[i];
				farr[arr[i]-'a']--;
			}
		}

		for (char ch : ans) {
			System.out.print(ch);
		}
    }
}

// Radix Sort
class Solution{
    private static void radixsort(int[] arr) {
        int max = arr[0];
        for(int i=1;i<arr.length;i++){
            if(arr[i]>max){
                max = arr[i];
            }
        }

        int exp = 1;
        while(max/exp >0){
            countingsort(arr,exp);
            exp = exp*10;
        }

		for (int val : arr) {
			System.out.print(val + " ");
		}
	}

    public static void countSort(int[] arr, int exp) {
        int range = 10;
        int[] farr = new int[range];
        for (int i = 0; i < arr.length; i++) {
            farr[(arr[i]/exp)%10]++;
        }

        for (int i = 1; i < farr.length; i++) {
            farr[i] += farr[i - 1];
        }

        int[] ans = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            int idx = farr[(arr[i]/exp)%10] - 1;
            ans[idx] = arr[i];
            farr[(arr[i]/exp)%10]--;
        }

        for (int i = 0; i < arr.length; i++) {
			arr[i] = ans[i];
		}
    }

}



/**
How to efficiently sort a big list dates in 20’s

Example: 

Input:
       Date arr[] = {{20,  1, 2014},
                    {25,  3, 2010},
                    { 3, 12, 2000},
                    {18, 11, 2001},
                    {19,  4, 2015},
                    { 9,  7, 2005}}
 */


public class Pep_JavaIP_2SnS_62SortDates {
    static class Date {
		int day;
		int month;
		int year;

		public Date(int day, int month, int year) {
			this.day = day;
			this.month = month;
			this.year = year;
		}
	}

	private static void CountingSortyear(Date[] arr) {
		Date[] output = new Date[arr.length];
		int[] count_array = new int[100];

		for (int i = 0; i < arr.length; i++) {
			count_array[arr[i].year % 2000]++;
		}

		for (int i = 1; i < count_array.length; i++) {
			count_array[i] += count_array[i - 1];
		}

		for (int i = arr.length - 1; i >= 0; i--) {
			output[count_array[arr[i].year % 2000] - 1] = arr[i];
			count_array[arr[i].year % 2000]--;
		}

		for (int i = 0; i < arr.length; i++) {
			arr[i] = output[i];
		}
	}

	private static void CountingSortmonth(Date[] arr) {
		Date[] output = new Date[arr.length];
		int[] count_array = new int[13];

		for (int i = 0; i < arr.length; i++) {
			count_array[arr[i].month]++;
		}

		for (int i = 1; i < count_array.length; i++) {
			count_array[i] += count_array[i - 1];
		}

		for (int i = arr.length - 1; i >= 0; i--) {
			output[count_array[arr[i].month] - 1] = arr[i];
			count_array[arr[i].month]--;
		}

		for (int i = 0; i < arr.length; i++) {
			arr[i] = output[i];
		}
	}

	private static void CountingSortday(Date[] arr) {
		Date[] output = new Date[arr.length];
		int[] count_array = new int[32];

		for (int i = 0; i < arr.length; i++) {
			count_array[arr[i].day]++;
		}

		for (int i = 1; i < count_array.length; i++) {
			count_array[i] += count_array[i - 1];
		}

		for (int i = arr.length - 1; i >= 0; i--) {
			output[count_array[arr[i].day] - 1] = arr[i];
			count_array[arr[i].day]--;
		}

		for (int i = 0; i < arr.length; i++) {
			arr[i] = output[i];
		}

	}

    public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		Date[] arr = new Date[scn.nextInt()];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = new Date(scn.nextInt(), scn.nextInt(), scn.nextInt());
		}

		CountingSortday(arr);
		CountingSortmonth(arr);
		CountingSortyear(arr);
        
		for (Date date : arr) {
			System.out.println(date.day + " " + date.month + " " + date.year);
		}
	}

}