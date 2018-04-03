package main

import (
	"fmt"
	"strings"
)

//Solution returns the minimal impact factor of nucleotides contained in a particular part of the given DNA sequence
func Solution(S string, P []int, Q []int) []int {
	// write your code in Go 1.4
	var min []int
	hasNucleotide := func(s string, c rune) bool {
		return strings.IndexRune(s, c) != -1
	}
	A := 'A'
	C := 'C'
	G := 'G'

	if len(S) > 0 {
		min = make([]int, len(P), len(P))
		results := make(map[string]int, len(P))
		for i := 0; i < len(min); i++ {
			slice := S[P[i] : Q[i]+1]
			key := fmt.Sprintf("%d_%d", P[i], Q[i]+1)
			//fmt.Println(slice)
			if id, has := results[key]; has {
				min[i] = id
			} else {
				if hasNucleotide(slice, A) {
					min[i] = 1
				} else if hasNucleotide(slice, C) {
					min[i] = 2
				} else if hasNucleotide(slice, G) {
					min[i] = 3
				} else {
					min[i] = 4
				}
				results[key] = min[i]
			}
		}
		fmt.Println(results)
	}

	return min
}

func main() {
	fmt.Println(Solution("CAGCCTA", []int{2, 5, 0}, []int{4, 5, 6}))

}
