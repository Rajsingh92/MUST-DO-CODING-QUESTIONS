class BinarySearch:
    def binarySearch(self,arr,low,high,key):

        if high>=low:
            mid = (low+high)//2

            if arr[mid] == key:
                return mid
            elif arr[mid]>key:
                return self.binarySearch(arr,low,mid-1,key)
            else:
                return self.binarySearch(arr,mid+1,high,key)
        else:
            return -1


    # Find Floor of an element in a Sorted Array
    def findFloor(self,arr,k):
        low = 0
        high = len(arr)-1
        floor = -1

        while low<=high:
            mid = (low+high)//2

            if arr[mid]==k:
                return arr[mid]
            elif arr[mid]>k:
                high =mid-1
            else:
                floor = arr[mid]
                low = mid+1
        return floor
    

    # Ceil of an element in a Sorted Array
    def findCeil(self,arr,k):
        low = 0
        high = len(arr)-1
        ceil = -1

        while low<=high:
            mid = (low+high)//2

            if arr[mid]==k:
                return arr[mid]
            elif arr[mid]>k:
                ceil = arr[mid]
                high = mid-1
            else:
                low= mid+1

        return ceil

    # Find position of an element in a sorted array of infinite numbers
    def findKeyInInfiniteSortedArray(self,arr,key):
        low = 0
        high = 1

        while arr[high]<key:
            low= high
            high = high*2

        return self.binarySearch(arr,low,high,key)
