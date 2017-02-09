package main
import (
  "fmt"
)

func replaceJob(inputString string) []string {
  length := len(inputString)
  var spaceCount int

  for i := 0; i < length; i++ {
    tokenCharacter := string([]rune(inputString)[i])
    if tokenCharacter == " " {
      spaceCount++;
    }
  }
  allocatedLength := length + (spaceCount*2)
  var returnableArray = make([]string, allocatedLength)
  j := 0
	for i := 0; i < length; i++ {
		matchCharacter := string([]rune(inputString)[i])

		if matchCharacter == " " {
      returnableArray[j] = "%"
			j = j + 1
			returnableArray[j] = "2"
			j = j + 1
			returnableArray[j] = "0"
			j = j + 1
		} else {
			returnableArray[j] = matchCharacter
			j = j + 1
		}
	}
  return returnableArray
}

func main() {
  inputString := "hell o wor ld"
  fmt.Println(replaceJob(inputString))
}
