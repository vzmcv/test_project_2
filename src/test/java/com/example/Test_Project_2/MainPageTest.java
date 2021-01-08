package com.example.Test_Project_2;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MainPageTest {

    @BeforeAll
    public static void setUpAllure() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @BeforeEach
    public void setUp() {
        Configuration.startMaximized = true;
        open("https://www.google.com/");
    }

    @Test
    public void search() {

        $(byTitle("Search")).sendKeys(("Selenium practice"));

        $(byXpath("//*[@type='submit']")).shouldHave(attribute("value", "Google Search")).click();

        $(byId("center_col")).findElement(byXpath("//*[@href='https://www.seleniumeasy.com/test/']")).click();


    }

}
