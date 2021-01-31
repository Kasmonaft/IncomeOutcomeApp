package services.db.api;

import java.util.List;

import org.springframework.stereotype.Controller;

import model.balance.Balance;

public interface IBalanceApi {
	
	public List<Balance> getAllBalancesByAccountName(String accountName);
	
	public void pushBalance(Balance balance);
	
	public Balance updateBalance(Balance balance);
	
	public void deleteBalance(Balance balance);

}
