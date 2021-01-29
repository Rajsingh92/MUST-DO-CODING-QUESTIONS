
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

