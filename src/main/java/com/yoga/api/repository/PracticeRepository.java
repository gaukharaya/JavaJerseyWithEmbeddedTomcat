package com.yoga.api.repository;

import com.yoga.api.model.Practice;
import com.yoga.api.model.PracticeSearch;

import java.util.List;

public interface PracticeRepository {

	List<Practice> findAllPractices();

	Practice findPractice(String practiceId);

	void create(Practice practice);

	Practice update(Practice practice);

	void delete(String practiceId);

	List<Practice> findByDescription(List<String> descriptions, int durationFrom, int durationTo);

	List<Practice>  findByConstraints(PracticeSearch search);

}