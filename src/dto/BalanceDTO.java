package dto;

import java.io.Serializable;

public class BalanceDTO implements Serializable{
	
	private String balanceName;
	
	private String accountName;

	public String getBalanceName() {
		return balanceName;
	}

	public void setBalanceName(String balanceName) {
		this.balanceName = balanceName;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
}
