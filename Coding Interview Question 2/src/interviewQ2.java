import java.util.Scanner;

public class interviewQ2 
{
	public final static String key = "<div>";

	public static void main(String[] args) 
	{
		Scanner scnr = new Scanner(System.in);

		String htmlString = scnr.nextLine();

		htmlString = htmlDivFixer(htmlString);

		System.out.println(htmlString);

		scnr.close();
	}

	public static String htmlDivFixer(String html)
	{
		//"<div><p>Here is a <div> tag </p>" to "<div><p>Here is a </div> tag </p>"
		String fixedHtml = "";
		int divCount = 0;

		for(int i = 0; i < html.length(); i++)
		{
			if(html.charAt(i) == '<' && i <= html.length() - key.length())
			{
				
				if(html.substring(i, i+key.length()).equals(key) && divCount == 0)
				{
					divCount++;
				}
				
				else if(html.substring(i, i+key.length()).equals(key))
				{
					fixedHtml += "</";
					divCount = 0;
					continue;
				}
				
			}
			fixedHtml += html.charAt(i);
			
		}
		return fixedHtml;
	}
}
