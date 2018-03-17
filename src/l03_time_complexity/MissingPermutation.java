package l03_time_complexity;

public class MissingPermutation {
	public int solution(int[] A) {
		int min = 1;
		if (A != null && A.length > 0) {
			boolean[] index = new boolean[A.length + 2];
			for (int item : A) {
				index[item] = true;
			}

			for (int i = 1; i <= A.length + 1; i++) {
				if (!index[i]) {
					return i;
				}
			}
		}

		return min;
	}

	public static void main(String[] args) {
		MissingPermutation s = new MissingPermutation();
		System.out.println(s.solution(new int[] { 1, 2, 3 }));
		System.out.println(s.solution(new int[] { 2, 3, 1, 4 }));
		System.out.println(s.solution(new int[] { 1 }));
		System.out.println(s.solution(new int[] { 2 }));
	}
}
