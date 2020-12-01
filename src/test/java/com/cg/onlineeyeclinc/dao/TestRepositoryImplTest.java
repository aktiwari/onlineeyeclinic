package com.cg.onlineeyeclinc.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.cg.onlineeyeclinc.entity.Tests;
import com.cg.onlineeyeclinc.exeception.TestIdNotFoundException;

class TestRepositoryImplTest {
	
	TestRepositoryImpl dao;

	@BeforeEach
	void setUp() throws Exception {
		dao = new TestRepositoryImpl();
	}

	@AfterEach
	void tearDown() throws Exception {
		dao = null;
	}

	@Test
	void testTestRepositoryImpl() {
		assertTrue(dao instanceof TestRepositoryImpl);;
	}

	@Test
	void testAddTest() {
		Tests test = new Tests("catract", "surgery", "eye operation", 12000.0);
		dao.beginTransaction();
		Tests t = dao.addTest(test);
		dao.commitTransaction();
		assertEquals(t.getTestName(), "catract");
	}

	@Test
	void testUpdateTest() {
		Tests test = new Tests("catract", "surgery", "eye operation", 12000.0);
		dao.beginTransaction();
		test = dao.addTest(test);
		dao.commitTransaction();
		
		test.setTestCost(15000.0);;
		
		dao.beginTransaction();
		test = dao.updateTest(test);
		dao.commitTransaction();
		
		assertEquals(test.getTestCost(), 15000.0);
	}

	@Test
	void testRemoveTest() throws TestIdNotFoundException {
		Tests test = new Tests("catract", "surgery", "eye operation", 12000.0);
		dao.beginTransaction();
		test = dao.addTest(test);
		test = dao.removeTest(test.getTestId());
		dao.commitTransaction();
		
		assertNull(test);
	}

	@Test
	void testViewTest() throws TestIdNotFoundException {
		Tests test = new Tests("catract", "surgery", "eye operation", 12000.0);
		dao.beginTransaction();
		test = dao.addTest(test);
		dao.commitTransaction();
		
		test = dao.viewTest(test.getTestId());
		
		assertNotNull(test);
	}

	@Test
	void testViewAllTests() {
		List<Tests> allTests = dao.viewAllTests();
		assertNotNull(allTests);
	}

}
