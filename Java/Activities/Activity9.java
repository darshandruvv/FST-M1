package activities;

import java.util.ArrayList;

public class Activity9 {
	public static void main(String[] args) {

		ArrayList<String> myList = new ArrayList<>();

		// adding names
		myList.add("Sanju");
		myList.add("Darshan");
		myList.add("Deepak");
		myList.add("Maya");
		myList.add("Kiran");

		// printing all names
		for (int i = 0; i < myList.size(); i++) {
			System.out.println(myList.get(i));
		}

		// get 3rd name
		System.out.println("3rd name: " + myList.get(2));

		// check if name exists
		System.out.println("Contains 'Maya'? " + myList.contains("Maya"));

		// print size
		System.out.println("Size of list: " + myList.size());

		// remove a name and print size again
		myList.remove("Deepak");
		System.out.println("Size after removing: " + myList.size());
	}
}
