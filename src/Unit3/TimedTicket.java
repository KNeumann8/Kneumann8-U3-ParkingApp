package Unit3;

import java.time.LocalTime;

public class TimedTicket extends Ticket{
    public TimedTicket(int ticketID, LocalTime startTime){
        super(ticketID, startTime);
    }
}
