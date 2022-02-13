package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

// class가 인터페이스 상속할때는 implements/ 인터페이스 인터페이스는 extends 다중상속도 가능
public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository {

    //select m from Member m where m.name = ?로 해주는거 인터페이스 이름만으로도 해결
    @Override
    Optional<Member> findByName(String name);
}
