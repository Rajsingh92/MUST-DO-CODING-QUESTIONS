# Bubble Sort
def bubbleSort(arr):
    for i in range(len(arr)):
        for j in range(len(arr)-i-1): # Last i elements are already in place 
            if arr[j]>arr[j+1]:
                arr[j], arr[j+1] = arr[j+1], arr[j] 

    return arr


def bubbleSort_optimize(arr):
    for i in range(len(arr)):
        swapped = False
        for j in range(len(arr)-i-1): 
            if arr[j]>arr[j+1]:
                arr[j], arr[j+1] = arr[j+1], arr[j] 
            
        if swapped == False:  #already sorted
            break
    return arr


def bubbleSort_rec(arr,n):
    if n==1:
        return
    for i in range(n-1):
        if arr[i]>arr[i+1]:
            arr[i],arr[i+1] = arr[i+1],arr[i]
        
    return bubbleSort_rec(arr,n-1)