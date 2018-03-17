package l04_couting_elements;

import java.util.Arrays;


public class PermCheck {

	// you can also use imports, for example:
	// import java.util.*;

	// you can write to stdout for debugging purposes, e.g.
	// System.out.println("this is a debug message");

	public int solution(int[] A) {
		if (A != null && A.length > 0) {
			Arrays.sort(A);
			for(int i =0; i < A.length; ++i) {
				if(A[i] != i+1) {
					return 0;
				}
			}
			return 1;
		}
		return 0;
	}
	
	

	public static void main(String[] args) {
		PermCheck s = new PermCheck();
		System.out.println(s.solution(new int[] { 1,2,3,4 }));
		System.out.println(s.solution(new int[] { 4, 1, 3 }));
		System.out.println(s.solution(new int[] { 0,1 }));
		System.out.println(s.solution(new int[] { 1,3 }));
		//System.out.println(s.solution(new int[] { 1, 3, 1, 4, 2, 3, 5, 4 }));
		//System.out.println(s.solution(new int[] { 1, 3, 1, 4, 2, 3, 5, 4 }));
		//System.out.println(s.solution(new int[] { 1}));
	}
}
