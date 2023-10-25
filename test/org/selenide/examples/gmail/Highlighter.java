package org.selenide.examples.gmail;

import static com.codeborne.selenide.Selenide.executeJavaScript;
import static com.codeborne.selenide.Selenide.sleep;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverListener;

public class Highlighter implements WebDriverListener {

  @Override public void beforeClick(WebElement element) {
    highlight(element, "orange");
  }

  @Override public void afterFindElement(WebDriver driver, By locator, WebElement element) {
    highlight(element, "green");
  }

  @Override public void beforeSendKeys(WebElement element, CharSequence... keysToSend) {
    highlight(element, "orange");
  }

  public static <T extends WebElement> T highlight(T element) {
    return highlight(element, "orange");
  }

  public static <T extends WebElement> T highlight(T element, final String color) {
    if (element != null && element.getAttribute("__selenideHighlighting") == null) {
      for (int i = 1; i < 4; i++) {
        transform(element, color, i);
        sleep(150);
      }
      for (int i = 4; i > 0; i--) {
        transform(element, color, i);
        sleep(150);
      }
    }
    return element;
  }

  private static void transform(WebElement element, String color, int i) {
    executeJavaScript(
        "arguments[0].setAttribute('__selenideHighlighting', 'done'); " + 
        "arguments[0].setAttribute(arguments[1], arguments[2])",
        element,
        "style",
        "border: " + i + "px solid " + color + "; border-style: dotted; " +
        "transform: scale(1, 1." + i + ");");
  }
}
