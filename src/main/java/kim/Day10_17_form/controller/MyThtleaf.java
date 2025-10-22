package kim.controller.Day10_17_form;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 템플릿 엔진 (Thymeleaf, Mustache) 처리 컨트롤러
 *
 * 기능:
 * - Thymeleaf 템플릿 렌더링
 * - Mustache 템플릿 렌더링
 * - HTML 정적 페이지 제공
 */
@Controller
public class MyThtleaf {

	/**
	 * 정적 HTML 페이지 반환
	 *
	 * @return hello.html
	 */
	@GetMapping("/hello")
	public String hello() {
		return "hello";
	}

	/**
	 * Thymeleaf 템플릿 렌더링
	 *
	 * @param model 뷰에 전달할 모델 데이터
	 * @return hello_thyleaf.html
	 */
	@GetMapping("/thyleaf")
	public String thyleaf(Model model) {
		model.addAttribute("message", "스프링부트 타임리프 화면");
		return "hello_thyleaf";
	}

	/**
	 * Mustache 템플릿 렌더링
	 *
	 * @param model 뷰에 전달할 모델 데이터
	 * @return hello_mus.mustache
	 */
	@GetMapping("/mustache")
	public String mustache(Model model) {
		model.addAttribute("message", "머스태치화면");
		return "hello_mus";
	}

}