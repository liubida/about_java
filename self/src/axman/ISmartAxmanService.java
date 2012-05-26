package axman;

public interface ISmartAxmanService {
	Result resultTest(int count, char c);

	void noResultTest(String str);
}

class AxmanServiceProxy implements ISmartAxmanService {
	private final Scheduler scheduler;
	private final SmartAxmanServiceImpl serviceImpl;

	public AxmanServiceProxy(Scheduler scheduler,
			SmartAxmanServiceImpl serviceImpl) {
		this.serviceImpl = serviceImpl;
		this.scheduler = scheduler;
	}

	@Override
	public void noResultTest(String str) {
		scheduler.invoke(new NoResultRequest(serviceImpl, str));
	}

	@Override
	public Result resultTest(int count, char c) {
		FutureResult future = new FutureResult();
		scheduler.invoke(new ResultRequest(serviceImpl, future, count, c));
		return future;
	}

}

class SmartAxmanServiceImpl implements ISmartAxmanService {
	@Override
	public Result resultTest(int count, char c) {
		char[] buf = new char[count];
		try {
			Thread.sleep(200);
			for (int i = 0; i < count; i++) {
				buf[i] = c;
				// Thread.sleep(200);
			}
		} catch (Throwable t) {
		}
		return new RealResult(new String(buf));
	}

	@Override
	public void noResultTest(String str) {
		try {
			System.out.println("displayString :" + str);
			Thread.sleep(10);
		} catch (Throwable t) {
		}
	}
}