package Java;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVComparator {
	
	public static void main(String[] args) {
		String filePath1 = "C:/Users/" + System.getProperty("user.name") + "/Downloads/CornerStone_WithIssue11G.csv";
		String filePath2 = "C:/Users/" + System.getProperty("user.name") + "/Downloads/CornerStone_Corrected11G.csv";
 
        List<String> file1Lines = readCSV(filePath1);
        List<String> file2Lines = readCSV(filePath2);
 
        compareCSVFiles(file1Lines, file2Lines);
    }
 
    private static List<String> readCSV(String filePath) {
        List<String> lines = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            StringBuilder lineBuilder = new StringBuilder();
            String line;
            boolean insideQuotedField = false;
            while ((line = br.readLine()) != null) {
                lineBuilder.append(line);
                if (line.contains("\"")) {
                    // Count quotes to detect if inside a quoted field
                    int quoteCount = 0;
                    for (char c : line.toCharArray()) {
                        if (c == '\"') {
                            quoteCount++;
                        }
                    }
                    if (quoteCount % 2 != 0) {
                        insideQuotedField = !insideQuotedField;
                    }
                }
                if (!insideQuotedField) {
                    lines.add(lineBuilder.toString());
                    lineBuilder.setLength(0); // Reset the builder for the next line
                } else {
                    lineBuilder.append("\n");
                }
            }
            if (lineBuilder.length() > 0) {
                lines.add(lineBuilder.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }
    
    private static void compareCSVFiles(List<String> file1Lines, List<String> file2Lines) {
        int maxLines = Math.max(file1Lines.size(), file2Lines.size());
 
        for (int i = 0; i < maxLines; i++) {
            String line1 = (i < file1Lines.size()) ? file1Lines.get(i) : "";
            String line2 = (i < file2Lines.size()) ? file2Lines.get(i) : "";
 
            if (!line1.equals(line2)) {
                System.out.println("Difference found at line " + (i + 1));
                System.out.println("File1: " + line1);
                System.out.println("File2: " + line2);
            }
 
            if (line1.contains("\n") || line1.contains("\r") || line2.contains("\n") || line2.contains("\r")) {
                System.out.println("Line break detected at line " + (i + 1));
                System.out.println("File1: " + line1);
                System.out.println("File2: " + line2);
            }
        }
    }
}
