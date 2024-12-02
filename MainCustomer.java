/*main handphone service program*/
import java.util.Scanner;
import java.util.*;
import java.io.*;
import java.util.StringTokenizer;

public class MainCustomer
{
    public static void main (System[] args) throws IOException
    {
        try
        {
            Scanner input = new Scanner (System.in);
            
            String ans = "yes";
            int eChoice =0, totalProceed=1,mChoice=0;
            int countCust =0, countEmp =0, countMan =0;
            int qty01=0, qty02=0, qty03=0, qty04=0, qty05=0, qty06=0;
            int remaining01=100,remaining02=100,remaining03=100,remaining04=100,remaining05=100,remaining06=100;
            int stock01=0,stock02=0,stock03=0,stock04=0,stock05=0,stock06=0;
            int service01=0,service02=0,service03=0,service04=0,service05=0,service06=0;
            double totalPrice=0, totalAll=0,balance=0;
            String u="";
            
            while (ans.equalsIgnoreCase("yes"))
            {
                FileWriter fw = new FileWriter("CustData.txt");
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter pw = new PrintWriter(bw);
            
                System.out.println(" ------------------------------------------------------------------------- ");
                System.out.println("   W E L C O M E  T O  H A N D P H O N E  S E R V I C E  S Y S T E M S ! ");
                System.out.println(" ------------------------------------------------------------------------- ");
                System.out.println("\n\t\t[ 1 ] CUSTOMER\t\t[ 3 ] MANAGER ");
                System.out.println("\n\t\t[ 2 ] EMPLOYEE");
                System.out.print("\n\t\tPlease Choose To Continue : ");
                u = input.next();
                
                if (u.equalsIgnoreCase("customer")||u.equalsIgnoreCase("manager") || u.equalsIgnoreCase("employee")){
                    if (u.equalsIgnoreCase("customer")){
                        System.out.println("\n ------------------------------------------------------------------------- ");
                        System.out.print("\t    How Many "+u+" Account Do You Want To Proceed : ");
                        totalProceed = input.nextInt();
                        System.out.println(" ------------------------------------------------------------------------- ");
                    }
                    else if (u.equalsIgnoreCase("manager") || u.equalsIgnoreCase("employee"))
                        totalProceed = 1;
                    
                    Account[] acc = new Account[totalProceed];
                   
                    for (int i=0; i<acc.length; i++)
                    {
                        if (u.equalsIgnoreCase("customer"))
                        {
                            System.out.println("\n\t\t\t   E N T E R   D E T A I L S");
                            System.out.println("\t\t  +----------------------------------------+ ");
                            System.out.println("\t\t\t     Today Date And Time");
                            System.out.print("\n\t\t\t\tDay     : ");
                            int day = input.nextInt();
                            System.out.print("\t\t\t\tMonth   : ");
                            int month = input.nextInt();
                            System.out.print("\t\t\t\tYear    : ");
                            int year = input.nextInt();
                            System.out.print("\t\t\t\tHour    : ");
                            String hour = input.next();
                            System.out.print("\t\t\t\tMinutes : ");
                            String minutes= input.next();
                            System.out.println("\n\t\t\t  DETAILS HAS BEEN RECORDED! ");
                            System.out.println("\t\t  +----------------------------------------+ ");
                        
                            System.out.println("\n ---------------------------------------------------------------------------");
                            System.out.println("                    WELCOME TO OUR HANDPHONE SERVICE CENTRE              ");
                            System.out.println(" ---------------------------------------------------------------------------");
                            System.out.println(" |  SERVICE ID   |    SERVICE TYPE     |      SERVICE NAME    |  PRICE(RM) |");
                            System.out.println(" ---------------------------------------------------------------------------");
                            System.out.println(" |      01       |       SCREEN        |     REPAIR SCREEN    |   100.00   |");
                            System.out.println(" |      02       |       BATTERY       |     CHANGE BATTERY   |    40.00   |");
                            System.out.println(" |      03       |       CAMERA        |     REPAIR CAMERA    |   150.00   |");
                            System.out.println(" |      04       |       BUTTON        |     REPLACE BUTTON   |    10.00   |");
                            System.out.println(" |      05       |    WATER DAMAGED    |     CLEAN HANDPHONE  |    70.00   |");
                            System.out.println(" |      06       |   UPDATE SOFTWARE   |       SOFTWARE       |    30.00   |");
                            System.out.println(" ===========================================================================");
                            System.out.print("\n\t\tEnter Customer Name      : ");
                            String custName = input.nextLine();
                            custName += input.nextLine();
                            System.out.print("\t\tChoose Service ID        : ");
                            int servID = input.nextInt();
                            System.out.print("\t\tEnter quantity           : ");
                            int qty = input.nextInt();
                            System.out.print("\t\tDo you have warranty? [True|False]    : ");
                            boolean wr = input.nextBoolean();
                            System.out.print("\t\tDo you have membership? [True|False]  : ");
                            boolean mb = input.nextBoolean();
                            System.out.print("\t\tChoose Payment Type  [ Cash / Debit ] : ");
                            String pt = input.next();
                            System.out.println("\n\t\tYou Have Done Proceed "+(i+1)+" "+u);
                            acc[i] = new Customer(u,custName,servID,qty,wr,mb,pt,year,month,day,hour,minutes);  
                        }
                        else if (u.equalsIgnoreCase("employee"))
                        {
                            System.out.print("\n\t\tEnter Employee Name : ");
                            String empName = input.nextLine();
                            empName += input.nextLine();
                            acc[i] = new Employee(u,empName);
                        }
                        else if (u.equalsIgnoreCase("manager"))
                        {
                            System.out.print("\n\t\tEnter Manager Name : ");
                            String manName = input.nextLine();
                            manName += input.nextLine();
                            acc[i] = new Manager(u,manName);
                        }
                        if (acc[i] instanceof Customer)
                        {  
                            Customer cust = (Customer) acc[i];
                            System.out.print("\t\tDo you want a receipt [Yes|No] : ");
                            String answ = input.next();
                            if (answ.equalsIgnoreCase("yes"))
                            {
                                System.out.println("Customer "+(i+1));
                                System.out.println("\n\t\t  --------------+ RECEIPT +---------------");
                                System.out.println(acc[i].toString());
                                System.out.println("\n\t\t  The Total Price After Tax : RM "+cust.ServiceIDPrice());
                                System.out.println("\t\t  +----------------------------------------+ ");
                            }
                            else 
                            {
                                pw.println("\n\t\t  --------------+ RECEIPT +---------------");
                                pw.println(acc[i].toString());
                                pw.println("\n\t\t  The Total Price After Tax : RM "+cust.ServiceIDPrice());
                                pw.println("\t\t  +----------------------------------------+ ");
                            }
                        }
                    }
                            
                    for (int i=0; i<acc.length; i++)
                    {
                        if (acc[i] instanceof Customer)
                        {
                            Customer cust = (Customer) acc[i];
                            if (cust.getServiceID() == 01)
                                service01++;
                            else if (cust.getServiceID() == 02)
                                service02++;
                            else if (cust.getServiceID() == 03)
                                service03++;
                            else if (cust.getServiceID() == 04)
                                service04++;
                            else if (cust.getServiceID() == 05)
                                service05++;
                            else if (cust.getServiceID() == 06)
                                service06++;
                        }
                    }
                            
                    for (int i=0; i<acc.length; i++)
                    {
                        if (acc[i] instanceof Customer)
                        {
                            Customer cust = (Customer) acc[i];
                            if (cust.getServiceID() == 01)
                            {
                                qty01=qty01+cust.getQuantity();
                                remaining01=remaining01-qty01;
                            }
                            else if (cust.getServiceID() == 02)
                            {
                                qty02=qty02+cust.getQuantity();
                                remaining02=remaining02-qty02;
                            }
                            else if (cust.getServiceID() == 03)
                            {
                                qty03=qty03+cust.getQuantity ();
                                remaining03=remaining03-qty03;
                            }
                            else if (cust.getServiceID() == 04)
                            {
                                qty04=qty04+cust.getQuantity ();
                                remaining04=remaining04-qty04;
                            }
                            else if (cust.getServiceID() == 05)
                            {
                                qty05=qty05+cust.getQuantity ();
                                remaining05=remaining05-qty05;
                            }
                            else if (cust.getServiceID() == 06)
                            {
                                qty06=qty06+cust.getQuantity ();
                                remaining06=remaining06-qty06;
                            }
                            totalPrice = cust.ServiceIDPrice();
                            totalAll = totalAll + totalPrice;
                            totalPrice = cust.ServiceIDPrice();
                            totalAll = totalAll + totalPrice;
                            
                            countCust++;
                        }
                        else if (acc[i] instanceof Employee)
                        {
                            int eback=1;
                            while (eback == 1){
                                System.out.println(" ------------------------------------------------------------------------- ");
                                System.out.println("\t[ 1 ] HIGHER SERVICE ORDER \t[ 2 ] CHECK SERVICE STOCK ");
                                System.out.print("\n\t\t  Please Enter [1|2] To Continue : ");
                                eChoice = input.nextInt();
                                
                                if (eChoice == 1)
                                {
                                    Employee emp = (Employee) acc[i];
                                    System.out.println(emp.toString());
                                    System.out.println("\n\tThe Total Order For Service ID 01 (SCREEN)          : "+service01);
                                    System.out.println("\tThe Total Order For Service ID 02 (BATTERY)         : "+service02);
                                    System.out.println("\tThe Total Order For Service ID 03 (CAMERA)          : "+service03);
                                    System.out.println("\tThe Total Order For Service ID 04 (BUTTON)          : "+service04);
                                    System.out.println("\tThe Total Order For Service ID 05 (WATER DAMAGED)   : "+service05);
                                    System.out.println("\tThe Total Order For Service ID 06 (UPDATE SOFTWARE) : "+service06);
                                }
                                else if (eChoice ==2)
                                {
                                    System.out.println("\n\t    Remaining Stocks For Repair Screen   : " +remaining01);
                                    System.out.println("\t    Remaining Stocks For Change Battery  : " +remaining02);
                                    System.out.println("\t    Remaining Stocks For Repair Camera   : " +remaining03);
                                    System.out.println("\t    Remaining Stocks For Replace Button  : " +remaining04);
                                    System.out.println("\t    Remaining Stocks For Clean Handphone : " +remaining05);
                                    System.out.println("\t    Remaining Stocks For Software        : " +remaining06);
                                    if(remaining01<0)
                                    {
                                        System.out.println("\n\tOUT OF STOCKS For Repair Screen    : " +remaining01);
                                    }
                                    else if(remaining02<0)
                                    {
                                        System.out.println("\n\tOUT OF STOCKS For Change Battery   : " +remaining02);
                                    }
                                    else if(remaining03<0)
                                    {
                                        System.out.println("\n\tOUT OF STOCKS For Repair Camera    : " +remaining03);
                                    }
                                    else if(remaining04<0)
                                    {
                                        System.out.println("\n\tOUT OF STOCKS For Replace Button   : " +remaining04);
                                    }
                                    else if(remaining05<0)
                                    {
                                        System.out.println("\n\tOUT OF STOCKS For Clean Handphone  : " +remaining05);
                                    }
                                    else if(remaining06<0)
                                    {
                                        System.out.println("\n\tOUT OF STOCKS For Software         : " +remaining06);
                                    }
                                    System.out.println("\n The total of customer : " +countCust);
                                    countEmp++;
                                }
                                else
                                    System.out.println("\t\tPlease Enter [1|2] Only");
                                    
                                System.out.println("\n ------------------------------------------------------------------------- ");
                                System.out.println("\t\t[ 1 ] BACK \t\t[ 2 ] EXIT ");
                                System.out.print("\n\t\tPlease Enter [1|2] To Continue : ");
                                eback = input.nextInt();
                            }
                        }
                        else if (acc[i] instanceof Manager)
                        {
                            int mback=1;
                            while (mback ==1){
                                System.out.println(" ------------------------------------------------------------------------- ");
                                System.out.println("\t\t[ 1 ] COMPANY EARNS \t[ 2 ] UPDATE STOCK ");
                                System.out.print("\n\t\tPlease Enter [1|2] To Continue : ");
                                mChoice = input.nextInt();
                                if (mChoice ==1){
                                    Manager man = (Manager) acc[i];
                                    System.out.println(man.toString());
                                    System.out.println("\n\t\tObjective Is To Reach RM1000");
                                    System.out.println("\t\tThe Total Company Earns : RM " +totalAll);
                                    balance = 1000-totalAll;
                                    if (totalAll > 1000)
                                        System.out.println("\t\tThe Company Gain A Profit!!! ");
                                        else
                                    {
                                        System.out.println("\t\tThe Company Suffered A Loss ...");
                                        System.out.println("\t\tShort of : RM  " +balance);
                                    }
                                }
                                else if(mChoice == 2 ){
                                    if (remaining01<101)
                                        stock01=100-remaining01;
                                    if (remaining02<101)
                                        stock02=100-remaining02;
                                    if (remaining03<101)
                                        stock03=100-remaining03;
                                    if (remaining04<101)
                                        stock04=100-remaining04;
                                    if (remaining05<101)
                                        stock05=100-remaining05;
                                    if (remaining06<101)
                                        stock06=100-remaining06;
                                    System.out.println("\n\tService That Need To Update Stocks For Repair Screen   : " +stock01);
                                    System.out.println("\tService That Need To Update Stocks For Change Battery  : " +stock02);
                                    System.out.println("\tService That Need To Update Stocks For Repair Camera   : " +stock03);
                                    System.out.println("\tService That Need To Update Stocks For Replace Button  : " +stock04);
                                    System.out.println("\tService That Need To Update Stocks For Clean Handphone : " +stock05);
                                    System.out.println("\tService That Need To Update Stocks For Software        : " +stock06);
                                    countMan++;
                                }
                                else
                                    System.out.println("\t\tPlease Enter [1|2] Only");
                                    
                                System.out.println("\n ------------------------------------------------------------------------- ");
                                System.out.println("\t\t[ 1 ] BACK \t\t[ 2 ] EXIT ");
                                System.out.print("\n\t\tPlease Enter [1|2] To Continue : ");
                                mback = input.nextInt();
                            }
                        } 
                    }
                                    
                    if (u.equalsIgnoreCase("Manager") || u.equalsIgnoreCase("Employee"))
                    {
                        if(service01>service02 && service01>service03 && service01>service04 && service01>service05 && service01>service06)
                            System.out.println("\n\tSERVICE REPAIR SCREEN HAS THE MOST REQUESTED FOR THIS MONTH");
                        else if(service02>service03 && service02>service04 && service02>service05 && service02>service06)
                            System.out.println("\n\tSERVICE CHANGE BATTERY HAS THE MOST REQUESTED FOR THIS MONTH");
                        else if(service03>service04 && service03>service05 && service03>service06)
                            System.out.println("\n\tSERVICE REPAIR CAMERA HAS THE MOST REQUESTED FOR THIS MONTH");
                        else if(service04>service05 && service04>service06)
                            System.out.println("\n\tSERVICE REPLACE BUTTON HAS THE MOST REQUESTED FOR THIS MONTH");
                        else if(service05>service06)
                            System.out.println("\n\tSERVICE CLEAN HANDPHONE HAS THE MOST REQUESTED FOR THIS MONTH");
                        else
                            System.out.println("\n\tSERVICE SOFTWARE HAS THE MOST REQUESTED FOR THIS MONTH");
                                
                        System.out.println("\n\tThe Total User For Account Customer : "+countCust);
                        System.out.println("\tThe Total User For Account Employee : "+countEmp);
                        System.out.println("\tThe Total User For Account Manager  : "+countMan);
                    }
                    System.out.print("\n\n\t\tEnter yes to continue | otherwise to stop : ");
                    ans = input.next();
                    pw.close();
                }
                else{
                    System.out.println("\n\t+---------------------------------------------------------+ ");
                    System.out.println("\t\t Please Enter |Customer |Manager |Employee Only");
                    ans = "yes";
                }
            }
        }
        catch (FileNotFoundException e)
        {
            System.out.println("File not Found : " +e.getMessage());
        }
    }
}