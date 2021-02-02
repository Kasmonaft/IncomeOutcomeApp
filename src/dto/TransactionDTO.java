package dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

import model.transaction.TransactionType;

public class TransactionDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@JsonProperty(required = true)
	private BigDecimal amount;
	
	@JsonProperty(required = true)
	private Date date;
	
	@JsonProperty(required = true)
	private TransactionType transactionType;
	
	@JsonProperty
	private String comment;
	
	private String balanceName;
	
	private String accountName;

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


	public String getBalanceName() {
		return balanceName;
	}

	public void setBalanceName(String balanceName) {
		this.balanceName = balanceName;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public TransactionType getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(TransactionType transactionType) {
		this.transactionType = transactionType;
	}

}
