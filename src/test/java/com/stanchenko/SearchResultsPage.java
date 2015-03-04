package com.stanchenko;

import static com.codeborne.selenide.Selenide.$$;

import com.codeborne.selenide.ElementsCollection;

import ru.yandex.qatools.allure.annotations.Step;

public class SearchResultsPage {
	@Step
	public ElementsCollection getResults() {
		return $$("#ires li.g");
	}
}
