package com.tburakonat.runnerz.run;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/runs")
public class RunController {

    RunRepository runRepository;

    RunController(RunRepository runRepository) {
        this.runRepository = runRepository;
    }

    @GetMapping("")
    List<Run> getAllRuns(@RequestParam(required = false) Location location) {
        if (location != null) {
            return runRepository.findByLocation(location);
        }
        return runRepository.findAll();
    }

    @GetMapping("/{id}")
    Run getRunById(@PathVariable Integer id) {
        Optional<Run> optionalRun = runRepository.findById(id);
        if (optionalRun.isPresent()) {
            return optionalRun.get();
        }

        throw new RunNotFoundException();
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    void createRun(@Valid @RequestBody Run run) {
        runRepository.save(run);
    }

    @PostMapping("/batch")
    @ResponseStatus(HttpStatus.CREATED)
    void createMultipleRuns(@Valid @RequestBody List<Run> runs) {
        runRepository.saveAll(runs);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void updateRun(@Valid @RequestBody Run run, @PathVariable Integer id) {
        runRepository.save(run);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteRun(@PathVariable Integer id) {
        runRepository.deleteById(id);
    }
}
