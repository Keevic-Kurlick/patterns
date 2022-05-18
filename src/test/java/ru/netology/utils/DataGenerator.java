package ru.netology.utils;

import com.github.javafaker.Faker;
import lombok.experimental.UtilityClass;
import ru.netology.entities.RegistrationData;

import java.util.Locale;

@UtilityClass
public class DataGenerator {

    @UtilityClass
    public static class RegistrationInfoGenerator {

        public static RegistrationData generateByName(String locale) {
            Faker faker = new Faker(new Locale(locale));
            return new RegistrationData(faker.name().fullName(),
                    faker.phoneNumber().phoneNumber());
        }

    }
}
