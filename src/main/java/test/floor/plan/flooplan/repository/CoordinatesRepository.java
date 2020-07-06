package test.floor.plan.flooplan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import test.floor.plan.flooplan.models.Coordinates;

public interface CoordinatesRepository extends JpaRepository<Coordinates, Long> {
}
