//class account
public class Account
{
    private String user;
    
    public Account (String u)
    {
        user = u;
    }
    
    public String getUser ()
    {
        return user;
    }
    
    public String toString ()
    {
        return 
        "\n\t\t-----------+ Welcome "+user+" +-------------";
    }
}