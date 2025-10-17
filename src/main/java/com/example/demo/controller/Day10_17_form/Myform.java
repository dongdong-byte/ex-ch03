package com.example.demo.controller.Day10_17_form;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.request.Day10_17_form.ArticleRequest;

@RestController
public class Myform {
	
    @GetMapping("/article-get")
    public String articleget(@RequestParam String id ,@RequestParam String title , @RequestParam String content) {
		
//		방법1: 일반적인 방법
//		String result = " 아이디는  : " + "<br>"+id + "비밀번호는 :" +  "<br>"+title  + "<br>"+ "내용은 : " +content;
//		return result;

//		방법2: string.format 사용
//		return String.format("아이디는 : %s , 비밀번호는 : %s,내용은 : %s",
//				
//				id,title,content);
		
//		방법3: Text Blocks (최신버젼)
		
//        return """
//				=======게시글 정보======
//				ID : %s
//				제목 : %s
//				내용 : %s
//				""".formatted(id,title,content);

//        방법 4: StringBuilder ->대용량 데이터용
return  new StringBuilder()
        .append("아이디는").append(id)
        .append(", 제목은").append(title)
        .append(", 내용은").append(content)
        .toString();


    }

    @PostMapping("/article-post")
    public String articlepost(@RequestBody ArticleRequest request) {
		
//		방법1:formatted() 최신 방식
//        String result= "아이디는 : %s , 비밀번호는 : %s,내용은 : %s".formatted(
//
//                request.id(),
//                request.title(),
//                request.content()
//
//        );
//       방법2: text block (최신버젼)
        String result= """
                아이디는 : %s,
                비밀번호는 : %s,
                내용은 : %s

                """.formatted(request.id(),request.title(),request.content());

//방법3 strigbulider 정보를 대량으로 입력할때 좋음

return result;
    }
//		방법 
@PostMapping("/article-postman")
public String articlepostman(@ModelAttribute ArticleRequest request) {
			
//			방법1:formatted() 최신 방식
    String result = "아이디는 : %s , 비밀번호는 : %s,내용은 : %s".formatted(
					
            request.id(),
            request.title(),
            request.content()
					
    );
    return result;
//			방법 
}

// 화면 테스트 가능 , 포스트맨 데스트 가능
//	
@RequestMapping("/article-auto")
public String articleAuto (ArticleRequest request) {

    String result = "아이디는 : %s , 비밀번호는 : %s,내용은 : %s".formatted(
					
            request.id(),
            request.title(),
            request.content()
					
    );
    return result;

}
		

}
