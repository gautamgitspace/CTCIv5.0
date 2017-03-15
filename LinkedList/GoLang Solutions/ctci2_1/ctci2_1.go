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

func randomNumberGenerator(min int, max int) int {
	return min + rand.Intn(max-min)
}

func randomListGenerator(limit, max, min int) *List {
	rand.Seed(time.Now().UTC().UnixNano())
	l := new(List)
	for i := 0; i < limit; i++ {
		l.insertFront(randomNumberGenerator(min, max))
	}
	return l
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

//using hashset - O(n) time and space
func removeDups(l *List) {
	if l.peakFront() == nil {
		return
	}
	//key(int) value(bool) map
	set := make(map[int]bool)
	var prev *Node
	for e := l.peakFront(); e != nil; e = e.next {
		val := e.data
		if set[val] {
			prev.next = e.next
			l.sizeDecrement()
		} else {
			set[val] = true
			prev = e
		}
	}
}

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

func main() {
	l1 := buildListWithDups()
	fmt.Printf("BEFORE    : %v\n", l1.printList())
	removeDups(l1)
	fmt.Printf("AFTER     : %v\n", l1.printList())
}
