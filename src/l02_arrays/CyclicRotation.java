package l02_arrays;

public class CyclicRotation {
	public int solution(int[] A) {
		if (A.length == 0) {
			return 0;
		}

		if (A.length == 1) {
			return A[0];
		}

		boolean[] c = new boolean[A.length];
		outer: for (int i = 0; i < A.length; i++) {
			if (c[i]) {
				continue;
			}
			for (int j = i + 1; j < A.length; j++) {
				if (c[j]) {
					continue;
				}

				if (A[i] == A[j]) {
					c[i] = true;
					c[j] = true;
					continue outer;
				}
			}
		}

		for (int i = 0; i < A.length; i++) {
			if (!c[i]) {
				return A[i];
			}

		}
		return 0;
	}

	public static void main(String[] args) {
		CyclicRotation s = new CyclicRotation();
		System.out.println(s.solution(new int[] { 1, 2, 1, 2, 3 }));
		System.out.println(s.solution(new int[] { 3, 2, 1, 2, 3 }));
		System.out.println(s.solution(new int[] { 1, 2, 3, 1, 3 }));
	}
}
