package axman;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class ResultInvokeTask implements Runnable {

	private final ISmartAxmanService service;
	private final char c;

	public ResultInvokeTask(ISmartAxmanService service, String name) {
		this.service = service;
		this.c = name.charAt(0);
	}

	@Override
	public void run() {
		int i = 1;
		while (true) {
			Result result = service.resultTest(i++, c);
			System.out.println(Thread.currentThread().getName() + " value = "
					+ result.getResultValue());
		}
	}
}

public class AxmanDemo {
	public static void main(String[] args) throws InterruptedException {
		ISmartAxmanService service = SmartAxmanServiceFactory.createService();
		ExecutorService exec = Executors.newCachedThreadPool();
		exec.execute(new ResultInvokeTask(service, "liubida"));
		exec.execute(new ResultInvokeTask(service, "zww"));
		exec.execute(new ResultInvokeTask(service, "xiaomin"));
		exec.execute(new ResultInvokeTask(service, "chuhao"));
		// TimeUnit.SECONDS.sleep(10);
		exec.shutdown();
	}
}
