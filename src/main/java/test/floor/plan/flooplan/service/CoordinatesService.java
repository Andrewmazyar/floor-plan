package test.floor.plan.flooplan.service;

import java.util.List;
import java.util.Optional;
import test.floor.plan.flooplan.models.Coordinates;

public interface CoordinatesService {
    Coordinates add(Coordinates coordinates);

    Optional<Coordinates> getById(Long id);

    List<Coordinates> getAll();

    Coordinates getLast();
}
