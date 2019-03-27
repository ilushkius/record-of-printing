package com.ilushkius.printingdevices.recordofprinting.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.ilushkius.printingdevices.recordofprinting.dao.JobRepository;
import com.ilushkius.printingdevices.recordofprinting.entity.Job;

@Service
public class JobServiceImpl implements JobService {
    private JobRepository jobRepository;

    @Autowired
    public JobServiceImpl(final JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    @Override
    public List<Job> findAll() {
        return jobRepository.findAll();
    }

    @Override
    public Job findById(final int theId) {
        Optional<Job> result = jobRepository.findById(theId);

        Job theJob = null;

        if (result.isPresent()) {
            theJob = result.get();
        } else {
            throw new RuntimeException("Did not find job id - " + theId);
        }
        return theJob;
    }

    @Override
    public void save(final Job theJob) {
        jobRepository.save(theJob);
    }

    @Override
    public void deleteById(final int theId) {
        jobRepository.deleteById(theId);
    }

    @Override
    public List<Job> findAll(final Specification<Job> spec) {
        return jobRepository.findAll(spec);

    }

    @Override
    public List<Job> findAll(final Specification<Job> spec, final Sort sort) {
        return jobRepository.findAll(spec, sort);

    }
}
