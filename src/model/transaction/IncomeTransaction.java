package model.transaction;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Income")
public class IncomeTransaction extends Transaction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
