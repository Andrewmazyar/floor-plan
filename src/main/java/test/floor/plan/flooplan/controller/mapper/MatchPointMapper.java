package test.floor.plan.flooplan.controller.mapper;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;
import test.floor.plan.flooplan.models.Coordinates;
import test.floor.plan.flooplan.models.Points;
import test.floor.plan.flooplan.service.CoordinatesService;
import test.floor.plan.flooplan.service.PointsService;
import test.floor.plan.flooplan.util.FloorPlan;
import test.floor.plan.flooplan.util.ParseData;

@Component
public class MatchPointMapper {
    private final FloorPlan floorPlan;
    private final ParseData parseData;
    private final PointsService pointsService;
    private final CoordinatesService coordinatesService;

    public MatchPointMapper(FloorPlan floorPlan,
                            ParseData parseData,
                            PointsService pointsService,
                            CoordinatesService coordinatesService) {
        this.floorPlan = floorPlan;
        this.parseData = parseData;
        this.pointsService = pointsService;
        this.coordinatesService = coordinatesService;
    }

    public void match(String text) {
        Coordinates coordinates = new Coordinates();
        List<Points> newPoints = new ArrayList<>();
        if (floorPlan.floorChecker(parseData.parse(text))) {
            for (Points point : parseData.parse(text)) {
                newPoints.add(pointsService.add(point));
            }
            coordinates.setPoints(newPoints);
            coordinatesService.add(coordinates);
        }
    }
}
