package services.db.api.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Controller;

import model.account.Account;
import model.transaction.Transaction;
import services.db.api.ITransactionApi;

@Controller
@Profile("HIBERNATE")
@Transactional
public class DBTransactionApiImpl implements ITransactionApi{
	
	@PersistenceContext
	EntityManager entityManager;

	public List<Transaction> getAllTransactionsByAccountName(String accountName){
		return entityManager.createQuery("from Transaction", Transaction.class).getResultList();
	}
	
	public void pushTransaction(Transaction transaction) {
		entityManager.persist(transaction);
	}
	
	public Transaction updateTransaction(Transaction transaction) {
		return entityManager.merge(transaction);
	}
	
	public void deleteTransaction(Transaction transaction) {
		entityManager.remove(transaction);
	}
}
