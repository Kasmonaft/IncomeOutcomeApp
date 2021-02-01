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

import dto.BalanceDTO;
import model.balance.Balance;
import services.entity.api.IBalanceApi;

@RestController
@DependsOn(value = "balanceApiImpl")
public class BalanceApi {
	
	@Autowired
	private IBalanceApi api;
	
	@GetMapping("getAllBalancesByAccountName")
	@ResponseBody
	public List<BalanceDTO> getAllBalancesByAccountName(String accountName){
		return mapBalancesDTOs(api.getAllBalancesByAccountName(accountName));
	}
	
	@PostMapping("pushBalance")
	public void pushBalance(@RequestBody BalanceDTO balance) {
		api.pushBalance(Balance.mapBalanceFromDTO(balance));
	}
	
	@PutMapping("updateBalance")
	@ResponseBody
	public BalanceDTO updateBalance(@RequestBody BalanceDTO balance) {
		return Balance.mapDTOFromBalance(api.updateBalance(Balance.mapBalanceFromDTO(balance)));
	}
	
	@DeleteMapping("deleteBalance")
	public void deleteBalance(@RequestBody BalanceDTO balance) {
		api.deleteBalance(Balance.mapBalanceFromDTO(balance));
	}
	
	private List<BalanceDTO> mapBalancesDTOs(List<Balance> allBalances) {
		return allBalances.stream().map(Balance::mapDTOFromBalance).collect(Collectors.toList());
	}

}
