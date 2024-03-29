package concurrent;

class Generator<T> {
	private final Class<T> c;

	public Generator(Class<T> c) {
		this.c = c;
	}

	public T next() {
		try {
			return c.newInstance();
		} catch (InstantiationException e) {
		} catch (IllegalAccessException e) {
		} catch (Exception e) {
		}
		return null;
	}
}

@SuppressWarnings("unused")
class ExchangerProducer<T> implements Runnable {
	private Generator<T> generator;

	@Override
	public void run() {

	}

}

public class ExchangerDemo {

}
