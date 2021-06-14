package com.springboot.BeverageAPI.entities;

import java.util.Date;
import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;
import java.sql.Timestamp;

@Entity
@Table(name = "beverages")
public class Beverage {

		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private int id;
		
		@Column(name="Name")
		private String Name;
		
		@Column(name="Description")
		private String Description;
		
		@Column(name="Alcohol_percentage")
		private Double Alcohol_percentage;
		
		@Column(name="Creation_date")
		private Timestamp Creation_date;
		
					
		public long getID() {
			return id;
		}
		public void setID(int iD) {
			this.id = iD;
		}		
		
		public String getName() {
			return Name;
		}
		public void setName(String name) {
			this.Name = name;
		}
		
		public String getDescription() {
			return Description;
		}
		public void setDescription(String description) {
			this.Description = description;
		}
		
		public Double getAlcohol_percentage() {
			return Alcohol_percentage;
		}
		public void setAlcohol_percentage(Double alcohol_percentage) {
			this.Alcohol_percentage = alcohol_percentage;
		}
		
		public Timestamp getCreation_date() {
			return Creation_date;
		}
		public void setCreation_date(Timestamp creation_date) {
			this.Creation_date = creation_date;
		}

}
