package test.floor.plan.flooplan.controller.mapper;

import org.springframework.stereotype.Component;
import test.floor.plan.flooplan.models.Points;
import test.floor.plan.flooplan.models.dto.PointsDto;

@Component
public class PointMapper {
    public PointsDto convertToDto(Points points) {
        PointsDto dto = new PointsDto();
        dto.setFirst(points.getFirst());
        dto.setSecond(points.getSecond());
        return dto;
    }
}
