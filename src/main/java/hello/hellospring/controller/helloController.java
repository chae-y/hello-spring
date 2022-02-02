package hello.hellospring.controller;

import hello.hellospring.HelloSpringApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class helloController {
    @GetMapping("hello")
    public String hello(Model model){
        model.addAttribute("data", "hello!");
        return "hello";//templates의 hello.html을 찾아서 랜더링한다.
    }

    @GetMapping("hello-mvc")
    public String helloMVC(@RequestParam("name") String name, Model model){
        model.addAttribute("name", name);
        return "hello-template";
    }

    @GetMapping("hello-string")
    @ResponseBody //http에서 바디에 이 데이터를 직접 넣어주겠다
    public String helloString(@RequestParam("name") String name){
        return "hello"+name;
    }

    //정적컨텐츠 - 그냥 파일을 그대로 내려준다
    //mvc와 템플릿엔진 - 템플릿엔진을 모델,뷰,컨트롤러방식으로 쪼개서 븊를 템플릿엔진으로 랜더링이 된 html을 클라이언트에게 전달해준다
    //api - 객체를 반환
    @GetMapping("hello-api")
    @ResponseBody //객체가 오면 json방식으로 데이터를 만들어서 반환
    public Hello helloApi(@RequestParam("name") String name){
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }

    static class Hello{
        private String name;
        //getter stter 불러오는 거 alt+insert
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
