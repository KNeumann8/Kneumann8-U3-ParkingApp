package Unit3;

import java.time.LocalTime;

public interface TicketFactory {
    public Ticket createTicket(int ticketID , LocalTime startTime);
}
