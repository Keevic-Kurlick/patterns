package ru.netology.elements;

import org.openqa.selenium.Keys;
import ru.netology.entities.RegistrationData;
import ru.netology.utils.DataGenerator;

import static com.codeborne.selenide.Selenide.$x;

public class Login {
    public static void login(RegistrationData user, int days) {
        $x("//input[@placeholder =\"Город\"]").setValue(user.getCity());
        $x("//input [@placeholder = \"Дата встречи\"]").sendKeys(Keys.CONTROL + "A");
        $x("//input [@placeholder = \"Дата встречи\"]").sendKeys(Keys.BACK_SPACE);
        $x("//input [@placeholder = \"Дата встречи\"]").setValue(DataGenerator.DateGenerator.addDaysToCurrentDate(days));
        $x("//span[@data-test-id = \"name\"]//input").setValue(user.getName());
        $x("//input[@placeholder = \"+7 000 000 00 00\"]").setValue(user.getPhoneNumber());
        $x("//span[@class = \"checkbox__box\"]").click();
        $x("//*[text() = \"Запланировать\"]").click();
    }
}
