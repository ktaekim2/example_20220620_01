package com.example.ex.controller;

import com.example.ex.service.MainService;
import com.sun.tools.javac.Main;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor // final 키워드가 붙은 필드를 매개변수로 하는 생성자 생성
public class MainController {
    // 객체 선언 방식
//    MainService mainService = new MainService();

    // 필드 주입(권고하지 않음)
//    @Autowired
//    private MainService mainService;

    // 생성자 주입(기본 생성자는 사라짐)
//    private MainService mainService;
//    MainController(MainService mainService) {
//        this.mainService = mainService;
//    }

    // lombok 활용
    private final MainService mainService;


    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @GetMapping("/req1")
    public String req1(Model model) {
        String data = mainService.req1();
        model.addAttribute("data", data);
        return "req1";
    }
}
