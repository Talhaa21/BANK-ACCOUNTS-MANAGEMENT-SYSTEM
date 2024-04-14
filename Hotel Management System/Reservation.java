package Task2;

import java.util.ArrayList;
import java.util.List;

//--------------------------- RESERVE ROOM CLASS ------------------
	
	//--------------- INHERITED CLASS FROM HOTEL ------------------

class Reservation extends Hotel 
{
    private int reservationId;
    private Guest guest;
    private Room room;
    private int checkInDate;
    private int checkOutDate;
    
    //--------------------- DEFAULT CONSTRUCTOR ---------------------
    public Reservation() 
    {
        reservationId = 0;
        checkInDate = 0;
        checkOutDate = 0;
    }

    // -------------------- PARAMETERIZED CONSTRUCTOR -----------------
    public Reservation(int reservationId, Guest guest, Room room, int checkInDate, int checkOutDate) 
    {
        this.reservationId = reservationId;
        this.guest = guest;
        this.room = room;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
    }
    
    // ------------- GETTERS ---------------
    public int getReservationId() 
    {
        return reservationId;
    }

    public Guest getGuest() 
    {
        return guest;
    }

    public Room getRoom() 
    {
        return room;
    }

    public int getCheckInDate() 
    {
        return checkInDate;
    }

    public int getCheckOutDate() 
    {
        return checkOutDate;
    }
    
    // -------------- SETTERS -----------------
    
    public void setReservationId(int reservationId) 
    {
        this.reservationId = reservationId;
    }

    public void setGuest(Guest guest) 
    {
        this.guest = guest;
    }

    public void setRoom(Room room) 
    {
        this.room = room;
    }

    public void setCheckInDate(int checkInDate) 
    {
        this.checkInDate = checkInDate;
    }

    public void setCheckOutDate(int checkOutDate) 
    {
        this.checkOutDate = checkOutDate;
    }
    
    // ------------------- FUNCTIONS -----------------------
    
    int calculateDays(int checkIn , int checkout)
    {
    	return checkout - checkIn;
    }
    
    //---------------- OVER RIDED FUNCTION ----------------
    public String reserveRoom(int roomNumber , String GuestName) 
    {
        for (Room room : rooms) 
        {
            if (room.getRoomNumber() == roomNumber && room.isAvailable()) 
            {
                room.reserveRoom();
                return "Room " + roomNumber + " has been reserved for " + GuestName;
            }
        }
        return "Room not available";
    }
    
  //----------- OVER RIDE FUNCTION -----------------
    public List<Room> getAvailableRooms() 
    {
        List<Room> availableRooms = new ArrayList<>();
        for (Room room : rooms) 
        {
            if (room.isAvailable()) 
            {
                availableRooms.add(room);
            }
        }
        return availableRooms;
    }
}
