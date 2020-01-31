package com.test.currencyconverter.dao;

import java.util.List;

import com.test.currencyconverter.model.ConvertRate;

public interface ConverterDao {
	public boolean saveRate(ConvertRate rate);
	public boolean updateRate(ConvertRate rate);
	public boolean deleteRate(ConvertRate rate);
	public List<ConvertRate> get();
}
