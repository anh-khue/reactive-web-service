package io.khuetla.reactivewebservicecontrollerbased.services;

import io.khuetla.reactivewebservicecontrollerbased.dto.MemberDTO;
import io.khuetla.reactivewebservicecontrollerbased.models.Member;
import io.khuetla.reactivewebservicecontrollerbased.models.Project;
import io.khuetla.reactivewebservicecontrollerbased.repositories.MemberRepository;
import io.khuetla.reactivewebservicecontrollerbased.repositories.ProjectRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.function.BiFunction;

@Service
public class MemberService {

    private final MemberRepository memberRepository;
    private final ProjectRepository projectRepository;

    public MemberService(MemberRepository memberRepository,
                         ProjectRepository projectRepository) {
        this.memberRepository = memberRepository;
        this.projectRepository = projectRepository;
    }

    public Flux<MemberDTO> findAllMembers() {
        return memberRepository.findAll()
                               .flatMap(member -> {
                                   var projects = projectRepository.findByPmId(member.getId())
                                                                   .collectList();

                                   return Mono.zip(Mono.just(member), projects, memberDTOBiFunction);
                               });
    }

    public Mono<MemberDTO> findMemberById(int memberId) {
        var member = memberRepository.findById(memberId);
        var projects = projectRepository.findByPmId(memberId)
                                        .collectList();

        return Mono.zip(member, projects, memberDTOBiFunction);
    }

    private final BiFunction<Member, List<Project>, MemberDTO> memberDTOBiFunction
            = (member, projects) -> MemberDTO.builder()
                                             .id(member.getId())
                                             .name(member.getName())
                                             .age(member.getAge())
                                             .salary(member.getSalary())
                                             .managedProjects(projects)
                                             .build();
}
