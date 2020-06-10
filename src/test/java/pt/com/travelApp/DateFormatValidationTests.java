package pt.com.travelApp;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.format.DateTimeParseException;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import pt.com.travelApp.util.DateUtils;

@SpringBootTest
public class DateFormatValidationTests {

	@Test()
	public void testDateFormatAssertThrows() {
		assertThrows(DateTimeParseException.class, () -> {
			DateUtils.fromStringToLocalDate("12*12*2020");
		});
		assertThrows(DateTimeParseException.class, () -> {
			DateUtils.fromStringToLocalDate("2000/21/06");
		});
		assertThrows(DateTimeParseException.class, () -> {
			DateUtils.fromStringToLocalDate("12/13/2020");
		});
		assertThrows(DateTimeParseException.class, () -> {
			DateUtils.fromStringToLocalDate("12-12-2020");
		});
		assertThrows(DateTimeParseException.class, () -> {
			DateUtils.fromStringToLocalDate("12/123/2020");
		});
		assertThrows(DateTimeParseException.class, () -> {
			DateUtils.fromStringToLocalDate("12/12/20201");
		});
	}
	
	@Test
	public void testDateFormatDoesNotAssertThrows() {
		assertDoesNotThrow(() -> DateUtils.fromStringToLocalDate("01/01/2020"));
		assertDoesNotThrow(() -> DateUtils.fromStringToLocalDate("31/01/2020"));
		assertDoesNotThrow(() -> DateUtils.fromStringToLocalDate("01/01/1990"));
		assertDoesNotThrow(() -> DateUtils.fromStringToLocalDate("28/02/2020"));
		assertDoesNotThrow(() -> DateUtils.fromStringToLocalDate("03/06/2020"));
		assertDoesNotThrow(() -> DateUtils.fromStringToLocalDate("04/11/2020"));
		assertDoesNotThrow(() -> DateUtils.fromStringToLocalDate("01/12/2020"));
	}
}
