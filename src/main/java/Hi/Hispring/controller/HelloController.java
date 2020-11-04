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
    }
}

