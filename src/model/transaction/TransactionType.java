package model.transaction;

public enum TransactionType{
	
	INCOME("Income"), OUTCOME("Outcome");
	
	TransactionType(String string) {
		value=string;
	}

	private String value;

	public String getValue() {
		return value;
	}
	
	
}
