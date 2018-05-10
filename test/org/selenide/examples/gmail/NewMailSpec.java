package org.selenide.examples.gmail;

import org.junit.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static org.selenide.examples.gmail.Highlighter.highlight;

public class NewMailSpec extends GmailTests {
  @Test
  public void userCanComposeEmail() {
    $(byText("COMPOSE")).click();
    waitUntilPagesIsLoaded();
    $(By.name("to")).val("andrei.solntsev@gmail.com").pressTab();
    $(by("placeholder", "Subject")).val("GeeCon demo").pressTab();

    $(".editable").val("We are not afraid of ajax anymore.").pressEnter();
    $(byText("Send")).click();

    $(withText("Your message has been sent.")).shouldBe(visible);
    $(byText("Undo")).click();
    // highlight($(byText("Sending has been undone.")).should(appear));

    $(".editable").should(appear)
        .append("Hello from Kraków")
        .pressEnter()
        .pressEnter();

    $(byText("Send")).click();
    highlight($(withText("Your message has been sent.")).should(appear));
    highlight($(byText("Undo")).should(appear)).waitUntil(disappears, 12000);

    assertUserCanSeeSentEmails();
  }

  private void assertUserCanSeeSentEmails() {
    $(byText("Sent Mail")).click();
    highlight($(byText("GeeCon demo")).shouldBe(visible));
  }
}
