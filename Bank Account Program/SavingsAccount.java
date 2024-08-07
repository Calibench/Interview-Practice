
public class SavingsAccount extends BankAccount
{

	private final int NUM_WITHDRAWS = 3;
	private int numWithdraws;
	
	public SavingsAccount(String userId, String name, String accountNumber, double balance)
	{
		super(userId, name, accountNumber, balance);
		numWithdraws = 0;
	}
	
	@Override
	public boolean withdraw(double amount)
	{
		if(getBalance() >= amount && amount <= Withdrawables.MAX_WITHDRAW && numWithdraws < NUM_WITHDRAWS)
		{
			super.withdraw(amount);
			setNumWithdraws(1);
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public int getNumWithdraws()
	{
		return this.numWithdraws;
	}
	
	public void setNumWithdraws(int numWithdraws)
	{
		this.numWithdraws += numWithdraws;
	}
	
}
