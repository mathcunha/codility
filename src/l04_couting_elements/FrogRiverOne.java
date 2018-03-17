package l04_couting_elements;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class FrogRiverOne {

	// you can also use imports, for example:
	// import java.util.*;

	// you can write to stdout for debugging purposes, e.g.
	// System.out.println("this is a debug message");

	public int solution(int X, int[] A) {
		if (A != null && A.length > 0) {
			Map<Integer, Integer> path = new HashMap<>();
			for (int i = 0; i < A.length; i++) {
				if (A[i] > X) {
					continue;
				}
				Integer j = path.get(A[i]); 
				if (j == null || j > i) {
					path.put(A[i], i);
				}
				if (path.keySet().size() == X) {
					Integer bigger = null;
					for (Entry<Integer, Integer> entry : path.entrySet()) {
						if (bigger == null || bigger < entry.getValue()) {
							bigger = entry.getValue();
						}
					}
					return bigger;
				}
			}
		}
		return -1;
	}
	
	public void printPath(Integer[] path) {
		System.out.println("printing\n");
		for (Integer integer : path) {
			System.out.print(integer+", ");
		}
	}

	public static void main(String[] args) {
		FrogRiverOne s = new FrogRiverOne();
		System.out.println(s.solution(5, new int[] { 1, 3, 1, 4, 2, 3, 5, 4 }));
		System.out.println(s.solution(4, new int[] { 1, 3, 1, 4, 2, 3, 5, 4 }));
		System.out.println(s.solution(6, new int[] { 1, 3, 1, 4, 2, 3, 5, 4 }));
		System.out.println(s.solution(1, new int[] { 1}));
	}
}
