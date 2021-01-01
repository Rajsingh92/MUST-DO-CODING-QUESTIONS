#linear search
def linearSearch(arr,x):
    for i in range(len(arr)):
        if arr[i] == x:
            print("found at:",i)
    return -1

# Binary search
def binarySearch(arr,x):
    low = 0
    high = len(arr)-1

    while high>=low:
        mid = (high+low)//2

        if arr[mid] < x:
            low = mid+1 

        elif arr[mid] > x:
            high = mid-1

        else:
            return mid

    return -1