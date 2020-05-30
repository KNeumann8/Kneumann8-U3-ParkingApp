package Unit3;

import java.time.LocalTime;

public class TimedTicketFactory implements TicketFactory {
    @Override
    public Ticket createTicket(int ticketID , LocalTime startTime) {
        Ticket newTicket = new TimedTicket(ticketID, startTime);

        newTicket.setDisplayBehavior(new TimeDisplay());
        newTicket.setFeeBehavior(new MinMaxFee());

        return newTicket;
    }
}
