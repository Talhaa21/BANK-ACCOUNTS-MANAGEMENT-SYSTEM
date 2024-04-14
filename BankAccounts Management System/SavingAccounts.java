package proj1;

public class SavingAccounts extends Accounts 
{
    private static double interestRate = 0.02; // Default interest rate (2%)
    
  //------------------------- CONSTRUCTORS ---------------------------
    public SavingAccounts() 
    {
    	////
    }

    // Constructor for SavingsAccount
    public SavingAccounts(int accountNumber, double initialBalance, Customer customer) 
    {
        super(accountNumber, initialBalance, customer);
    }
    
  //------------------------- CALCULATE INTEREST RATE ---------------------------
    public void calculateInterest() 
    {
        double interest = super.checkBalance() * interestRate;
        super.makeDeposit(interest);
        System.out.println("Interest earned: " + interest + " PKR");
    }

  //------------------------- SET INTEREST RATE ---------------------------
    public static void setInterestRate(double rate) 
    {
        if (rate >= 0) 
        {
            interestRate = rate;
            System.out.println("Interest rate set to: " + (rate * 100) + "%");
        } 
        else 
        {
            System.out.println("Invalid interest rate.");
        }
    }

  //------------------------- ZAKAT FOR SAVING ONLY ---------------------------
    @Override
    public void calculateZakat() 
    {
        if (balance >= 20000) 
        {
            double zakat = (balance * 2.5) / 100;
            System.out.println("Zakat for this account: " + zakat + " PKR");
        } 
        else 
        {
            System.out.println("Zakat is not applicable to this account.");
        }
    }

  //------------------------- SHOW ALL DEDUCTIONS ---------------------------
    
    // Override displayAllDeductions to show interest rate and Zakat
    @Override
    public void displayAllDeductions() 
    {
        super.displayAllDeductions();
        calculateZakat(); 
        System.out.println("Interest Rate: " + (interestRate * 100) + "%");
    }
}

