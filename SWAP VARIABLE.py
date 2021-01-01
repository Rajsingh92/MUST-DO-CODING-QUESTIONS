def swap(var1,var2):
    var1 = var1+var2
    var2 = var1 - var2
    var1 = var1  - var2

    return var1,var2

def swap2(arr,i,j):
    tmp = arr[i]
    arr[i] = arr[j]
    arr[j] = arr[i]

def swap3(arr,i,j):
    arr[i],arr[j] = arr[j],arr[i]
