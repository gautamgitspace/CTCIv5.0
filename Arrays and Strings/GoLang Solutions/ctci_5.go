package main
import (
  "fmt"
)

func countCompression(inputString string) (int, int) {
  stringSize := 0;
  count := 1;
  if len(inputString) == 0 {
    stringSize = 0;
  }
  last := (string(inputString[0]))
  for i := 1; i < len(inputString); i++ {
    if string(inputString[i]) == last {
      count++;
    }else{
      last = string(inputString[i])
      stringSize += 1 + len(string(count))
      count = 1;
    }
  }
  stringSize += 1 + len(string(count))
  return stringSize, len(inputString)
}

func compress(inputString string) string {
  count := 1;
  if len(inputString) == 0 {
    return "Empty string fool!"
  }else{
    compareSize, originalLength := countCompression(inputString)
    fmt.Println("ORIGINAL SIZE:", originalLength)
    fmt.Println("COMPRESSED SIZE:", compareSize)

    if compareSize >= len(inputString) {
      return inputString
    }
    var customString string = ""
    last := string(inputString[0])
    for i:=0; i<len(inputString); i++ {
      if last == string(inputString[i]) {
        count++
      }else{
          customString = customString + (string(last))
          customString = customString + (string(count))
          last = string(inputString[i])
          count = 1
        }
      }
      customString = customString + string(last)
      customString = customString + string(count)
      return customString
  }
}

func main() {
  compressedLength, originalLength := countCompression("abc")
  fmt.Println("COMPRESSED LENGTH:", compressedLength)
  fmt.Println("ORIGINAL LENGTH:", originalLength)
}
