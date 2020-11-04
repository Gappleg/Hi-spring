package Hi.Hispring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {

    @GetMapping("hello") //Get 방식으로 hello get ( localhost:8080/hello
    public String hello(Model model) {
        model.addAttribute("data","hello!!");
        return "hello"; // src templates폴더 안의 hello를 찾음. thymleaf 템플릿 엔진 처리
    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model) {
        model.addAttribute("name", name);
        return "hello-template";
        // localhost:8080/hello-mvc?name=spring!! 으로 접속 시
        // name param = spring!! 을 name에 넣고 model로 가져온 뒤
        // hello-template.html에 return한다.
        // template.html안에 $name에 param을 넣고 viewResolver에서 변환해서 출력
    }
}

