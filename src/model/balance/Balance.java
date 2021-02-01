package model.balance;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.NaturalId;

import model.account.Account;
import model.transaction.Transaction;

@Entity
@Table(name = "IOA_BALANCE")
public class Balance implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "ID")
	private Long id;
	
	@Column(name = "AMOUNT")
	private BigDecimal amount;
	
	@NaturalId
	@Column(name = "BALANCE_NAME")
	private String balanceName;
	
	@NaturalId
	@JoinColumn(table = "IOA_ACCOUNT", name = "ACCOUNT_FK", referencedColumnName = "ID")
	private Account account;
	
	@OneToMany(mappedBy = "balance")
	private Set<Transaction> transactions = new HashSet<>();

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public Long getId() {
		return id;
	}

	public Set<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(Set<Transaction> transactions) {
		this.transactions = transactions;
	}

	public String getBalanceName() {
		return balanceName;
	}

	public void setBalanceName(String balanceName) {
		this.balanceName = balanceName;
	}
}
