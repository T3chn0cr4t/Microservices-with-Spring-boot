package com.moncif.tp1.reposotories;

import com.moncif.tp1.entities.student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Date;
import java.util.List;
@RepositoryRestResource
public interface studentRepo extends JpaRepository<student,Long> {
    List<student> findStudentByName(String name);
    List<student> findStudentByNameAndDdn(String name, Date ddn);

    @Query("SELECT s.name from student s where s.studentID=:id")
    String findNameByStudentID(@Param("id") Long id);
    @Query("Update student set ddn=:date where studentID=:id")
    void updatedatenaissance(@Param("date") Date date, @Param("id") Long id);
    @Query("SELECT count(*) from student s , formation f where f.formationID=s.formation.formationID and f.formationID=:id")
    String findNNumber(@Param("id") Long id);
}
