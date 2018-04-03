package l05_prefix_sums;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class GenomicRangeQuery {
	public int[] solution(String S, int[] P, int[] Q) {
		int[] min = null;
		if (S != null && S.length() > 0) {
			min = new int[P.length];
			Map<String, Integer> results = new HashMap<>();
			for (int i = 0; i < P.length; i++) {
				String sequence = S.substring(P[i], Q[i] + 1);
				String key = P[i] + "_" + (Q[i] + 1);
				Integer v = results.get(key);
				if (v != null) {
					min[i] = v;
				} else {
					// System.out.println(sequence);
					char[] chars = sequence.toCharArray();
					Arrays.sort(chars);

					switch (chars[0]) {
					case 'A':
						min[i] = 1;
						break;
					case 'C':
						min[i] = 2;
						break;
					case 'G':
						min[i] = 3;
						break;
					default:
						min[i] = 4;
					}
					results.put(key, min[i]);
				}

			}
		}
		return min;
	}

	public int[] solution_try(String S, int[] P, int[] Q) {
		int[] min = null;
		if (S != null && S.length() > 0) {
			min = new int[P.length];
			outer: for (int i = 0; i < P.length; i++) {
				String sequence = S.substring(P[i], Q[i] + 1);
				// System.out.println(sequence);
				char[] chars = sequence.toCharArray();
				char minor = 'T';
				for (char c : chars) {
					if (c == 'A') {
						min[i] = 1;
						continue outer;
					} else if (minor > c) {
						minor = c;
					}
				}
				switch (minor) {
				case 'C':
					min[i] = 2;
					break;
				case 'G':
					min[i] = 3;
					break;
				default:
					min[i] = 4;
				}

			}
		}
		return min;
	}

	public static void main(String[] args) {
		GenomicRangeQuery s = new GenomicRangeQuery();
		Arrays.stream(s.solution("CAGCCTA", new int[] { 2, 5, 0 }, new int[] { 4, 5, 6 })).forEach(System.out::print);
	}
}
