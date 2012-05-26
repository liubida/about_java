package Question;

public class CPU {

	public static void half() throws InterruptedException {
		int busyTime = 10;
		int idleTime = busyTime * 2;
		long start = 0;
		while (true) {
			start = System.currentTimeMillis();
			while ((System.currentTimeMillis() - start) <= busyTime)
				;
			Thread.sleep(idleTime);
		}
	}

	public static void sin() throws InterruptedException {
		final double PI = Math.PI;
		double split = 0.01;
		int COUNT = (int) (2 / split);
		int interval = 200;
		int half = interval / 2;
		long[] busySpan = new long[COUNT];
		long[] idleSpan = new long[COUNT];

		double radian = 0.0;
		for (int i = 0; i < COUNT; i++) {
			busySpan[i] = (long) (half + (Math.sin(PI * radian) * half));
			idleSpan[i] = interval - busySpan[i];
			radian += split;
		}
		long startTime = 0;
		int j = 0;
		while (true) {
			j = j % COUNT;
			startTime = System.currentTimeMillis();
			while (System.currentTimeMillis() - startTime < busySpan[j])
				;
			Thread.sleep(idleSpan[j]);
			j++;
		}

	}

	public static void main(String[] args) throws InterruptedException {
		// sin();
		half();
	}
}
