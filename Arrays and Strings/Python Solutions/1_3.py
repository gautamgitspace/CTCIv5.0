#!/usr/bin/env python
#check if one stringe is permutation of other - by counting the number of occurrence of chars in both strings and comparing
from collections import Counter
def isPermute(str1, str2):
    count_a = Counter(str1)
    count_b = Counter(str2)
    if count_a == count_b:
        return True
    else:
        return False
print isPermute("hello", "lelho")
