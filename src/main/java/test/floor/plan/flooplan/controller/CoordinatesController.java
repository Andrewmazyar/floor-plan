package test.floor.plan.flooplan.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import test.floor.plan.flooplan.controller.mapper.CoordinateMapper;
import test.floor.plan.flooplan.controller.mapper.MatchPointMapper;
import test.floor.plan.flooplan.models.Coordinates;
import test.floor.plan.flooplan.models.dto.CoordinateDto;
import test.floor.plan.flooplan.service.CoordinatesService;

@Controller
public class CoordinatesController {
    private final CoordinatesService coordinatesService;
    private final MatchPointMapper matchPointMapper;
    private final CoordinateMapper coordinateMapper;

    public CoordinatesController(CoordinatesService coordinatesService,
                                 MatchPointMapper matchPointMapper,
                                 CoordinateMapper coordinateMapper) {
        this.coordinatesService = coordinatesService;
        this.matchPointMapper = matchPointMapper;
        this.coordinateMapper = coordinateMapper;
    }

    @PostMapping
    public String add(@RequestParam String text) {
        matchPointMapper.match(text);
        return "index";
    }

    @GetMapping
    public String get(Model model) {
        List<CoordinateDto> coordinates = new ArrayList<>();
        for (Coordinates coordinate : coordinatesService.getAll()) {
            coordinates.add(coordinateMapper.convertToDto(coordinate));
        }
        model.addAttribute("points", coordinates);
        return "index";
    }
}
