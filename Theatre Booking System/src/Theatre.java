import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Theatre {
 /**
 ** This code defines a public class called Theatre.
 **/

    static Scanner input = new Scanner(System.in);

    //Row1, 2, and 3 represent seats in the theatre.
    static final int[] Row1 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    static final int[] Row2 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    static final int[] Row3 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    static ArrayList<Ticket> Tickets = new ArrayList<>();

    // Declare two static integer variables.
    static int RowNumber;
    static int SeatNumber;

    public static void theatre() {
        System.out.println("Welcome to the New Theatre");
        int option;
        do{
            // Print menu options.
            System.out.println("-".repeat(40));
            System.out.println("\nPlease select an option: ");
            System.out.println("1) Buy a ticket");
            System.out.println("2) Print seating area");
            System.out.println("3) Cancel ticket");
            System.out.println("4) List available seats");
            System.out.println("5) Save to file");
            System.out.println("6) Load from file");
            System.out.println("7) Print ticket information and total price");
            System.out.println("8) Sort tickets by price");
            System.out.println("\t0) Quit");
            System.out.println("-".repeat(40));

            System.out.print("Enter option: ");

            // Read input from user and handle exceptions.
            option=-1;
            try {
                option = input.nextInt();
            }catch (Exception e){
                input.next();
            }

            // Use switch statement to execute different options based on user input.
            switch (option) {
                case 1:
                    buy_a_ticket();
                    break;
                case 2:
                    print_seating_area();
                    break;
                case 3:
                    cancel_ticket();
                    break;
                case 4:
                    list_available_seat();
                    break;
                case 5:
                    save_to_file();
                    break;
                case 6:
                    load_from_file();
                    break;
                case 7:
                    print_ticket_information_and_total_price();
                    break;
                case 8:
                    sort_tickets_by_price();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("You Entered a Wrong input");
                    break;

            }
        }
        while (option != 0);  // Repeat the do-while loop until the user enters 0 to quit.
    }

    //This method prints the buy a ticket.
    public static void buy_a_ticket() {

        System.out.println("Enter the Name: ");
        while (input.hasNext(".*\\d+.*")) {  // loop until valid input is entered.
            System.out.println("Invalid letter.");
            input.next();  //This line reads the user input and discards it.
            System.out.print("Enter the Name: ");
        }
        String name = input.next();  //User input is assigned to a variable called "name".

        System.out.println("Enter the Surname: ");
        while (input.hasNext(".*\\d+.*")) {  //The while loop checks if user input contains any digits.
            System.out.println("Invalid letter.");
            input.next();  //This line reads the user input and discards it.
            System.out.print("Enter the Surname: ");
        }
        String surname = input.next();  //User input is assigned to a variable called "surname".

        System.out.println("Enter the Email: ");
        String email = input.next();  //User input is assigned to a variable called "email".

        Person person=new Person(name,surname,email);  //Creating an object of type "Person" with name, surname, and email values entered by user.

        while (true){  // loop until valid input is entered.
            try {
                System.out.println("Enter row number: ");
                RowNumber=input.nextInt();  // read integer input from user.
                if(RowNumber <= 3 && RowNumber > 0){  // check if input is valid.
                    break;
                }
            }catch (Exception e){  // handle any exceptions that may occur.
                input.next();
            }
            System.out.println("Invalid row number");

        }
        boolean running=true;  // set running to true.
        while (running){  // loop until valid input is entered.
            try {
                System.out.println("Enter seat number: ");
                SeatNumber = input.nextInt();  // read integer input from user.
            }catch (Exception e){  // handle any exceptions that may occur.
                System.out.println("Invalid Seat Number");
                input.next();
            }
            switch (RowNumber) { // check which row the user selected.
                case 1: {  // if row 1 is selected.
                    if (SeatNumber > 0 && SeatNumber <= 12) {  // check if seat number is valid.
                        if (Row1[SeatNumber - 1] == 0) {  // check if seat is available.
                            System.out.println("Seat is Available.");
                            Row1[SeatNumber - 1] = 1;  // mark seat as taken.
                            Ticket ticket = new Ticket(RowNumber, SeatNumber, 8000.0, person);  // create a new Ticket object.
                            Tickets.add(ticket);
                        } else {
                            System.out.println("Seat is not Available.");
                        }
                        running=false;  // exit loop.
                    } else {
                        System.out.println("Invalid Seat Number");
                    }
                }
                break;
                case 2: {  // if row 2 is selected.
                    if (SeatNumber > 0 && SeatNumber <= 16) {  // check if seat number is valid.
                        if (Row2[SeatNumber - 1] == 0) {  // check if seat is available.
                            System.out.println("Seat is Available.");
                            Row2[SeatNumber - 1] = 1;  // mark seat as taken.
                            Ticket ticket = new Ticket(RowNumber, SeatNumber, 5000.0, person);  // create a new Ticket object.
                            Tickets.add(ticket);
                        } else {
                            System.out.println("Seat is not Available.");
                        }
                        running=false;  // exit loop.
                    } else {
                        System.out.println("Invalid Seat Number");
                    }
                }
                break;
                case 3: {  // if row 3 is selected.
                    if (SeatNumber > 0 && SeatNumber <= 20) {  // check if seat number is valid.
                        if (Row3[SeatNumber - 1] == 0) {  // check if seat is available.
                            System.out.println("Seat is Available.");
                            Row3[SeatNumber - 1] = 1;  // mark seat as taken
                            Ticket ticket = new Ticket(RowNumber, SeatNumber, 2000.0, person);  // create a new Ticket object.
                            Tickets.add(ticket);
                        } else {
                            System.out.println("Seat is not Available.");
                        }
                        running=false;  // exit loop
                    } else {
                        System.out.println("Invalid Seat Number");
                    }
                }
                break;
            }

        }
    }

    // This method prints the seating area.
    public static void print_seating_area() {
        // Print the stage.
        System.out.println(" ".repeat(4) + "*".repeat(13));
        System.out.println(" ".repeat(4) + "*  STAGE  *");
        System.out.println(" ".repeat(4) + "*".repeat(13));

        // Print the first row of seats.
        System.out.print(" ".repeat(4));
        for (int x = 0; x < Row1.length; x++) {  // Loops through the first row of seats.
            if (x == Row1.length / 2) {  // If the middle seat is reached.
                System.out.print(" ");
            }
            if (Row1[x] == 0) {  // If the seat is empty.
                System.out.print("O");
            } else {  // If the seat is taken.
                System.out.print("X");
            }
        }
        System.out.println();  // Move to the next line.

        // Print the second row of seats.
        System.out.print(" ".repeat(2));
        for (int x = 0; x < Row2.length; x++) {  // Loops through the second row of seats.
            if (x == Row2.length / 2) {  // If the middle seat is reached.
                System.out.print(" ");
            }
            if (Row2[x] == 0) {  // If the seat is empty.
                System.out.print("O");
            } else {  // If the seat is taken.
                System.out.print("X");
            }
        }
        System.out.println();  // Move to the next line.

        // Print the third row of seats.
        for (int x = 0; x < Row3.length; x++) {  // Loops through the third row of seats.
            if (x == Row3.length / 2) {  // If the middle seat is reached.
                System.out.print(" ");
            }
            if (Row3[x] == 0) {  // If the seat is empty.
                System.out.print("O");
            } else {
                System.out.print("X");
            }
        }
        System.out.println();  // Move to the next line.
    }

    //This method prints the cancel ticket.
    public static void cancel_ticket() {
        System.out.print("Enter the Row Number: ");
        RowNumber = input.nextInt();
        System.out.print("Enter the Seat Number: ");
        SeatNumber = input.nextInt();
        boolean havetocancel = false;

        switch (RowNumber) {
            case 1: {  // If the Row Number is 1.
                if (SeatNumber > 0 && SeatNumber <= 12) {  // If the Seat Number is between 1 and 12.
                    if (Row1[SeatNumber - 1] == 1) {  // If the seat is booked.
                        havetocancel = true;
                        System.out.println("Seat Booking is Cancelled. ");
                        Row1[SeatNumber - 1] = 0;  // Set the seat to unbooked.
                    } else {  // If the seat is not booked.
                        System.out.println("Seat is not Booked. ");
                    }

                } else {  // If the Seat Number is not between 1.
                    System.out.println("Invalid Seat Number. ");
                }
            }
            break;
            case 2: {  // If the Row Number is 2.
                if (SeatNumber > 0 && SeatNumber <= 16) {  // If the Seat Number is between 1 and 16.
                    if (Row2[SeatNumber - 1] == 1) {  // If the seat is booked.
                        havetocancel = true;
                        System.out.println("Seat Booking is Cancelled. ");
                        Row2[SeatNumber - 1] = 0;  // Set the seat to unbooked.
                    } else {  // If the seat is not booked.
                        System.out.println("Seat is not Booked. ");
                    }
                } else {  // If the Seat Number is not between 1 and 16.
                    System.out.println("Invalid Seat Number. ");
                }
            }
            break;
            case 3: {  // If the Row Number is 3.
                if (SeatNumber > 0 && SeatNumber <= 20) {  // If the Seat Number is between 1 and 20.
                    if (Row3[SeatNumber - 1] == 1) {  // If the seat is booked.
                        havetocancel = true;
                        System.out.println("Seat Booking is Cancelled. ");
                        Row3[SeatNumber - 1] = 0;  // Set the seat to unbooked.
                    } else {  // If the seat is not booked.
                        System.out.println("Seat is not Booked. ");
                    }

                } else {  // If the Seat Number is not between 1 and 20.
                    System.out.println("Invalid Seat Number. ");
                }
            }
            break;
            default:  // If the Row Number is not 1, 2 or 3.
                System.out.println("Invalid the Row Number. ");
                break;
        }
        if (havetocancel) {  // If the seat has to be cancelled.
            for (int x = 0; x < Tickets.size(); x++) {  // Loop through the Tickets ArrayList.
                if ((Tickets.get(x).Row == RowNumber) && (Tickets.get(x).Seat == SeatNumber)) {  // If the Row and Seat match.
                    Tickets.remove(x);
                }
            }
        }
    }

    public static void list_available_seat() {
        // Print available seats in Row 1.
        System.out.print("Seat Available in Row 1: ");
        for (int x = 0; x < Row1.length; x++) {
            if (Row1[x] == 0) {  // Check if seat is available.
                System.out.print((x + 1) + ",");  // Print seat number.
            }
        }
        System.out.println();  // Move to next line.
        // Print available seats in Row 2.
        System.out.print("Seats Available in Row 2: ");
        for (int x = 0; x < Row2.length; x++) {
            if (Row2[x] == 0) {  // Check if seat is available.
                System.out.print((x + 1) + ",");  // Print seat number.
            }
        }
        System.out.println();  // Move to next line.
        System.out.print("Seats Available in Row 3: ");
        for (int x = 0; x < Row3.length; x++) {
            if (Row3[x] == 0) {  // Check if seat is available.
                System.out.print((x + 1) + ",");  // Print seat number.
            }
        }
        System.out.println();  // Move to next line.
    }

    public static void save_to_file() {
        try {
            FileWriter fWrite = new FileWriter("data.txt");

            for (int x : Row1) {
                fWrite.write(x + ",");  // Write each element followed by a comma.
            }
            fWrite.write("\n");

            // Write Row 2 data to file.
            for (int x : Row2) {
                fWrite.write(x + ",");  // Write each element followed by a comma.
            }
            fWrite.write("\n");

            // Write Row 3 data to file.
            for (int x : Row3) {
                fWrite.write(x + ",");  // Write each element followed by a comma.
            }
            fWrite.write("\n");
            fWrite.close();
            System.out.println("Data Successfully Imported. ");
        } catch (Exception y) {  // Catch any exceptions thrown.
            System.out.println(y);
        }
    }

    public static void load_from_file() {
        try {
            FileReader fRead = new FileReader("data.txt");  // Create a new file reader.
            Scanner input = new Scanner(fRead);  // Create a new scanner object.

            // Loop through each row.
            for (int x = 0; x < 3; x++) {
                String[] a = input.nextLine().split(",");  // Read the next line and split it into an array.

                // Load data into Row 1.
                if (x == 0) {
                    for (int y = 0; y < a.length; y++) {
                        Row1[y] = Integer.parseInt(a[y]);  // Parse each element as an integer and store it in Row 1.
                    }
                }
                // Load data into Row 2.
                else if (x == 1) {
                    for (int y = 0; y < a.length; y++) {
                        Row2[y] = Integer.parseInt(a[y]);  // Parse each element as an integer and store it in Row 2.
                    }
                }
                // Load data into Row 3.
                else {
                    for (int y = 0; y < a.length; y++) {
                        Row3[y] = Integer.parseInt(a[y]);  // Parse each element as an integer and store it in Row 3
                    }
                }
            }
        } catch (Exception e) {  // Catch any exceptions thrown.
            System.out.println(e);
        }
    }
    public static void print_ticket_information_and_total_price() {
        double Total = 0;  // Initialize Total to 0.
        for (Ticket x : Tickets) {  // Loop through each ticket in Tickets list.
            x.print();  // Print the ticket information.
            Total += x.Price;  // Add the price of the ticket to Total.
        }
        System.out.println("Total is Rs." + Total);
    }

    public static void sort_tickets_by_price() {
        int bottom = Tickets.size() - 2;  // Set bottom to second last index of Tickets list.
        Ticket temp;  // Declare a temporary Ticket variable.
        boolean exchanged = true;  // Initialize exchanged to true.
        while (exchanged) {  // Loop until exchanged is false.
            exchanged = false;
            for (int x = 0; x <= bottom; x++) {  // Loop through each ticket in Tickets list up to bottom index.
                if(Tickets.get(x).Price > Tickets.get(x + 1).Price) {  // If current ticket's price is greater than next ticket's price.
                    temp = Tickets.get(x);  // Swap current ticket with next ticket using temporary variable temp.
                    Tickets.set(x,Tickets.get(x + 1));
                    Tickets.set(x + 1, temp);
                    exchanged = true;  // Set exchanged to true.
                }
            }
            bottom--;  // Decrement bottom by 1.
        }
    }

}
