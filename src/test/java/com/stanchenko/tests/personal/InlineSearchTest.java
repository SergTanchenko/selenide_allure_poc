package com.stanchenko.tests.personal;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.open;

import org.junit.Test;

import com.stanchenko.lib.AbstractTest;
import com.stanchenko.pageobjects.Workspace;

import ru.yandex.qatools.allure.annotations.Stories;
import ru.yandex.qatools.allure.annotations.Title;

/**
 * (c) Swissquote 26.05.15
 *
 * @author Sergii Tanchenko (o_stanch)
 */
public class InlineSearchTest extends AbstractTest {

	private final static String LINK_TO_WS = "http://esen2344:@localhost:8060/sqi_fox/index.action";

	@Stories("Personal list")
	@Title("When user searches for product then it appears in the search expander")
	@Test
	public void userCanSearch() {
		final String searchText = "abbn";

		open(LINK_TO_WS, Workspace.class)
			.getPersonalListWidget()
			.doClickOnAddSymbolButton()
			.doSearchFor(searchText)
			.getResults().get(1)
			.shouldHave(text(searchText));
	}

	@Stories("Personal list")
	@Title("Failed test")
	@Test
	public void userCanNotSearch() {
		final String searchText = "abbn";

		open(LINK_TO_WS, Workspace.class)
			.getPersonalListWidget()
			.doClickOnAddSymbolButton()
			.doSearchFor(searchText)
			.getResults().shouldBe(size(50));
	}
}

