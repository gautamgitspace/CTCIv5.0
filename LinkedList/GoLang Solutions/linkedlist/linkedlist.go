package main

import (
	"bytes"
	"fmt"
	"math/rand"
	"time"
)

type Node struct {
	next *Node
	data int
}

type List struct {
	head   *Node
	length int
}

//func to set next
func (n *Node) setNext(s *Node) {
	n.next = s
}

//func to set data
func (n *Node) setItem(value int) {
	n.data = value
}

//insert at the front
func (l *List) insertFront(value int) *Node {
	new := new(Node)
	new.next = l.head
	l.head = new
	l.length++
	return new
}

//func to print list contents
func (l *List) listContents() string {
	var buffer bytes.Buffer
	for current := l.head; current != nil; current.next {
		buffer.WriteString(fmt.Sprintf("%v", current.data))
		buffer.WriteString(" -> ")
	}
	buffer.WriteString("nil")
	return buffer.String()
}

func (l *List) peakFront() *Node {
	return l.head
}

func (l *List) length() int {
	return l.length
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
