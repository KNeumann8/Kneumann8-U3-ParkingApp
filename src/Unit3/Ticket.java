package Unit3;

import java.io.Serializable;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public abstract class Ticket implements Serializable {

    private int ticketID;
    private LocalTime startTime;
    private LocalTime endTime;
    protected FeeBehavior feeBehavior;
    protected DisplayBehavior displayBehavior;

    public Ticket(int ticketID, LocalTime startTime){
        this.ticketID = ticketID;
        this.startTime = startTime;
    }

    public void setEndTime(LocalTime endTime){
        this.endTime = endTime;
    }

    public double getTotal(){
        return feeBehavior.getTotal(startTime,endTime);
    }

    public void display(){
        displayBehavior.display(this);
    }

    public void setFeeBehavior(FeeBehavior feeBehavior){
        this.feeBehavior = feeBehavior;
    }

    public void setDisplayBehavior(DisplayBehavior displayBehavior){
        this.displayBehavior = displayBehavior;
    }

    public String getDuration(){
        if(endTime != null){
            String timeBuilder = "";
            long hours = startTime.until(endTime, ChronoUnit.HOURS);
            timeBuilder += hours;
            timeBuilder += " hours and ";
            timeBuilder += startTime.until(endTime, ChronoUnit.MINUTES)-(60*hours);
            timeBuilder +=" minutes";
            return timeBuilder;
        }
        else{
            return "Invalid time parameters";
        }
    }

    public int getTicketID() {
        return ticketID;
    }

    public boolean isLost(){
        if(endTime == null) return true;
        else return false;
    }

}
