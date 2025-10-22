package kim.chapter08;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServerErrorRestComtroller {

@RequestMapping("/throwServerError")
    public String throwServerError(){

    throw  new  RuntimeException();
}

}
