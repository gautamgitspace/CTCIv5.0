package main

import (
	"bytes"
	"fmt"
)

/*Partition of Linked List around the pivot element*/
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

func (l *List) printList() string {
	var buffer bytes.Buffer
	for current := l.head; current != nil; current = current.next {
		buffer.WriteString(fmt.Sprintf("%v", current.data))
		buffer.WriteString(" -> ")
	}
	buffer.WriteString("nil")
	return buffer.String()
}

func partitionList(l *List, val int) {
	upper := new(List)
	lower := new(List)
	var current *Node

	for current = l.peakFront(); current != nil; {
		if current.data < val {
			lower.insertFront(current.data)
			fmt.Println("INSERTED BEFORE: ", current.data)
		} else {
			upper.insertFront(current.data)
			fmt.Println("INSERTED AFTER: ", current.data)
		}
		current = current.next
	}
	current = lower.head
	var lowNode *Node
	lowNode = lower.head

	for lowNode.next != nil {
		lowNode = lowNode.next
	}
	lowNode.next = upper.head

	fmt.Println("LIST AFTER PIVOT SORT:", lower.printList())
}

func main() {
	l := new(List)
	l.insertFront(11)
	l.insertFront(7)
	l.insertFront(18)
	l.insertFront(3)
	l.insertFront(9)
	fmt.Printf("LIST: %v\n", l.printList())
	partitionList(l, 7)

}
