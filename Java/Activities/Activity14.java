package activities;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;

public class Activity14 {

    public static void main(String[] args) {

        
        try {
            // Step 1: Create a text file
            File sourceFile = new File("notes.txt");

            if (sourceFile.createNewFile()) {
                System.out.println("A new file has been created: " + sourceFile.getName());
            } else {
                System.out.println("File already exists, continuing...");
            }

            // Step 2: Write something into the file
            String message = "Activity 14  - writing data into a file using FileUtils.";
            FileUtils.writeStringToFile(sourceFile, message, "UTF8");
            System.out.println("Text has been written to the file.");

            // Step 3: Read and display the text
            String originalData = FileUtils.readFileToString(sourceFile, "UTF8");
            System.out.println("Content in original file -> " + originalData);

            // Step 4: Create a directory where the file will be copied
            File targetFolder = new File("destinationFolder");

            if (!targetFolder.exists()) {
                targetFolder.mkdir();
                System.out.println("Directory 'destinationFolder' created.");
            }

            // Step 5: Copy file into the new directory
            FileUtils.copyFileToDirectory(sourceFile, targetFolder);
            System.out.println("File has been copied to the new folder.");

            // Step 6: Read the copied file
            File copied = FileUtils.getFile(targetFolder, "notes.txt");
            String copiedText = FileUtils.readFileToString(copied, "UTF8");

            System.out.println("Content in copied file -> " + copiedText);

        } catch (IOException e) {
            System.out.println("Something went wrong: " + e.getMessage());
        }
    }
}
