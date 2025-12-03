package activity1;

public class Activity2 {
	
	
	public static boolean checkTensSum(int[] arr) {
        int sumOfTens = 0;

       
        for (int element : arr) {
            if (element == 10) {
                sumOfTens += 10;
            }
        }


        return sumOfTens == 30;
    }

	public static void main(String[] args) {
		int[] numbers = {10, 77, 10, 54, -11, 10};

        System.out.println("Starting Activity 2: Checking sum of 10s in the array.");
        System.out.print("Array elements: [");
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i] + (i < numbers.length - 1 ? ", " : ""));
        }
        System.out.println("]");
	

	boolean result = checkTensSum(numbers);

    // Print the result as required
    System.out.println("\nCheck result (Is the sum of all 10s exactly 30?): " + result);
}
}
