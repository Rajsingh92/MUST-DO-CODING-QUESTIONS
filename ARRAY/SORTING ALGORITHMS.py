
def bubbleSort(arr):
    for i in range(len(arr)):
        for j in range(len(arr)-i-1): # Last i elements are already in place 
            if arr[j]>arr[j+1]:
                arr[j], arr[j+1] = arr[j+1], arr[j] 

    return arr



def bubbleSort_rec(arr,n):
    if n==1:
        return

    for i in range(n-1):
        if arr[i]>arr[i+1]:
            arr[i],arr[i+1] = arr[i+1],arr[i]
        
    return bubbleSort_rec(arr,n-1)


# --------------------------------------------------------------------------------------------------------------------
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


# --------------------------------------------------------------------------------------------------------------------


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





# --------------------------------------------------------------------------------------------------------------------
