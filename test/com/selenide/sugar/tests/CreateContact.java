package com.selenide.sugar.tests;

import com.selenide.sugar.util.TestCase;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.disappears;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.hidden;
import java.lang.*;

public class CreateContact extends TestCase {
  @Test
  public void createContact() {
    $("#moduleTab_AllContacts").hover().shouldHave(text("Contacts"));
    $("#CreateContactAll").click();
    $($("#first_name")).waitUntil(visible, 20000).val("Djamshed");
     $("#last_name").val("Melikov");
    $("#Contacts0emailAddress0").val("Djamshed@example.com");
    $("#re_email_address").val("Djamshed@example.com");
    $("#SAVE_FOOTER").click();
  }

}
