package com.magsad.springboothospitalapp.controller;

import com.magsad.springboothospitalapp.model.Hospital;
import com.magsad.springboothospitalapp.service.HospitalService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("hospitals")
@Slf4j
public class HospitalController {
    private final HospitalService hospitalService;

    @GetMapping
    public ResponseEntity<List<Hospital>> getHospitals(){
        return ResponseEntity.ok(hospitalService.findAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<Hospital> getHospitalById(@PathVariable Long id){
        log.info("hospital id {}",id);
        return ResponseEntity.ok(hospitalService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Hospital> save(@RequestBody Hospital hospital){
        return ResponseEntity.ok(hospitalService.save(hospital));
    }

    @PutMapping
    public ResponseEntity<Hospital> update(@RequestBody Hospital hospital){
        return ResponseEntity.ok(hospitalService.update(hospital));
    }

    @DeleteMapping
    public ResponseEntity<Hospital> delete(@RequestBody Hospital hospital){
        return ResponseEntity.ok(hospitalService.delete(hospital));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Hospital> deleteHospitalById(@PathVariable Long id){
        return ResponseEntity.ok(hospitalService.delete(id));
    }

    @DeleteMapping("query")
    public ResponseEntity<Hospital> deleteHospitalByIdQuery(@RequestParam Long id){
        return ResponseEntity.ok(hospitalService.delete(id));
    }


    @GetMapping("query{hospitalId}")
    public ResponseEntity<Hospital> getHospitalByIdQuery2(@RequestParam("hospitalId") Long id){//(@RequestParam(name = "hospitalId")
        return ResponseEntity.ok(hospitalService.findById(id));
    }
}
