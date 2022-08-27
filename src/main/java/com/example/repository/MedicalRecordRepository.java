package com.example.repository;

import com.example.model.MedicalRecord;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface MedicalRecordRepository extends JpaRepository<MedicalRecord, Integer> {

//    @Query(value = "select * from medical_record", nativeQuery = true)
//    List<MedicalRecord> findAll();

    @Query(value = " select * from medical_record where name like :name or doctor like :doctor ", nativeQuery = true,
            countQuery = " select count(*) from (select * from medical_record where name like :keyword or doctor like :keyword) temp_table ")
    Page<MedicalRecord> findAllMedical(Pageable pageable, @Param("name") String name, @Param("doctor") String doctor);

//    @Modifying
//    @Transactional
//    @Query(value = "insert into medical_record(doctor, end_date, medical, medthod, name, reason, start_date, patient_id) values (:doctor, :endDate, :medical, :medthod, :name, :reason, :startDate, :patient );", nativeQuery = true)
//    void save(@Param("doctor") String doctor, @Param("endDate") String endDate, @Param("medical") String medical, @Param("medthod") String method, @Param("name") String name, @Param("reason") String reason, @Param("startDate") String startDate, @Param("reason") Integer patient);
//
//    @Transactional
//    @Modifying
//    @Query(value = "update medical_record set doctor = :doctor, end_date = :endDate, medical = :medical, method = :method, name = :name, reason = :reason, start_date = :startDate, patient_id = :patient,  where id = :id", nativeQuery = true)
//    void update(@Param("doctor") String doctor, @Param("endDate") String endDate, @Param("medical") String medical, @Param("method") String method, @Param("name") String name, @Param("reason") String reason, @Param("startDate") String startDate, @Param("patient") String patient);

    @Modifying
    @Query(value = "delete from medical_record where id:= id ", nativeQuery = true)
    void delete(@Param("id") int id);
}
