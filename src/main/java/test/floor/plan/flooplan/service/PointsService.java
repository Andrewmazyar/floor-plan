package test.floor.plan.flooplan.service;

import java.util.List;
import java.util.Optional;
import test.floor.plan.flooplan.models.Points;

public interface PointsService {
    Points add(Points points);

    Optional<Points> getById(Long id);

    List<Points> getAll();
}
