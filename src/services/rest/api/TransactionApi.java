package services.rest.api;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import model.transaction.Transaction;

@RestController
public class TransactionApi {

	@GetMapping("getAllTransactionsByAccountName")
	public List<Transaction> getAllTransactionsByAccountName(String accountName){
		return null;
	}
	
	@PostMapping("pushTransaction")
	public Transaction pushTransaction(Transaction transaction) {
		return null;
	}
	
	@PutMapping("updateTransaction")
	public Transaction updateTransaction(Transaction transaction) {
		return null;
	}
	
	@DeleteMapping("deleteTransaction")
	public Transaction deleteTransaction(Transaction transaction) {
		return null;
	}
}
