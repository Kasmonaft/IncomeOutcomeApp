package services.db.api.impl;

import java.util.List;

import org.springframework.stereotype.Controller;

import model.transaction.Transaction;
import services.db.api.ITransactionApi;

@Controller
public class DBTransactionApiImpl implements ITransactionApi{

	public List<Transaction> getAllTransactionsByAccountName(String accountName){
		return null;
	}
	
	public void pushTransaction(Transaction transaction) {
	}
	
	public Transaction updateTransaction(Transaction transaction) {
		return null;
	}
	
	public void deleteTransaction(Transaction transaction) {
	}
}
