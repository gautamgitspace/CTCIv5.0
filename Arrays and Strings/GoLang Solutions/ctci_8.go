package main
import (
  "fmt"
  "strings"
)

func isSubstring(big string, small string) bool {
  if strings.Contains(big, small) {
    return true
  }
    return false
}

func isRotation(s1 string, s2 string) bool {
  if len(s1) == len(s2) && len(s1) > 0 {
    bigString := s1 + s2
    fmt.Println(bigString)
    return isSubstring(bigString, s2)
  }
  return false
}

func main() {
first := "razer"
second := "hello"
fmt.Println(isRotation(first, second))
}
