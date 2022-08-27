package com.example.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Set;

@Entity
public class MedicalRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String medical;

    @ManyToOne
    @JoinColumn(name = "patient_id", referencedColumnName = "id")

    private Patient patient;

    private String name;
    private String startDate;
    private String endDate;
    private String reason;
    private String medthod;
    private String doctor;

    public MedicalRecord() {
    }

    public MedicalRecord(int id, String medical, Patient patient, String name, String startDate, String endDate, String reason, String medthod, String doctor) {
        this.id = id;
        this.medical = medical;
        this.patient = patient;
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.reason = reason;
        this.medthod = medthod;
        this.doctor = doctor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMedical() {
        return medical;
    }

    public void setMedical(String medical) {
        this.medical = medical;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getMedthod() {
        return medthod;
    }

    public void setMedthod(String medthod) {
        this.medthod = medthod;
    }

    public String getDoctor() {
        return doctor;
    }

    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }
}
