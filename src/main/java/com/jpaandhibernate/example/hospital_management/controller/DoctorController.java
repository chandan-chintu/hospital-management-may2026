package com.jpaandhibernate.example.hospital_management.controller;

import com.jpaandhibernate.example.hospital_management.model.Doctor;
import com.jpaandhibernate.example.hospital_management.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.print.Doc;
import java.util.List;

@RestController
@RequestMapping("/doctor/apis")
public class DoctorController {

    @Autowired
    DoctorService doctorService;

    // debugging - tracing the flow of the application(understanding line by line what is happening and all)

    //spring boot application - takes input in the form of JSON(javascript object notation)

    // @RequestBody - it is used to take input request from UI or postman and it is used for only complete class inputs

    @PostMapping("/save")
    public String saveDoctor(@RequestBody Doctor doctor){
        String response = doctorService.saveDoctor(doctor);
        return response;
    }

    @GetMapping("/findAll")
    public List<Doctor> findAllDoctors(){
        List<Doctor> doctorList = doctorService.getAllDoctors();
        return doctorList;
    }

    //@PathVariable - it is used to take the inputs in input request url path
    @GetMapping("/findById/{id}")
    public Doctor findDoctorById(@PathVariable int id){
        Doctor doctor = doctorService.getDoctorById(id);
        return doctor;
    }

    @GetMapping("/count")
    public String countDoctors(){
        String response  = doctorService.countDoctors();
        return response;
    }

    @DeleteMapping("/deleteById/{id}")
    public String deleteDoctorsById(@PathVariable int id){
        String response = doctorService.deleteDoctorById(id);
        return response;
    }

    @PutMapping("/updatePut/{id}")
    public String updateDoctorUsingPut(@PathVariable int id,@RequestBody Doctor doctor){
        String response = doctorService.updateDoctorUsingPut(id,doctor);
        return response;
    }

    // @RequestParam - it takes the input in the form of parameter query
    @PatchMapping("/updatePatch/{id}")
    public String updateDoctorUsingPatch(@PathVariable int id,@RequestParam String newEmail,@RequestParam String newMobile){
        String response  = doctorService.updateDoctorUsingPatch(id, newEmail, newMobile);
        return response;
    }
}
