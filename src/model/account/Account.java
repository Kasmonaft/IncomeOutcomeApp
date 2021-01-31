package model.account;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import model.balance.Balance;
import model.transaction.Transaction;

@Entity
@Table(name = "IOA_ACCOUNT")
public class Account implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "ID")
	private Long id;
	
	@Column(name="ACCOUNT_NAME")
	private String accountName;
	
	@OneToMany(mappedBy = "account")
	private Set<Balance> balance = new HashSet<>();

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public Set<Balance> getBalance() {
		return balance;
	}

	public void setBalance(Set<Balance> balance) {
		this.balance = balance;
	}

	public Long getId() {
		return id;
	}
	

}
