package proj1;
import java.util.Scanner;


public class Main {
    private static Admin admin = new Admin();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) 
    {
    	//------------------------- DISPLAY MENU ---------------------------
        while (true) 
        {
        	System.out.print("\n");
            System.out.println("				--> Welcome to the Account Management System <-- ");
        	System.out.print("\n");
            System.out.println("1. Open Account");
            System.out.println("2. Close Account");
            System.out.println("3. Log In");
            System.out.println("4. Set Savings Interest Rate");
            System.out.println("5. Display All Account Details");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline
            int accountNumber;
            switch (choice) 
            {
                case 1:
                	System.out.print("\n");
                    System.out.print("Enter customer name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter customer address: ");
                    String address = scanner.nextLine();
                    System.out.print("Enter customer phone number: ");
                    String phoneNumber = scanner.nextLine();
                    System.out.print("Enter initial balance: ");
                    double initialBalance = scanner.nextDouble();
                    scanner.nextLine(); // Consume the newline
                    System.out.print("Enter account type (savings/checking): ");
                    String accountType = scanner.nextLine();
                    admin.openAccount(name, address, phoneNumber, initialBalance, accountType);
                    break;
                    
                case 2:
                	System.out.print("\n");
                    System.out.print("Enter account number to close: ");
                    accountNumber = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline
                    admin.closeAccount(accountNumber);
                    break;
                    
                case 3:
                	System.out.print("\n");
                	System.out.print("Enter account number to log in: ");
                    accountNumber = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline
                    Accounts account = admin.login(accountNumber);
                    if (account != null) 
                    {
                        Customer customer = account.getcustomer(); 
                        System.out.print("\n");
                        System.out.println("---> Logged in as : " + customer.getName());
                        performAccountOperations(account);
                    } 
                    else 
                    {
                        System.out.println("Account not found.");
                    }
                    break;
                    
                case 4:
                	System.out.print("\n");
                	System.out.print("Enter new savings interest rate (as a decimal): ");
                    double interestRate = scanner.nextDouble();
                    scanner.nextLine(); // Consume the newline
                    admin.setSavingsInterestRate(interestRate);
                    break;
                    
                case 5:
                	System.out.print("\n");
                	admin.displayAllAccountDetails();
                    break;
                    
                default:
                	System.out.print("\n");
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
  //------------------------- ACCOUNT OPERATIONS ---------------------------
    private static void performAccountOperations(Accounts account) {
        while (true) 
        {
            System.out.println("\n----> Account Options <----");
        	System.out.print("\n");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Print Statement");
            System.out.println("5. Transfer Money");
            System.out.println("6. Calculate Zakat (Savings Account)");
            System.out.println("7. Display All Deductions");
            System.out.println("8. Logout");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline
            double amount;
            switch (choice) 
            {
                case 1:
                	System.out.print("\n");
                	System.out.print("Enter the amount to deposit: ");
                    amount = scanner.nextDouble();
                    scanner.nextLine(); // Consume the newline
                    account.makeDeposit(amount);
                    break;
                    
                case 2:
                	System.out.print("\n");
                	System.out.print("Enter the amount to withdraw: ");
                    amount = scanner.nextDouble();
                    scanner.nextLine(); // Consume the newline
                    account.makeWithdrawal(amount);
                    break;
                    
                case 3:
                	System.out.print("\n");
                	account.CheckBalance();
                    break;
                    
                case 4:
                	System.out.print("\n");
                	account.printStatement();
                    break;
                    
                case 5:
                	System.out.print("\n");
                    transferMoney(account);
                    break;
                    
                case 6:
                	System.out.print("\n");
                	account.calculateZakat();
                    break;
                    
                case 7:
                	System.out.print("\n");
                	account.displayAllDeductions();
                    break;
                    
                case 8:
                	System.out.print("\n");
                	System.out.print("Logged Out");
                    return; // Logout
                    
                default:
                	System.out.print("\n");
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
    
    private static void transferMoney(Accounts sourceAccount) 
    {
        System.out.print("Enter the target account number: ");
        int targetAccountNumber = scanner.nextInt();
        scanner.nextLine(); // Consume the newline

        Accounts targetAccount = admin.login(targetAccountNumber);
        if (targetAccount != null) 
        {
            System.out.print("Enter the amount to transfer: ");
            double amount = scanner.nextDouble();
            scanner.nextLine(); // Consume the newline

            sourceAccount.transferAmount(targetAccount, amount);
        } 
        else 
        {
            System.out.println("Target account not found.");
        }
    }
}
