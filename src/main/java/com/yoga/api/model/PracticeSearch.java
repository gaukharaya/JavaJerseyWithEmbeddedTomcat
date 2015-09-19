package com.yoga.api.model;

import java.util.List;

public class PracticeSearch {

	private int durationFrom;
	private int durationTo;
	
	private List<String> descriptions;
	
	private PracticeSearchType searchType;

	public PracticeSearchType getSearchType() {
		return searchType;
	}

	public void setSearchType(PracticeSearchType searchType) {
		this.searchType = searchType;
	}

	public List<String> getDescriptions() {
		return descriptions;
	}

	public int getDurationFrom() {
		return durationFrom;
	}

	public int getDurationTo() {
		return durationTo;
	}

	public void setDescriptions(List<String> descriptions) {
		this.descriptions = descriptions;
	}

	public void setDurationFrom(int durationFrom) {
		this.durationFrom = durationFrom;
	}

	public void setDurationTo(int durationTo) {
		this.durationTo = durationTo;
	}
	
}
