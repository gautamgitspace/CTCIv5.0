//unique chars using boolean array and hash set.
//reflect can be used to print the data type of a go object

package main
import (
  "fmt"
  //"reflect"
)

//using a boolean array
func isUniqueChars1(str string) bool {
	if len(str) > 128 {
		return false
	}
	var char_set [128]bool // every bool represents if a character was seen
	for _, val := range str {
    //fmt.Println(reflect.TypeOf(val))
		if char_set[val] {
			return false
		}
		char_set[val] = true
	}
	return true
}

//using a hashset
func isUniqueChars2(str string) bool {
  if len(str) > 128 {
    return false
  }
  set := make(map[int]bool)
  for _, val := range str {
    if set[int(val)] {
      return false
    }else{
      set[int(val)] = true
    }
  }
  return true
}

func main() {
  result := isUniqueChars1("abca")
  fmt.Println("Using Boolean Array:", result)
  result2 := isUniqueChars2("abca")
  fmt.Println("Using Hash Set:", result2)
}
