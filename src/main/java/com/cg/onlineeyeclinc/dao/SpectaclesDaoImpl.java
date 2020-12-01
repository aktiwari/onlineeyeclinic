package com.cg.onlineeyeclinc.dao;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.cg.onlineeyeclinc.entity.Spectacles;
import com.cg.onlineeyeclinc.exeception.SpectaclesIdNotFoundException;

/**The SpectaclesDaoImpl class provides methods to persist the data or update or remove or view from database
 * 
 * @author sneha's
 *
 */
public class SpectaclesDaoImpl implements ISpectaclesDao{
	
	private EntityManager entityManager;
	/*
	 * Constructor to obtain the entity manager to perform CRUD operations and store in DB
	 */
	
	public SpectaclesDaoImpl() {
		entityManager = JPAUtil.getEntityManager();
	}
	
	/**
	 * This method takes spectacles object and store spectacles details to DB
	 * @param spectacles - spectacles entity details 
	 */
	@Override
	public Spectacles addSpectacles(Spectacles spectacles) {
		entityManager.persist(spectacles);
		return spectacles;
	}
	
	/**
	 * This method takes spectacles object and update spectacles details in DB
	 * @param spectacles - spectacles entity details 
	 */
	@Override
	public Spectacles updateSpectacles(Spectacles spectacles) {
		entityManager.merge(spectacles);
		return spectacles;
	}

	/**
	 * This method takes SpectaclesId parameter and delete Spectacles details from DB
	 * @param doctor - SpectaclesId - integer value to display
	 */
	
	@Override
	public Spectacles removeSpectaclesById(int spectaclesId) throws SpectaclesIdNotFoundException {
	Spectacles s=	entityManager.find(Spectacles.class, spectaclesId);
	if(s==null)
	{
		throw new SpectaclesIdNotFoundException(spectaclesId);
	}
		entityManager.remove(s);
		s=null;
		return s;
		
	}
	
	/**
	 * This method is used to fetch all spectacles details from DB
	 * @return list of spectacles
	 */
	@Override
	public List<Spectacles> viewAllSpectacles() {
		TypedQuery<Spectacles> query= entityManager.createQuery("select a from Spectacles a", Spectacles.class);
		List<Spectacles> allSpectacles = query.getResultList();
		return allSpectacles;
	}

	/**
	 * This method takes spectaclesId parameter and display spectacles details from DB
	 * @param SpectaclesId - integer value to display spectacles based on spectaclesId
	 * @return  Spectacles Object
	 */
	
	@Override
	public Spectacles viewSpectaclesById(int spectaclesId) throws SpectaclesIdNotFoundException {
	Spectacles spectacles=entityManager.find(Spectacles.class, spectaclesId);
	if(spectacles==null)
	{
		throw new SpectaclesIdNotFoundException(spectaclesId);
	}
	return spectacles;
		
	}
	
	/**
	 * This method is used to commit transaction.
	 */
	
	@Override
	public void commitTransaction() {
		entityManager.getTransaction().commit();
	}
	
	/**
	 * This method is used to begin the transaction.
	 */
	
	@Override
	public void beginTransaction() {
		
		entityManager.getTransaction().begin();
	}
	
}
