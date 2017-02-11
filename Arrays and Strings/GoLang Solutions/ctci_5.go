package main
import (
  "fmt"
  "bytes"
  "strconv"
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

    if compareSize >= originalLength {
      return inputString
    }
    //var customString string = ""
    var buffer bytes.Buffer
    last := string(inputString[0])
    for i:=1; i<len(inputString); i++ {
      if last == string(inputString[i]) {
        count++
      }else{
          buffer.WriteString(string(last))
          //customString += (string(last))
          //fmt.Println("CUSTOM STRING:", buffer.String())
          buffer.WriteString(strconv.Itoa(count))
          //fmt.Println("CUSTOM STRING AFTER APPENDING COUNT:", buffer.String())
          //customString += (string(count))
          last = string(inputString[i])
          count = 1
        }
      }
      buffer.WriteString(last)
      //customString = customString + string(last)
      buffer.WriteString(strconv.Itoa(count))
      //customString = customString + string(count)
      return buffer.String()
  }
}

func main() {
  fmt.Println("RESULTANT STRING:", compress("AABBCCCDDEEEEE"))
}
