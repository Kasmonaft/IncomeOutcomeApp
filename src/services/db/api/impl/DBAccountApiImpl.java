package services.db.api.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Controller;

import model.account.Account;
import services.entity.api.IAccountApi;

@Controller("accountApiImpl")
@Profile("HIBERNATE")
@Transactional
public class DBAccountApiImpl implements IAccountApi{
	
	@PersistenceContext
	EntityManager entityManager;
	
	public List<Account> getAllAccounts(){
		return entityManager.createQuery("from Account", Account.class).getResultList();
	}
	
	public void pushAccount(Account account) {
		entityManager.persist(account);
	}
	
	public Account updateAccount(Account account) {
		return entityManager.merge(account);
	}
	
	public void deleteAccount(Account account) {
		entityManager.remove(account);
	}

}
