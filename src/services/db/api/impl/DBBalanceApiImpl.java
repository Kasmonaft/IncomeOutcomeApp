package services.db.api.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Controller;

import model.balance.Balance;
import model.transaction.Transaction;
import services.db.api.IBalanceApi;

@Controller
@Profile("HIBERNATE")
@Transactional
public class DBBalanceApiImpl implements IBalanceApi{
	
	@PersistenceContext
	EntityManager entityManager;
	
	public List<Balance> getAllBalancesByAccountName(String accountName){
		return entityManager.createQuery("from Balance", Balance.class).getResultList();
	}
	
	public void pushBalance(Balance balance) {
		entityManager.persist(balance);
	}
	
	public Balance updateBalance(Balance balance) {
		return entityManager.merge(balance);
	}
	
	public void deleteBalance(Balance balance) {
		entityManager.remove(balance);
	}

}
