package org.selenide.examples.gmail;

import org.junit.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;

public class NewMailSpec extends GmailTests {
  @Test
  public void userCanComposeEmail() {
    $(byText("COMPOSE")).click();
    waitUntilPagesIsLoaded();
    $(By.name("to")).val("andrei.solntsev@gmail.com").pressTab();
    $(by("placeholder", "Subject")).val("ConfetQA demo!").pressTab();

    $(".editable").val("Hello braza!").pressEnter();
    $(byText("Send")).click();

    $(withText("Your message has been sent.")).shouldBe(visible);
    $(byText("Undo")).click();
    $(byText("Sending has been undone.")).should(appear);

    $(".editable").should(appear).append("Hello from ConfetQA Selen").pressEnter().pressEnter();

    $(byText("Send")).click();
    $(withText("Your message has been sent.")).should(appear);
    $(byText("Undo")).waitUntil(disappears, 12000);

    assertUserCanSeeSentEmails();
  }

  private void assertUserCanSeeSentEmails() {
    $(byText("Sent Mail")).click();
    $(byText("ConfetQA demo!")).shouldBe(visible);
  }
}
