package l01_iterations;

import java.util.Arrays;
import java.util.List;

public class BinaryGap {

	public int solution(int N) {
		String binary = Integer.toBinaryString(N);
		int ini = binary.indexOf('1');
		int end = binary.lastIndexOf('1');
		if (ini != end && ini != -1) {
			List<String> list = Arrays.asList(binary.substring(ini, end+1).split("1"));
			if (list.size() > 0) {
				list.sort((x, y) -> (y.compareTo(x)));
				return list.get(0).length();
			}
		}
		return 0;
	}

	public static void main(String[] args) {
		BinaryGap s = new BinaryGap();
		// System.out.println(s.solution(328));
		System.out.println(s.solution(51712));
		//System.out.println(s.solution(9));
		//System.out.println(s.solution(529));
	}
}
