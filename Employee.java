//subclass Employee
public class Employee extends Account
{
    private String employeeName;
    
    public Employee (String u,String empName)
    {
        super (u);
        employeeName = empName;
    }
    
    public void setEmployee (String empName)
    {
        employeeName = empName;
    }
    
    public String getEmployeeName ()
    {
        return employeeName;
    }
    
    public String toString ()
    {
        return super.toString() +
        "\n\t\tEmployee Name : " +employeeName;
    }
    
    
}