package Automation;

import java.io.File;
import java.io.IOException;
 
public class ChangeFileExtension {
 
    public static void main(String[] args) {
        // Specify the original file path and the new file extension
 //       String originalFilePath = "path/to/your/file.xls";  // Update this to your file path
        String originalFilePath = "C:/Users/" + System.getProperty("user.name") + "/Downloads/Document (1).xls";
        String newExtension = ".xlsx";  // New file extension
 
        // Change the file extension
        boolean result = changeFileExtension(originalFilePath, newExtension);
 
        if (result) {
            System.out.println("File extension changed successfully.");
        } else {
            System.out.println("Failed to change file extension.");
        }
    }
 
    /**
     * Changes the extension of the given file.
     *
     * @param originalFilePath The original file path.
     * @param newExtension The new file extension.
     * @return true if the file was renamed successfully, false otherwise.
     */
    public static boolean changeFileExtension(String originalFilePath, String newExtension) {
        // Get the original file
        File originalFile = new File(originalFilePath);
        
        // Check if the original file exists
        if (!originalFile.exists()) {
            System.out.println("The original file does not exist.");
            return false;
        }
 
        // Get the new file path by replacing the original extension with the new extension
        String newFilePath = originalFilePath.replaceFirst("[.][^.]+$", newExtension);
        File newFile = new File(newFilePath);
 
        // Rename the original file to the new file
        return originalFile.renameTo(newFile);
    }
}
