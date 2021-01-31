package model.transaction;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "IOA_TRANSACTION")
public abstract class Transaction extends AbstractTransaction {

	private static final long serialVersionUID = 1L;
	
}
