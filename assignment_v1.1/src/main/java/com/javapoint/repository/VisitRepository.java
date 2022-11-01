package com.javapoint.repository;

import com.cgi.dentistapp.entity.DentistVisitEntity;
import org.springframework.data.repository.CrudRepository;

public interface VisitRepository extends CrudRepository<DentistVisitEntity, Integer> {

}
