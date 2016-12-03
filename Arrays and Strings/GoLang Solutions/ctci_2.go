package main
import (
  "fmt"
)

func reverse(str string) string {
	length := len(str)
  fmt.Println(length)
	revArr := []byte(str)
	for i := length / 2; i >= 0; i-- {
		revArr[i], revArr[length-i-1] = revArr[length-i-1], revArr[i]
	}
	return string(revArr)
}

func main() {
  result := reverse("string")
  fmt.Println(result)
}
