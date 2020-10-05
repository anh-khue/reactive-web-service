package io.khuetla.reactivewebservicecontrollerbased.controllers;

import io.khuetla.reactivewebservicecontrollerbased.dto.MemberDTO;
import io.khuetla.reactivewebservicecontrollerbased.services.MemberService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping("/members")
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping
    public Mono<ResponseEntity<List<MemberDTO>>> getAllMembers() {
        return memberService.findAllMembers()
                            .collectList()
                            .map(ResponseEntity::ok)
                            .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @GetMapping("/{id}")
    public Mono<ResponseEntity<MemberDTO>> getAllMembers(@PathVariable String id) {
        return memberService.findMemberById(Integer.parseInt(id))
                            .map(ResponseEntity::ok)
                            .defaultIfEmpty(ResponseEntity.notFound().build());
    }
}
