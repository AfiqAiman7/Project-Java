//subclass Manager
public class Manager extends Account 
{ 
    private String managerName;
    
    public Manager (String u,String manName)
    {
        super (u);
        managerName = manName;
    }
    
    public void setManager (String manName)
    {
        managerName = manName;
    }
    
    public String getManagerName ()
    {
        return managerName;
    }

    public String toString ()
    {
        return super.toString() +
        "\n\t\tManager Name : " +managerName;
    }
    

}