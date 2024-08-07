
public interface Withdrawables {

	public final int MAX_WITHDRAW = 500;
	
	public abstract void deposit(double amount);
	
	public abstract boolean withdraw(double amount);
	
}
