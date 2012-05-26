package axman;

public abstract class MethodRequest {
	protected final SmartAxmanServiceImpl serviceImpl;
	protected final FutureResult future;

	protected MethodRequest(SmartAxmanServiceImpl serviceImpl,
			FutureResult future) {
		this.serviceImpl = serviceImpl;
		this.future = future;
	}

	public abstract void execute();
}

class ResultRequest extends MethodRequest {
	private final int count;
	private final char c;

	public ResultRequest(SmartAxmanServiceImpl serviceImpl,
			FutureResult future, int count, char c) {
		super(serviceImpl, future);
		this.count = count;
		this.c = c;
	}

	public void execute() {
		Result result = serviceImpl.resultTest(count, c);
		future.setResult(result);
	}
}

class NoResultRequest extends MethodRequest {
	private String str;

	public NoResultRequest(SmartAxmanServiceImpl serviceImpl, String str) {
		super(serviceImpl, null);
		this.str = str;
	}

	public void execute() {
		serviceImpl.noResultTest(str);
	}
}