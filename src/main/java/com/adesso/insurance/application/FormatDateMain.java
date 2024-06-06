package com.adesso.insurance.application;

import java.time.LocalDate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.adesso.insurance.convert.DayMonthYearCalculator;

public class FormatDateMain {

    private static final Logger LOGGER = LoggerFactory.getLogger(FormatDateMain.class);

    public static void main(String[] args) {
        String date = "1995/02/01";
        LocalDate dateFormated = DayMonthYearCalculator.dayMonthYearValue(date);

        DayMonthYearCalculator.tagValue(dateFormated);
        DayMonthYearCalculator.monthValue(dateFormated);
        DayMonthYearCalculator.yearValue(dateFormated);

        DayMonthYearCalculator.convertDateFormat(date.toString());

    }

}
