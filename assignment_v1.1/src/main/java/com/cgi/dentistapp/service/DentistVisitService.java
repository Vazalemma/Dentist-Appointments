package com.cgi.dentistapp.service;

import com.cgi.dentistapp.entity.DentistVisitEntity;
import com.javapoint.repository.VisitRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class DentistVisitService {

    private static VisitRepository visitRepository;

    public static List<DentistVisitEntity> getAllVisits() {
        List<DentistVisitEntity> visits = new ArrayList<>();
        visitRepository.findAll().forEach(visits::add);
        return visits;
    }

    public static void setVisitRepository(VisitRepository visitRepository) {
        DentistVisitService.visitRepository = visitRepository;
    }

    /*public DentistVisitDTO getStudentById(int id) {
        return visitRepository.findById(id).get();
    }*/

    public void addVisit(String dentistName, Date visitTime) {
        DentistVisitEntity entity = new DentistVisitEntity(dentistName, visitTime);
        visitRepository.save(entity);
    }
}
