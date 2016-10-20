package com.citrix.hackathon.common.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by sanketmishra on 10/8/16.
 */
@Entity
public class Cloud {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String cloudProvider;

    @Column
    private String availabilityZone;

    @Column
    private String notes;

    @OneToMany(mappedBy="cloud")
    List<Control> controls;

    @ManyToOne
    private App app;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCloudProvider() {
        return cloudProvider;
    }

    public void setCloudProvider(String cloudProvider) {
        this.cloudProvider = cloudProvider;
    }

    public String getAvailabilityZone() {
        return availabilityZone;
    }

    public void setAvailabilityZone(String availabilityZone) {
        this.availabilityZone = availabilityZone;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public List<Control> getControls() {
        return controls;
    }

    public void setControls(List<Control> controls) {
        this.controls = controls;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Cloud() {
    }

    public Cloud(String cloudProvider, String availabilityZone, String notes) {
        this.cloudProvider = cloudProvider;
        this.availabilityZone = availabilityZone;
        this.notes = notes;
    }

}
