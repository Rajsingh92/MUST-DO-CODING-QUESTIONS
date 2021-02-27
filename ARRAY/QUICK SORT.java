
/**
QUICK SORT
 */
public class Main {

    public static void quickSort(int[] arr, int lo, int hi) {
        if (lo > hi) {
            return;
        }

        int pi = partition(arr, lo, hi);
        quickSort(arr, lo, pi - 1);
        quickSort(arr, pi + 1, hi);
    }

    public static int partition(int[] arr, int lo, int hi) {
        int pivot = arr[hi];
        int i = lo, j = lo;
        while (i <= hi) {
            if (arr[i] <= pivot) {
                swap(arr, i, j);
                i++;
                j++;
            } else {
                i++;
            }
        }

        return (j - 1);
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}


/**
QUICK SELECT : find the k-th smallest element in the given array
 */



public class Main {

    // passed k as k-1
    public static int quickSelect(int[] arr, int lo, int hi, int k) {

        int pi = partition(arr, lo, hi);
        if (k > pi) {
            return quickSelect(arr, pi + 1, hi, k);
        } else if (k < pi) {
            return quickSelect(arr, lo, pi - 1, k);
        } else {
            return arr[pi];
        }
    }

    public static int partition(int[] arr, int lo, int hi) {
        int pivot = arr[hi];
        int i = lo, j = lo;
        while (i <= hi) {
            if (arr[i] <= pivot) {
                swap(arr, i, j);
                i++;
                j++;
            } else {
                i++;
            }
        }

        return (j - 1);
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}




/**
Sort a binary array using one traversal
Given a binary array, sort it using one traversal and no extra space.

Examples :

Input : 1 0 0 1 0 1 0 1 1 1 1 1 1 0 0 1 1 0 1 0 0 
Output : 0 0 0 0 0 0 0 0 0 1 1 1 1 1 1 1 1 1 1 1 1
Explanation: The output is a sorted array of 0 and 1
 */


class Solution {
    public static void sort(int[] arr) {
        int czero = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                czero++;
            }
        }

        int k = 0;
        while (k < czero) {
            arr[k] = 0;
            k++;
        }

        while (k < arr.length) {
            arr[k] = 1;
            k++;
        }
    }

    public static void sort2(int[] arr) {
        int i = 0;
        int j = 0;

        while (i < arr.length) {
            if (arr[i] == 1) {
                i++;
            } else {
                swap(arr, i, j);
                i++;
                j++;
            }
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}


// 3 Way Quicksort Dutch National Flag
public class Solution {
    private static void quicksort(int[] arr, int lo, int hi) {
        if (lo >= hi) {
            return;
        }

        int[] two = threewayPartition(arr, lo, hi);
        quicksort(arr, lo, two[0]);
        quicksort(arr, two[1], hi);

    }

    private static int[] threewayPartition(int[] arr, int lo, int hi) {
        int pivot = arr[hi];

        int i = lo;
        int j = hi;
        int itr = lo;
        while (itr <= j) {
            if (arr[itr] < pivot) {
                swap(arr, itr, i);
                i++;
                itr++;
            } else if (arr[itr] == pivot) {
                itr++;
            } else {
                swap(arr, itr, j);
                j--;
            }
        }

        int[] two = new int[2];
        two[0] = i - 1;
        two[1] = itr;
        return two;
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}

/**

| 75 | Sort Colors |  Medium | Adobe, Amazon, Apple, Facebook, Google, Microsoft |
Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color 
are adjacent, with the colors in the order red, white, and blue.

Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

 */

class Solution {
    public void sortColors(int[] nums) {
        int i = 0;
        int j = 0;
        int k = arr.length - 1;

        while (i <= k) {
            if (arr[i] == 0) {
                swap(arr, i, j);
                i++;
                j++;
            } else if (arr[i] == 1) {
                i++;
            } else {
                swap(arr, i, k);
                k--;
            }
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}


/**
Segregate positive and Negative
 */

class Solution {
    public static void SegregatePosNeg(int[] arr) {
        int pivot = 0;
        int i = 0, j = arr.length-1;

        while (i <= hi) {
            if (arr[i] < pivot) {
                swap(arr, i, j);
                j++;
            }
            i++;
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}


