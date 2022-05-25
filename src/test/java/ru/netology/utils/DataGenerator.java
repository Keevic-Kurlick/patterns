package ru.netology.utils;

import com.github.javafaker.Faker;
import lombok.experimental.UtilityClass;
import ru.netology.entities.RegistrationData;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

@UtilityClass
public class DataGenerator {

    @UtilityClass
    public static class RegistrationInfoGenerator {

        public static RegistrationData generateByName(String locale, String city) {
            Faker faker = new Faker(new Locale(locale));
            return new RegistrationData(faker.name().fullName(),
                    faker.phoneNumber().phoneNumber(), city);
        }
    }

    @UtilityClass
    public static class DateGenerator {
        public static String addDaysToCurrentDate(int daysPeriod) {
            return (LocalDate.now()
                    .plusDays(daysPeriod)
                    .format(DateTimeFormatter.ofPattern("dd.MM.yyyy")));
        }
    }
}
