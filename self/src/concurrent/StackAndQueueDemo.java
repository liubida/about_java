package concurrent;

class LinkedStack<T> {
	private static class Node<E> {
		E item;
		Node<E> next;

		Node() {
			this.item = null;
			this.next = null;
		}

		Node(E item, Node<E> next) {
			this.item = item;
			this.next = next;
		}

		boolean isEnd() {
			return item == null && next == null;
		}

	}

	private Node<T> top = new Node<T>();

	public void push(T item) {
		top = new Node<T>(item, top);
	}

	public T pop() {
		T item = top.item;
		if (!top.isEnd()) {
			top = top.next;
		}
		return item;
	}
}

class LinkedQueue<T> {
	private static class Node<E> {
		E item;
		Node<E> next;

		Node() {
			this.item = null;
			this.next = null;
		}

		Node(E item, Node<E> pre) {
			this.item = item;
			this.next = pre.next;
			pre.next = this;
		}

		boolean isEnd() {
			return null == item && null == next;
		}
	}

	private Node<T> head = new Node<T>();
	private Node<T> cur = head;

	public void put(T item) {
		cur = new Node<T>(item, cur);
		if (null == head.item) {
			head = cur;
		}
	}

	public T get() {
		if (null == head) {
			return null;
		} else {
			T item = head.item;
			if (!head.isEnd()) {
				head = head.next;
			}
			return item;
		}
	}
}

public class StackAndQueueDemo {
	public static void main(String[] args) {
		LinkedStack<String> lss = new LinkedStack<String>();
		LinkedQueue<String> lqs = new LinkedQueue<String>();
		for (String s : "liubida love zww!".split(" ")) {
			lss.push(s);
			lqs.put(s);
		}

		String s;
		while ((s = lss.pop()) != null)
			System.out.println(s);
		while ((s = lqs.get()) != null)
			System.out.println(s);
	}
}
