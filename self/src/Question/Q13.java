package Question;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

//题目：在一个字符串中找到第一个只出现一次的字符。如输入abaccdeff，则输出b。
public class Q13 {
	public static void main(String[] args) {
		char[] a = "abaccdeff".toCharArray();
		Map<Character, Integer> m = new HashMap<Character, Integer>();
		Map<Character, Integer> m1 = new Hashtable<Character, Integer>();
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
		new Q13().a((short)1, "");
		int b = 1/0;
	}

	public void a(int a, String b) {
		System.out.println(1);
	}

	public void a(short a, String b) {
		System.out.println(2);
	}
}
