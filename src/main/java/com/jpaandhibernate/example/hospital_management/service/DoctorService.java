package com.jpaandhibernate.example.hospital_management.service;

import com.jpaandhibernate.example.hospital_management.model.Doctor;
import com.jpaandhibernate.example.hospital_management.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service // it contains business logic
public class DoctorService {

    @Autowired
    DoctorRepository doctorRepository;

    public String saveDoctor(Doctor doctor){
        doctorRepository.save(doctor);
        return "Doctor saved successfully!!";
    }
}
