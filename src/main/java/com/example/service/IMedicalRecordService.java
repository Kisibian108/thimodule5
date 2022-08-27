package com.example.service;

import com.example.model.MedicalRecord;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IMedicalRecordService {

    Page<MedicalRecord> findAllMedical(Pageable pageable, String name, String doctor);

    void save(MedicalRecord medicalRecord);

    void delete(MedicalRecord id);

    Optional<MedicalRecord> findById(int id);
}
