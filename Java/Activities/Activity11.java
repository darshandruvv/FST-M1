package activities;

import java.util.HashMap;
import java.util.Map;

public class Activity11 {
    public static void main(String[] args) {

        Map<Integer, String> colours = new HashMap<>();

        // adding some colours
        colours.put(1, "Red");
        colours.put(2, "Blue");
        colours.put(3, "Green");
        colours.put(4, "Yellow");
        colours.put(5, "Pink");

        System.out.println("Full map: " + colours);

        // remove one colour
        colours.remove(4);

        // check if green is there
        boolean hasGreen = colours.containsValue("Green");
        System.out.println("Green present? " + hasGreen);

        // size of map
        System.out.println("Size: " + colours.size());

        System.out.println("Updated map: " + colours);
    }
}
