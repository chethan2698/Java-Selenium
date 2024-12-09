package Java.PdfCompare;

import java.io.IOException;

import de.redsix.pdfcompare.CompareResultWithPageOverflow;
import de.redsix.pdfcompare.PdfComparator;
import de.redsix.pdfcompare.RenderingException;

public class PDF_Compare {
	
	public static void main(String[] args) throws RenderingException, IOException {
		
		String file1 = "D:\\WorkSpaces\\WorkSpace - Chethan\\Automation\\files\\Current SOP.pdf";
		String file2 = "D:\\WorkSpaces\\WorkSpace - Chethan\\Automation\\files\\New SOP.pdf";
		String resultFile = "D:\\WorkSpaces\\WorkSpace - Chethan\\Automation\\files\\results\\result.pdf";
		
		boolean isEquals = new PdfComparator(file1, file2).compare().writeTo(resultFile);
		
//		new PdfComparator(file1, file2 , new CompareResultWithPageOverflow()).compare();
		
		if (!isEquals) {
		    System.out.println("Differences found!");
		}
		
	}
	

}
