package test.floor.plan.flooplan.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import test.floor.plan.flooplan.models.Coordinates;
import test.floor.plan.flooplan.models.Points;
import test.floor.plan.flooplan.service.CoordinatesService;
import test.floor.plan.flooplan.service.PointsService;
import test.floor.plan.flooplan.util.FloorPlan;

@Controller
public class CoordinatesController {
    private final FloorPlan floorPlan;
    private final PointsService pointsService;
    private final CoordinatesService coordinatesService;

    public CoordinatesController(FloorPlan floorPlan,
                                 PointsService pointsService,
                                 CoordinatesService coordinatesService) {
        this.floorPlan = floorPlan;
        this.pointsService = pointsService;
        this.coordinatesService = coordinatesService;
    }

    @PostMapping
    public String add(@RequestParam String text) {
        List<Points> pointsList = new ArrayList<>();
        for (String string : text.split(";")) {
            Points points = new Points();
            String[] iteration = string.split(",");
            points.setCoordinateX(Integer.parseInt(iteration[0]));
            points.setCoordinateY(Integer.parseInt(iteration[1]));
            pointsList.add(points);
        }
        Coordinates coordinates = new Coordinates();
        List<Points> newPoints = new ArrayList<>();
        if (floorPlan.floorChecker(pointsList)) {
            for (Points point : pointsList) {
                newPoints.add(pointsService.add(point));
            }
            coordinates.setPoints(newPoints);
            coordinatesService.add(coordinates);
        }
        return "index";
    }

    @GetMapping
    public String get(Model model) {
        Coordinates coordinates = coordinatesService.getById(2L).get();
        model.addAttribute("points", coordinates.getPoints());
        return "index";
    }
}
