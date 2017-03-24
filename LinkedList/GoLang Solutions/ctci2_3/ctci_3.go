package main

import (
	"bytes"
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

func (l *List) printList() string {
	var buffer bytes.Buffer
	for current := l.head; current != nil; current = current.next {
		buffer.WriteString(fmt.Sprintf("%v", current.data))
		buffer.WriteString(" -> ")
	}
	buffer.WriteString("nil")
	return buffer.String()
}

func removeMiddle(l *List, middle *Node) {
	if middle == nil || l.peakFront() == nil {
		return
	}
	for e := l.peakFront(); e != nil; e = e.next {
		if e.next == middle {
			//node hop
			e.next = e.next.next
			//de-link middle
			middle.next = nil
			middle = nil
			l.sizeDecrement()
			return
		}
	}
}

func main() {
	l := new(List)
	l.insertFront(1)
	l.insertFront(2)
	middle := l.insertFront(3)
	l.insertFront(4)
	l.insertFront(5)
	fmt.Printf("The List: %v\n", l.printList())
	removeMiddle(l, middle)
	fmt.Printf("removeMiddle(3) : %v\n", l.printList())
}
