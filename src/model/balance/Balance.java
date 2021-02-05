package model.balance;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.NaturalId;

import dto.BalanceDTO;
import model.account.Account;
import model.transaction.Transaction;

@Entity
@Table(name = "IOA_BALANCE")
public class Balance implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "ID")
	private Long id;
	
	@Transient
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
		BigDecimal result = new BigDecimal(0);
		for(Transaction transaction : transactions) {
			result = result.add(transaction.getAmount());
		}
		return result;
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
	
	public static Balance mapBalanceFromDTO(BalanceDTO dto) {
		Balance balance = new Balance();
		balance.setBalanceName(dto.getBalanceName());
		Account account = new Account();
		account.setAccountName(dto.getAccountName());
		balance.setAccount(account);
		return balance;
	}
	public static BalanceDTO mapDTOFromBalance(Balance balance) {
		BalanceDTO dto = new BalanceDTO();
		dto.setBalanceName(balance.getBalanceName());
		dto.setAccountName(balance.getAccount().getAccountName());
		dto.setAmount(balance.getAmount());
		dto.setTransactions(balance.getTransactions().stream().map(Transaction::mapDTOFromTransaction).collect(Collectors.toList()));
		return dto;
	}
}
