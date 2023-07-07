package org.selenide.examples.gmail;

import static com.codeborne.selenide.Condition.disappear;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Configuration.browser;
import static com.codeborne.selenide.Configuration.browserPosition;
import static com.codeborne.selenide.Configuration.browserSize;
import static com.codeborne.selenide.Configuration.timeout;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.addListener;
import static com.codeborne.selenide.WebDriverRunner.closeWebDriver;

import java.time.Duration;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.openqa.selenium.chrome.ChromeOptions;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.junit.ScreenShooter;

public abstract class GmailTests {
  private static final String gmailUsername = System.getProperty("gmail.username", "enter-your-gmail-username");
  private static final String gmailPassword = System.getProperty("gmail.password", "enter-your-gmail-password");

  @Rule
  public ScreenShooter screenShooter = ScreenShooter.failedTests();

  @BeforeClass
  public static void openInbox() {
    Configuration.browserCapabilities = new ChromeOptions()
      .addArguments("--disable-blink-features=AutomationControlled");

    timeout = 10000;
    baseUrl = "http://gmail.com";
    browser = "chrome";
    browserPosition = "890x10";
    browserSize = "780x950";
    addListener(new Highlighter());
    
    open("/");
    login();
    waitUntilPagesIsLoaded();
  }

  protected static void waitUntilPagesIsLoaded() {
    $(byText("Loading")).should(disappear, Duration.ofSeconds(20));
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
