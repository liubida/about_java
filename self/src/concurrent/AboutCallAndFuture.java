package concurrent;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class LongTask implements Callable<Integer> {
	private Integer id;
	private Integer count = 0;
	private long timeout = 0;

	public LongTask(Integer id, long timeout) {
		this.id = id;
		this.timeout = timeout;
	}

	private String genString() {
		return "Thread: " + id + "->" + count++;
	}

	public Integer call() {
		try {
			System.out.println(genString());

			// 线程B1去做sql任务
			Thread t = new Thread() {
				public void run() {
					while (!interrupted()) {
						BufferedReader read = new BufferedReader(
								new InputStreamReader(System.in));
						StringBuilder sb = new StringBuilder();
						String s = null;
						try {
							while (null != (s = read.readLine())) {
								sb.append(s);
								sb.append("\n");
							}
							System.out.println("i read: " + sb.toString());
						} catch (IOException e) {
						}
					}
				}
			};
			t.start();
			Thread.currentThread().join(timeout);
			t.interrupt();
		} catch (InterruptedException e) {

		}
		System.out.println("SQL execute too long, thread: " + id
				+ " is interrupt! the last count: " + count);
		return id;
	}
}

public class AboutCallAndFuture {
	public static void main(String[] args) {
		int ThreadCount = 3;
		int TaskCount = 10;
		ExecutorService exec = Executors.newFixedThreadPool(ThreadCount);
		List<Future<Integer>> list = new ArrayList<Future<Integer>>();

		for (int i = 0; i < TaskCount; i++) {
			list.add(exec.submit(new LongTask(i, 2000)));
		}
		for (Future<Integer> fu : list) {
			try {
				System.out.println(fu.get());
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ExecutionException e) {
				e.printStackTrace();
			}
			// catch (TimeoutException e) {
			// System.out.println("timeout!");
			// fu.cancel(true);
			// }
		}
	}
}
