package Unit1;

import java.time.LocalTime;
import java.util.Scanner;

public class CheckInMachine {

//    public Unit1.CheckInMachine(){
//
//    }

    public static Ticket carArrives(int ticketID){
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
        if(menuChoice ==2) System.out.println("not an option :P");
        LocalTime earliestTime = LocalTime.parse("07:00");
        RandomTime rand = new RandomTime(LocalTime.parse("07:00"),LocalTime.parse("12:00"));
        Ticket newTicket = new Ticket(ticketID,rand.getTime());
        System.out.println("=========Sue Doe's Garage=========");
        System.out.println("You Have Been Issued Unit1.Ticket ID: "+ticketID);
        return newTicket;
    }

    private static void printMenu(){
        System.out.println("*Sue Doe's Garage*");
        System.out.println("==================");
        System.out.println("1: Check In");
        System.out.println("2: Don't");
        System.out.println("Please choose \n" +
                           "one of our \n" +
                           "plentiful options");
    }

}
