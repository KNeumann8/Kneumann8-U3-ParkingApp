package Unit3;

import java.io.Serializable;
import java.time.LocalTime;

public class EventFee implements FeeBehavior, Serializable {
    @Override
    public double getTotal(LocalTime start, LocalTime end) {
        return 20;
    }
}
