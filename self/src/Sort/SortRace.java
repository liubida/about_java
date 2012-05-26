package Sort;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SortRace implements Runnable {
	private static final int SIZE = 10000;
	private static final int MAX = 99900;
	private int[] data;

	public SortRace(int[] a) {
		this.data = new int[a.length];
		for (int i = 0; i < a.length; i++) {
			this.data[i] = a[i];
		}
	}

	public void run() {
		long start = System.currentTimeMillis();
//		 data = Sort.BubbleSort(data);
		 data = Sort.insertSort(data);
//		data = Sort.quickSort(data, 0, data.length - 1);
		long end = System.currentTimeMillis();
		System.out.println("sort time: " + (end - start));
		System.out.println(this);
	}

	public static void race() throws InterruptedException {
		int data[] = new int[SIZE];
		long now = System.currentTimeMillis();
		Random seed = new Random(now);
		for (int i = 0; i < SIZE; i++) {
			data[i] = seed.nextInt(MAX);
		}
		ExecutorService exec = Executors.newCachedThreadPool();
		exec.execute(new SortRace(data));
		TimeUnit.MILLISECONDS.sleep(2000);
		exec.shutdown();
	}

	public static void main(String[] args) throws InterruptedException {
		race();
	}

	public String toString() {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < data.length; i++) {
			sb.append(data[i]);
			sb.append(",");
		}
		return sb.toString();
	}

}