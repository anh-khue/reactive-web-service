package io.khuetla.reactivewebservicecontrollerbased.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.relational.core.mapping.Table;
import reactor.core.publisher.Flux;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Table("project")
public class Project {

    @Id
    private int id;
    private String name;
    private Integer pmId;
    @Transient
    private Member manager;
    @Transient
    private Flux<ProjectHasMember> members;
}
