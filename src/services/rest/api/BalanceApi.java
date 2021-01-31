package services.rest.api;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import model.balance.Balance;

@RestController
public class BalanceApi {
	
	@GetMapping("getAllBalancesByAccountName")
	public List<Balance> getAllBalancesByAccountName(String accountName){
		return null;
	}
	
	@PostMapping("pushBalance")
	public Balance pushBalance(Balance balance) {
		return null;
	}
	
	@PutMapping("updateBalance")
	public Balance updateBalance(Balance balance) {
		return null;
	}
	
	@DeleteMapping("deleteBalance")
	public Balance deleteBalance(Balance balance) {
		return null;
	}

}
