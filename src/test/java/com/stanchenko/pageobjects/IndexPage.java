package com.stanchenko.pageobjects;

import static com.codeborne.selenide.Selenide.page;

/**
 * (c) Swissquote 26.05.15
 *
 * @author Sergii Tanchenko (o_stanch)
 */
public class IndexPage {

	public Workspace getWorkspace() {
		return page(Workspace.class);
	}
}
