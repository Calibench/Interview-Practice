import java.util.Scanner;

public class interviewQ1 {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		String reader = " ";
		Scanner scnr = new Scanner(System.in);
		while(reader.charAt(0) != 'q') 
		{
			System.out.println("Please enter a string to be capitalized\nOtherwise type 'q' to exit");
			reader = scnr.nextLine();
			letterHumps(reader);
		}
		System.out.println("Exiting program!");
		scnr.close();
		
	}
	
	public static void letterHumps(String word)
	{
		String capHolder = "";
		if(word.isEmpty())
		{
			return;
		}
		for(int i = 0; i < word.length(); i++)
		{
			if(i % 2 == 0)
			{
				
				capHolder += Character.toUpperCase(word.charAt(i));
			}
			else
			{
				capHolder += Character.toLowerCase(word.charAt(i));
			}
		}
		
		System.out.println(capHolder + "\n");
	}

}
