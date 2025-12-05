package activities;

import java.util.HashSet;

public class Activity10 {
    public static void main(String[] args) {

        // Create a HashSet
        HashSet<String> hs = new HashSet<>();

        // Add 6 objects
        hs.add("Apple");
        hs.add("Banana");
        hs.add("Orange");
        hs.add("Mango");
        hs.add("Grapes");
        hs.add("Pineapple");

        // Print size
        System.out.println("Size of HashSet: " + hs.size());

        // Remove an element
        System.out.println("Removing 'Orange': " + hs.remove("Orange"));

        // Try removing something not in the set
        System.out.println("Trying to remove 'Watermelon': " + hs.remove("Watermelon"));

        // Check if an item exists
        System.out.println("Does set contain 'Mango'? " + hs.contains("Mango"));
        System.out.println("Does set contain 'Orange'? " + hs.contains("Orange"));

        // Print updated set
        System.out.println("Updated HashSet: " + hs);
    }
}
