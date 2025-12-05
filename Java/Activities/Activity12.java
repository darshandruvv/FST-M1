package activities;

//Defining a functional interface
interface Addable {
 int add(int num1, int num2);
}

public class Activity12 {
 public static void main(String[] args) {

     // Lambda without body
     Addable ad1 = (a, b) -> a + b;

     // Lambda with body
     Addable ad2 = (int x, int y) -> {
         int sum = x + y;
         return sum;
     };

     System.out.println("Result from ad1: " + ad1.add(10, 20));
     System.out.println("Result from ad2: " + ad2.add(5, 7));
 }
}

