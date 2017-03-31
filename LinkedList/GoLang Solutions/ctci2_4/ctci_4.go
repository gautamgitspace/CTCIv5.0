package main

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
