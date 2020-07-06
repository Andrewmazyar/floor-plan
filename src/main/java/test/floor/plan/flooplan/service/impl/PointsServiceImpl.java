package test.floor.plan.flooplan.service.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import test.floor.plan.flooplan.models.Points;
import test.floor.plan.flooplan.repository.PointsRepository;
import test.floor.plan.flooplan.service.PointsService;

@Service
public class PointsServiceImpl implements PointsService {
    private final PointsRepository pointsRepository;

    public PointsServiceImpl(PointsRepository pointsRepository) {
        this.pointsRepository = pointsRepository;
    }

    @Override
    public Points add(Points points) {
        return pointsRepository.save(points);
    }

    @Override
    public Optional<Points> getById(Long id) {
        return pointsRepository.findById(id);
    }

    @Override
    public List<Points> getAll() {
        return pointsRepository.findAll();
    }
}
