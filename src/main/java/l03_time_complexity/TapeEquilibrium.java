package l03_time_complexity;

public class TapeEquilibrium {
	public int solution(int[] A) {
		int min = 0;
		if (A != null && A.length > 0) {
			int lSum = A[0];
			int rSum = 0;
			for (int i = 1; i < A.length; i++) {
				rSum += A[i];
			}

			min = Math.abs(lSum - rSum);
			//System.out.println("lSum:" + lSum + " rSum:" + rSum + " min:" + min);
			for (int i = 1; i < A.length-1; i++) {
				lSum += A[i];
				rSum -= A[i];

				int lMin = Math.abs(lSum - rSum);
				//System.out.println("lSum:" + lSum + " rSum:" + rSum + " min:" + lMin);
				if (lMin < min) {
					min = lMin;
				}
			}
		}
		return min;
	}

	public static void main(String[] args) {
		TapeEquilibrium s = new TapeEquilibrium();
		System.out.println(s.solution(new int[] { 3, 1, 2, 4, 3 }));
		System.out.println(s.solution(new int[] { -1000, 1000 }));
	}
}
