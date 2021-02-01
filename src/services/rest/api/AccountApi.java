package services.rest.api;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import dto.AccountDTO;
import model.account.Account;
import services.entity.api.IAccountApi;

@RestController
@DependsOn(value = "accountApiImpl")
public class AccountApi {
	
	@Autowired
	private IAccountApi api;
	
	@GetMapping("getAllAccounts")
	@ResponseBody
	public List<AccountDTO> getAllAccounts(){
		return mapAccountsDTOs(api.getAllAccounts());
	}

	@PostMapping("pushAccount")
	@ResponseBody
	public void pushAccount(@RequestBody AccountDTO account) {
		api.pushAccount(Account.mapAccountFromDTO(account));
	}

	@PutMapping("updateAccount")
	public AccountDTO updateAccount(@RequestBody AccountDTO account) {
		return Account.mapDTOFromAccount(api.updateAccount(Account.mapAccountFromDTO(account)));
	}
	
	@DeleteMapping("deleteAccount")
	public void deleteAccount(@RequestBody AccountDTO account) {
		api.deleteAccount(Account.mapAccountFromDTO(account));
	}
	
	private List<AccountDTO> mapAccountsDTOs(List<Account> allAccounts) {
		return allAccounts.stream().map(Account::mapDTOFromAccount).collect(Collectors.toList());
	}
	
	

}
