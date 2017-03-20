package main

import (
	"fmt"
)

type Node struct {
	next *Node
	data int
}
type List struct {
	head *Node
	size int
}

func (n *Node) setNext(s *Node) {
	n.next = s
}
func (n *Node) setItem(value int) {
	n.data = value
}
func (l *List) insertFront(value int) *Node {
	new := new(Node)
	new.next = l.head
	l.head = new
	new.data = value
	l.size++
	return new
}
func (l *List) peakFront() *Node {
	return l.head
}
func (l *List) sizeOfList() int {
	return l.size
}
func (l *List) sizeDecrement() {
	l.size--
}

func kthToLast(l *List, k int) int {
	if l.peakFront() == nil {
		return 0
	}
	if k > l.sizeOfList() {
		return 1
	}
	var ptr1 *Node
	var ptr2 *Node
	ptr1 = l.peakFront()
	ptr2 = l.peakFront()
	for i := 0; i < k; i++ {
		ptr2 = ptr2.next
	}
	if ptr2 == nil {
		fmt.Println("Reached END")
	}
	for ptr2 != nil {
		ptr1 = ptr1.next
		ptr2 = ptr2.next
	}
	return ptr1.data
}
