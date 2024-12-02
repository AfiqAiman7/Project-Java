//subclass customer
public class Customer extends Account
{
    private String customerName;
    private int serviceID;
    private int quantity;
    private boolean warranty;
    private boolean membership;
    private String paymentType;
    private Datetime date;

    
    public Customer (String u,String custName,int servID,int qty,boolean wrt,boolean mmb,String pt, int y, int mth, int d, String h, String min)
    {
        super (u);
        customerName = custName;
        serviceID = servID;
        quantity = qty;
        warranty = wrt;
        membership = mmb;
        paymentType = pt;
        date=new Datetime(y, mth, d, h, min);
    }
    
    public void setCustomer (String custName,int servID,int qty,boolean wrt,boolean mmb,String pt, int y, int mth, int d, String h, String min)
    {
        customerName = custName;
        serviceID = servID;
        quantity = qty;
        warranty = wrt;
        membership = mmb;
        paymentType = pt;
        date=new Datetime(y, mth, d, h, min);
    }
    
    public String getCustomerName ()
    {
        return customerName;
    }
    
    public int getServiceID ()
    {
        return serviceID;
    }
    
    public int getQuantity ()
    {
        return quantity;
    }
    
    public boolean getWarranty ()
    {
        return warranty;
    }
    
    public boolean getMembership ()
    {
        return membership;
    }
    
    public String getPaymentType ()
    {
        return paymentType;
    }
    
    public Datetime getDate()
    {
        return date;
    }
    
    public double ServiceIDPrice()
    {
        double price=0, totalPrice=0, charge=0, discount=0, tax=0.06, taxPrice=0;
        if(getServiceID()==01)
        {
            price=100;
        }
        else if(getServiceID()==02)
        {
            price=40;
        }
        else if(getServiceID()==03)
        {
            price=150;
        }
        else if(getServiceID()==04)
        {
            price=10;
        }
        else if(getServiceID()==05)
        {
            price=70;
        }
        else if(getServiceID()==06)
        {
            price=30;
        }
        else 
            price=0;
            
        if (warranty == true)
            charge = 0;
        else
            charge = 20;
        
        if (membership == true)
            discount = 0.10;
        else
            discount = 0;
        
        totalPrice = price * quantity;
        taxPrice=tax*totalPrice;
        double discountPrice = discount * totalPrice;
        double overallPrice = totalPrice + charge - discount+taxPrice;
        return overallPrice;
    }
    
    public String toString ()
    {
        return super.toString() +
        "\n\t\t  Customer Name    : "  +customerName +
        "\n\t\t  Service ID       : " +serviceID + 
        "\n\t\t  Quantity         : " +quantity +
        "\n\t\t  Warranty         : " +warranty + 
        "\n\t\t  Membership       : " +membership+
        "\n\t\t  Payment Type     : " +paymentType +
        "\n\t\t  Date             : "+date.displaydate();
    }
}