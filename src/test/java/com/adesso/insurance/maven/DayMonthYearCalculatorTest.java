package com.adesso.insurance.maven;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import org.junit.Test;

public class DayMonthYearCalculatorTest {

	@Test
	public void testGetDayMonthYear() {
		String dateStr = "1995.02.01";
		LocalDate expectedDate = LocalDate.of(1995, 02, 01);
		LocalDate actualDate = DayMonthYearCalculator.DayMonthYearValue(dateStr);
		assertEquals(expectedDate, actualDate);
		}
	
	 
	        }

