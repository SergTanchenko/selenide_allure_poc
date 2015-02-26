package com.stanchenko;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

import org.openqa.selenium.By;

public class GooglePage {
	public SearchResultsPage searchFor(String text) {
		$(By.name("q")).val(text).pressEnter();
		return page(SearchResultsPage.class);
	}
}
