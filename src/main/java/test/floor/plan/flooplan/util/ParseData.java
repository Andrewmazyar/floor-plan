package test.floor.plan.flooplan.util;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;
import test.floor.plan.flooplan.models.Points;

@Component
public class ParseData {

    public List<Points> parse(String line) {
        List<Points> pointsList = new ArrayList<>();
        for (String string : line.split(";")) {
            Points points = new Points();
            String[] iteration = string.split(",");
            points.setFirst(Integer.parseInt(iteration[0]));
            points.setSecond(Integer.parseInt(iteration[1]));
            pointsList.add(points);
        }
        return pointsList;
    }
}
