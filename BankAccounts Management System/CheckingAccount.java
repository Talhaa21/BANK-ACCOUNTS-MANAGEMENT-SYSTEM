package proj1;

public class CheckingAccount extends Accounts 
{
    private static final double TRANSACTION_FEE = 10.0;
    private int freeTransactionCount;
    private double transactionFeeTotal;

  //------------------------- CONSTRUCTORS ---------------------------
    
    // Constructor for CheckingAccount
    public CheckingAccount(int accountNumber, double initialBalance, Customer customer) 
    {
        super(accountNumber, initialBalance, customer);
        this.freeTransactionCount = 2; // Two free transactions per month
        this.transactionFeeTotal = 0.0;
    }

  //------------------------- WITHDRAW AMOUNT FOR TAX DEDUCTION---------------------------
    
    // Override makeWithdrawal method to handle transaction fees
    @Override
    public void makeWithdrawal(double amount) 
    {
        if (amount > 0) 
        {
        	//-------First 2 Free Transactions ---------------
            if (freeTransactionCount > 0) 
            {
                super.makeWithdrawal(amount);
                freeTransactionCount--;
            } 
          //---------Tax after 2 Transactions -----------------
            else 
            {
                double totalAmount = amount + TRANSACTION_FEE;
                if (super.checkBalance() >= totalAmount) 
                {
                    super.makeWithdrawal(totalAmount);
                    transactionFeeTotal += TRANSACTION_FEE;
                } 
                else 
                {
                    System.out.println("Insufficient balance for withdrawal.");
                }
            }
        } 
        else 
        {
            System.out.println("Invalid withdrawal amount.");
        }
    }

  //------------------------- DISPLAY TRANSACTION FEE ---------------------------
    
    // Override displayAllDeductions to show transaction fees
    @Override
    public void displayAllDeductions() 
    {
        super.displayAllDeductions();
        System.out.println("Transaction Fees Total: " + transactionFeeTotal + " PKR");
        System.out.println("Transaction Fees (if any): 10 PKR per additional transaction");
    }
}

