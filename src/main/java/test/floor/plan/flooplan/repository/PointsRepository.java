package test.floor.plan.flooplan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import test.floor.plan.flooplan.models.Points;

public interface PointsRepository extends JpaRepository<Points, Long> {
}
