package Java.Dates;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

public class DateMethods {

	public static void main(String[] args) {
		
	}

	public static String formatDateTime(LocalDateTime dateTime, String dateTimeFormat) {
		return dateTime.format(java.time.format.DateTimeFormatter.ofPattern(dateTimeFormat));
	}

	public static LocalDateTime addHours(LocalDateTime dateTime, int hoursToAdd, int startHour, int endHour) {
		for (int i = 0; i < hoursToAdd; i++) {
			dateTime = dateTime.plusHours(1);
			if (isWeekendOrOutsideWorkingHours(dateTime, startHour, endHour)) {
				dateTime = nextWorkingDay(dateTime, startHour);
			}
		}
		return dateTime;
	}

	public static boolean isWeekendOrOutsideWorkingHours(LocalDateTime dateTime, int startHour, int endHour) {
		return dateTime.getDayOfWeek() == DayOfWeek.SATURDAY || dateTime.getDayOfWeek() == DayOfWeek.SUNDAY
				|| dateTime.getHour() < startHour || dateTime.getHour() >= endHour;
	}

	public static LocalDateTime nextWorkingDay(LocalDateTime dateTime, int startHour) {
		if (dateTime.getDayOfWeek() == DayOfWeek.FRIDAY) {
			return dateTime.plusDays(3).withHour(startHour).withMinute(dateTime.getMinute()).withSecond(0);
		} else {
			return dateTime.plusDays(1).withHour(startHour).withMinute(dateTime.getMinute()).withSecond(0);
		}
	}

	public String addDateAndTime(String date, int hoursToAdd, int startHour, int endHour) throws java.text.ParseException {
			DateTimeFormatter inputFormat = DateTimeFormatter.ofPattern("M/d/yyyy h:mm a");
			LocalDateTime dateTime = LocalDateTime.parse(date, inputFormat);
			LocalDateTime startDateTime= LocalDateTime.of(dateTime.getYear(), dateTime.getMonthValue(), dateTime.getDayOfMonth(), dateTime.getHour(), dateTime.getMinute());
			LocalDateTime endDateTime= addHours(startDateTime, hoursToAdd, startHour, endHour);
			String outputDate = formatDateTime(endDateTime, "M/d/yyyy h:mm a");
			System.out.println(outputDate);
			return outputDate;
		}

}
