package Unit3;

import java.io.Serializable;
import java.text.NumberFormat;

public class TimeDisplay implements DisplayBehavior, Serializable {
    @Override
    public void display(Ticket thisTicket) {
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        System.out.println("Receipt for ticket ID: "+thisTicket.getTicketID());
        System.out.println("Parking duration: " + thisTicket.getDuration());
        System.out.println("Total: " + formatter.format(thisTicket.getTotal()));
    }
}
