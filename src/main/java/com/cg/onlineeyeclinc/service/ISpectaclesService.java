package com.cg.onlineeyeclinc.service;

import java.util.List;

import com.cg.onlineeyeclinc.entity.Spectacles;

public interface ISpectaclesService {
	
	Spectacles addSpectacles(Spectacles spectacles);
	
	Spectacles updateSpectacles(Spectacles spectacles );
		
		Spectacles removeSpectaclesById(int spectaclesId)  ;
		
		Spectacles viewSpectaclesById(int spectaclesId);
		
		List<Spectacles> viewAllSpectacles() ;
}
