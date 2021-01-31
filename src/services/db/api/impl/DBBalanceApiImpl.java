package services.db.api.impl;

import java.util.List;

import org.springframework.stereotype.Controller;

import model.balance.Balance;
import services.db.api.IBalanceApi;

@Controller
public class DBBalanceApiImpl implements IBalanceApi{
	
	public List<Balance> getAllBalancesByAccountName(String accountName){
		return null;
	}
	
	public void pushBalance(Balance balance) {
	}
	
	public Balance updateBalance(Balance balance) {
		return null;
	}
	
	public void deleteBalance(Balance balance) {
	}

}
