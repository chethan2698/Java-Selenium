package Automation;

//  String xl1Path = "C:/Users/" + System.getProperty("user.name") + "/Downloads/testcase289_Propersteps.xlsm"; // Path to the first Excel file
//String xl2Path = "C:/Users/" + System.getProperty("user.name") + "/Downloads/TC - Copy.xlsx"; 
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelConverter {

    public static void main(String[] args) {
        String xl1Path = "C:/Users/" + System.getProperty("user.name") + "/Downloads/testcase289_Propersteps.xlsm"; // Path to the first Excel file
        String xl2Path = "C:/Users/" + System.getProperty("user.name") + "/Downloads/TC - Copy.xlsx"; 

        try {
            // Load the first Excel file
            FileInputStream xl1File = new FileInputStream(xl1Path);
            Workbook xl1Workbook = new XSSFWorkbook(xl1File);
            Sheet xl1Sheet = xl1Workbook.getSheetAt(0);

            // Load the second Excel file
            FileInputStream xl2File = new FileInputStream(xl2Path);
            Workbook xl2Workbook = new XSSFWorkbook(xl2File);
            Sheet xl2Sheet = xl2Workbook.getSheetAt(0);

            // Get values from the first row of XL1
            Row firstRow = xl1Sheet.getRow(1); // Assuming data starts from row 1 (index 1)
            String title = firstRow.getCell(1).getStringCellValue(); // Title
            String assignedTo = firstRow.getCell(5).getStringCellValue(); // TS_RESPONSIBLE

            // Set Title and Assigned To in XL2 (Row 1)
            Row titleRow = xl2Sheet.getRow(1); // Row 2 is index 1
            if (titleRow == null) {
                titleRow = xl2Sheet.createRow(1);
            }
            Cell titleCell = titleRow.getCell(2);
            if (titleCell == null) {
                titleCell = titleRow.createCell(2);
            }
            titleCell.setCellValue(title); // Title

            Cell assignedToCell = titleRow.getCell(6);
            if (assignedToCell == null) {
                assignedToCell = titleRow.createCell(6);
            }
            assignedToCell.setCellValue(assignedTo); // Assigned To

            // Iterate through XL1 and write to XL2 starting from Row 2
            int rowCount = xl1Sheet.getPhysicalNumberOfRows();
            for (int i = 1; i < rowCount; i++) { // Start from row 1 to skip headers
                Row xl1Row = xl1Sheet.getRow(i);
                if (xl1Row != null) {
                    // Create a new row in XL2
                    Row xl2Row = xl2Sheet.createRow(i + 1); // Offset by 1 to account for title row

                    // Write Test Step number (i.e., Step 1 -> 1, Step 2 -> 2)
                    Cell testStepCell = xl2Row.createCell(3);
                    testStepCell.setCellValue(i); // Test Step

                    // Write Step Action (Description from XL1)
                    String description = xl1Row.getCell(3).getStringCellValue(); // DS_DESCRIPTION
                    Cell actionCell = xl2Row.createCell(4);
                    actionCell.setCellValue(description); // Step Action

                    // Write Step Expected (Expected from XL1)
                    String expected = xl1Row.getCell(4).getStringCellValue(); // DS_EXPECTED
                    Cell expectedCell = xl2Row.createCell(5);
                    expectedCell.setCellValue(expected); // Step Expected
                }
            }

            // Write the changes to the second Excel file
            try (FileOutputStream outputStream = new FileOutputStream(xl2Path)) {
                xl2Workbook.write(outputStream);
            }

            // Close the workbooks
            xl1Workbook.close();
            xl2Workbook.close();
            xl1File.close();
            xl2File.close();

            System.out.println("Data transferred successfully!");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
