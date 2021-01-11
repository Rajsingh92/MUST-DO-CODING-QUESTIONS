

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
 
