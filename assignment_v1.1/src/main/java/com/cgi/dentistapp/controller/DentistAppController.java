package com.cgi.dentistapp.controller;

import com.cgi.dentistapp.dto.DentistVisitDTO;
import com.cgi.dentistapp.entity.DentistVisitEntity;
import com.cgi.dentistapp.service.DentistVisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;

@Controller
@EnableAutoConfiguration
public class DentistAppController extends WebMvcConfigurerAdapter {

    @Autowired
    private DentistVisitService dentistVisitService;

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/results").setViewName("results");
        registry.addViewController("/visits").setViewName("visits");
    }

    @GetMapping("/")
    public String showRegisterForm(DentistVisitDTO dentistVisitDTO) {
        return "form";
    }

    @PostMapping("/")
    public String postRegisterForm(@Valid DentistVisitDTO dentistVisitDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "form";
        }

        dentistVisitService.addVisit(dentistVisitDTO.getDentistName(), dentistVisitDTO.getVisitTime());
        return "redirect:/results";
    }

    @GetMapping("/visits")
    private List<DentistVisitEntity> getAllVisits() {
        return DentistVisitService.getAllVisits();
    }

    /*@GetMapping("/visit/{id}")
    private DentistVisitDTO getStudent(@PathVariable("Long") Long id) {
        return DentistVisitService.getVisitById(id);
    }*/

    /*@PostMapping("/visit")
    private addVisit(@RequestBody String dentistName, Date visitDate) {
        DentistVisitService.addVisit(dentistName, visitDate);
        return ;
    }*/
}
