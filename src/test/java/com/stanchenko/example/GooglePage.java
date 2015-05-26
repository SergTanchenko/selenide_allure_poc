package com.stanchenko.example;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

import org.openqa.selenium.By;

import ru.yandex.qatools.allure.annotations.Step;

public class GooglePage {
	@Step
	public SearchResultsPage searchFor(String text) {
		$(By.name("q")).val(text).pressEnter();
		return page(SearchResultsPage.class);
	}
}
