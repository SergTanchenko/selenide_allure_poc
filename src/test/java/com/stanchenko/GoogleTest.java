package com.stanchenko;

import com.stanchenko.lib.AbstractTest;
import org.junit.Test;
import ru.yandex.qatools.allure.annotations.Stories;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.open;

public class GoogleTest extends AbstractTest {

	@Stories("Google Search")
	@Test
	public void userCanSearch() {
		GooglePage page = open("http://google.com", GooglePage.class);
		SearchResultsPage results = page.searchFor("Selenide: concise UI tests in Java");
		results.getResults().get(0).shouldHave(text("Selenide: concise UI tests in Java"));
	}
}
