package test.floor.plan.flooplan.controller;

import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import test.floor.plan.flooplan.models.Coordinates;
import test.floor.plan.flooplan.models.Points;
import test.floor.plan.flooplan.service.CoordinatesService;
import test.floor.plan.flooplan.service.PointsService;
import test.floor.plan.flooplan.util.FloorPlan;
import test.floor.plan.flooplan.util.ParseData;

@Controller
public class CoordinatesController {
    private final FloorPlan floorPlan;
    private final PointsService pointsService;
    private final CoordinatesService coordinatesService;
    private final ParseData parseData;

    public CoordinatesController(FloorPlan floorPlan,
                                 PointsService pointsService,
                                 CoordinatesService coordinatesService,
                                 ParseData parseData) {
        this.floorPlan = floorPlan;
        this.pointsService = pointsService;
        this.coordinatesService = coordinatesService;
        this.parseData = parseData;
    }

    @PostMapping
    public String add(@RequestParam String text) {
        Coordinates coordinates = new Coordinates();
        List<Points> newPoints = new ArrayList<>();
        if (floorPlan.floorChecker(parseData.parse(text))) {
            for (Points point : parseData.parse(text)) {
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

    @SneakyThrows
    @GetMapping("/canvas/{id}")
    public String getCanvas(@PathVariable String id, Model model) {
        Coordinates coordinates = coordinatesService.getById(Long.valueOf(id)).get();
        ObjectMapper objectMapper = new ObjectMapper();

        String stringJson = objectMapper.writeValueAsString(coordinates.getPoints());
        model.addAttribute("loading", stringJson);
        return "canvas";
    }
}
