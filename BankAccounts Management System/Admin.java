package proj1;
import java.util.ArrayList;
import java.util.List;

public class Admin {
    private List<Customer> customers;
    private List<Accounts> accounts;
    private double savingsInterestRate;
    
  //------------------------- CONSTRUCTORS ---------------------------

    public Admin() 
    {
        customers = new ArrayList<>();
        accounts = new ArrayList<>();
        savingsInterestRate = 0.02; // Default savings interest rate (2%)
    }
    
  //------------------------- ACCOUNT NO ---------------------------
    private int generateAccountNumber() 
    {
        return 10001 + accounts.size();
    }
    
  //------------------------- OPEN ACCOUNT ---------------------------
    public void openAccount(String customerName, String customerAddress, String customerPhoneNumber, double initialBalance, String accountType) 
    {
    	int accountcount=0;
        Customer customer = new Customer(customerName, customerAddress, customerPhoneNumber);
        int accountNumber = generateAccountNumber();
        
        if(accountcount==0)
        {
        	if ("savings".equalsIgnoreCase(accountType)) 
        	{
            SavingAccounts savingsAccount = new SavingAccounts(accountNumber, initialBalance, customer);
            accounts.add(savingsAccount);
            customers.add(customer);
            System.out.println("Account opened successfully.");
            System.out.println("Your Account No is: " + accountNumber);
            accountcount++;
        	} 
        	else if ("checking".equalsIgnoreCase(accountType)) 
        	{
            CheckingAccount checkingAccount = new CheckingAccount(accountNumber, initialBalance, customer);
            accounts.add(checkingAccount);
            customers.add(customer);
            System.out.println("Account opened successfully.");
            System.out.println("Your Account No is: " + accountNumber);
            accountcount++;
        	} 
        	else 
        	{
            System.out.println("Invalid account type. Account not opened.");
        	}
        	if(accountcount>1)
        	{
        		System.out.println("You cannot create more than 1 account (saving/current");
        	}
        }   
    }

    //------------------------- CLOSE ACCOUNT ---------------------------
    public void closeAccount(int accountNumber) 
    {
        Accounts accountToRemove = null;
        Customer customerToRemove = null;
        
        for (Accounts account : accounts) 
        {
            if (account.getAccountNumber() == accountNumber) 
            {
                accountToRemove = account;
                customerToRemove = account.getcustomer();
                break;
            }
        }
        
        if (accountToRemove != null) {
            accounts.remove(accountToRemove);
            customers.remove(customerToRemove);
            System.out.println("Account closed successfully.");
        } 
        else 
        {
            System.out.println("Account not found.");
        }
    }

  //------------------------- LOGIN ---------------------------
    public Accounts login(int accountNumber) 
    {
        for (Accounts account : accounts) 
        {
            if (account.getAccountNumber() == accountNumber) 
            {
                return account;
            }
        }
        return null; // Account not found
    }

  //------------------------- INTEREST RATE ---------------------------
    
    public void setSavingsInterestRate(double interestRate) 
    {
        if (interestRate >= 0) 
        {
            savingsInterestRate = interestRate;
            System.out.println("Savings interest rate set to: " + (interestRate * 100) + "%");
        } 
        else 
        {
            System.out.println("Invalid interest rate.");
        }
    }

  //------------------------- DISPLAY DETAILS --------------------------- 
    
    public void displayAllAccountDetails() 
    {
        for (Customer customer : customers) 
        {
            System.out.println("Customer: " + customer.getName());
            System.out.println("Customer Address: " + customer.getAddress());
            System.out.println("Customer Phone Number: " + customer.getPhoneNumber());

            boolean hasAccounts = false;

            for (Accounts account : accounts) 
            {
                if (account.getcustomer() == customer) 
                {
                    System.out.println("Account Number: " + account.getAccountNumber());
                    System.out.println("Account Type: " + (account instanceof SavingAccounts ? "Savings" : "Checking"));
                    System.out.println("Balance: " + account.checkBalance() + " PKR");
                    account.displayAllDeductions();
                    System.out.println();
                    hasAccounts = true;
                }
            }

            if (!hasAccounts) 
            {
                System.out.println("No accounts found for this customer.");
            }
        }
    }
}

