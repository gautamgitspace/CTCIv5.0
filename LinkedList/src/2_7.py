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
L1 = randomLinkedList(3, 3, 4)
print "L2:", L1
print "Is Palindrome? ", isPalindrome(L1)
L2 = LinkedList()
for i in range(1,4):
    L2.addNode(i)
for i in range(3, 0, -1):
    L2.addNode(i)
print "L3:", L2
print "Is Palindrome? ", isPalindrome(L2)
