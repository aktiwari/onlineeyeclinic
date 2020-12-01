package com.cg.onlineeyeclinc.service;

import java.util.List;

import com.cg.onlineeyeclinc.dao.TestRepositoryImpl;
import com.cg.onlineeyeclinc.entity.Tests;
import com.cg.onlineeyeclinc.exeception.TestIdNotFoundException;

public class TestServiceImpl implements ITestService{
	
	private TestRepositoryImpl dao;
	
	public TestServiceImpl() {
		dao = new TestRepositoryImpl();
	}

	@Override
	public Tests addTest(Tests test) {
		dao.beginTransaction();
		dao.addTest(test);
		dao.commitTransaction();
		return test;
	}

	@Override
	public Tests updateTest(Tests test) {
		dao.beginTransaction();
		dao.updateTest(test);
		dao.commitTransaction();
		return test;
	}

	@Override
	public Tests removeTest(int testId){
		Tests test = null;
		dao.beginTransaction();
		
		try {
			test = dao.removeTest(testId);
				
			dao.removeTest(testId);
		} catch (TestIdNotFoundException e) {
			System.out.println(e);
		}
		
		dao.commitTransaction();
		
		return test;
	}

	@Override
	public Tests viewTest(int testId){
		Tests test = null;
		try {
			test = dao.viewTest(testId);
		} catch (TestIdNotFoundException e) {
			System.out.println(e);
		}
		return test;
	}

	@Override
	public List<Tests> viewAllTests() {
		List<Tests> allTests = dao.viewAllTests();
		return allTests;
	}

}
