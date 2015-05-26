package com.stanchenko.pageobjects;

import static com.codeborne.selenide.Condition.present;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

import com.stanchenko.lib.WidgetType;

import ru.yandex.qatools.allure.annotations.Step;

/**
 * (c) Swissquote 26.05.15
 *
 * @author Sergii Tanchenko (o_stanch)
 */
public class Workspace {

	@Step
	public PersonalListWidget getPersonalListWidget() {
		$(WidgetType.PERSONAL_LIST.getSelector()).shouldBe(present);
		return page(PersonalListWidget.class);
	}
}
