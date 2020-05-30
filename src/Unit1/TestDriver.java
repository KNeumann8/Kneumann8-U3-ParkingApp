package Unit1;

import java.time.LocalTime;
import java.util.Random;
import java.util.Scanner;

public class TestDriver {

    public static void main(String[] args) throws InterruptedException {

        LocalTime today = LocalTime.now();
        System.out.println(today);

        String time = "07:25";

        LocalTime newTime = LocalTime.parse(time);

        System.out.println(newTime);//using for test ticket below

        Random rand = new Random();
        System.out.println("rand: "+rand.nextInt(9));
        String anotherTime = rand.nextInt(2)+rand.nextInt(9)+":"+rand.nextInt(6)+rand.nextInt(9);
        System.out.println(anotherTime.toString());


        System.out.println("And now time for our main event!");
        String seven = "07:00", eleven = "11:00";
        LocalTime early = LocalTime.parse(seven),late = LocalTime.parse(eleven);
        RandomTime mainEvent = new RandomTime(early,late);
        System.out.println(mainEvent.getTime().toString());

        //test ceil and time functions:
        System.out.println();

        //Unit1.Ticket creation
        System.out.println("Unit1.Ticket creation");
        Ticket testTicket = new Ticket(15,newTime);
        testTicket.setEndTime(LocalTime.parse("12:27"));
        System.out.println(testTicket.getDuration());
        System.out.println(testTicket.getTotal());

//        System.out.println("*Sue Doe's Garage*");
//        System.out.println("==================");
//        System.out.println("1: Check In");
//        System.out.println("Please choose \n" +
//                "one of our \n" +
//                "plentiful options");

        Scanner keyboard = new Scanner(System.in);
        keyboard.nextLine();

        Ticket newTicket = CheckInMachine.carArrives(9999);
        System.out.println(newTicket.getTotal());

        CheckOutMachine.carLeaves(newTicket);
        System.out.println(newTicket.getTotal());



    }

}
