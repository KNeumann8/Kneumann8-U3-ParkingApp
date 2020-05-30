package Unit3;

import java.io.Serializable;
import java.text.NumberFormat;

public class EventDisplay implements DisplayBehavior, Serializable {
    @Override
    public void display(Ticket thisTicket) {
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        System.out.println("Receipt for ticket ID: "+thisTicket.getTicketID());
        System.out.println("Special Event Parking");
        System.out.println("Total: " + formatter.format(thisTicket.getTotal()));
    }
}
