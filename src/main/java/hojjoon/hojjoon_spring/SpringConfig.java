package hojjoon.hojjoon_spring;

import hojjoon.hojjoon_spring.repository.MemberRepository;
import hojjoon.hojjoon_spring.repository.MemoryMemberRepository;
import hojjoon.hojjoon_spring.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    public MemberService memberService(){
        return new MemberService(memberRepository());
    }
    public MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }
}
