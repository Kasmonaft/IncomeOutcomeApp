package services.db.api;

import java.util.List;

import org.springframework.stereotype.Controller;

import model.transaction.Transaction;

public interface ITransactionApi {

	public List<Transaction> getAllTransactionsByAccountName(String accountName);
	
	public void pushTransaction(Transaction transaction);
	
	public Transaction updateTransaction(Transaction transaction);
	
	public void deleteTransaction(Transaction transaction);
}
