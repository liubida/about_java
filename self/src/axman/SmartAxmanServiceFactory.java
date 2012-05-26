package axman;

public class SmartAxmanServiceFactory {
	public static synchronized ISmartAxmanService createService() {
		SmartAxmanServiceImpl imp = new SmartAxmanServiceImpl();
		SmartQueue queue = new SmartQueue();
		Scheduler st = new Scheduler(queue);
		AxmanServiceProxy p = new AxmanServiceProxy(st, imp);
		st.start();
		return p;
	}
}