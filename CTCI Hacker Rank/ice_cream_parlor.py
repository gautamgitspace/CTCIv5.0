#!/usr/bin/env python
"""
2
4
5
1 4 5 3 2
4
4
2 2 4 3
"""
visits = int(raw_input())
pool_amount_one = int(raw_input())
flavor_count_visit_one = int(raw_input())
flavors_visit_one = map(int, raw_input().split())

pool_amount_two = int(raw_input())
flavor_count_visit_two = int(raw_input())
flavors_visit_two = map(int, raw_input().split())

set1 = set()
set2 = set()
l1 = []
l2 = []
for item in flavors_visit_one:
    diff = pool_amount_one - item
    if diff in set1:
        l1.append(diff)
        l1.append(item)
    else:
        set1.add(item)
for item in flavors_visit_two:
    diff2 = pool_amount_two - item
    if diff2 in set2:
        l2.append(diff)
        l2.append(item)
    else:
        set2.add(item)

print l1
print l2
