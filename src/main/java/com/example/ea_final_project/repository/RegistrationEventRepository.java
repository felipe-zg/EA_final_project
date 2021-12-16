package com.example.ea_final_project.repository;

import com.example.ea_final_project.model.RegistrationEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface RegistrationEventRepository extends JpaRepository<RegistrationEvent,Integer> {

    @Query("select ev from RegistrationEvent ev join ev.registrationGroups g  join g.students s " +
            "where s.studentId = :id")

    public List<RegistrationEvent> getLatestRegistationEvents(@Param("id") String id);


@Query("select  ev from RegistrationEvent  ev order by ev.startDate desc ")
    RegistrationEvent findEventOrderByStartDateDesc();

}
