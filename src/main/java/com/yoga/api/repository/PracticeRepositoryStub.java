package com.yoga.api.repository;


import com.yoga.api.model.Practice;
import com.yoga.api.model.PracticeSearch;
import com.yoga.api.model.User;

import java.util.ArrayList;
import java.util.List;

public class PracticeRepositoryStub implements PracticeRepository {

	@Override
	public List<Practice> findByConstraints(PracticeSearch search) {
		
		System.out.println(search.getDurationTo());
		System.out.println(search.getSearchType());
		
		List<Practice> practices = new ArrayList<Practice>();

		Practice practice = new Practice();
		practice.setId("2345");
		practice.setDescription("Bikram");
		practice.setDuration(55);
		
		practices.add(practice);
		
		return practices;
	}
	
	@Override
	public List<Practice> findByDescription(List<String> descriptions, int durationFrom, int durationTo) {
		// select * from practices where description in (?,?,?) and duration > ? and duration < ?
		
		List<Practice> practices = new ArrayList<Practice>();
		
		Practice practice = new Practice();
		practice.setId("2345");
		practice.setDescription("Ashtanga");
		practice.setDuration(55);
		
		practices.add(practice);
		
		return practices;
	}
	
	@Override
	public void create(Practice practice) {
		//should issue a insert statement to the db
	}
	
	@Override
	public void delete(String practiceId) {
		//delete from Practice where Practiceid = ?
	}
	
	@Override
	public Practice update(Practice practice) {
		//search the database to see if we have an practice with that id already
		//select * from practice where id = ?
		//if rs size == 0
		//insert into practice table
		//else
		//update the practice
		
		return practice;
	}
	
	public List<Practice> findAllPractices() {
		List<Practice> practices = new ArrayList<Practice>();

		Practice practice1 = new Practice();
		
		practice1.setDescription("Hatha");
		practice1.setDuration(80);
		
		practices.add(practice1);
		
		Practice practice2 = new Practice();
		
		practice2.setDescription("Vinyasa");
		practice2.setDuration(60);
		
		practices.add(practice2);
		
		return practices;
	}
	
	@Override
	public Practice findPractice(String practiceId) {
		
		if(practiceId.equals("7777")) {
			return null;
		}
		
		Practice practice1 = new Practice();
		
		practice1.setId("1234");
		practice1.setDescription("Hatha");
		practice1.setDuration(90);
		
		User user = new User();
		user.setId("5678");
		user.setName("Gaukhar");
		
		practice1.setUser(user);

		return practice1;
	}
	
}
