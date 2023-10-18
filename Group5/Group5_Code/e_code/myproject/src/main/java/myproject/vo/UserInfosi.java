package myproject.vo;

public class UserInfosi {
	private static String usernamesigin ;
	private String passwordsign;
	private String passwordsignre;
	public static String getUsernamesign () 
	{ 
		return usernamesigin;
	}
	public void setUsernamesign(String usernamesigin)
	{
		this.usernamesigin =usernamesigin;
	}
	public String getPasswordsign() 
	{
		return passwordsign;
	}
    public void setPasswordsign(String passwordsign)
    {
    	this.passwordsign =passwordsign;
    }
    public String getPasswordsignre() 
	{
		return passwordsignre;
	}
    public void setPasswordsignre(String passwordsignre)
    {
    	this.passwordsignre =passwordsignre;
    }
}
