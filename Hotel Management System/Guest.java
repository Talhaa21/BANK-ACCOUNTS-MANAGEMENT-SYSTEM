package Task2;

import java.util.List;

//---------------------- GUEST CLASS ----------------------
class Guest 
{
    private int guestId;
    private String name;
    private String contactNumber;
    private List<Bill> bills;
    private int roomNo;
    
    //--------- DEFAULT CONSTRUCTOR ----------------
    public Guest() 
    {
        guestId = 0;
        name = null;      
    }

    //------ PARAMETERIZED CONSTRUCTOR ------------
    public Guest(int guestId, String name, String contactNumber , int roomNo) 
    {
        this.guestId = guestId;
        this.name = name;
        this.contactNumber = contactNumber; 
        this.roomNo = roomNo;
    }

    //------ GETTERS -----------
    
    public int getGuestId() 
    {
        return guestId;
    }
    
    public int getGuestroomNo() 
    {
        return roomNo;
    }

    public String getName() {
        return name;
    }
    
    public String getContactNumber() {
        return contactNumber;
    }

    public List<Bill> getBills() 
    {
        return bills;
    }

    public void addBill(Bill bill) 
    {
        bills.add(bill);
    }
    
    //----------- SETTERS --------------

    public void setGuestId(int guestId) 
    {
        this.guestId = guestId;
    }

    public void setName(String name) 
    {
        this.name = name;
    }

    public void setContactNumber(String contactNumber) 
    {
        this.contactNumber = contactNumber;
    }
    
    public void setRoomNo(int roomNo) 
    {
        this.roomNo = roomNo;
    }

}
