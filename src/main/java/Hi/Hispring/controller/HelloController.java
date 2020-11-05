package Hi.Hispring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("hello") //Get 방식으로 hello get ( localhost:8080/hello
    public String hello(Model model) {
        model.addAttribute("data","hello!!");
        return "hello"; // src templates폴더 안의 hello를 찾음. thymleaf 템플릿 엔진 처리
    }

    @GetMapping("hello-mvc") // localhost:8080/hello-mvc
    public String helloMvc(@RequestParam("name") String name, Model model) {
        model.addAttribute("name", name);
        return "hello-template";
        // localhost:8080/hello-mvc?name=spring!! 으로 접속 시
        // name param = spring!! 을 name에 넣고 model에 담아서
        // hello-template.html에 return한다.
        // template.html안에 $name에 param을 넣고 viewResolver에서 변환해서 출력
    }

    @GetMapping("hello-string")
    @ResponseBody //body에 return 데이터를 직접 넣어주겠다는 것 (html 없이 string문자 그대로 내려감.
   public String helloString(@RequestParam("name") String name){
        return "hello" + name; // "hello spring"
    }

    @GetMapping("hello-api")
    @ResponseBody //body에 return data 직접 넣어줌.
    // 없으면 view resolver에 던져줌
    // 있으면 HttpMessageConverter가 동작
    // string이면 웹에 바로 던져줌 -> string Converter 동작
    // 객체일 때 Json 스타일로 바꿈-> Json Converter 동작
    // 여러가지 converter가 있음.
    public Hello helloApi(@RequestParam("name") String name){ // ?name= " Param값 "
        Hello hello = new Hello(); // Hello 객체 생성
        hello.setName(name); // hello 객체에 name 설정
        return hello;
    }

    static class Hello{
        private String name; // private이라 접근을 못하기때문에
        //getter setter로 접근해서 써야함.
        //property 접근방식
        public String getName() {
            return name;
        }

        public void setName(String name) { // setname으로 name 설정
            this.name = name; // 넣을때는 setname 받을때는 getname
        }
    }
}

