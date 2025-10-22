package kim.controller.Ch03;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import kim.service.Ch03.Myservice;





@RestController
public class MyController03 {

//	자바가 객체를 생성하는 방식 -> 안사용함
//	Myservice myservice = new Myservice();


    Myservice myservice;

    public MyController03(Myservice myservice) {

        this.myservice = myservice;

    }


    @GetMapping("/")
    public String getMethodName() {

        System.out.println("기본화면 실행");
        return myservice.sayHello("chapter03 실무에서쓰이는 자바문법 ");
    }

    @GetMapping("/ex321")
    public String ex321() {
        return myservice.IF();
    }


    @GetMapping("/ex322")
    public String ex322() {
        return myservice.For();
    }

    @GetMapping("/ex323")
    public String ex323() {
        return myservice.While();
    }

    @GetMapping("/ex324")
    public String ex324() {
        return myservice.Interface();
    }

    @GetMapping("/ex325")
    public String ex325() {
        return myservice.List();
    }

    @GetMapping("/ex326")
    public String ex326() {
        return myservice.ArrayList();
    }

    @GetMapping("/ex327")
    public String ex327() {
        return myservice.equal();
    }

    @GetMapping("/ex3271")
    public String ex3271() {
        return myservice.equa4();
    }

    @GetMapping("/ex3272")
    public String ex3272() {
        return myservice.equa5();
    }

    @GetMapping("/ex328")
    public String ex328() {
        return myservice.equal1();
    }

    @GetMapping("/ex3281")
    public String ex3281() {
        return myservice.equal2();
    }

    @GetMapping("/ex3282")
    public String ex3282() {
        return myservice.equal3();
    }

    @GetMapping("/ex332")
    public String ex332() {
        return myservice.ArrayListAPI();


    }

    @GetMapping("/ex333")
    public String ex333() {
        return myservice.ArrayListFor1();

    }

    @GetMapping("/ex3331")
    public String ex3331() {
        return myservice.ArrayListFor2();


    }

    @GetMapping("/ex3332")
    public String ex3332() {
        return myservice.ArrayListBetterFor();


    }

    @GetMapping("/ex334")
    public String ex334() {
        return myservice.StreamAPI();

    }

    @GetMapping("/ex336")
    public String ex336() {
        return myservice.Fiter();

    }

    @GetMapping("/ex335")
    public String ex335() {
        return myservice.ForEach();

    }

    @GetMapping("/ex337")
    public String ex337() {
        return myservice.Distanct();

    }

    @GetMapping("/ex338")
    public String ex338() {
        return myservice.Map();

    }

    @GetMapping("/ex339")
    public String ex339() {
        return myservice.Optional();

    }

    @GetMapping("/ex3310")
    public String ex3310() {
        return myservice.NullPointerException1();

    }

    @GetMapping("/ex3311 ")
    public String ex3311() {
        return myservice.OptionalEmpty();

    }

    @GetMapping("/ex3312")
    public String ex3312() {
        return myservice.Optional03();

    }

    @GetMapping("/ex3314")
    public String ex3314() {
        return myservice.AntiPattern();


    }
}