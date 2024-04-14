package Task2;
import java.util.List;
import java.util.Scanner;



//---------------- MAIN CLASS -------------------------

public class HotelManagementSystem 
{
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
        Hotel hotel = new Hotel("VIP Hotel");

        while (true) 
        {
            System.out.println("Hotel Management System");
            System.out.println("1. Add Room");
            System.out.println("2. Get Available Rooms");
            System.out.println("3. Search Guest");
            System.out.println("4. Add Guest");
            System.out.println("5. Book Room");
            System.out.println("6. Reserve Room");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) 
            {
            	
            	// --------- ADDS A NEW ROOM ----------------
                case 1:
                    System.out.print("Enter Room Number: ");
                    int roomNumber = scanner.nextInt();
                    scanner.nextLine(); 

                    System.out.print("Enter Room Type: ");
                    String roomType = scanner.nextLine();

                    Room room = new Room(roomNumber, roomType);
                    hotel.addRoom(room);
                    hotel.calculateRoomRate();
                    System.out.println("Room added successfully.");
                    scanner.nextLine(); 
                    break;
                    
                  //-------------- DISPLAYS ALL AVAILABLR ROOMS ---------------
                case 2:
                    List<Room> availableRooms = hotel.getAvailableRooms();
                    if (availableRooms.isEmpty()) 
                    {
                        System.out.println("No available rooms.");
                    } 
                    else 
                    {
                        System.out.println("Available rooms:");
                        for (Room availableRoom : availableRooms) 
                        {
                            System.out.println("Room Number: " + availableRoom.getRoomNumber() + ", Room Type: " + availableRoom.getRoomType());
                        }
                    }
                    scanner.nextLine(); 
                    break;
                    
                    
                    //----------------- SEARCH GUEST ------------------
                case 3:
                    System.out.print("Enter Guest ID: ");
                    int guestId = scanner.nextInt();
                    scanner.nextLine(); 

                    Guest guest = hotel.searchGuest(guestId);
                    if (guest != null) 
                    {
                        System.out.println("Guest found - Name: " + guest.getName());
                        System.out.println("Room no: " + guest.getGuestroomNo());
                        System.out.println("Contact Number: " + guest.getContactNumber());
                    } 
                    else 
                    {
                        System.out.println("Guest not found.");
                    }
                    scanner.nextLine(); 
                    break;
                    
                    // -------------- ADDS A NEW GUEST BY INFORMATION ---------------
                case 4:
                    System.out.print("Enter Guest Name: ");
                    String guestName = scanner.nextLine();

                    System.out.print("Enter Guest Contact Number: ");
                    String guestContact = scanner.nextLine();
                    
                    System.out.print("Enter Room no: ");
                    int guestroom= scanner.nextInt();
                    
                    Guest newGuest = new Guest(hotel.guests.size() + 1, guestName, guestContact , guestroom);
                    hotel.addGuest(newGuest);
                    System.out.println("Guest added successfully. Guest id is: " + hotel.guests.size());
                    scanner.nextLine(); 
                    break;
                    
                    //---------------------- BOOK ROOM ---------------------
                case 5:
                    System.out.print("Enter Guest ID: ");
                    guestId = scanner.nextInt();
                    scanner.nextLine(); 

                    System.out.print("Enter Room Number: ");
                    roomNumber = scanner.nextInt();
                    scanner.nextLine(); 

                    System.out.print("Enter Check-In Date: ");
                    int checkInDate = scanner.nextInt();

                    System.out.print("Enter Check-Out Date: ");
                    int checkOutDate = scanner.nextInt();
                    
                    scanner.nextLine();
                    
                    System.out.print("Wifi room? ");
                    String wifi = scanner.nextLine();
                    
                    System.out.print("Do you want MiniBar? ");
                    String minibar = scanner.nextLine();
                    
                    Reservation r = new Reservation();
                    int days = r.calculateDays(checkInDate, checkOutDate);
                    
                    int billAmount = 0;

                    if (wifi.equalsIgnoreCase("yes") && minibar.equalsIgnoreCase("yes") ) 
                    {                        
                        Bill b = new Bill();
                        billAmount = b.enableWifi() + (days * 100) + b.miniBar();   
                    } 
                    
                    if (wifi.equalsIgnoreCase("yes") && !minibar.equalsIgnoreCase("yes") ) 
                    {                        
                        Bill b = new Bill();
                        billAmount = b.enableWifi() + (days * 100);   
                    } 
                    
                    if (!wifi.equalsIgnoreCase("yes") && minibar.equalsIgnoreCase("yes") ) 
                    {                        
                        Bill b = new Bill();
                        billAmount = (days * 100) + b.miniBar();   
                    } 
                    
                    if (!wifi.equalsIgnoreCase("yes") && !minibar.equalsIgnoreCase("yes") )
                    {
                        billAmount = days * 100;                      
                    }
                    
                    String bookingResult = hotel.bookRoom(guestId, roomNumber, checkInDate, checkOutDate, billAmount);
                    System.out.println(bookingResult);
                    scanner.nextLine(); 
                    break;
                    
                    // ----------------------- RESERVE ROOM -------------------------
                case 6:
                    System.out.print("Enter Room Number to Reserve: ");
                    roomNumber = scanner.nextInt();
                    scanner.nextLine(); 
                    
                    System.out.println("Enter Your Name: ");
                    guestName = scanner.next();
                    scanner.nextLine(); 

                    String reserveResult = hotel.reserveRoom(roomNumber , guestName);
                    System.out.println(reserveResult);
                    scanner.nextLine(); 
                    break;
                    
                    //------------------- EXIT MANAGEMENT SYSTEM -------------------
                case 7:
                    System.out.println("Exiting Hotel Management System.");
                    scanner.nextLine(); 
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
                    scanner.nextLine();
            }
        }
    }
}

