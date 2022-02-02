package com.magsad.springboothospitalapp.repository;

import com.magsad.springboothospitalapp.model.Hospital;

import java.util.List;

public interface HospitalDAO {
    Hospital getHospitalById(Long id);
    List<Hospital> getAllHospitals();
    boolean deleteHospital(Hospital hospital);
    boolean deleteHospital(Long id);
    boolean updateHospital(Hospital hospital);
    boolean createHospital(Hospital hospital);
}
