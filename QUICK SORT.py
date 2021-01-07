

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