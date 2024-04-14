package Task2;

//----------------------- BILLING CLASS --------------------

//----------------- INHERITED CLASS ---------------

class Bill extends Hotel
{
    private int billId;
    private double amount;
    private String description;
    
    //---------- DEFAULT CONSTRUCTOR ---------- 
    public Bill()
    {
    	billId = 0;
    	amount = 0;
    	description = null;
    }
    
    //---------- PARAMETERIZED CONSTRUCTOR -----------
    public Bill(int billId, double amount, String description) 
    {
        this.billId = billId;
        this.amount = amount;
        this.description = description;
    }
    
    // -------------- GETTERS ---------------
    public int getBillId() 
    {
        return billId;
    }

    public double getAmount() 
    {
        return amount;
    }

    public String getDescription() 
    {
        return description;
    }
    
    //----------------- SETTERS -------------
    public void setBillId(int billId) 
    {
        this.billId = billId;
    }

    public void setAmount(double amount) 
    {
        this.amount = amount;
    }

    public void setDescription(String description) 
    {
        this.description = description;
    }
    
    //-------------------- FUNCTIONS ---------------
    double calculateRoomRate() 
    {
        return 100.0; // $100 per night
    }
    
    int enableWifi()
    {
    	return 200;  //200$ for wifi
    }
    
    int miniBar()
    {
    	return 100;   //100$ for minibar
    }

}
