'''
Sort a binary array using one traversal
Given a binary array, sort it using one traversal and no extra space.

Examples :

Input : 1 0 0 1 0 1 0 1 1 1 1 1 1 0 0 1 1 0 1 0 0 
Output : 0 0 0 0 0 0 0 0 0 1 1 1 1 1 1 1 1 1 1 1 1
Explanation: The output is a sorted array of 0 and 1

'''


def sort(A):
    czero = 0
    for i in A:
        if i==0:
            czero+=1
    k = 0      
    while k<czero:
        A[k]=0
        k+=1
    
    while k<len(A):
        A[k]=1 
        k+=1
    
    return A

#partition logic of quicksort
def swap(A,i,j):
    A[i] = A[i]+A[j]
    A[j] = A[i]-A[j]
    A[i] = A[i]-A[j]
    
def sort(A):
    pivot =  1 
    j = 0
    
    for i in range(len(A)):
        if pivot>A[i]:
            swap(A,i,j)
            j+=1