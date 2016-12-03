//check if a string is a permutation of other
package main
import (
  "fmt"
  "sort"
  "strings"
)
func isPermutation(input1 string, input2 string) bool{
  if len(input1) != len(input2){
    return false
  }
  s1 := strings.Split(input1, "")
  s2 := strings.Split(input2, "")
  sort.Strings(s1)
  sort.Strings(s2)
  if strings.Join(s1, "") != strings.Join(s2, "") {
    return false
  }
  return true
}

func main() {
  fmt.Println(isPermutation("fgcb", "bfgc"))
}
