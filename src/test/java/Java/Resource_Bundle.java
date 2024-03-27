package Java;

import java.util.Locale;
import java.util.ResourceBundle;

public class Resource_Bundle {

	public static void main(String[] args) {

		String lang = "ge";
		String country = "GE";
		try {
			Locale l = new Locale(lang, country);

			ResourceBundle bundle = ResourceBundle
					.getBundle("Bundle", l);
			System.out.println("Message in " + l + ": " + bundle.getString("name"));

		} catch (Exception e) {
			System.err.println("Error loading resource bundle: " + e.getMessage());
			e.printStackTrace();
		}

	}
}
