package com.jpaandhibernate.example.hospital_management.service;

import com.jpaandhibernate.example.hospital_management.model.Doctor;
import com.jpaandhibernate.example.hospital_management.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service // it contains business logic
public class DoctorService {

    @Autowired
    DoctorRepository doctorRepository;

    public String saveDoctor(Doctor doctor){
        doctorRepository.save(doctor);
        return "Doctor saved successfully!!";
    }

    public List<Doctor> getAllDoctors(){
        List<Doctor> doctorList = doctorRepository.findAll();
        return doctorList;
    }

    public Doctor getDoctorById(int id){
        Optional<Doctor> doctorOptional = doctorRepository.findById(id);
        if(doctorOptional.isPresent()){
            return doctorOptional.get();
        } else {
            return null;
        }
    }
    
    public String countDoctors(){
        long totalCount = doctorRepository.count();
        return "Doctors present are : "+totalCount;
    }

    public String deleteDoctorById(int id){
        doctorRepository.deleteById(id);
        return "Doctor with id : "+id+" deleted successfully";
    }

    //update using put operation - updates complete object
    public String updateDoctorUsingPut(int id, Doctor newDoctorRequest){
        // find doctor with id
        // if doctor is present, update it
        // else we cannot update
        Doctor existingDoctor = getDoctorById(id);
        if(existingDoctor!=null){
            // proceed to update
            doctorRepository.save(newDoctorRequest);
            return "Doctor with id : "+id+" updated successfully";
        } else {
            // cannot update
            return "Doctor is not present with id : "+id+", hence cannot update";
        }
    }

    //update using patch operation - single specific fields
    public String updateDoctorUsingPatch(int id, String newEmail, String newMobile){
        // find doctor with id
        // if doctor is present, update it
        // else we cannot update
        Doctor existingDoctor = getDoctorById(id);
        if(existingDoctor!=null){
            // proceed to update
            existingDoctor.setMobile(newMobile);
            existingDoctor.setEmail(newEmail);
            doctorRepository.save(existingDoctor);
            return "Doctor with id : "+id+" updated successfully";
        } else {
            // cannot update
            return "Doctor is not present with id : "+id+", hence cannot update";
        }
    }
}
