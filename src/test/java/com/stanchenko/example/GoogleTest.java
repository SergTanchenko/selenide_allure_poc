package com.stanchenko.example;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.open;

import org.junit.Ignore;
import org.junit.Test;

import com.stanchenko.lib.AbstractTest;

import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Stories;

public class GoogleTest extends AbstractTest {

	@Ignore
	@Stories("Google Search")
	@Test
	@Description("Test google search")
	public void userCanSearch() {
		open("http://google.com", GooglePage.class)
			.searchFor("Selenide: concise UI tests in Java")
			.getResults().get(0).shouldHave(text("Selenide: concise UI tests in Java"));
	}
}
