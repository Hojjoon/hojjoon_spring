package hojjoon.hojjoon_spring.service;

import hojjoon.hojjoon_spring.domain.Member;
import hojjoon.hojjoon_spring.repository.MemberRepository;
import hojjoon.hojjoon_spring.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberService {

    private final MemberRepository memberRepository;

    @Autowired
    public MemberService (MemberRepository memberRepository){
        this.memberRepository = memberRepository;
    }
    /*
    *  회원가입
    **/
    public long join(Member member){
        //같은 이름이 있는 중복회원 x
        validateDuplicateMember(member);
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member){
        memberRepository.findByName(member.getName())
                .ifPresent(m-> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }
    public List<Member> findMembers(){
        return memberRepository.findAll();
    }
    public Optional<Member> findOne(long memberId){
        return memberRepository.findById(memberId);
    }


}
