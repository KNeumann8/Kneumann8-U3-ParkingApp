package Unit1;

import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.Random;

public class RandomTime {

    private LocalTime randomTime;

    public RandomTime(LocalTime earliestTime, LocalTime latestTime){
        Random rand = new Random();
        boolean fitsTheBill;
        String timeBuilder;
        do{
            fitsTheBill = true;
            timeBuilder = ""+rand.nextInt(2)+rand.nextInt(9)+":"+rand.nextInt(6)+rand.nextInt(9);
            LocalTime tempTime = LocalTime.MIDNIGHT;
            try{
                tempTime = LocalTime.parse(timeBuilder);
            }
            catch(DateTimeParseException e){
                fitsTheBill = false;
            }
            if(tempTime.compareTo(earliestTime)<0||tempTime.compareTo(latestTime)>0) fitsTheBill = false;
        }while(!fitsTheBill);


        this.randomTime = LocalTime.parse(timeBuilder);
    }



    public LocalTime getTime(){
        return randomTime;
    }

}
