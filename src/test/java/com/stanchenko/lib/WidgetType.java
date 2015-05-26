package com.stanchenko.lib;

/**
 * (c) Swissquote 26.05.15
 *
 * @author Sergii Tanchenko (o_stanch)
 */
public enum WidgetType {

	SEARCH("Search", ""), PERSONAL_LIST("Personal List", ".quotelist[data-type='QuoteList']");

	private String widgetName;
	private String selector;

	private WidgetType(String filterName, String selector) {
		this.widgetName = filterName;
		this.selector = selector;
	}

	public static WidgetType get(String widgetName) {
		for (WidgetType searchType : WidgetType.values()) {
			if (widgetName.equalsIgnoreCase(searchType.getWidgetName())) {
				return searchType;
			}
		}
		throw new IllegalArgumentException(String.format("'%s' value is not supported.", widgetName));
	}

	public String getWidgetName() {
		return widgetName;
	}

	public String getSelector() {
		return selector;
	}
}

