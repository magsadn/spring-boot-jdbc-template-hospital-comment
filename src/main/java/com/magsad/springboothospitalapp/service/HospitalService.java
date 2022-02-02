package com.magsad.springboothospitalapp.service;

import com.magsad.springboothospitalapp.model.Hospital;
import com.magsad.springboothospitalapp.repository.CommentRepository;
import com.magsad.springboothospitalapp.repository.HospitalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.logging.LogLevel;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

@Service
@RequiredArgsConstructor
public class HospitalService {
    private final HospitalRepository hospitalRepository;
    private final CommentRepository commentRepository;

    private final Logger LOGGER = java.util.logging.Logger.getLogger(Hospital.class.getName());

    public List<Hospital> findAll(){
        LOGGER.info("Started... findAll");
        List<Hospital> hospitals = hospitalRepository.getAllHospitals();
        LOGGER.info(String.format("hospitals : %s",hospitals));
        hospitals.forEach(
                hospital -> hospital.setCommentList(commentRepository.getCommentsByHospital(hospital)
                )
        );
        return hospitals;
    }

    public Hospital findById(Long id) {
        LOGGER.info("Started.. findById =" + id);
        Hospital hospital = null;
    try {
        hospital = hospitalRepository.getHospitalById(id);
        hospital.setCommentList(commentRepository.getCommentsByHospital(hospital));
        LOGGER.info(String.format("hospital info - %s", hospital));
    }catch (Exception e) {
        LOGGER.log(Level.OFF,e.getMessage());
    }
        return hospital;
    }

    public Hospital save(Hospital hospital) {
        hospitalRepository.createHospital(hospital);
        return hospital;
    }

    public Hospital update(Hospital hospital) {
        hospitalRepository.updateHospital(hospital);
        return hospital;
    }

    public Hospital delete(Hospital hospital) {
        hospitalRepository.deleteHospital(hospital);
        return hospital;
    }

    public Hospital delete(Long id) {
        Hospital hospital = hospitalRepository.getHospitalById(id);
        hospitalRepository.deleteHospital(id);
        return hospital;
    }
}
