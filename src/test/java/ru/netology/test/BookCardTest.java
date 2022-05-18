package ru.netology.test;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;
import ru.netology.entities.RegistrationData;
import ru.netology.utils.DataGenerator;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static com.codeborne.selenide.Condition.ownText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;


public class BookCardTest {
    private RegistrationData user;

    private String generateDate(int daysPeriod) {
        return (LocalDate.now()
                .plusDays(daysPeriod)
                .format(DateTimeFormatter.ofPattern("dd.MM.yyyy")));
    }

    @BeforeEach
    void setUp(){
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
        $x("//input[@placeholder =\"Город\"]").setValue("Москва");
        $x("//input [@placeholder = \"Дата встречи\"]").sendKeys(Keys.CONTROL + "A");
        $x("//input [@placeholder = \"Дата встречи\"]").sendKeys(Keys.BACK_SPACE);
        $x("//input [@placeholder = \"Дата встречи\"]").setValue(generateDate(3));
        $x("//span[@data-test-id = \"name\"]//input").setValue(user.getName());
        $x("//input[@placeholder = \"+7 000 000 00 00\"]").setValue(user.getPhoneNumber());
        $x("//span[@class = \"checkbox__box\"]").click();
        $x("//*[text() = \"Запланировать\"]").click();

        $(withText("Успешно!")).should(visible);
        $(".notification__content").should(ownText(generateDate(3)));
    }

    @Test
    void shouldBookCardWithProperValuesSecondTimeGen() {
        $x("//input[@placeholder =\"Город\"]").setValue("Москва");
        $x("//input [@placeholder = \"Дата встречи\"]").sendKeys(Keys.CONTROL + "A");
        $x("//input [@placeholder = \"Дата встречи\"]").sendKeys(Keys.BACK_SPACE);
        $x("//input [@placeholder = \"Дата встречи\"]").setValue(generateDate(3));
        $x("//span[@data-test-id = \"name\"]//input").setValue(user.getName());
        $x("//input[@placeholder = \"+7 000 000 00 00\"]").setValue(user.getPhoneNumber());
        $x("//span[@class = \"checkbox__box\"]").click();
        $x("//*[text() = \"Запланировать\"]").click();

        $(withText("Успешно!")).should(visible, Duration.ofSeconds(15));
        $$(".notification__content").filter(visible).first().should(ownText(generateDate(3)));
        $x("//*[text() = \"Запланировать\"]").click();
        $(withText("Необходимо подтверждение")).should(visible, Duration.ofSeconds(3));
        $(".notification__content button").click();
        $$(".notification__content").filter(visible).last().should(ownText(generateDate(3)));

    }
}
