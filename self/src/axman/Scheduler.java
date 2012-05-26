package axman;

public class Scheduler extends Thread {
	private final SmartQueue queue;

	public Scheduler(SmartQueue queue) {
		this.queue = queue;
	}

	public void invoke(MethodRequest request) {
		queue.putRequest(request);
	}

	@Override
	public void run() {
		while (true) {
			MethodRequest request = queue.takeRequest();
			request.execute();
		}
	}
}

class SmartQueue {
	private final static int MAX_COUNT = 100;
	private final MethodRequest[] requestQueue;
	private int head;
	private int tail;
	private int count;

	public SmartQueue() {
		requestQueue = new MethodRequest[MAX_COUNT];
		head = tail = count = 0;
	}

	public synchronized void putRequest(MethodRequest request) {
		while (count >= requestQueue.length) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		requestQueue[tail] = request;
		tail = (tail + 1) % requestQueue.length;
		count++;
		System.out.println("put one: " + count);
		notifyAll();
	}

	public synchronized MethodRequest takeRequest() {
		while (count <= 0) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		MethodRequest request = requestQueue[head];
		head = (head + 1) % requestQueue.length;
		count--;
		notifyAll();
		return request;
	}
}