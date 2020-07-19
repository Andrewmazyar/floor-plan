package test.floor.plan.flooplan.controller;

import java.util.ArrayList;
import java.util.List;
import lombok.SneakyThrows;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import test.floor.plan.flooplan.controller.mapper.PointMapper;
import test.floor.plan.flooplan.models.Coordinates;
import test.floor.plan.flooplan.models.Points;
import test.floor.plan.flooplan.models.dto.PointsDto;
import test.floor.plan.flooplan.service.CoordinatesService;


@Controller
public class CanvasController {
    private final CoordinatesService coordinatesService;
    private final PointMapper pointMapper;

    public CanvasController(CoordinatesService coordinatesService,
                            PointMapper pointMapper) {
        this.coordinatesService = coordinatesService;
        this.pointMapper = pointMapper;
    }

    @SneakyThrows
    @GetMapping("/canvas/{id}")
    public String getCanvas(Model model, @PathVariable String id) {
        Coordinates coordinates = coordinatesService.getById(Long.parseLong(id)).get();
        List<PointsDto> result = new ArrayList<>();
        for (Points points : coordinates.getPoints()) {
            result.add(pointMapper.convertToDto(points));
        }
        model.addAttribute("loading", result);
        return "canvas";
    }

    @GetMapping("/canvas")
    public String getCanvasLast(Model model) {
        Coordinates coordinates = coordinatesService.getLast();
        List<PointsDto> result = new ArrayList<>();
        for (Points points : coordinates.getPoints()) {
            result.add(pointMapper.convertToDto(points));
        }
        model.addAttribute("loading", result);
        return "canvas";
    }
}
