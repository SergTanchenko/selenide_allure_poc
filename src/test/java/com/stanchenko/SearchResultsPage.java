package com.stanchenko;

import static com.codeborne.selenide.Selenide.$$;

import com.codeborne.selenide.ElementsCollection;

public class SearchResultsPage {
	public ElementsCollection getResults() {
		return $$("#ires li.g");
	}
}
