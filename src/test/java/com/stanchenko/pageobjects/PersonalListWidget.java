package com.stanchenko.pageobjects;

import static com.codeborne.selenide.Selenide.page;

import ru.yandex.qatools.allure.annotations.Step;

/**
 * (c) Swissquote 26.05.15
 *
 * @author Sergii Tanchenko (o_stanch)
 */
public class PersonalListWidget extends AbstractWidget {

	@Step
	public SearchExpander doClickOnAddSymbolButton() {

		return page(SearchExpander.class);
	}
}
