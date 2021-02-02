package model.transaction;

import javax.persistence.Entity;
import javax.persistence.Table;

import dto.TransactionDTO;
import model.account.Account;
import model.balance.Balance;

@Entity
@Table(name = "IOA_TRANSACTION")
public abstract class Transaction extends AbstractTransaction {

	private static final long serialVersionUID = 1L;
	
	public static Transaction mapTransactionFromDTO(TransactionDTO dto) {
		Transaction transaction = null;
		if(dto.getTransactionType().equals(TransactionType.INCOME)) {
			transaction = new IncomeTransaction();
		}else {
			transaction = new OutcomeTransaction();
		}
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
		dto.setTransactionType(TransactionType.valueOf(transaction.getTransactionType()));
		dto.setComment(transaction.getTransactionComment());
		dto.setBalanceName(transaction.getBalance().getBalanceName());
		dto.setAccountName(transaction.getBalance().getAccount().getAccountName());
		return dto;
	}
	
}
