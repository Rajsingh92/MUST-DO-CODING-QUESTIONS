

class Solution:
    def reverse(self,arr):
        low = 0
        high = len(arr)-1

        while low<high:
            arr[low],arr[high] = arr[high],arr[low]
            low+=1
            high-=1

