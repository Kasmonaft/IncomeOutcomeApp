package model.transaction;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;

import model.account.Account;

@Table(name = "IOA_TRANSACTION")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@MappedSuperclass
@DiscriminatorColumn(name = "TRANSACTION_TYPE", discriminatorType = DiscriminatorType.STRING)
public abstract class AbstractTransaction implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "ID")
	private Long id;
	
	@Column(name = "TRANSACTION_AMOUNT")
	private BigDecimal amount;
	
	@Column(name = "TRANSACTION_DATE")
	private Date date;
	
	@Column(name = "TRANSACTION_TYPE")
	private String transactionType;
	
	@ManyToOne
	@JoinColumn(name = "ACCOUNT_FK", nullable = false)
	private Account account;

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

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public Long getId() {
		return id;
	}

}
