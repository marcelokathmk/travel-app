package pt.com.travelApp.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateUtils {

	public static LocalDate fromStringToLocalDate(String date) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate localDate = LocalDate.parse(date, formatter);
		return localDate;
	}
}
