package com.stanchenko.pageobjects;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import ru.yandex.qatools.allure.annotations.Step;

/**
 * (c) Swissquote 26.05.15
 *
 * @author Sergii Tanchenko (o_stanch)
 */
public class SearchExpander extends PersonalListWidget {
	private final static String CSS_SEARCH_EXPANDER = ".searchExpander";
	private final static String CSS_SEARCH_INSTRUMENT_FIELD = "input[type = 'text']";
	private final static String CSS_INSTRUMENT_NAME = ".column1U3";

	@Step
	public SearchExpander doSearchFor(String instrumentToSearch) {
		getSearchExpander().$(CSS_SEARCH_INSTRUMENT_FIELD)
			// enter the value
			.val(instrumentToSearch);
		return this;
	}

	@Step
	public ElementsCollection getResults() {
		return $$(CSS_INSTRUMENT_NAME);
	}

	private SelenideElement getSearchExpander() {
		return $(CSS_SEARCH_EXPANDER).shouldBe(visible);
	}
}
