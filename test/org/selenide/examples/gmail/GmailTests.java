package org.selenide.examples.gmail;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.junit.ScreenShooter;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;

import static com.codeborne.selenide.Condition.disappears;
import static com.codeborne.selenide.Configuration.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.executeJavaScript;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.addListener;
import static com.codeborne.selenide.WebDriverRunner.closeWebDriver;

public abstract class GmailTests {
  private static String gmailUsername = System.getProperty("gmail.username", "enter-your-gmail-username");
  private static String gmailPassword = System.getProperty("gmail.password", "enter-your-gmail-password");

  @Rule
  public ScreenShooter screenShooter = ScreenShooter.failedTests();

  @BeforeClass
  public static void openInbox() {
    timeout = 10000;
    baseUrl = "http://gmail.com";
    startMaximized = false;
    browser = "chrome";
    browserPosition = "890x10";
    browserSize = "780x950";
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
    $("#identifierId").val(gmailUsername).pressEnter();
    $("#password input").val(gmailPassword).pressEnter();
  }
}
