package com.ilushkius.printingdevices.recordofprinting.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@Entity
@Table(name = "job")
@JsonPropertyOrder({"id", "device", "user", "type", "amount", "time"})
public final class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "job_id")
    @JsonIgnore
    private int jobId;

    @JsonProperty(value = "jobId")
    @Column(name = "id")
    private int id;

    @JsonProperty(value = "device")
    @Column(name = "device")
    private String device;

    @JsonProperty(value = "user")
    @Column(name = "user")
    private String user;

    @JsonProperty(value = "type")
    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private Type type;

    @JsonProperty(value = "amount")
    @Column(name = "amount")
    private int amount;

    @DateTimeFormat(iso = ISO.DATE_TIME)
    @JsonFormat(pattern = "dd.MM.yyyy HH:mm")
    @JsonProperty(value = "time")
    @Column(name = "time")
    private LocalDateTime time;

    public Job() {
    }

    public Job(final int id, final String device, final String user,
               final Type type, final int amount, final LocalDateTime time) {
        this.id = id;
        this.device = device;
        this.user = user;
        this.type = type;
        this.amount = amount;
        this.time = LocalDateTime.now();
    }

    public int getJobId() {
        return jobId;
    }

    public void setJobId(final int jobId) {
        this.jobId = jobId;
    }

    public int getId() {
        return id;
    }

    public void setId(final int id) {
        this.id = id;
    }

    public String getDevice() {
        return device;
    }

    public void setDevice(final String device) {
        this.device = device;
    }

    public String getUser() {
        return user;
    }

    public void setUser(final String user) {
        this.user = user;
    }

    public Type getType() {
        return type;
    }

    public void setType(final Type type) {
        this.type = type;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(final int amount) {
        this.amount = amount;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(final LocalDateTime time) {
        this.time = time;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + amount;
        result = prime * result + ((device == null) ? 0 : device.hashCode());
        result = prime * result + id;
        result = prime * result + jobId;
        result = prime * result + ((time == null) ? 0 : time.hashCode());
        result = prime * result + ((type == null) ? 0 : type.hashCode());
        result = prime * result + ((user == null) ? 0 : user.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Job other = (Job) obj;
        if (amount != other.amount)
            return false;
        if (device == null) {
            if (other.device != null)
                return false;
        } else if (!device.equals(other.device))
            return false;
        if (id != other.id)
            return false;
        if (jobId != other.jobId)
            return false;
        if (time == null) {
            if (other.time != null)
                return false;
        } else if (!time.equals(other.time))
            return false;
        if (type != other.type)
            return false;
        if (user == null) {
            if (other.user != null)
                return false;
        } else if (!user.equals(other.user))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Job [jobId=" + jobId + ", id=" + id + ", device=" + device
                + ", user=" + user + ", type=" + type + ", amount=" + amount
                + ", time=" + time + "]";
    }

}
