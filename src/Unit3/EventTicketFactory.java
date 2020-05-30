package Unit3;

import java.time.LocalTime;

public class EventTicketFactory implements TicketFactory {
    @Override
    public Ticket createTicket(int ticketID , LocalTime startTime) {
        Ticket newTicket = new EventTicket(ticketID, startTime);

        newTicket.setDisplayBehavior(new EventDisplay());
        newTicket.setFeeBehavior(new EventFee());

        return newTicket;
    }
}
