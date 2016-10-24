# This is written after refering the CLRS book and hints from the site http://en.literateprograms.org/Merge_sort_(Python)

#The merge method takes in the two subarrays and creates a output array

def merge(left, right):
    result = []
    i , j = 0 , 0
    while i < len (left) and j < len (right):
        if left[i] <= right [j]:
            result.append(left[i])
            i+=1
        else:
            result.append(right[j])
            j+=1
    #COPY THE REMAINING ELEMENTS:
    result += left[i:]
    result += right[j:]
    return result

def mergesort(lst):
    if len(lst) <= 1:
        return lst
    #COMPUTE MIDDLE
    middle = int(len(lst) / 2)
    #LEFT LIST
    left = mergesort(lst[:middle])
    #RIGHT LIST
    right = mergesort(lst[middle:])
    #MERGE LEFT AND RIGHT
    return merge(left, right)


if __name__ == '__main__':
	print 'finally\n', mergesort([3, 44, 8, 0, 6, 7, 4, 2, 1, 9, 4, 5])
