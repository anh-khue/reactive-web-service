package io.khuetla.reactivewebservicecontrollerbased.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.relational.core.mapping.Table;
import reactor.core.publisher.Mono;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Table("project_has_member")
public class ProjectHasMember {

    @Id
    private int id;
    private Integer projectId;
    private Integer memberId;
    @Transient
    private Mono<Project> project;
    @Transient
    private Mono<Member> member;
}
