package com.cg.onlineeyeclinc.dao;

import java.util.List;

import com.cg.onlineeyeclinc.entity.Tests;
import com.cg.onlineeyeclinc.exeception.TestIdNotFoundException;

public interface ITestRepository {
	Tests addTest(Tests test);

	Tests updateTest(Tests test);

	Tests removeTest(int testId) throws TestIdNotFoundException;

	Tests viewTest(int testId) throws TestIdNotFoundException;

	List<Tests> viewAllTests();
	
	void beginTransaction();
	void commitTransaction();
}
