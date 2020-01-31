package com.test.currencyconverter.service;

import com.google.gson.JsonObject;

public interface ConvertService {
	public double convert(String baseCountry, String exCountry, double amount);
}
