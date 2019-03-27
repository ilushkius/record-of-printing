package com.ilushkius.printingdevices.recordofprinting.service;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;

import com.ilushkius.printingdevices.recordofprinting.entity.Job;

public interface JobService {

    List<Job> findAll();

    Job findById(int theId);

    void save(Job theJob);

    void deleteById(int theId);

    List<Job> findAll(Specification<Job> spec);

    List<Job> findAll(Specification<Job> spec, Sort sort);
}
