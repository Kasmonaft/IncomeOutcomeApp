package model.account;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import dto.AccountDTO;
import model.balance.Balance;

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
	private Set<Balance> balances = new HashSet<>();

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public Set<Balance> getBalances() {
		return balances;
	}

	public void setBalances(Set<Balance> balance) {
		this.balances = balance;
	}

	public Long getId() {
		return id;
	}
	
	public static Account mapAccountFromDTO(AccountDTO dto) {
		
		return null;
	}
	public static AccountDTO mapDTOFromAccount(Account account) {
		
		return null;
	}
}
