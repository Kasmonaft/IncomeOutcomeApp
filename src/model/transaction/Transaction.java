package model.transaction;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import dto.TransactionDTO;
import model.account.Account;
import model.balance.Balance;

@Entity
@Table(name = "IOA_TRANSACTION")
public class Transaction {

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "ID")
	private Long id;
	
	@Column(name = "TRANSACTION_AMOUNT")
	private BigDecimal amount;
	
	@Column(name = "TRANSACTION_DATE")
	private Date date;
	
	@Column(name = "TRANSACTION_COMMENT")
	private String transactionComment;

	@Column(name = "TRANSACTION_TYPE")
	private String transactionType;
	
	@ManyToOne
	@JoinColumn(name = "BALANCE_FK", nullable = false)
	private Balance balance;

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getTransactionComment() {
		return transactionComment;
	}

	public void setTransactionComment(String transactionType) {
		this.transactionComment = transactionType;
	}

	public Long getId() {
		return id;
	}


	public Balance getBalance() {
		return balance;
	}

	public void setBalance(Balance balance) {
		this.balance = balance;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	
	public static Transaction mapTransactionFromDTO(TransactionDTO dto) {
		Transaction transaction = new Transaction();
		transaction.setAmount(dto.getAmount());
		transaction.setDate(dto.getDate());
		Balance balance = new Balance();
		Account account = new Account();
		account.setAccountName(dto.getAccountName());
		balance.setAccount(account);
		balance.setBalanceName(dto.getBalanceName());
		transaction.setBalance(balance);
		return transaction;
	}
	public static TransactionDTO mapDTOFromTransaction(Transaction transaction) {
		TransactionDTO dto = new TransactionDTO();
		dto.setAmount(transaction.getAmount());
		dto.setDate(transaction.getDate());
		dto.setTransactionType(transaction.getTransactionType());
		dto.setComment(transaction.getTransactionComment());
		dto.setBalanceName(transaction.getBalance().getBalanceName());
		dto.setAccountName(transaction.getBalance().getAccount().getAccountName());
		return dto;
	}
	
}
