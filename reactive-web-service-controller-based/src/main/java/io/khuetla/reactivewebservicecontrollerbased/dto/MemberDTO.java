package io.khuetla.reactivewebservicecontrollerbased.dto;

import io.khuetla.reactivewebservicecontrollerbased.models.Project;
import io.khuetla.reactivewebservicecontrollerbased.models.ProjectHasMember;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class MemberDTO {

    private int id;
    private String name;
    private int age;
    private double salary;
    private List<Project> managedProjects;
    private List<ProjectHasMember> projects;

}
