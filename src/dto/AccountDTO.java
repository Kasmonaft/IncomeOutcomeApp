package dto;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AccountDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@JsonProperty(required = true)
	private String name;
	
	@JsonProperty
	List<BalanceDTO> balances;
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<BalanceDTO> getBalances() {
		return balances;
	}

	public void setBalances(List<BalanceDTO> balances) {
		this.balances = balances;
	}


}
