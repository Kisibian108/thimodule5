package com.example.controller;

import com.example.model.MedicalRecord;
import com.example.service.IMedicalRecordService;
import com.example.service.IPatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/medicalRecord")
@CrossOrigin
public class MedicalRecordRestController {

    @Autowired
    IMedicalRecordService medicalRecordService;

    @Autowired
    IPatientService patientService;

    @GetMapping("/list")
    public ResponseEntity<Page<MedicalRecord>> listAll(@PageableDefault(4) Pageable pageable,
                                                       Optional<String> nameSearch,
                                                       Optional<String> doctorSearch) {
        String name = nameSearch.orElse("");
        String doctor = doctorSearch.orElse("");
        if (name.equals("null")) {
            name = "";
        }
        if (doctor.equals("null")) {
            doctor = "";
        }
        Page<MedicalRecord> medicalRecords = medicalRecordService.findAllMedical(pageable, name, doctor);
        if (medicalRecords.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(medicalRecords, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<MedicalRecord>> get(@PathVariable int id) {
        Optional<MedicalRecord> medicalRecord = medicalRecordService.findById(id);
        if (!medicalRecord.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(medicalRecord, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Void> create(@RequestBody MedicalRecord medicalRecord) {
        medicalRecordService.save(medicalRecord);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<MedicalRecord> update(@PathVariable int id, @RequestBody MedicalRecord medicalRecord) {
        if (medicalRecord == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        medicalRecordService.save(medicalRecord);
        return new ResponseEntity<>(medicalRecord, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        Optional<MedicalRecord> medicalRecord = medicalRecordService.findById(id);
        if (!medicalRecord.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        medicalRecordService.delete(medicalRecord.get());
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
