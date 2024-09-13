package com.tburakonat.runnerz.run;

import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

public interface RunRepository extends ListCrudRepository<Run, Integer> {
    public List<Run> findByLocation(Location location);
}
