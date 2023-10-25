package org.selenide.examples.gmail;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.selenide.examples.gmail.Highlighter.highlight;

import org.junit.Test;
import org.openqa.selenium.By;

import com.codeborne.selenide.SelenideElement;

public class DuckDuckGoTest {

  @Test
  public void checkHighlighting() {
    open("https://duckduckgo.com");
    SelenideElement element = $(By.name("q"));
    SelenideElement button = $("button[type=submit]");
    highlight(element, "orange");
    highlight(button, "green");
  }

}
