package Question;

interface h {
	public int a = 2;
}

public class Q14 implements h {
	public Q14() {

	}

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		Q14 q = new Q14();
		// new g();
		int flag = 16;
		// System.out.println(flag & (flag - 1));
		// System.out.println(q.countOne1(3));

		// for (int i = 1; i < 45; i++) {
		// System.out.println(fibonacci(i));
		// }

		System.out.println(toFloat(45.320f));
		System.out.println(f(-10));
	}

	public int countOne1(int n) {
		int count = 0;
		while (true) {
			if ((n & 1) == 1) {
				count++;
			}
			n = n >>> 1;
			if (n == 0) {
				break;
			}
		}
		return count;
	}

	public static int f(int x) {
		int y = -1;
		for (int i = 0; i < x; i++, y++)
			;
		return y;

	}

	public static float toFloat(float f) {
		return (float) ((f) * 100 - (int) ((f) * 100) >= 0.5 ? (int) ((f) * 100 + 1) / 100.0
				: (int) ((f) * 100) / 100.0);
	}

	public static long fibonacci(int n) {
		long a1 = 1, a2 = 2, a3 = 0;
		if (n == 1 || n == 2) {
			return 1;
		}
		if (n == 3) {
			return 2;
		}
		for (int i = 4; i <= n; i++) {
			a3 = a1 + a2;
			a1 = a2;
			a2 = a3;
		}
		return a3;
	}
}

class Single {
	private Single() {
	};

	private static Single s = new Single();

	public static Single getSingle() {
		return s;
	}
}
