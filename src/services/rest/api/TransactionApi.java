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

import dto.TransactionDTO;
import model.transaction.Transaction;
import services.entity.api.ITransactionApi;

@RestController
@DependsOn(value = "transactionApiImpl")
public class TransactionApi {
	
	@Autowired
	private ITransactionApi api;

	@GetMapping("getAllTransactionsByAccountName")
	@ResponseBody
	public List<TransactionDTO> getAllTransactionsByAccountName(String balanceName){
		return mapTransactionsDTOs(api.getAllTransactionsByBalanceName(balanceName));
	}
	
	@PostMapping("pushTransaction")
	public void pushTransaction(@RequestBody TransactionDTO transaction) {
		api.pushTransaction(Transaction.mapTransactionFromDTO(transaction));
	}
	
	@PutMapping("updateTransaction")
	@ResponseBody
	public TransactionDTO updateTransaction(@RequestBody TransactionDTO transaction) {
		return Transaction.mapDTOFromTransaction(Transaction.mapTransactionFromDTO(transaction));
	}
	
	@DeleteMapping("deleteTransaction")
	public void deleteTransaction(@RequestBody TransactionDTO transaction) {
		api.deleteTransaction(Transaction.mapTransactionFromDTO(transaction));
	}
	
	private List<TransactionDTO> mapTransactionsDTOs(List<Transaction> allAccounts) {
		return allAccounts.stream().map(Transaction::mapDTOFromTransaction).collect(Collectors.toList());
	}
}
