package com.example.ea_final_project.repository;

import com.example.ea_final_project.model.CourseOffering;
import com.example.ea_final_project.model.RegistrationRequest;
import com.example.ea_final_project.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface RegistrationRequestRepository extends JpaRepository<RegistrationRequest,Integer> {
    @Query("from RegistrationRequest req where req.courseOffering.id=:id ")
    RegistrationRequest getRegistrationRequestById(int id);

    @Query("from RegistrationRequest req where req.student.id=:id ")
    List<RegistrationRequest> getRegistrationRequestBySdudentId(int id);

//    @Query("from RegistrationRequest req where req.student.id=:id ")
//    List<RegistrationRequest> getRegistrationRequestBySdudentId(int id);

    @Query("from RegistrationRequest req where req.student.id=:studentId and req.courseOffering.block.id=:blockId ")
    List<RegistrationRequest> getRegistrationRequestByStudentIdAndBlockId(int studentId,int blockId);



}
