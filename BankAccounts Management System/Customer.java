package proj1;

public class Customer 
{
  protected String name;
  private String address;
  private String phone;
  private int CID;

//------------------------- CONSTRUCTORS ---------------------------
  //Default Constructor
  public Customer()
  {
	  name=null;
	  address=null;
	  phone=null;
	  CID=0;
  }
  
  // Parameterised Constructor 
  public Customer(String name, String address, String phone) 
  {
      this.name = name;
      this.address = address;
      this.phone = phone;
  }
  
//------------------------- SETTERS ---------------------------
  public void setName(String name)
  {
	  this.name=name;
  }
  
  public void setadress(String address)
  {
	  this.address=address;
  }
  
  public void setphoneNo(String phone)
  {
	  this.phone=phone;
  }
  
  public void setID(int CID)
  {
	  this.CID=CID;
  }

//------------------------- GETTERS ---------------------------
  public String getName() 
  {
      return name;
  }

  public String getAddress() 
  {
      return address;
  }

  public String getPhoneNumber() 
  {
      return phone;
  }

  public int getCustomerID() 
  {
      return CID;
  }

}

