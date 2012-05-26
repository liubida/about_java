package Question;

import java.util.HashMap;
import java.util.Map;

public class Q13 {
	public static void main(String[] args) {
		char[] a = "abaccdeff".toCharArray();
		Map<Character, Integer> m = new HashMap<Character, Integer>();
		for (int i = 0; i < a.length; i++) {
			if (!m.containsKey(a[i])) {
				m.put(a[i], 1);
			} else {
				int tmp = m.get(a[i]);
				m.put(a[i], ++tmp);
			}
		}
		for (int i = 0; i < a.length; i++) {
			if (1 == m.get(a[i])) {
				System.out.println(a[i]);
				break;
			}
		}
		new Q13().a(1, "");
		new Q13().a((short) 1, "");
	}

	public void a(int a, String b) {
		System.out.println(1);
	}

	public void a(short a, String b) {
		System.out.println(2);
	}
}
