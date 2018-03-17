package l04_couting_elements;

import java.util.Arrays;

public class MissingInteger {

	public int solution(int[] A) {
		if (A != null && A.length > 0) {
			Arrays.sort(A);
			boolean[] pos = new boolean[A[A.length-1]+1];
			for (int i : A) {
				if(i >= 1) {
					pos[i] = true;
				}
			}
			for (int i = 1; i < pos.length; i++) {
				if(!pos[i]) {
					return i;
				}
			}
			if (pos.length == 0) {
				return 1;
			}else {
				return pos.length;
			}
		}
		return 1;
    }
	public static void main(String[] args) {
		MissingInteger s = new MissingInteger();
		//System.out.println(s.solution(new int[] { 3, 1, 2, 4, 3 }));
		System.out.println(s.solution(new int[] { 1, 3, 6, 4, 1, 2}));
		System.out.println(s.solution(new int[] { 1, 2, 3}));
		System.out.println(s.solution(new int[] { 0,1, 3,2,5}));
		System.out.println(s.solution(new int[] { -1, -3}));
	}
}
