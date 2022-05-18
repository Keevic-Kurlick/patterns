package ru.netology.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateGenerator {
    public static String addDaysToCurrentDate(int daysPeriod) {
        return (LocalDate.now()
                .plusDays(daysPeriod)
                .format(DateTimeFormatter.ofPattern("dd.MM.yyyy")));
    }
}
