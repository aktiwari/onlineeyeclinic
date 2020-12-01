package com.cg.onlineeyeclinc.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.cg.onlineeyeclinc.entity.Tests;

class TestServiceImplTest {

	TestServiceImpl service;
	
	@BeforeEach
	void setUp() throws Exception {
		service = new TestServiceImpl();
	}

	@AfterEach
	void tearDown() throws Exception {
		service = null;
	}

	@Test
	void testTestServiceImpl() {
		assertTrue(service instanceof TestServiceImpl);
	}

	@Test
	void testAddTest() {
		Tests test = new Tests("catract", "surgery", "eye operation", 12000.0);
		test = service.addTest(test);
		assertEquals(test.getTestName(), "catract");
	}

	@Test
	void testUpdateTest() {
		Tests t = new Tests("catract", "surgery", "eye operation", 12000.0);
		t = service.addTest(t);
		t.setTestCost(15000.0);
		t = service.updateTest(t);
		assertEquals(t.getTestCost(), 15000.0);
	}

	@Test
	void testRemoveTest() {
		Tests test = new Tests("catract", "surgery", "eye operation", 12000.0);
		test = service.addTest(test);
		test = service.removeTest(test.getTestId());
		assertNull(test);
	}

	@Test
	void testViewTest() {
		Tests test = new Tests("catract", "surgery", "eye operation", 12000.0);
		test = service.addTest(test);
		Tests tests = service.viewTest(test.getTestId());
		assertNotNull(tests);
	}

	@Test
	void testViewAllTests() {
		List<Tests> test = service.viewAllTests();
		assertNotNull(test);
	}

}
