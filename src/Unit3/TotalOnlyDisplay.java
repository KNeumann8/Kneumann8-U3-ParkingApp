package Unit3;

import java.io.Serializable;
import java.text.NumberFormat;

public class TotalOnlyDisplay implements DisplayBehavior, Serializable {
    @Override
    public void display(Ticket thisTicket) {
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        System.out.println("Total: " + formatter.format(thisTicket.getTotal()));
    }
}
