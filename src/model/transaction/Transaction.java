package model.transaction;

import javax.persistence.Entity;
import javax.persistence.Table;

import dto.TransactionDTO;

@Entity
@Table(name = "IOA_TRANSACTION")
public abstract class Transaction extends AbstractTransaction {

	private static final long serialVersionUID = 1L;
	
	public static Transaction mapTransactionFromDTO(TransactionDTO dto) {
		
		return null;
	}
	public static TransactionDTO mapDTOFromTransaction(Transaction transaction) {
		
		return null;
	}
	
}
