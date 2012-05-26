package Question;

public class Q15 {
	static char[] reverse(char[] s) {
		int len = s.length;
		int start = 0;
		int end = len - 1;
		char tmp;
		while (start < end) {
			tmp = s[start];
			s[start++] = s[end];
			s[end--] = tmp;
		}
		return s;
	}

	static char[] rotate(char[] a) {
		int i = 0;
		int j = a.length - 1;
		char c;
		while (i < j) {
			c = a[i];
			a[i] = a[j];
			a[j] = c;
			i++;
			j--;
		}
		return a;
	}

	static char[] leftRoateStr(String s, int n) {
		char[] a = s.substring(0, n).toCharArray();
		char[] b = s.substring(n, s.length()).toCharArray();
		a = rotate(a);
		b = rotate(b);
		// char[] c = a + b;
		return null;
	}

	public static void main(String[] args) {
		Plus[] list = new Plus[100];
		System.out.println(Plus.getSum());
		int a = 1, b = 100;

		a = a ^ b;
		b = a ^ b;
		a = a ^ b;

		System.out.println(a);
		System.out.println(b);

		String s = "abcedf";
		System.out.println(String.valueOf(reverse(s.toCharArray())));
	}
}

class Plus {
	private static int sum = 0;
	private static int n = 0;

	Plus() {
		n++;
		sum += n;
	}

	static int getSum() {
		return sum;
	}
}
