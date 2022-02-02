package com.magsad.springboothospitalapp.mapper;

import com.magsad.springboothospitalapp.model.Hospital;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class HospitalMapper implements RowMapper<Hospital> {

    @Override
    public Hospital mapRow(ResultSet rs, int rowNum) throws SQLException {
        Hospital hospital = new Hospital();
        hospital.setId(rs.getLong("id"));
        hospital.setName(rs.getString("name"));
        hospital.setAddress(rs.getString("address"));
        hospital.setEmail(rs.getString("email"));
        hospital.setPhone(rs.getString("phone"));
        return hospital;
    }
}
