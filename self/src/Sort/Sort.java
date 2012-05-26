package Sort;

public class Sort {

	public static int[] BubbleSort(int[] a) {
		boolean isOver = true;
		int tmp = 0;
		for (int i = 0; i < a.length; i++) {
			isOver = true;
			for (int j = 0; j < a.length - i - 1; j++) {
				if (a[j] > a[j + 1]) {
					isOver = false;
					tmp = a[j];
					a[j] = a[j + 1];
					a[j + 1] = tmp;
				}
			}
			if (isOver) {
				break;
			}
		}
		return a;
	}

	public static int[] insertSort(int[] a) {
		int i, j, tmp;
		for (i = 1; i < a.length; i++) {
			tmp = a[i];
			for (j = i - 1; j >= 0 && tmp < a[j]; j--) {
				a[j + 1] = a[j];
			}
			a[j + 1] = tmp;
		}
		return a;
	}

	public static int[] quickSort(int[] a, int low, int high) {
		if (low < high) {
			int i = low;
			int j = high;
			int key = a[i];
			while (i < j) {
				while (i < j && a[j] >= key)
					j--;
				a[i] = a[j];
				while (i < j && a[i] <= key)
					i++;
				a[j] = a[i];
			}
			a[i] = key;
			quickSort(a, low, i - 1);
			quickSort(a, i + 1, high);
		}
		return a;
	}
}
