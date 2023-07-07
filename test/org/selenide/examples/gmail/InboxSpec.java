package org.selenide.examples.gmail;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.by;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

import org.junit.Test;

public class InboxSpec extends GmailTests {
  @Test
  public void showsNumberOfUnreadMessages() {
    $("div[role='navigation'] *[aria-label^='Inbox']")
        .shouldBe(visible)
        .shouldHave(attribute("aria-label", "Inbox 1 unread"));
  }

  @Test
  public void inboxShowsUnreadMessages() {
    $$(byText("Gmail Team")).filter(visible).shouldHave(size(1));
    $$(byText("Pivotal Tracker")).filter(visible).shouldHave(size(1));
  }

  @Test
  public void userCanRefreshMessages() {
    $(by("title", "Refresh")).click();
  }
}
