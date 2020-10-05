package io.khuetla.reactivewebservicecontrollerbased.repositories;

import io.khuetla.reactivewebservicecontrollerbased.models.Project;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface ProjectRepository extends ReactiveCrudRepository<Project, Integer> {

    Flux<Project> findByPmId(Integer pmId);
}
