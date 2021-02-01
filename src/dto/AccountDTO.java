package dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AccountDTO implements Serializable{
	
	@JsonProperty(required = true)
	private String name;

}
