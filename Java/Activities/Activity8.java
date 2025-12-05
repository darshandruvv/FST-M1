package activities;

class CustomException extends Exception {
	private String message;

	public CustomException(String message) {

		this.message = message;
	}

	@Override
	public String getMessage() {
		return message;
	}

}

public class Activity8 {

	public static void exceptionTest(String Value) throws CustomException {

		if (Value == null) {
			throw new CustomException("Input value cannot be null please enter some value!");
		} else {
			System.out.println("Received: " + Value);
		}
	}

	public static void main(String[] args) {
        try {
            exceptionTest("Will print to console");
            exceptionTest(null);   // This will throw CustomException
        } catch (CustomException e) {
            System.out.println("Custom Error: " + e.getMessage());
        }
    }
}