package main
import (
  "fmt"
  "math/rand"
  "time"
  "strings"
  "strconv"
  "bytes"
)

type Node struct {
  next *Node
  data int
}

type List struct {
  head *Node
  length int
}

//func to set next
func (n *Node) setNext(s *Node){
  n.next = s
}
//func to set data
func (n *Node) setItem(value int){
  n.data = value
}
//insert at the front
func (l *List) insertFront(value int) *Node{
  new := new(Node)
  new.next = l.head
  l.head = new
  l.length++
  return new
}
