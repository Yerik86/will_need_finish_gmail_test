package com.selenide.app;


import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

import java.time.Duration;

import com.codeborne.selenide.SelenideElement;
import org.junit.After;
import org.junit.Test;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;


public class GmailTests4 {

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

    public void userWillSentMail() {
        SelenideElement $ = $("div.T-I.T-I-KE.L3");
        $.shouldBe(enabled, Duration.ofSeconds(50));
        $.click();
        $x("//input[@id=':17g']").shouldBe(enabled, Duration.ofSeconds(20)).setValue("e.sarsenbekov@gmail.com");
        //$("BbVjBd").shouldBe(enabled, Duration.ofSeconds(10)).setValue("e.sarsenbekov@gmail.com");
        $(".Am.Al.editable.LW-avf").shouldBe(enabled, Duration.ofSeconds(10)).setValue("Думай, что говоришь, и говори, что думаешь.");
        $("div.T-I.J-J5-Ji.aoO.v7.T-I-atl.L3").shouldBe(enabled, Duration.ofSeconds(10)).click();
    }
}