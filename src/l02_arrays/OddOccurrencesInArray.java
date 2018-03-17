package l02_arrays;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class OddOccurrencesInArray {
	public int solution(int[] A) {
		Map<Integer, Integer> map = new HashMap<>(A.length / 2);
		for (int i : A) {
			Integer sum = map.get(i);
			if(sum == null) {
				sum = 0;
			}
			map.put(i, ++sum);
		}
		
		Set<Map.Entry<Integer,Integer>> entries = map.entrySet();
		Map.Entry<Integer, Integer> odd = null;
		for (Map.Entry<Integer, Integer> entry : entries) {
			if(entry.getValue() % 2 == 1 ){
				odd =entry;
				break;
			}
		}
		if(odd == null) {
			return 0;
		}else {
			return odd.getKey();
		}
	}

	public static void main(String[] args) {
		OddOccurrencesInArray s = new OddOccurrencesInArray();
		System.out.println(s.solution(new int[] { 1, 2, 1, 2, 3 }));
		System.out.println(s.solution(new int[] { 3, 2, 1, 2, 3 }));
		System.out.println(s.solution(new int[] { 1, 2, 3, 1, 3 }));
	}
}
