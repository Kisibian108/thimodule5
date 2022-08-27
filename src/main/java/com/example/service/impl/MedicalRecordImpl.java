package com.example.service.impl;

import com.example.model.MedicalRecord;
import com.example.repository.MedicalRecordRepository;
import com.example.service.IMedicalRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MedicalRecordImpl implements IMedicalRecordService {

    @Autowired
    MedicalRecordRepository medicalRecordRepository;

    @Override
    public Page<MedicalRecord> findAllMedical(Pageable pageable, String name, String doctor) {
        return medicalRecordRepository.findAllMedical(pageable,"%" + name + "%","%" + doctor + "%");
    }

    @Override
    public void save(MedicalRecord medicalRecord) {
        medicalRecordRepository.save(medicalRecord);
    }

    @Override
    public void delete(MedicalRecord id) {
        medicalRecordRepository.delete(id);
    }

    @Override
    public Optional<MedicalRecord> findById(int id) {
        return medicalRecordRepository.findById(id);
    }
}
