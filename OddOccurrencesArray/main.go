package main

import (
	"fmt"
)

func Solution(A []int) int {
	// write your code in Go 1.4
	max := len(A)
	matchs := make([]bool, max, max)
	found := 0

outter:
	for i := 0; i < max && found < max-1; i++ {
		if matchs[i] {
			continue
		}
		for j := i + 1; j < max && found < max-1; j++ {
			if matchs[j] {
				continue
			}
			if A[i] == A[j] {
				found += 2
				matchs[i], matchs[j] = true, true
				continue outter
			}
		}
	}
	for i, v := range matchs {
		if !v {
			return A[i]
		}
	}
	return -1
}
func main() {
	fmt.Printf("the odd ocurrence 7 is %d\n", Solution([]int{9, 3, 9, 3, 9, 7, 9}))
	fmt.Printf("the odd ocurrence 1 is %d\n", Solution([]int{9, 3, 9, 3, 9, 7, 9, 7, 1}))
	fmt.Printf("the odd ocurrence 2 is %d\n", Solution([]int{2, 7, 9, 3, 9, 3, 9, 7, 9}))
	fmt.Printf("the odd ocurrence 5 is %d\n", Solution([]int{9, 3, 9, 7, 5, 3, 9, 7, 9}))
}
