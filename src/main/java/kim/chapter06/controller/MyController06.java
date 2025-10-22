package kim.chapter06.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController06 {
//    옛날 버젼
//    @RequestMapping("/article")
//    public String Createarticle(@RequestParam("title") String title, @RequestParam("content") String content){
//        return  String.format("title = %s, content = %s",title,content);
//    }

//    최근버젼
    @RequestMapping("/article")
    public  String Createarticle( String title , String content){
        return  "title = %s , content = %s ".formatted(title,content);

    }


}
