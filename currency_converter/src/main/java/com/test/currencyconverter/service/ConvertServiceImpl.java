package com.test.currencyconverter.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.currencyconverter.dao.ConverterDaoImpl;
import com.test.currencyconverter.model.ConvertRate;

@Service("currencyService")
public class ConvertServiceImpl implements ConvertService {

	@Autowired
	ConverterDaoImpl dao;

	public void setDao(ConverterDaoImpl dao) {
		this.dao = dao;
	}

	public double convert(String baseCountry, String exCountry, double amount) {
		double exAmount = 1;

		ConvertRate rate = dao.get(baseCountry, exCountry);
		exAmount = amount * rate.getRate();

		return exAmount;
	}

}
