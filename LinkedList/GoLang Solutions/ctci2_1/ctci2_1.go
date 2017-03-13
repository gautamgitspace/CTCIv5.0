package main

import (
	"math/rand"
	"time"
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

//hey slave! Give me a random integer
func randomNumberGenerator(min int, max int) int {
	return min + rand.Intn(max-min)
}

//hey slave! Give me a list with random values between min and max
func randomListGenerator(limit, max, min int) *List {
	rand.Seed(time.Now().UTC().UnixNano())
	l := new(List)
	for i := 0; i < limit; i++ {
		l.insertFront(randomNumberGenerator(min, max))
	}
	return l
}
