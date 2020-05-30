package Unit3;

import java.io.Serializable;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class MinMaxFee implements FeeBehavior, Serializable {
    @Override
    //Re-used math from unit 1:
    public double getTotal(LocalTime startTime, LocalTime endTime) {
        if ((startTime.until(endTime, ChronoUnit.MINUTES)) <= 3 * 60) return 5;
        else {
            long minutes = startTime.until(endTime, ChronoUnit.MINUTES);
            minutes -= (3 * 60);//reducing the already accounted for 3 hours pay
            int hours = 0; //Math.ceil likes to ignore my small numbers I guess. Now I've got to do this on my own.
            int minFloor = 0, minCeil = 60;
            while (hours == 0) {
                if (minutes > minFloor && minutes < minCeil)
                    hours = (minCeil / 60); //If minutes is between the two values it'll be caught
                else {
                    minFloor += 60;
                    minCeil += 60;
                }
            } //I hate that this is currently working, and that normal math doesn't
            double total = hours + 5;
            if (total > 15) return 15;
            else return total;
        }
    }
}
