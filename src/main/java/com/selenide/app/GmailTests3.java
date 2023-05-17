package com.selenide.app;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.junit.Test;
import org.openqa.selenium.By;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;


public class GmailTests3 {

    @Test

    public void loginToGmail() {
        Selenide.sleep(2000);
        open("https://www.google.com/intl/ru/gmail/about/");

        // FROM MAIN PAGE CLICK BTN LOGIN
        String login_button = ".header__container a:nth-child(2)";
        $(login_button).shouldBe(enabled, Duration.ofSeconds(20)).click();

        if ($("#identifierId").isDisplayed()) {
            $("#identifierId").shouldBe(enabled, Duration.ofSeconds(10)).setValue("testforevertesting@gmail.com");
            $("#identifierNext").shouldBe(enabled, Duration.ofSeconds(10)).click();
            // INPUT PASSWORD
            $(".eEgeR input").shouldBe(enabled).setValue("123456789p#");
            $("#passwordNext").shouldBe(enabled).click();
        } else {
            // выбараем только логин для авторизации
            $("div.tgnCOd").shouldBe(enabled, Duration.ofSeconds(20)).click();
        }

    }

    @Test

    public void userMakeSignature() {
        String createSignatureButton = "button.P5";
        $(createSignatureButton).scrollIntoView(true);
        $(createSignatureButton).shouldBe(enabled, Duration.ofSeconds(100)).click();

        $("input.xx.nr").shouldBe(enabled, Duration.ofSeconds(30)).setValue("Отгадай кто?");
        $("button[name='ok']").shouldBe(enabled, Duration.ofSeconds(10)).click();
        Selenide.sleep(2000);
        $("tr.r7:nth-child(29)").scrollIntoView(true);
        $("tr.r7:nth-child(29) tr div.Am").setValue("Отгадай кто?");

        $("tr.r7:nth-child(29) label:nth-child(1) select").selectOptionContainingText("Отгадай кто?");
        $("tr.r7:nth-child(29) label:nth-child(2) select").selectOptionContainingText("Отгадай кто?");
        $("tr.r7:nth-child(29) input[type=\"checkbox\"]").setSelected(true);
        Selenide.sleep(5000);

        String saveSettingsButton = "tr.r7:nth-child(33) button:nth-child(1)";
        $(saveSettingsButton).scrollIntoView(true);
        $(saveSettingsButton).shouldBe(enabled, Duration.ofSeconds(20)).click();
        Selenide.sleep(7000);
    }
}