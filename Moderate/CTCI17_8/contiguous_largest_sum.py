#!/usr/bin/env python
def maxsum(array):
    sum = 0
    max_sum = 0
    for i in range(len(array)):
        sum += array[i]
        if max_sum < sum:
            max_sum = sum
        elif sum < 0:
            sum = 0
    return max_sum

array = [2,3,-8,-1,2,4,-2,3]
print maxsum(array)
