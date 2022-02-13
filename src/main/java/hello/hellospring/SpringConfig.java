package hello.hellospring;

import hello.hellospring.repository.*;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

@Configuration
public class SpringConfig {

//    private final DataSource dataSource; //스프링부트가 자동적으로 해줌
//
//    @Autowired
//    public SpringConfig(DataSource dataSource){
//        this.dataSource = dataSource;
//    }
//    private EntityManager em;
//
//    @Autowired
//    public SpringConfig(EntityManager em) {
//        this.em = em;
//    }

    private final MemberRepository memberRepository;

    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }


    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository);
    }

//    @Bean
//    public MemberRepository memberRepository(){
////        return new MemoryMemberRepository();
////        return new JdbcMemberRepository(dataSource);
//        //스프링은 이게 좋다 다형성 한줄로 편하게 바꿀 수 있음
//        //개방패쇠의 원칙(OCP): 확장에는 열려있고, 수정,변경에는 닫혀있다
//        //객체지향의 진짜 매력은 인터페이스에서 구현체를 바꾸면서도 기존코드를 바꾸지 않고 바꿀 수 있는것후
////        return new JdbcTemplateMemberRepository(dataSource);
//        return new JpaMemberReposityory(em);
//    }
}
