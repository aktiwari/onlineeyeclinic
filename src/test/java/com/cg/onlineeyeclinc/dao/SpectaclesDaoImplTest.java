package com.cg.onlineeyeclinc.dao;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.cg.onlineeyeclinc.entity.Spectacles;
import com.cg.onlineeyeclinc.exeception.SpectaclesIdNotFoundException;

import junit.framework.TestCase;

class SpectaclesDaoImplTest extends TestCase{

	SpectaclesDaoImpl spectaclesDao;
	@BeforeEach
	protected void setUp() throws Exception {
	spectaclesDao=new SpectaclesDaoImpl();	
	}
	@AfterEach
	protected void tearDown() throws Exception {
		spectaclesDao=null;
	}
	@Test
	public void testSpectaclesDaoImpl() {
		//SpectaclesDaoImpl sdi=new SpectaclesDaoImpl();
		assertTrue(spectaclesDao instanceof SpectaclesDaoImpl);
		
	}
	@Test
	public void testAddSpectacles() {
	Spectacles s=new Spectacles(10,"puma","gud",560.0);

	spectaclesDao.beginTransaction();
	Spectacles sps = spectaclesDao.addSpectacles(s);
	spectaclesDao.commitTransaction();
		
	assertEquals(sps.getSpectaclesCost(),560.0);
	}
	
	

	@Test
	public void testUpdateSpectacles() {
		
		Spectacles sp=new Spectacles(12,"puma","bad",580.0);
		
		spectaclesDao.beginTransaction();
	Spectacles	specs=spectaclesDao.addSpectacles(sp);
		spectaclesDao.commitTransaction();
		
		specs.setSpectaclesModel("adidas");
			
		spectaclesDao.beginTransaction();
		spectaclesDao.updateSpectacles(specs);
		spectaclesDao.commitTransaction();
	
		assertEquals(specs.getSpectaclesModel(),"adidas");

	}
	@Test
	public void testRemoveSpectaclesById() throws SpectaclesIdNotFoundException {
		Spectacles s=new Spectacles(14,"puma","gud",560.0);
		
		spectaclesDao.beginTransaction();
		Spectacles sp1=spectaclesDao.addSpectacles(s);
		spectaclesDao.commitTransaction();
		
		spectaclesDao.beginTransaction();
		sp1=spectaclesDao.removeSpectaclesById(sp1.getSpectaclesId());
		spectaclesDao.commitTransaction();
		assertNull(sp1);
	}
	
	@Test
	public void testViewSpectaclesById() throws SpectaclesIdNotFoundException {
		Spectacles s=new Spectacles(03,"pumasuper","best",560.0);
	
		spectaclesDao.beginTransaction();
		Spectacles	spectacles=spectaclesDao.addSpectacles(s);
		spectaclesDao.commitTransaction();
		
		spectaclesDao.beginTransaction();
		s=spectaclesDao.viewSpectaclesById(spectacles.getSpectaclesId());
		spectaclesDao.commitTransaction();
		
		assertEquals(spectacles.getSpectaclesId(),03);
	}
	
	@Test
	public void testViewAllSpectacles() {
	    List<Spectacles> spectaclesList = spectaclesDao.viewAllSpectacles();
	    
	    assertNotNull(spectaclesList);
	
	}
}