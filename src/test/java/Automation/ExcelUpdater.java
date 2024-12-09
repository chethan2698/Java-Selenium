package Automation;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
 
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
 
public class ExcelUpdater {
 
    public static void main(String[] args) {
        String xl1Path = "C:/Users/" + System.getProperty("user.name") + "/Downloads/TescaseALM1.xlsx";  // Path to xl 1
        String xl2Path = "C:/Users/" + System.getProperty("user.name") + "/Downloads/TC - Copy.xlsx";  // Path to xl 2
 
        try (FileInputStream fis1 = new FileInputStream(xl1Path);
             FileInputStream fis2 = new FileInputStream(xl2Path);
             Workbook workbook1 = new XSSFWorkbook(fis1);
             Workbook workbook2 = new XSSFWorkbook(fis2)) {
 
            // Getting the first sheet from xl1
            Sheet sheet1 = workbook1.getSheetAt(0);
            // Getting the first sheet from xl2
            Sheet sheet2 = workbook2.getSheetAt(0);
 
            // Variables for reading xl1
            int stepColumnIndex = 0;  // Assuming "Step Name" is the first column in xl1
            int descriptionColumnIndex = 1;  // Assuming "Description" is the second column in xl1
            int expectedColumnIndex = 2;  // Assuming "Expected" is the third column in xl1
 
            // Variables for writing into xl2
            int testStepColumnIndex = 3;  // "Test Step" in xl2 (column D)
            int actionColumnIndex = 4;  // "Step Action" in xl2 (column E)
            int expectedStepColumnIndex = 5;  // "Step Expected" in xl2 (column F)
            
            int rowNum2 = 2;  // Start writing from row 3 in xl2
            int stepNumber = 1;  // Test Step number
 
            // Reading xl1 and writing to xl2
            for (int rowNum1 = 1; rowNum1 <= sheet1.getLastRowNum(); rowNum1++) {
                Row row1 = sheet1.getRow(rowNum1);
                if (row1 != null) {
                    String description = row1.getCell(descriptionColumnIndex).getStringCellValue();
                    String expected = row1.getCell(expectedColumnIndex).getStringCellValue();
 
                    // Create a new row in xl2 and write values
                    Row row2 = sheet2.createRow(rowNum2++);
                    
                    // Set the Test Step column (1, 2, 3...)
                    row2.createCell(testStepColumnIndex).setCellValue(stepNumber++);
 
                    // Set the Step Action column (Description from xl1)
                    row2.createCell(actionColumnIndex).setCellValue(description);
 
                    // Set the Step Expected column (Expected from xl1)
                    row2.createCell(expectedStepColumnIndex).setCellValue(expected);
                }
            }
 
            // Write updates to xl2
            try (FileOutputStream fos = new FileOutputStream(xl2Path)) {
                workbook2.write(fos);
            }
 
            System.out.println("Excel updated successfully!");
 
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}