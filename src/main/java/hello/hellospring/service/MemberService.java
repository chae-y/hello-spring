package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;

public class MemberService {

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    /**회원가입*/
    public Long join(Member member){
        //같은 이름이 있으면 안된다
//        Optional<Member> result = memberRepository.findByName(member.getName()); //ctrl+alt+v하면 옵션얼 붙여줌
//        result.ifPresent(m->{//null이 아니라 존재하면
//            throw new IllegalStateException("이미존재하는 회원입니다");
//        });
        validateDuplicateMember(member);
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                        .ifPresent(m->{
                            throw new IllegalStateException("이미존재하는 회원입니다");
                        });
    }
    /** 전체회원조회*/
    public List<Member> findMembers(){
        return memberRepository.findAll();
    }

    public  Optional<Member> findOne(Long memberId){
        return memberRepository.findById(memberId);
    }

}
