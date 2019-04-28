class Sort:
    def SelectionSort(self, nums):
        n = len(nums)
        for i in range(n):
            idx = i
            for j in range(i+1, n):
                if a[j] < a[idx]:
                    idx = j
            a[i], a[idx] = a[idx], a[i]

    def InsertionSort(self, nums):
        n = len(nums)
        for i in range(n):
            for j in range(i, -1, -1):
                if a[j] < a[j-1]:
                    a[j], a[j-1] = a[j-1], a[j]
                else:
                    break

    def ShellSort(self, nums):
        n = len(nums)
        h = 1
        while h < N / 3: h = 3*h + 1
        while h >= 1:
            for i in range(h, n):
                for j in range(i, h-1, -h):
                    if a[j] < a[j-h]:
                        a[j], a[j-h] = a[j-h], a[j]


    def MergeSort(self, nums):
        if len(nums)>1:
            mid = len(nums)//2
        left = nums[:mid]
        right = nums[mid:]
        mergeSort(left)
        mergeSort(right)
        i, j, k = 0, 0, 0
        while i < len(left) and j < len(right):
            if left[i] < right[j]:
                nums[k] = left[i]
                i += 1
            else:
                nums[k] = right[j]
                j += 1 
            k += 1

        while i < len(left):
            nums[k] = left[i]
            i += 1
            k += 1

        while j < len(right):
            nums[k]=right[j]
            j += 1
            k += 1


    def quickSort(nums):
       quickSortHelper(nums,0,len(nums)-1)

    def quickSortHelper(nums,first,last):
       if first<last:
           splitpoint = partition(nums,first,last)
           quickSortHelper(nums,first,splitpoint-1)
           quickSortHelper(nums,splitpoint+1,last)

    def partition(nums,first,last):
       pivotvalue = nums[first]
       left = first+1
       right = last
       done = False
       while not done:
           while left <= right and nums[left] <= pivotvalue:
               left = left + 1
           while nums[right] >= pivotvalue and right >= left:
               right = right -1
           if right < left:
               done = True
           else:
               temp = nums[left]
               nums[left] = nums[right]
               nums[right] = temp
       temp = nums[first]
       nums[first] = nums[right]
       nums[right] = temp
       return right
