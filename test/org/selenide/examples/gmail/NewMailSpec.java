package org.selenide.examples.gmail;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.disappear;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.by;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static org.selenide.examples.gmail.Highlighter.highlight;

import java.time.Duration;

import org.junit.Test;
import org.openqa.selenium.By;

import com.codeborne.selenide.SelenideElement;

public class NewMailSpec extends GmailTests {
  @Test
  public void userCanComposeEmail() {
    $(byText("Compose")).click();
    waitUntilPagesIsLoaded();
    $(By.name("to")).find("input").val("andrei.solntsev@gmail.com").pressTab();
    $(by("placeholder", "Subject")).val("GeeCon demo").pressTab();

    $(".editable").val("We are not afraid of ajax anymore.").pressEnter();
    $(byText("Send")).click();

    $(withText("Message sent")).shouldBe(visible);
    SelenideElement undo = $(byText("Undo"));
    undo.click();
    highlight($(byText("Sending undone.")).should(appear));

    $(".editable").should(appear)
        .append("Hello from Kraków")
        .pressEnter()
        .pressEnter();

    $(byText("Send")).click();
    highlight($(withText("Message sent")).should(appear));
    undo.should(appear);
    highlight(undo);
    undo.should(disappear, Duration.ofSeconds(12));

    assertUserCanSeeSentEmails();
  }

  private void assertUserCanSeeSentEmails() {
    $(byText("Sent")).click();
    highlight($(byText("GeeCon demo")).shouldBe(visible));
  }
}
