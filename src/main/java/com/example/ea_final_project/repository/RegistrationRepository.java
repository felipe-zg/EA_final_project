package com.example.ea_final_project.repository;

import com.example.ea_final_project.model.Registration;
import com.example.ea_final_project.model.RegistrationRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface RegistrationRepository extends JpaRepository<Registration, Integer> {
//    @Query("from RegistrationRequest req where req.courseOffering.id=:id ")
//    RegistrationRequest getRegistrationRequestById(int id);
//
//    @Query("from RegistrationRequest req where req.student.id=:id ")
//    List<RegistrationRequest> getRegistrationRequestBySdudentId(int id);



    @Query("from RegistrationRequest req where req.courseOffering.id=:id ")
    List<RegistrationRequest> getRegistrationRequestByCourseOfferingId(int id);

    @Query("from Registration reg  where reg.student.id=:id ")
    List<Registration> getRegistrationByStudentId(int id);

  //  @Query("select count(*) from Registration reg  reg.student.id")
    List<Registration> getAvailableSeat(int id);

}
