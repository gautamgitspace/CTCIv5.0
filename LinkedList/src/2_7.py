from classes.LinkedList import *

def isPalindrome(linkedlist):
    if linkedlist.head == None:
        return None
    fast = linkedlist.head
    slow = linkedlist.head
    firsthalf = []
    while fast != None and fast.next != None:
        firsthalf.append(slow.value)
        slow = slow.next
        fast = fast.next.next
    if fast != None:
        slow = slow.next
    while slow != None:
        if firsthalf.pop() != slow.value:
            return False
        else:
            slow = slow.next
    return True
