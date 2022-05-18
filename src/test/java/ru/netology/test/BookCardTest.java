package ru.netology.test;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.elements.Login;
import ru.netology.entities.RegistrationData;
import ru.netology.utils.DataGenerator;
import ru.netology.utils.DateGenerator;

import java.time.Duration;


import static com.codeborne.selenide.Condition.ownText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;


public class BookCardTest {
    private RegistrationData user;

    @BeforeEach
    void setUp() {
        Configuration.holdBrowserOpen = true;
        open("http://localhost:9999");
        this.user = DataGenerator.RegistrationInfoGenerator.generateByName("ru");
    }

    @AfterEach
    void tearDown() {
        this.user = null;
    }

    @Test
    void shouldBookCardWithProperValuesDataGen() {
        Login.login(user, 3);

        $(withText("Успешно!")).should(visible);
        $(".notification__content").should(ownText(DateGenerator.addDaysToCurrentDate(3)));
    }

    @Test
    void shouldBookCardWithProperValuesSecondTimeGen() {
        Login.login(user, 3);

        $(withText("Успешно!")).should(visible, Duration.ofSeconds(15));
        $$(".notification__content").filter(visible).first().should(ownText(DateGenerator.addDaysToCurrentDate(3)));
        $x("//*[text() = \"Запланировать\"]").click();
        $(withText("Необходимо подтверждение")).should(visible, Duration.ofSeconds(3));
        $(".notification__content button").click();
        $$(".notification__content").filter(visible).last().should(ownText(DateGenerator.addDaysToCurrentDate(3)));

    }
}
