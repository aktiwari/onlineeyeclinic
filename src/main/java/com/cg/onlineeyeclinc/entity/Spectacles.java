package com.cg.onlineeyeclinc.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/** This is entity class for spectacles with default constructor, parameterized constructor along with getters and setters
 * 
 * @author sneha's
 * @version 1.0
 *
 */

@Entity
@Table(name="spectacle")
public class Spectacles implements Serializable {
	private static final long serialVersionUID = 1L;
	
	
	/**
	 * Data Fields
	 */
	
		@Id
		@Column(length=10)
		private int spectaclesId;
		@Column(length=10)
		private String spectaclesModel;
		@Column(length=10)
		private String spectaclesDescription;
		@Column(length=10)
		private double spectaclesCost;
		
		/**
		 * Default Constructor
		 */
		
		
		public Spectacles() {
			
		}

		/**
		 * Parameterized Constructor
		 */
		
		public Spectacles(int spectaclesId, String spectaclesModel, String spectaclesDescription,
				double spectaclesCost) {
			super();
			this.spectaclesId = spectaclesId;
			this.spectaclesModel = spectaclesModel;
			this.spectaclesDescription = spectaclesDescription;
			this.spectaclesCost = spectaclesCost;
		}
		/**
		 * Getters and setters for All data fields
		 * 
		 */
		public int getSpectaclesId() {
			return spectaclesId;
		}
		public void setSpectaclesId(int spectaclesId) {
			this.spectaclesId = spectaclesId;
		}
		public String getSpectaclesModel() {
			return spectaclesModel;
		}
		public void setSpectaclesModel(String spectaclesModel) {
			this.spectaclesModel = spectaclesModel;
		}
		public String getSpectaclesDescription() {
			return spectaclesDescription;
		}
		public void setSpectaclesDescription(String spectaclesDescription) {
			this.spectaclesDescription = spectaclesDescription;
		}
		public double getSpectaclesCost() {
			return spectaclesCost;
		}
		public void setSpectaclesCost(double spectaclesCost) {
			this.spectaclesCost = spectaclesCost;
		}
		@Override
		public String toString() {
			return "Spectacles [spectaclesId=" + spectaclesId + ", spectaclesModel=" + spectaclesModel
					+ ", spectaclesDescription=" + spectaclesDescription + ", spectaclesCost=" + spectaclesCost + "]";
		}
	

}
