package Task2;

import java.util.ArrayList;
import java.util.List;

//------------------ BOOK ROOMS -----------------

//----------------- INHERITED CLASS FROM HOTEL -----------------------
class Room extends Hotel
{
    private int roomNumber;
    private String roomType;
    private boolean isAvailable;
    
    //---------- DEFAULT CONSTRUCTOR --------------------
    public Room()
    {
    	roomNumber=0;
    	roomType = null;
    	isAvailable = false;
    }

    //----------- PARAMETERIZED CONSTRUCTOR ----------------
    public Room(int roomNumber, String roomType) 
    {
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.isAvailable = true;
    }

    // ------------- GETTERS -------------
    public int getRoomNumber() 
    {
        return roomNumber;
    }

    public String getRoomType() 
    {
        return roomType;
    }

    public boolean isAvailable() 
    {
        return isAvailable;
    }

    
    public void bookRoom() 
    {
        isAvailable = false;
    }

    public void reserveRoom() 
    {
        isAvailable = false;
    }
    
    //--------- SETTERS --------------
    public void markAvailable() 
    {
        isAvailable = true;
    }
    
    public void setRoomNumber(int roomNumber) 
    {
        this.roomNumber = roomNumber;
    }
    
    public void setRoomType(String roomType) 
    {
        this.roomType = roomType;
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
    
    //----------------------------------------------------------
    public Room getRoomByNumber(int roomNumber) 
    {
        for (Room room : rooms) 
        {
            if (room.getRoomNumber() == roomNumber) 
            {
                return room;
            }
        }
        return null; // Return null if the room with the specified number is not found
    }

    
  //----------- OVER RIDE FUNCTION -----------------
    public String bookRoom(int guestId, int roomNumber, int checkInDate, int checkOutDate , int Bill) 
    {
        Guest guest = searchGuest(guestId);
        if (guest != null) {
            for (Room room : rooms) 
            {
                if (room.getRoomNumber() == roomNumber && room.isAvailable()) 
                {
                    room.bookRoom();
                    int reservationId = reservations.size() + 1;
                    Reservation reservation = new Reservation(reservationId, guest, room, checkInDate, checkOutDate);
                    reservations.add(reservation);
                    return "Room " + roomNumber + " has been booked for " + guest.getName() + ". Reservation ID: " + reservationId + ". Total Bill Charges: " + Bill + "$";
                }
            }
            return "Room not available";
        } 
        else 
        {
            return "Guest not found";
        }
    }
 
}                   
