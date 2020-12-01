package com.cg.onlineeyeclinc.dao;

import java.util.List;

import com.cg.onlineeyeclinc.entity.Spectacles;
import com.cg.onlineeyeclinc.exeception.SpectaclesIdNotFoundException;

public interface ISpectaclesDao {


	Spectacles addSpectacles(Spectacles spectacles);
	
	Spectacles updateSpectacles(Spectacles spectacles);

	Spectacles removeSpectaclesById(int spectaclesId) throws SpectaclesIdNotFoundException;

	List<Spectacles> viewAllSpectacles();

	Spectacles viewSpectaclesById(int spectaclesId) throws SpectaclesIdNotFoundException ;

	
	void commitTransaction();

	void beginTransaction();
	
}

