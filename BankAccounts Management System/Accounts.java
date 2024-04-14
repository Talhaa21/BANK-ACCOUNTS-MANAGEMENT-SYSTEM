package proj1;

public class Accounts 
{
    protected int accountNo;
    protected double balance;
    protected String dateCreated;
    protected Customer customer;
    
    //---------------------------------- CONSTRUCTORS ------------------------------------------
    // Default Constructor
    Accounts()
    {
    	accountNo=0;
    	balance=0;
    	dateCreated=null;
    	customer=null;
    }
    
    // Parameterised Constructor
    public Accounts(int accountNo, double balance, Customer customer) 
    {
        this.accountNo = accountNo;
        this.balance = balance;
        this.customer = customer;
    }
    
    //------------------------------------ SETTERS -------------------------------------------------
    
    public void setAccNo(int accountNo)
    {
  	  this.accountNo=accountNo;
    }
    
    public void setdate(String dateCreated)
    {
  	  this.dateCreated=dateCreated;
    }
    
    public void setcustomer(Customer customer)
    {
  	  this.customer=customer;
    }
   
    public void setBalance(double balance) 
    {
        this.balance = balance;
    }
    
    //------------------------------------- GETTERS ------------------------------------------------
    
    
    public double checkBalance() 
    {
        return balance;
    }
    
    public int getAccountNumber() 
    {
        return accountNo;
    }
    
    public String getdate() 
    {
        return dateCreated;
    }
    
    public Customer getcustomer() 
    {
        return customer;
    }

    //--------------------------------- OTHER FUNCTIONALITIES --------------------------------------
    
    //  1 ----- Make Deposit --------
    public void makeDeposit(double amount) 
    {
        if (amount > 0) 
        {
            balance += amount;
            System.out.println("Deposit of " + amount + " PKR successful.");
        } 
        else 
        {
            System.out.println("Invalid deposit amount.");
        }
    }
    
    
    // 2 -------- Make Withdrawal ------
    public void makeWithdrawal(double amount) 
    {
        if (amount > 0) 
        {
            if (balance >= amount) 
            {
                balance -= amount;
                System.out.println("Withdrawal of " + amount + " PKR successful.");
            } 
            else 
            {
                System.out.println("Insufficient balance for withdrawal.");
            }
        } 
        else 
        {
            System.out.println("Invalid withdrawal amount.");
        }
    }

    // 3 -------- Check Balance ----- 
    public void CheckBalance() 
    {
    	System.out.println("Customer: " + customer.getName());
    	System.out.println("Balance: " + balance + " PKR");
    }

    // 4 ------ Print Statement -----
    public void printStatement() 
    {
        System.out.println("Customer: " + customer.getName());
        System.out.println("Phone Number: " + customer.getPhoneNumber());
        System.out.println("Account Number: " + accountNo);
        System.out.println("Date and Time: " + dateCreated);
        System.out.println("Transaction Amount: " + balance + " PKR");
        System.out.println("Remaining Balance: " + balance + " PKR");
    }

    // 5 ----- Transfer Amount -------
    public void transferAmount(Accounts targetAccount, double amount) 
    {
        if (amount > 0 && this != targetAccount && balance >= amount) 
        {
            this.makeWithdrawal(amount);
            targetAccount.makeDeposit(amount);
            System.out.println("Transfer of " + amount + " PKR to Account " + targetAccount.getAccountNumber() + " successful.");
        } 
        
        else 
        {
            System.out.println("Invalid transfer.");
        }
    }

    // 6 ------ Calculate Zakat ---------
    public void calculateZakat() 
    {
        System.out.println("Zakat is not applicable to this account.");
    }


    // 7 ------ Display All Deductions ------
    public void displayAllDeductions() 
    {
        //System.out.println("No deductions for this account.");
    }
}

