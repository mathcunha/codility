package l05_prefix_sums;

public class CountDiv {
	public int solution(int A, int B, int K) {
		if (B > A) {
			int divB = B / K;
			int divA = A / K;
			//System.out.println(divB +" "+ divA);
			if (A % K == 0) {
				return divB - divA + 1;
			}else {
				return divB - divA;
			}
		}else if (B == A){
			if (A % K == 0) {
				return 1;
			}
		}
		return 0;
	}

	public static void main(String[] args) {
		CountDiv s = new CountDiv();
		//System.out.println(s.solution(6, 11, 2));
		//System.out.println(s.solution(14, 14, 3));
		//System.out.println(s.solution(6, 15, 3));
		//System.out.println(s.solution(5, 7, 20));
		//System.out.println(s.solution(1, 1, 11));
		int maxInt = 2000000000;
		System.out.println(s.solution(0, maxInt, 1));
		System.out.println(s.solution(0, maxInt, maxInt));
		
	}
}
