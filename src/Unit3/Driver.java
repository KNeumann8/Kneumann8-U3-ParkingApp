package Unit3;

import java.io.*;
import java.text.NumberFormat;
import java.util.HashMap;
import java.util.Scanner;

public class Driver {

    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);
        HashMap tickets = new HashMap<Integer, Ticket>();
        String input;
        String fileName = "newtickets";

        //Load tickets:
        try{
            FileInputStream fis = new FileInputStream(fileName);
            ObjectInputStream ois = new ObjectInputStream(fis);
            Object obj;
            while((obj = ois.readObject()) != null){
                tickets = (HashMap) obj;
            }
        }catch(EOFException e){
            //Jedi business. Go back to your drinks.
        }
        catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        catch(IOException e){
            //e.printStackTrace();
            System.out.println("No file found");
        }


        boolean megaLoopControl;
        do{
            megaLoopControl = true;

            boolean validMenuChoice;
            int godMenuChoice = 0;
            do{
                validMenuChoice = true;
                printGodMenu();
                input = keyboard.nextLine();
                if(input == "") validMenuChoice = false;
                else{
                    if(Character.isDigit(input.charAt(0))){
                        if(Character.getNumericValue(input.charAt(0))==1) godMenuChoice = 1;
                        else if(Character.getNumericValue(input.charAt(0))==2) godMenuChoice = 2;
                        else if(Character.getNumericValue(input.charAt(0))==3) godMenuChoice = 3;
                        else validMenuChoice = false;
                    }
                }
            }while(!validMenuChoice);

            switch (godMenuChoice){
                case 1:
                    //Check In
                    boolean loopControl = true;
                    int x = 1;
                    do{
                        if(tickets.keySet().contains(x)) x++;
                        else loopControl = false;
                    }while(loopControl);
                    Ticket newTicket = CheckInMachine.CHECK_IN_MACHINE.carArrives(x);
                    tickets.put(newTicket.getTicketID(),newTicket); //int x is the same as the ticketID
                    break;
                case 2:
                    //Check Out
                    System.out.println("Which ticket ID is returning?");
                    input = keyboard.nextLine();
                    int id = Integer.parseInt(input);
                    CheckOutMachine.CHECK_OUT_MACHINE.carLeaves((Ticket) tickets.get(id));
                    break;
                case 3:
                    //Close Garage

                    double ticketTotal= 0;
                    double eventTicketTotal = 0;
                    double lostTicketTotal = 0;

                    for(Object k : tickets.keySet()){
                        if(!((Ticket) tickets.get(k)).isLost()){
                            if(((Ticket) tickets.get(k)) instanceof EventTicket){
                                eventTicketTotal += ((Ticket) tickets.get(k)).getTotal();
                            }
                            else{
                                ticketTotal += ((Ticket) tickets.get(k)).getTotal();
                            }
                        }
                        else{
                            lostTicketTotal+= ((Ticket) tickets.get(k)).getTotal();
                        }
                    }
                    NumberFormat formatter = NumberFormat.getCurrencyInstance();
                    System.out.println("Sue Doe's Garage");
                    System.out.println("Activity to date");
                    System.out.println(formatter.format(ticketTotal)+" was collected from check-ins");
                    System.out.println(formatter.format(eventTicketTotal)+" was collected from event parking");
                    System.out.println(formatter.format(lostTicketTotal) + " was collected from lost tickets");
                    System.out.println(formatter.format(((lostTicketTotal)+ticketTotal))+" was collected total");



                    try{
                        FileOutputStream fos = new FileOutputStream(fileName);
                        ObjectOutputStream oos = new ObjectOutputStream(fos);
                        oos.writeObject(tickets);
                        oos.close();
                    }catch (IOException e){
                        e.printStackTrace();
                    }

                    megaLoopControl = false;
                    break;
            }

        }while(megaLoopControl);



    }

    private static void printGodMenu(){
        System.out.println("==== GOD  MENU ====");
        System.out.println("1: Car at check in");
        System.out.println("2: Car at check out");
        System.out.println("3: Close the garage");
    }
}
