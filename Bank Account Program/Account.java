
public class Account {

	private String routingNumber = "202835935";
	private String userId;
	private String name;
	
	public Account(String userId, String name)
	{
		this.userId = userId;
		this.name = name;
	}
	
	public String getUserId()
	{
		return this.userId;
	}
	
	public void setUserId(String userId)
	{
		this.userId = userId;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}

	public String getRoutingNumber() {
		return routingNumber;
	}
}
