package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

@Transactional
public class JpaMemberReposityory implements MemberRepository{

    private final EntityManager em; //스프링 부트가 자동적으로 만들어줌

    public JpaMemberReposityory(EntityManager em) {
        this.em = em;
    }

    @Override
    public Member save(Member member) {
       em.persist(member);
       return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        Member member = em.find(Member.class, id);
        return Optional.ofNullable(member);
    }

    @Override
    public Optional<Member> findByName(String name) {
        List<Member> result = em.createQuery("select m from Member m where m.name =  :name", Member.class)
                .setParameter("name", name)
                .getResultList();

        return result.stream().findAny();
    }

    @Override
    public List<Member> findAll() {
//        List<Member> result = em.createQuery("select m from Member m", Member.class)
//                .getResultList();
        //리턴이랑 바로 연결 시프트+alt+n
        return em.createQuery("select m from Member m", Member.class)
                .getResultList(); //객체를 대상으로 쿼리 날림
    }
}
