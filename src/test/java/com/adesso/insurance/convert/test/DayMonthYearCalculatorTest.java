package com.adesso.insurance.convert.test;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;

import org.junit.Test;

import com.adesso.insurance.convert.DayMonthYearCalculator;

public class DayMonthYearCalculatorTest {

	@Test
	public void testGetDayMonthYear() {
		String dateStr = "1995.02.01";
		LocalDate expectedDate = LocalDate.of(1995, 02, 01);
        LocalDate actualDate = DayMonthYearCalculator.dayMonthYearValue(dateStr);
		assertEquals(expectedDate, actualDate);
		}
	
	 
	        }

