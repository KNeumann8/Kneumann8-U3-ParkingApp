package Unit3;

import java.time.LocalTime;

public interface FeeBehavior {
    double getTotal(LocalTime start, LocalTime end);
}
