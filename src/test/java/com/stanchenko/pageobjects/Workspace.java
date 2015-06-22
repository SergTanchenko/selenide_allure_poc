package com.stanchenko.pageobjects;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

import ru.yandex.qatools.allure.annotations.Step;

/**
 * (c) Swissquote 26.05.15
 *
 * @author Sergii Tanchenko (o_stanch)
 */
public class Workspace {

	@Step
	public PersonalListWidget getPersonalListWidget() {
		$(".quotelist[data-type='QuoteList']").$$("table tr td").filter(text("Abb"));

		return page(PersonalListWidget.class);
	}
}
