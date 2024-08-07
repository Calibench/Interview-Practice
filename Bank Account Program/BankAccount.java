import java.util.ArrayList;

public class BankAccount extends Account implements Withdrawables
{
	
	private String accountNumber;
	private double balance;
	private ArrayList<String> transactionHistory = new ArrayList<String>();
	
	public BankAccount(String userId, String name, String accountNumber, double balance)
	{
		super(userId, name);
		this.accountNumber = accountNumber;
		this.balance = balance;
	}

	@Override
	public void deposit(double amount) 
	{
		balance += amount;
		addTransaction("deposit", amount);
	}

	@Override
	public boolean withdraw(double amount) 
	{
		if(balance >= amount && amount <= MAX_WITHDRAW)
		{
			balance -= amount;
			addTransaction("Withdraw", amount);
			return true;
		}
		
		else
		{
			return false;
		}
	}
	
	public String getTransaction()
	{
		return transactionHistory.toString();
	}
	
	private void addTransaction(String type, double amount)
	{
		transactionHistory.add(type + ":" + amount);
	}
	
	public double getBalance()
	{
		return this.balance;
	}
	
	public void setAccountNumber(String accountNumber)
	{
		this.accountNumber = accountNumber;
	}
	
	public String getAccountNumber()
	{
		return this.accountNumber;
	}
	
}
