package com.magsad.springboothospitalapp.repository;

import com.magsad.springboothospitalapp.mapper.HospitalMapper;
import com.magsad.springboothospitalapp.model.Hospital;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class HospitalRepository implements HospitalDAO {
     private final JdbcTemplate jdbcTemplate;

    @Override
    public Hospital getHospitalById(Long id) {
        return jdbcTemplate.queryForObject(SQLConstants.SQL_FIND_HOSPITAL,new Object[]{id},new HospitalMapper());
    }

    @Override
    public List<Hospital> getAllHospitals() {
        return jdbcTemplate.query(SQLConstants.SQL_FIND_ALL_HOSPITALS,new HospitalMapper());
    }

    @Override
    public boolean createHospital(Hospital hospital) {
        return jdbcTemplate.update(SQLConstants.SQL_INSERT_HOSPITAL,new Object[]{
                hospital.getName(),
                hospital.getAddress(),
                hospital.getEmail(),
                hospital.getPhone(),
        })>0?true:false;
    }

    @Override
    public boolean updateHospital(Hospital hospital) {
        return jdbcTemplate.update(SQLConstants.SQL_UPDATE_HOSPITAL,new Object[]{
                hospital.getName(),
                hospital.getAddress(),
                hospital.getEmail(),
                hospital.getPhone(),
                hospital.getId()
        })>0?true:false;
    }

    @Override
    public boolean deleteHospital(Hospital hospital) {
        return jdbcTemplate.update(SQLConstants.SQL_DELETE_HOSPITAL,new Object[]{hospital.getId()})>0?true:false;
    }

    @Override
    public boolean deleteHospital(Long id) {
        return jdbcTemplate.update(SQLConstants.SQL_DELETE_HOSPITAL,new Object[]{id})>0?true:false;
    }
}
