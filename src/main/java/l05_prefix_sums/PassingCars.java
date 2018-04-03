package l05_prefix_sums;

public class PassingCars {
	public int solution(int[] A) {
		int maxCars = 1000000000;
		int count = 0;
		int east = 0;
		if (A != null && A.length > 0) {
			for (int i = 0; i < A.length; i++) {
				if (A[i] == 0) {
					east++;
				} else {
					count += east;
				}
				if(count > maxCars) {
					return -1;
				}
			}
		}

		return count;
	}

	public static void main(String[] args) {
		PassingCars s = new PassingCars();
		System.out.println(s.solution(new int[] { 0, 1, 0, 1, 1 }));
		System.out.println(s.solution(new int[] { 0, 0 }));
		System.out.println(s.solution(new int[] { 1, 0 }));

	}
}
