package model.balance;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import org.hibernate.annotations.Formula;

public class CompositeBalance extends Balance {
	
	
	private static final long serialVersionUID = 1L;
	
	@ManyToMany
    @JoinTable(
        name = "IOA_BALANCE_BALANCE_RS", 
        joinColumns = { @JoinColumn(name = "main_balance_fk") }, 
        inverseJoinColumns = { @JoinColumn(name = "related_balance_fk") }
    )
	private Set<Balance> childBalances = new HashSet<>();
	
	@Formula(value = "sum(childBalances.amount")
	private BigDecimal totalAmount;
}
