package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);
    Optional<Member> findById(Long id);//optional은 java8에 있는 기능, null을 optional로 감싸서 처리
    Optional<Member> findByName(String name);
    List<Member> findAll();
}
