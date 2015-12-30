package main

import (
	"bytes"
	"encoding/binary"
	"fmt"
)

func Solution(N int) int {
	buf := new(bytes.Buffer)
	err := binary.Write(buf, binary.LittleEndian, int64(N))
	if err != nil {
		fmt.Println("binary.Write failed:", err)
	}
	bytes := buf.Bytes()
	gap := 0
	localGap := 0
	firstOne := true
	for j := 0; j < len(bytes); j++ {
		n := bytes[j]
		for i := byte(1); i > 0; i = i << 1 {
			hasOne := n&i > 0
			if hasOne {
				if firstOne {
					localGap = 0
					firstOne = false
					continue
				}
				if gap < localGap {
					gap = localGap
				}
				localGap = 0
			} else {
				localGap++
			}
		}
	}
	return gap
}

func main() {
	fmt.Printf("the gap for %d is %d\n", 1041, Solution(1041))
	fmt.Printf("the gap for %d is %d\n", 529, Solution(529))
	fmt.Printf("the gap for %d is %d\n", 20, Solution(20))
	fmt.Printf("the gap for %d is %d\n", 9, Solution(9))
}
