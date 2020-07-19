package test.floor.plan.flooplan.service.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import test.floor.plan.flooplan.models.Coordinates;
import test.floor.plan.flooplan.repository.CoordinatesRepository;
import test.floor.plan.flooplan.service.CoordinatesService;

@Service
public class CoordinatesServiceImpl implements CoordinatesService {
    private final CoordinatesRepository coordinatesRepository;

    public CoordinatesServiceImpl(CoordinatesRepository coordinatesRepository) {
        this.coordinatesRepository = coordinatesRepository;
    }

    @Override
    public Coordinates add(Coordinates coordinates) {
        return coordinatesRepository.save(coordinates);
    }

    @Override
    public Optional<Coordinates> getById(Long id) {
        return coordinatesRepository.findById(id);
    }

    @Override
    public List<Coordinates> getAll() {
        return coordinatesRepository.findAll();
    }

    @Override
    public Coordinates getLast() {
        return coordinatesRepository.findAll()
                .stream()
                .reduce((first, last) -> last)
                .get();
    }
}
