package com.cg.onlineeyeclinc.dao;

import static org.junit.Assert.assertNotNull;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.Test;

class JPAUtilTest {
	
	EntityManager em = null;


	@Test
	void testGetEntityManager() {
		em = JPAUtil.getEntityManager();
		assertNotNull(em);
	}

}
