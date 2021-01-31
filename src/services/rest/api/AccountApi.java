package services.rest.api;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import model.account.Account;

@RestController
public class AccountApi {
	
	@GetMapping("getAllAccounts")
	public List<Account> getAllAccounts(){
		return null;
	}
	
	@PostMapping("pushAccount")
	public Account pushAccount(Account account) {
		return null;
	}
	
	@PutMapping("updateAccount")
	public Account updateAccount(Account account) {
		return null;
	}
	
	@DeleteMapping("deleteAccount")
	public Account deleteAccount(Account account) {
		return null;
	}

}
