package com.stanchenko;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.open;

import org.junit.Test;

import com.stanchenko.lib.AbstractTest;

public class GoogleTest extends AbstractTest {


	@Test
	public void userCanSearch() {
		GooglePage page = open("http://google.com", GooglePage.class);
		SearchResultsPage results = page.searchFor("selenide");
		results.getResults().get(0).shouldHave(text("Selenide: concise UI tests in Java"));
	}


}
