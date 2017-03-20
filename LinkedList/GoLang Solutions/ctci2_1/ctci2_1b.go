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

//Logic function - O(n^2) time. Select element and keep comparing with others (next in List)
func removeDups(l *List) {
	if l.peakFront() == nil {
		return
	}
	current := l.peakFront()
	for current != nil {
		runner := current
		for runner.next != nil {
			if runner.next.data == current.data {
				runner.next = runner.next.next
				l.sizeDecrement()
			} else {
				runner = runner.next
			}
		}
		current = current.next
	}
}

//List builder function
func buildListWithDups() *List {
	l := new(List)
	l.insertFront(11)
	l.insertFront(22)
	l.insertFront(33)
	l.insertFront(44)
	l.insertFront(44)
	l.insertFront(22)
	l.insertFront(11)
	//fmt.Println(reflect.TypeOf(l))
	return l
}

//#DRIVER
func main() {
	l1 := buildListWithDups()
	fmt.Printf("BEFORE    : %v\n", l1.printList())
	removeDups(l1)
	fmt.Printf("AFTER     : %v\n", l1.printList())
}
