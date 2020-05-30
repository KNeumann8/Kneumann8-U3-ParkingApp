package Unit1;

import java.io.Serializable;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class Ticket implements Serializable {

    private int ticketID;
    private LocalTime startTime;
    private LocalTime endTime;

    public Ticket(int ticketID, LocalTime startTime){
        this.ticketID = ticketID;
        this.startTime = startTime;
    }

    public void setEndTime(LocalTime endTime){
        this.endTime = endTime;
    }

    public double getTotal(){
        /*The fee for parked vehicles is $5.00 minimum for up to three hours.
        After that, there is an additional $1.00 per each hour or part of an hour parked.
        The maximum parking charge  is $15.00, but lost tickets have a $25.00 fee.*/
        if(isLost()) return 25;
        else if((startTime.until(endTime,ChronoUnit.MINUTES))<=3*60) return 5;
        else{
            long minutes = startTime.until(endTime,ChronoUnit.MINUTES);
            minutes -=(3*60);//reducing the already accounted for 3 hours pay
            int hours =0; //Math.ceil likes to ignore my small numbers I guess. Now I've got to do this on my own.
            int minFloor = 0,minCeil = 60;
            while(hours ==0){
                if(minutes>minFloor&&minutes<minCeil) hours = (minCeil/60); //If minutes is between the two values it'll be caught
                else{
                    minFloor +=60;
                    minCeil +=60;
                }
            } //I hate that this is currently working, and that normal math doesn't
            double total = hours + 5;
            if(total > 15) return 15;
            else return total;
        }
    }

    public boolean isLost(){
        if(endTime == null) return true;
        else return false;
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
}
