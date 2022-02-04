package hello.hellospring.controller;

import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller //컨트롤러에서 외부요청을 받고 서비스에서 비즈니스 로직을 만들고 리파지토리에서 데이터를 저장하고 =>정형화되어있는 패턴 (컴포넌트 스캔 방법)
public class MemberController {

    private final MemberService memberService;
    
    //generate단축키 alt+insert
    @Autowired // 스프링이 멤버서비스를 연결해줌 (의존관계를 주입)
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
}
