package com.cg.onlineeyeclinc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.cg.onlineeyeclinc.entity.Tests;
import com.cg.onlineeyeclinc.exeception.TestIdNotFoundException;

public class TestRepositoryImpl implements ITestRepository{
	
	private EntityManager entityManager;
	
	public TestRepositoryImpl() {
		entityManager = JPAUtil.getEntityManager();
	}

	@Override
	public Tests addTest(Tests test) {
		entityManager.persist(test);
		return test;
	}

	@Override
	public Tests updateTest(Tests test) {
		Tests tests = entityManager.find(Tests.class, test.getTestId());
		entityManager.merge(tests);
		return tests;
	}

	@Override
	public Tests removeTest(int testId) throws TestIdNotFoundException {
		Tests test = entityManager.find(Tests.class, testId);
		if(test == null)
			throw new TestIdNotFoundException("Test Not Found");
		
		entityManager.remove(test);
		test = null;
		return test;
	}

	@Override
	public Tests viewTest(int testId) throws TestIdNotFoundException {
		Tests test = entityManager.find(Tests.class, testId);
		if(test == null)
			throw new TestIdNotFoundException("Test Not Found");
		
		return test;
	}

	@Override
	public List<Tests> viewAllTests() {
		TypedQuery<Tests> query = entityManager.createQuery("select t from Tests t", Tests.class);
		List<Tests> allTests = query.getResultList();
		return allTests;
	}

	@Override
	public void beginTransaction() {
		entityManager.getTransaction().begin();
		
	}

	@Override
	public void commitTransaction() {
		entityManager.getTransaction().commit();
		
	}

}
