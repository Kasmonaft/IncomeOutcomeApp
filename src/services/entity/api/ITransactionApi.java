package services.entity.api;

import java.util.List;

import org.springframework.stereotype.Controller;

import model.transaction.Transaction;

public interface ITransactionApi {

	public List<Transaction> getAllTransactionsByBalanceName(String accountName);
	
	public void pushTransaction(Transaction transaction);
	
	public Transaction updateTransaction(Transaction transaction);
	
	public void deleteTransaction(Transaction transaction);
}
