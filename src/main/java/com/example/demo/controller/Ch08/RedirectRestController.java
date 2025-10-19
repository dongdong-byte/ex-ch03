package com.example.demo.controller.Ch08;


import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;


@RestController
public class RedirectRestController {

    // ==================== 방법 1: HttpHeaders 직접 설정 (기본) ====================
    @RequestMapping("/redirectToTarget")
//    <object>를 추가하라는 이유-> 인테리제이에서 무엇이 들어갈 박스인지 박스 타입을 명확히 하라고 명시하라는것임 -> 현대적인 방법
//    public ResponseEntity redirectToTarget() {->컴파일러-> 뭐가 들어가는 박스인지 모르겠다.
//    public ResponseEntity<object> redirectToTarget(){ -> 무엇이든지 들어갈수가 있는 박스 타입이구나!!
    public ResponseEntity<Object> redirectToTarget() {
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(URI.create("/targetOfRedirect"));
        



        return new ResponseEntity<>(headers, HttpStatus.MOVED_PERMANENTLY);
    }

@RequestMapping("/targetOfRedirect")// 같은경로
    public  String targetOfRedirect() {//        같은 메서드명
        return "방법1: HttpHeaders 직접 설정한 redirect임";
        
}
    // ==================== 방법 2: ResponseEntity 빌더 패턴 (추천!) ====================
// <void> 사용하는게 가장 정확함
    @GetMapping("/targetToRedirect1")
    public  ResponseEntity<Void> redirectToTarget1() {


        return ResponseEntity
                .status(HttpStatus.MOVED_PERMANENTLY)
                .location(URI.create("/targetOfRedirect1")).build();

    }

    @GetMapping("/targetOfRedirect1")
    public String targetOfRedirect1(){
        return "이건 <void>를 사용한 redirect임 나에 경우에는 리다이렉트이어서 body가 없음<void>사용하는게 가장 효율적임";

    }
    // ==================== 방법 3: Spring의 "redirect:" 문법 (가장 간단) ====================
//    더 최신방법 -> 스프링은 리다이렉트 전용 메서드드 제공한다.
    @GetMapping("/redirectToTarget2")
    public ResponseEntity<Void> redirectToTarget2() {
        return  ResponseEntity
                .status(HttpStatus.MOVED_PERMANENTLY)
                .location(URI.create("/targetOfRedirect2")).build();

    }

    @GetMapping("/targetOfRedirect2")
    public String redirectToTarget2Final()
    {

        return  "방법3: Spring의 redirect: 문법 사용";//        String 반환 시에만

    }



}
