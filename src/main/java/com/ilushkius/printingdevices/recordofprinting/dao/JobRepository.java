package com.ilushkius.printingdevices.recordofprinting.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.ilushkius.printingdevices.recordofprinting.entity.Job;

public interface JobRepository extends JpaRepository<Job, Integer>,
        JpaSpecificationExecutor<Job> {

}
