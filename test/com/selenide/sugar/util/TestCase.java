package com.selenide.sugar.util;

import com.codeborne.selenide.junit.ScreenShooter;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;

import static com.codeborne.selenide.Condition.disappears;
import static com.codeborne.selenide.Configuration.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.addListener;
import static com.codeborne.selenide.WebDriverRunner.closeWebDriver;

public abstract class TestCase {
  @Rule
  public ScreenShooter screenShooter = ScreenShooter.failedTests();

  @BeforeClass
  public static void openInbox() {
    timeout = 10000;
    baseUrl = System.getProperty("sugar.baseUrl");
    startMaximized = false;
    addListener(new Highlighter());
    
    open("/");
    login();
    waitUntilPagesIsLoaded();
  }

  protected static void waitUntilPagesIsLoaded() {
    $(byText("Loading")).waitUntil(disappears, 20000);
  }

  @AfterClass
  public static void logout() {
    closeWebDriver();
  }

  private static void login() {
    $("#user_name").val(System.getProperty("sugar.username", "admin"));
    $("#user_password").val(System.getProperty("sugar.password", "admin"));
    $("#login_button").click();
    /*$("#Email").val(System.getProperty("sugar.username", "admin"));
    $("#next").click();
    $("#Passwd").val(System.getProperty("sugar.password", "admin"));
    $("#signIn").click();*/
    $(".error-msg").waitUntil(disappears, 2000);
  }
}
