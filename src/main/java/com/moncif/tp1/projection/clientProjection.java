package com.moncif.tp1.projection;

import com.moncif.tp1.entities.student;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.config.Projection;

@RepositoryRestResource
@Projection(name = "pr1", types = student.class)
public interface clientProjection {
    public Long getStudentID() ;

    @Value("#{target.name}")
    public String getName();

    @Value("#{target.formation.name}")
    public String getFormationName();

}
