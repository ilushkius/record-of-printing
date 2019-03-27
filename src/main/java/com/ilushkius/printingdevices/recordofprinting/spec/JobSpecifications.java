package com.ilushkius.printingdevices.recordofprinting.spec;

import java.time.LocalDateTime;

import org.springframework.data.jpa.domain.Specification;

import com.ilushkius.printingdevices.recordofprinting.entity.Job;
import com.ilushkius.printingdevices.recordofprinting.entity.Type;

public class JobSpecifications {

    JobSpecifications() {
    }

    public static Specification<Job> withUser(final String user) {
        if (user == null) {
            return null;
        } else {
            return (root, query, cb) -> cb.equal(root.get("user"), user);
        }
    }

    public static Specification<Job> withType(final Type type) {
        if (type == null) {
            return null;
        } else {
            return (root, query, cb) -> cb.equal(root.get("type"), type);
        }
    }

    public static Specification<Job> withDevice(final String device) {
        if (device == null) {
            return null;
        } else {
            return (root, query, cb) -> cb.equal(root.get("device"), device);
        }
    }

    public static Specification<Job> withTimeFrom(final String timeFrom) {
        if (timeFrom == null) {
            return null;
        } else {
            return (root, query, cb) -> cb.greaterThanOrEqualTo(root.<LocalDateTime>get("time"),
                    LocalDateTime.parse(timeFrom));
        }
    }

    public static Specification<Job> withTimeTo(final String timeTo) {
        if (timeTo == null) {
            return null;
        } else {
            return (root, query, cb) -> cb.lessThanOrEqualTo(root.<LocalDateTime>get("time"),
                    LocalDateTime.parse(timeTo));
        }
    }

}
