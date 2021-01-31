package services.db.api;

import java.util.List;

import org.springframework.stereotype.Controller;

import model.account.Account;

public interface IAccountApi {
	
	public List<Account> getAllAccounts();
	
	public void pushAccount(Account account);
	
	public Account updateAccount(Account account);
	
	public void deleteAccount(Account account);

}
