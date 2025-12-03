package activity1;

public class Activity4 {
	public static void main(String[] args) {
		int[] arr = { 9, 3, 7, 1, 4 };
		System.out.println("Before Sorting:");
		for (int n : arr)
			System.out.println(n + "");

		for (int i = 1; i < arr.length; i++) {
			int key = arr[i];
			int j = i - 1;
			while (j >= 0 && arr[j] > key) {
				arr[j + 1] = arr[j];
				j--;
			}
			arr[j + 1] = key;
		}

		System.out.println("\nAfter Sorting:");
		for (int n : arr)
			System.out.print(n + " ");
	}

}
