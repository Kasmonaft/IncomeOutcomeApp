package model.transaction;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Outcome")
public class OutcomeTransaction extends Transaction {

	private static final long serialVersionUID = 1L;
	
}
