package test.floor.plan.flooplan.controller.mapper;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;
import test.floor.plan.flooplan.models.Coordinates;
import test.floor.plan.flooplan.models.dto.CoordinateDto;
import test.floor.plan.flooplan.service.CoordinatesService;

@Component
public class CoordinateMapper {
    public CoordinateDto convertToDto(Coordinates coordinates) {
        CoordinateDto dto = new CoordinateDto();
        dto.setId(coordinates.getId());
        return dto;
    }
}
