package com.dave.apis.cabin;

import io.dropwizard.Configuration;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotEmpty;

public class CabinConfiguration extends Configuration {
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
}
