package com.dave.apis.cabin;

import io.dropwizard.Configuration;
import io.dropwizard.db.DataSourceFactory;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotEmpty;

public class CabinConfiguration extends Configuration {
	DatabaseConfig dbConfig = new DatabaseConfig(); 
			
	@NotEmpty
	private String dateFormat;

	@JsonProperty
	public String getDateFormat() {
		return dateFormat;
	}
	
	@JsonProperty
	public void setDateFormat(String dateFormat) {
		this.dateFormat = dateFormat;
	}
	
	
	/**
	 * Database configs
	 */
	@JsonProperty
	private DataSourceFactory database = new DataSourceFactory();

	public DataSourceFactory getDatabase() {
		return database;
	}

	public void setDatabase(DataSourceFactory database) {
		this.database = database;
	}
}
