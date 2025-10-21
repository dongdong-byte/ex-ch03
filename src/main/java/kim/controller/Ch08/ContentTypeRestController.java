package kim.controller.Ch08;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContentTypeRestController {
    @RequestMapping("/returnString")
    public String returnString() {
        return "<Strong>문자열</Strong> 리턴";
    }

    @RestController
    public class ContentTypeRestController1 {
        @RequestMapping(value = "/returnString1", produces = "text/plain")
        public String returnString1() {
            return "<Strong>문자열</Strong> 리턴 에 응답헤더를 text/plain 으로 강제로 바꾼경우";
        }
    }
}
//Bookmark를 정의 안해서 실행이 불가능하다
//    @RequestMapping("/returnBookmark")
//    public Bookmark returnBookmark(){
//        return  new Bookmark();
//    }

