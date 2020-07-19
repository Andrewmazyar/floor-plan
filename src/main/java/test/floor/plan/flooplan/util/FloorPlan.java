package test.floor.plan.flooplan.util;

import java.util.List;
import org.springframework.stereotype.Component;
import test.floor.plan.flooplan.models.Points;

@Component
public class FloorPlan {
    private final int MIN_SIZE = 4;

    public Boolean floorChecker(List<Points> coordinates) {
        if (coordinates.size() < MIN_SIZE){
            return false;
        }
        for (int i = 0; i < coordinates.size(); i++) {
            if (i + 1 <= coordinates.size() - 1) {
                if (!coordinates.get(i).getFirst().equals(coordinates.get(i + 1).getFirst())
                        && !coordinates.get(i).getSecond().equals(coordinates.get(i + 1).getSecond())) {
                    return false;
                }
            } else if (coordinates.get(i).getFirst() == 0){
                return false;
            } else {
                if (!coordinates.get(i).getFirst().equals(coordinates.get(0).getFirst())
                        && !coordinates.get(i).getSecond().equals(coordinates.get(0).getSecond())) {
                    return false;
                }
            }
        }
        return true;
    }
}
