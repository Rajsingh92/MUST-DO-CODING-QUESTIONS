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



def insertionSort(A):
    for i in range(1, len(A)):
        value = A[i]
        j = i
        while j > 0 and A[j - 1] > value:
            A[j] = A[j - 1]
            j = j - 1
 
        A[j] = value
 


def insertionSort_rec(A, i, n):
    if i>n:
        return
 
    value = A[i]
    j = i
 
    while j > 0 and A[j - 1] > value:
        A[j] = A[j - 1]
        j = j - 1
    A[j] = value
 
    return insertionSort_rec(A, i + 1, n)


def selectionSort(arr,n):
    
    for i in range(n):
        select_min = i
        for j in range(i+1,n):
            if arr[select_min]>arr[j]:
                select_min = j
        arr[i],arr[select_min] = arr[select_min],arr[i]



def selectionSort_rec(arr,n,i):
    if i == n-1:
        return 
     
    select_min = i
    for j in range(i+1,n):
        if arr[select_min]>arr[j]:
            select_min = j
    arr[i],arr[select_min] = arr[select_min],arr[i]
  
    return selectionSort_rec(arr,n,i+1)



def partition(arr,low,high):
    pIndex = 0
    pivot = arr[high]

    for i in range(low,high):
        if arr[i]<=pivot:
            arr[pIndex],arr[i]= arr[i],arr[pIndex]
            pIndex+=1
    
    arr[pIndex],arr[high] = arr[high],arr[pIndex]
    return pivot


def quickSort(arr,low,high):
    if low<high:
        pivot = partition(arr,low,high)
        quickSort(arr,low,pivot-1)
        quickSort(arr,pivot+1,high)



# merge sort
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