package com.cg.onlineeyeclinc.service;

import java.util.List;

import com.cg.onlineeyeclinc.dao.ISpectaclesDao;
import com.cg.onlineeyeclinc.dao.SpectaclesDaoImpl;
import com.cg.onlineeyeclinc.entity.Spectacles;
import com.cg.onlineeyeclinc.exeception.SpectaclesIdNotFoundException;

public class SpectaclesServiceImpl implements ISpectaclesService {
		private ISpectaclesDao dao;

		public SpectaclesServiceImpl() {
			dao = new SpectaclesDaoImpl();
		}

		@Override
		public Spectacles addSpectacles(Spectacles spectacles) {
			dao.beginTransaction();
			dao.addSpectacles(spectacles);
			dao.commitTransaction();
			return spectacles;
		}
		

		@Override
		public Spectacles viewSpectaclesById(int spectaclesId) {
			Spectacles specs=null;
			try {
				specs = dao.viewSpectaclesById(spectaclesId);
			} catch (SpectaclesIdNotFoundException e) {
				e.printStackTrace();
			}
			return specs;
		}
		
		@Override
		public List<Spectacles> viewAllSpectacles() {
			List<Spectacles> allSpectacles = dao.viewAllSpectacles();
			return allSpectacles;
			
		}

		@Override
		public Spectacles removeSpectaclesById(int spectaclesId) {
			Spectacles specs=null;
			dao.beginTransaction();
			try {
				specs=dao.removeSpectaclesById(spectaclesId);
			} catch (SpectaclesIdNotFoundException e) {
				e.printStackTrace();
			}
			dao.commitTransaction();
			return specs;
			
		}

		@Override
		public Spectacles updateSpectacles(Spectacles spectacles) {
			dao.beginTransaction();
			dao.updateSpectacles(spectacles);
			dao.commitTransaction();
			return spectacles;
			
		}	

	}
