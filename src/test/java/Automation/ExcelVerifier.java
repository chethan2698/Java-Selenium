package Automation;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
 
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
 
public class ExcelVerifier {
 
    public static void main(String[] args) {
 //       String filePath = "path/to/your/file.xls";
        String filePath = "C:/Users/" + System.getProperty("user.name") + "/Downloads/Document (1).xls";
        try {
            FileInputStream file = new FileInputStream(new File(filePath));
 
            // Create Workbook instance holding reference to .xls file
            HSSFWorkbook workbook = new HSSFWorkbook(file);
 
            // Get first/desired sheet from the workbook
            HSSFSheet sheet = workbook.getSheetAt(0);
 
            // Iterate through each rows one by one
            Iterator<Row> rowIterator = sheet.iterator();
            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
 
                // For each row, iterate through all the columns
                Iterator<Cell> cellIterator = row.cellIterator();
 
                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
 
                    // Check the cell type and perform verification
                    switch (cell.getCellType()) {
                        case STRING:
                            System.out.print(cell.getStringCellValue() + "\t");
                            break;
                        case NUMERIC:
                            System.out.print(cell.getNumericCellValue() + "\t");
                            break;
                        case BOOLEAN:
                            System.out.print(cell.getBooleanCellValue() + "\t");
                            break;
                        case FORMULA:
                            System.out.print(cell.getCellFormula() + "\t");
                            break;
                        default:
                            System.out.print("Unknown Cell Type\t");
                            break;
                    }
                }
                System.out.println("");
            }
            file.close();
            workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}