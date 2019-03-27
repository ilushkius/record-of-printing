package com.ilushkius.printingdevices.recordofprinting.rest;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Sort;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ilushkius.printingdevices.recordofprinting.entity.Job;
import com.ilushkius.printingdevices.recordofprinting.entity.Type;
import com.ilushkius.printingdevices.recordofprinting.service.JobService;

import static com.ilushkius.printingdevices.recordofprinting.spec.JobSpecifications.*;
import static org.springframework.data.jpa.domain.Specification.where;

@RestController
public class JobRestController {
    private JobService jobService;

    public JobRestController(final JobService jobService) {
        this.jobService = jobService;
    }

    @PostMapping(path = "/jobs", consumes = MediaType.APPLICATION_XML_VALUE)
    public Map<String, Integer> addJobs(final @RequestBody List<Job> jobs) {
        Map<String, Integer> result = new HashMap<String, Integer>();
        System.out.println("\n" + jobs);

        for (Job job : jobs) {
            result.computeIfPresent(job.getUser(),
                    (key, value) -> value + job.getAmount());
            result.putIfAbsent(job.getUser(), job.getAmount());
            System.out.println(result);
            job.setTime(LocalDateTime.now());
            job.setJobId(0);
            jobService.save(job);
        }
        return result;
    }

    @GetMapping("/statistics")
    public List<Job> getStatistics(final @RequestParam(name = "user", required = false) String user,
                                   final @RequestParam(name = "type", required = false) Type type,
                                   final @RequestParam(name = "device", required = false) String device,
                                   final @RequestParam(name = "timeFrom", required = false) String timeFrom,
                                   final @RequestParam(name = "timeTo", required = false) String timeTo) {
        Sort sort = new Sort(Sort.Direction.ASC, "time");

        List<Job> result = jobService.findAll(where(withUser(user))
                .and(withType(type))
                .and(withDevice(device))
                .and(withTimeFrom(timeFrom))
                .and(withTimeTo(timeTo)), sort);

        return result;
    }

}
