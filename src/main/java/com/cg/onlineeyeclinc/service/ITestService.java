package com.cg.onlineeyeclinc.service;

import java.util.List;

import com.cg.onlineeyeclinc.entity.Tests;

public interface ITestService {
	Tests addTest(Tests test);

	Tests updateTest(Tests test);

	Tests removeTest(int testId);

	Tests viewTest(int testId);

	List<Tests> viewAllTests();
}
