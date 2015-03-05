package com.stanchenko;

import com.codeborne.selenide.ElementsCollection;
import ru.yandex.qatools.allure.annotations.Step;

import static com.codeborne.selenide.Selenide.$$;

public class SearchResultsPage {
	@Step
	public ElementsCollection getResults() {
		return $$("#ires li.g");
	}
}
