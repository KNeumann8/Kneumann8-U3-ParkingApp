package Unit3;


import java.time.LocalTime;
import java.util.Scanner;

public enum CheckOutMachine {
    CHECK_OUT_MACHINE;

    public void carLeaves(Ticket customerTicket){
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
        if(menuChoice == 1){
            RandomTime rand = new RandomTime(LocalTime.parse("13:00"),LocalTime.parse("23:00"));
            customerTicket.setEndTime(rand.getTime());
        }
        else if(menuChoice==2){
            customerTicket.setFeeBehavior(new LostFee());
        }
        customerTicket.display();
    }

    private void printMenu(){
        System.out.println("*Sue Doe's Garage*");
        System.out.println("==================");
        System.out.println("1: Check Out");
        System.out.println("2: Lost Ticket");
    }
}
