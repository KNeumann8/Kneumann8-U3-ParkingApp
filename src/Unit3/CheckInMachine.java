package Unit3;

import Unit1.RandomTime;

import java.time.LocalTime;
import java.util.Scanner;

public enum CheckInMachine {
    CHECK_IN_MACHINE;

    TicketFactory ticketFactory = new TimedTicketFactory();
    TicketFactory eventTicketFactory = new EventTicketFactory();

    public Ticket carArrives(int ticketID){
        Scanner keyboard = new Scanner(System.in);
        String input;
        int menuChoice = 0;
        boolean validInput;
        do{
            validInput = true;
            printMenu();
            input = keyboard.nextLine();
            if(input == "") validInput = false;
            else{
                if(Character.isDigit(input.charAt(0))){
                    if(Character.getNumericValue(input.charAt(0))==1) menuChoice = 1;
                    else if(Character.getNumericValue(input.charAt(0))==2) menuChoice = 2;
                    else validInput = false;
                }
            }
        }while(!validInput);
        if(menuChoice ==2){
            return createTicket(eventTicketFactory, ticketID);
        }
        else{
            return createTicket(ticketFactory, ticketID);
        }
    }

    private void printMenu(){
        System.out.println("*Sue Doe's Garage*");
        System.out.println("==================");
        System.out.println("1: Check In");
        System.out.println("2: Event Check In");
        System.out.println("Please choose \n" +
                "one of our \n" +
                "plentiful options");
    }

    private Ticket createTicket(TicketFactory ticketFactory, int ticketID){
        LocalTime earliestTime = LocalTime.parse("07:00");
        RandomTime rand = new RandomTime(LocalTime.parse("07:00"),LocalTime.parse("12:00"));
        Ticket newTicket = ticketFactory.createTicket(ticketID, rand.getTime());
        System.out.println("=========Sue Doe's Garage=========");
        System.out.println("You Have Been Issued Ticket ID: "+ticketID);
        return newTicket;
    }
}
