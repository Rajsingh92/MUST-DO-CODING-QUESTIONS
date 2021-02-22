/**
'''
Merge two sorted arrays
Given two sorted arrays, the task is to merge them in a sorted manner.

Examples:
Input: arr1[] = { 1, 3, 4, 5}, arr2[] = {2, 4, 6, 8}
Output: arr3[] = {1, 2, 3, 4, 4, 5, 6, 8}
'''

def merge(arr1,arr2):
    m,n = len(arr1),len(arr2)
    arr = [None]*(m+n)

    i=j=k=0

    while i<m and j<n:
        if arr1[i]>arr2[j]:
            arr[k] = arr2[j]
            k+=1
            j+=1
        else:
            arr[k] = arr1[i]
            i+=1
            j+=1
    
    while i<m:
        arr[k] = arr1[i]
        k+=1
        i+=1
    
    while j<n:
        arr[k] = arr2[j]
        j+=1
        k+=1
        


def mergeSort(arr,low,high):
    if len(arr)>1:
        
        mid = len(arr)//2

        left = arr[:mid]
        right = arr[mid:]
        mergeSort(left)
        mergeSort(right)

        i=j=k=0

        while i<len(left) and j<len(right):
            if left[i]>right[j]:
                arr[k] = right[j]
                j+=1
                k+=1
            else:
                arr[k] = left[i]
                i+=1
                k+=1
            
        while i<len(left):
            arr[k] = left[i]
            k+=1
            i+=1
        while j< len(right):
            arr[k] = right[j]
            j+=1
            k+=1

            
 */



