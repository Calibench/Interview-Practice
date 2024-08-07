
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		boolean test = false;
				
		BankAccount account = new BankAccount("1234", "John Doe", "45678", 1000.00);
		
		account.deposit(500);
		account.withdraw(250); 
		account.withdraw(100); 
		account.withdraw(100); 
		
		System.out.println(account.getTransaction());
		
		SavingsAccount savings = new SavingsAccount("5678", "Mary Doe", "12345", 1000.00);
		
		savings.deposit(500);
		savings.withdraw(250);
		savings.withdraw(100);
		savings.withdraw(100);
		System.out.println(savings.getTransaction());
		
	}

}
