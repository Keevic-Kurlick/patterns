package ru.netology.test;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static com.codeborne.selenide.Condition.ownText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;


public class BookCardTest {
    private final int daysArea = 5;
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
    private final LocalDate date = LocalDate.now();
    private final LocalDate acceptableDate = date.plusDays(daysArea);
    private final String finalDate = (acceptableDate.format(formatter));

    @Test
    void shouldBookCardWithProperValues() {
        Configuration.holdBrowserOpen = true;
        open("http://localhost:9999");

        $x("//input[@placeholder =\"Город\"]").setValue("Москва");
        $x("//input [@placeholder = \"Дата встречи\"]").sendKeys(Keys.CONTROL + "A");
        $x("//input [@placeholder = \"Дата встречи\"]").sendKeys(Keys.BACK_SPACE);
        $x("//input [@placeholder = \"Дата встречи\"]").setValue(finalDate);
        $x("//span[@data-test-id = \"name\"]//input").setValue("Макаров Иван");
        $x("//span[@data-test-id = \"phone\"]//input").setValue("+79999999999");
        $x("//span[@class = \"checkbox__box\"]").click();
        $x("//*[text() = \"Забронировать\"]").click();

        $(withText("Успешно!")).should(visible, Duration.ofSeconds(15));
        $(".notification__content").should(ownText(finalDate));
    }
}
