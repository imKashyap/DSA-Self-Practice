package practice.oops;

public class Account {

	private int accountNumber;
	private String accountName;
	private String accountType;
	private double accountBalance;

	Account(int accountNumber, String accountName, String accountType, double accountBalance) {
		this.accountNumber = accountNumber;
		this.accountName = accountName;
		this.accountType = accountType;
		this.accountBalance = accountBalance;
	}

	public int getAccountNo() {
		return this.accountNumber;
	}

	public String getAccountName() {
		return this.accountName;
	}

	public String getAccountType() {
		return this.accountType;
	}

	public double getAccountBalance() {
		return this.accountBalance;
	}
}
