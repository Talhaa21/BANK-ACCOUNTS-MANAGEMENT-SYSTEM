package Task2;

import java.util.ArrayList;
import java.util.List;

//----------------- PARENT CLASS HOTEL (ADMIN) -----------------

class Hotel 
{
    private String name;
    public List<Room> rooms;
    List<Guest> guests;
    public List<Reservation> reservations;
    
    // ----------- DEFAULT CONSTRUCTOR -----------
    public Hotel()
    {
    	name = null;
    }
    
    //-------------- PARAMETERIZED CONSTRUCTOR ----------
    public Hotel(String name) 
    {
        this.name = name;
        this.rooms = new ArrayList<>();
        this.guests = new ArrayList<>();
        this.reservations = new ArrayList<>();
    }
    
    //-------------- GETTERS --------------

    public String getName() 
    {
        return name;
    }

    public List<Room> getRooms() 
    {
        return rooms;
    }

    public List<Guest> getGuests() 
    {
        return guests;
    }

    public List<Reservation> getReservations() 
    {
        return reservations;
    }

    // --------------- SETTERS -----------------

    public void setName(String name) 
    {
        this.name = name;
    }

    public void setRooms(List<Room> rooms) 
    {
        this.rooms = rooms;
    }

    public void setGuests(List<Guest> guests) 
    {
        this.guests = guests;
    }

    public void setReservations(List<Reservation> reservations) 
    {
        this.reservations = reservations;
    }
    
    //----------------- FUNCTIONS ---------------------
    
    public void addRoom(Room room) 
    {
        rooms.add(room);
    }

    //----------- OVER RIDE FUNCTION -----------------
    public List<Room> getAvailableRooms() 
    {
        List<Room> availableRooms = new ArrayList<>();
        for (Room room : rooms) {
            if (room.isAvailable()) {
                availableRooms.add(room);
            }
        }
        return availableRooms;
    }
    
    //---------------------------------------------------------------
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

    // ---------------- SEARCH GUEST ON BASIS OF ID -------------------
    public Guest searchGuest(int guestId) 
    {
        for (Guest guest : guests) 
        {
            if (guest.getGuestId() == guestId) 
            {
                return guest;
            }
        }
        return null;
    }
    
  //----------- OVER RIDE FUNCTION -----------------
    public String bookRoom(int guestId, int roomNumber, int checkInDate, int checkOutDate , int Bill) 
    {
        Guest guest = searchGuest(guestId);
        if (guest != null) 
        {
            for (Room room : rooms) 
            {
                if (room.getRoomNumber() == roomNumber && room.isAvailable()) 
                {
                    room.bookRoom();
                    int reservationId = reservations.size() + 1;
                    Reservation reservation = new Reservation(reservationId, guest, room, checkInDate, checkOutDate);
                    reservations.add(reservation);
                    return "Room " + roomNumber + " has been booked for " + guest.getName() + ". Total Bill Charges: " + Bill + "$";
                }
            }
            return "Room not available";
        } 
        else 
        {
            return "Guest not found";
        }
    }

  //----------- OVER RIDE FUNCTION -----------------
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
    
    // ----- ADDS A NEW GIEST ---------------------
    public void addGuest(Guest guest) 
    {
        guests.add(guest);
    }
    
  //----------- OVER RIDE FUNCTION -----------------
    double calculateRoomRate() 
    {
        return 100.0; // $100 per night
    }
}