package io.khuetla.reactivewebservicecontrollerbased.repositories;

import io.khuetla.reactivewebservicecontrollerbased.models.Member;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface MemberRepository extends ReactiveCrudRepository<Member, Integer> {

    Flux<Member> findByNameLike(String name);
}
