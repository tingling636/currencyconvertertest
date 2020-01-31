package com.test.currencyconverter.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="rate")
public class ConvertRate implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id", columnDefinition="bigint(20) NOT NULL", updatable=false)
	private long id;
	
	@Column(name="baseCountry", columnDefinition="varchar(20) NOT NULL")
	private String baseCountry;
	
	@Column(name="baseCountry", columnDefinition="varchar(20) NOT NULL")
	private String exCountry;
	
	@Column(name="rate", columnDefinition="double(15) NOT NULL")
	private double rate;
		
	public String getBaseCountry() {
		return baseCountry;
	}
	public void setBaseCountry(String baseCountry) {
		this.baseCountry = baseCountry;
	}
	public String getExCountry() {
		return exCountry;
	}
	public void setExCountry(String exCountry) {
		this.exCountry = exCountry;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}

}
