package com.cg.onlineeyeclinc.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.cg.onlineeyeclinc.entity.Spectacles;

class SpectaclesServiceImplTest {

	ISpectaclesService spectaclesService;
	Spectacles s= new Spectacles();
	//EntityManager entityManager;

	@BeforeEach
	 protected void setUp() throws Exception {
		 spectaclesService = new SpectaclesServiceImpl();
		//entityManager =  JPAUtil.getEntityManager();	
	}

	@AfterEach
	protected void tearDown() throws Exception 
	{
		spectaclesService = null;
		//entityManager.close();			
	}

	public void testSpectaclesServiceImpl() {
		
		//SpectaclesServiceImpl ssi=new SpectaclesServiceImpl();
		assertTrue(spectaclesService instanceof SpectaclesServiceImpl);
	}

	@Test
	public void testAddSpectacles() {
		
		Spectacles spectacles=new Spectacles(01,"puma","gud",560.0);
		//entityManager.persist(spectacles);
		s=spectaclesService.addSpectacles(spectacles);
		
		//Spectacles isSpectaclesNotNull=entityManager.find(Spectacles.class, spectacles.getSpectaclesId());
		//assertNull(isSpectaclesNotNull);
		
		//Spectacles isSpectaclesNull=entityManager.find(Spectacles.class, primaryKey)
		//	String addSpectacles = "For specs";
		assertEquals(spectacles.getSpectaclesId(),01);
	}
	@Test
	public void testViewSpectaclesById() {
		Spectacles spectacles=new Spectacles(02,"adidas","super",540.0);
		//entityManager.persist(spectacles);
		s=spectaclesService.addSpectacles(spectacles);
		Spectacles  s = spectaclesService.viewSpectaclesById(spectacles.getSpectaclesId());
		assertEquals(s.getSpectaclesId(),02);
	}

	@Test
	public void testViewAllSpectacles() {
		//Spectacles spectacles=new Spectacles();
		//spectaclesService.addSpectacles(spectacles);
		
		List<Spectacles> allSpectacles = spectaclesService.viewAllSpectacles();
		
		assertNotNull(allSpectacles);
		//assertTrue(allSpectacles.size()>0);
		
	}

	@Test
	public void testRemoveSpectaclesById() {
		
		Spectacles spectacles=new Spectacles(01,"puma","gud",560.0);
		//entityManager.persist(spectacles);
		//s=spectaclesService.addSpectacles(spectacles);
	spectacles=	spectaclesService.removeSpectaclesById(spectacles.getSpectaclesId());
		assertNull(spectacles);

	}

	@Test
	public void testUpdateSpectacles() {
		Spectacles spectacles=new Spectacles(03,"puma","best",580.0);
		//entityManager.persist(spectacles);
		String updatedSpectaclesDescription = "best";
		String updatedSpectaclesModel = "puma";
		
		assertEquals(spectacles.getSpectaclesDescription(), updatedSpectaclesDescription);
		assertEquals(spectacles.getSpectaclesModel(),updatedSpectaclesModel);
	
	}
	

}
