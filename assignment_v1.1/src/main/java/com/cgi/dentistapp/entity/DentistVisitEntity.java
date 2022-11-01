package com.cgi.dentistapp.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "dentist_visit")
public class DentistVisitEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String dentistName;

    @Column
    private Date visitDate;

    public DentistVisitEntity() {
    }

    public DentistVisitEntity(String dentistName, Date visitDate) {
        this.dentistName = dentistName;
        this.visitDate = visitDate;
    }

    public Long getId() {
        return id;
    }

    public Date getVisitTime() {
        return visitDate;
    }

    public String getDentistName() {
        return dentistName;
    }
}
