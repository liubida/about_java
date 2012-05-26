package axman;

public abstract class Result {
	public abstract Object getResultValue();
}

class FutureResult extends Result {
	private Result result;
	private boolean isCompleted = false;

	public synchronized void setResult(Result result) {
		this.result = result;
		this.isCompleted = true;
		notifyAll();
	}

	@Override
	public synchronized Object getResultValue() {
		while (!isCompleted) {
			try {
				wait();
			} catch (InterruptedException e) {
			}
		}
		return result.getResultValue();
	}
}

class RealResult extends Result {
	private final Object value;

	public RealResult(Object value) {
		this.value = value;
	}

	public Object getResultValue() {
		return value;
	}
}