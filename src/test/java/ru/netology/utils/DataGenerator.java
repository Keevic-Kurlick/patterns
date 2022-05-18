package ru.netology.utils;

import com.github.javafaker.Faker;
import lombok.experimental.UtilityClass;
import ru.netology.entities.RegistrationInfo;

import java.util.Locale;

@UtilityClass
public class DataGenerator {

    @UtilityClass
    public static class Registration {

        public static RegistrationInfo generateByName(String locale) {
            Faker faker = new Faker(new Locale(locale));
            return new RegistrationInfo(faker.name().fullName(),
                    faker.phoneNumber().phoneNumber());
        }

        public static RegistrationInfo generateByName() {
            Faker faker = new Faker(new Locale("ru"));
            return new RegistrationInfo(faker.name().fullName(),
                    faker.phoneNumber().phoneNumber());
        }

        private RegistrationInfo user = generateByName();

        public String name() {
            return user.getName();
        }

        public String phone() {
            return user.getPhoneNumber();
        }
    }
}
