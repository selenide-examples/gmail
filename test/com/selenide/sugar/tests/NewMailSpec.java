package com.selenide.sugar.tests;

import org.junit.Test;
import org.openqa.selenium.By;
import org.junit.Ignore;
import com.selenide.sugar.util.TestCase;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.selenide.sugar.util.Highlighter.highlight;

public class NewMailSpec extends TestCase {
  @Ignore
  public void userCanComposeEmail() {
    $(byText("COMPOSE")).click();
    waitUntilPagesIsLoaded();
    $(By.name("to")).val("andrei.solntsev@gmail.com").pressTab();
    $(by("placeholder", "Subject")).val("ConfetQA demo!").pressTab();

    $(".editable").val("Hello braza!").pressEnter();
    $(byText("Send")).click();

    $(withText("Your message has been sent.")).shouldBe(visible);
    $(byText("Undo")).click();
    // highlight($(byText("Sending has been undone.")).should(appear));

    $(".editable").should(appear).append("Hello from ConfetQA Selen").pressEnter().pressEnter();

    $(byText("Send")).click();
    highlight($(withText("Your message has been sent.")).should(appear));
    highlight($(byText("Undo")).should(appear)).waitUntil(disappears, 12000);

    assertUserCanSeeSentEmails();
  }

  private void assertUserCanSeeSentEmails() {
    $(byText("Sent Mail")).click();
    highlight($(byText("ConfetQA demo!")).shouldBe(visible));
  }
}
