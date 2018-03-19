package l04_couting_elements;

import java.util.Arrays;

public class MaxCounters {

	public int[] solution(int N, int[] A) {
		int[] counters = new int[N];
		if (A != null && A.length > 0) {
			int max = 0;
			int min = 0;
			int nPlus = N + 1;
			for (int k = 0; k < A.length; k++) {
				if (1 <= A[k] && A[k] <= N) {
					int X = A[k] - 1;
					counters[X] = Math.max(counters[X], min) + 1;
					max = Math.max(counters[X], max);
				} else if (A[k] == nPlus) {
					min = max;
				}
			}
			for (int i = 0; i < counters.length; i++) {
				counters[i] = Math.max(counters[i], min);
			}
		}
		return counters;
	}

	public static void main(String[] args) {
		MaxCounters s = new MaxCounters();
		// System.out.println(s.solution(new int[] { 3, 1, 2, 4, 3 }));
		Arrays.stream(s.solution(5, new int[] { 3, 4, 4, 6, 1, 4, 4 })).forEach(System.out::println);
	}
}
