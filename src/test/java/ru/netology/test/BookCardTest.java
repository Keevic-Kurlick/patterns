package ru.netology.test;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;


public class BookCardTest {

    @Test
    void shouldBookCard() {
        Configuration.holdBrowserOpen=true;

        open("http://localhost:9999");
        $x("//input[@placeholder =\"Город\"]").setValue("Москва");
        $x("//input [@placeholder = \"Дата встречи\"]").setValue("19.05.2022");
        $x("//span[@data-test-id = \"name\"]//input").setValue("Макаров Иван");
        $x("//span[@data-test-id = \"phone\"]//input").setValue("+79999999999");
        $x("//span[@class = \"checkbox__box\"]").click();
        $x("//button[contains(@class, \"button_view_extra\")]").click();
        $(withText("Успешно")).should(visible, Duration.ofSeconds(15));
        $(byText("19.05.2022")).should(visible);
    }
}
