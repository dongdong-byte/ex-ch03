package kim.controller.Day10_17_form;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kim.request.Day10_17_form.ArticleRequest;

/**
 * 폼 데이터 처리 컨트롤러
 *
 * 기능:
 * - GET 방식: @RequestParam 사용
 * - POST 방식: @RequestBody 사용
 * - @ModelAttribute: Form 데이터 자동 바인딩
 */
@RestController
public class Myform {

	/**
	 * GET 방식 게시글 조회
	 *
	 * @param id 게시글 ID
	 * @param title 제목
	 * @param content 내용
	 * @return 게시글 정보
	 */
	@GetMapping("/article-get")
	public String articleget(
		@RequestParam String id,
		@RequestParam String title,
		@RequestParam String content) {
		return new StringBuilder()
			.append("아이디는 ").append(id)
			.append(", 제목은 ").append(title)
			.append(", 내용은 ").append(content)
			.toString();
	}

	/**
	 * POST 방식 게시글 생성 (JSON)
	 *
	 * @param request 게시글 요청 정보
	 * @return 게시글 정보
	 */
	@PostMapping("/article-post")
	public String articlepost(@RequestBody ArticleRequest request) {
		return """
			아이디는 : %s,
			제목은 : %s,
			내용은 : %s
			""".formatted(request.id(), request.title(), request.content());
	}

	/**
	 * POST 방식 게시글 생성 (Form Data)
	 *
	 * @param request 게시글 요청 정보
	 * @return 게시글 정보
	 */
	@PostMapping("/article-postman")
	public String articlepostman(@ModelAttribute ArticleRequest request) {
		return "아이디는 : %s , 제목은 : %s, 내용은 : %s".formatted(
			request.id(),
			request.title(),
			request.content()
		);
	}

	/**
	 * 자동 바인딩을 사용한 게시글 조회
	 * GET, POST 모두 지원
	 *
	 * @param request 게시글 요청 정보
	 * @return 게시글 정보
	 */
	@RequestMapping("/article-auto")
	public String articleAuto(ArticleRequest request) {
		return "아이디는 : %s , 제목은 : %s, 내용은 : %s".formatted(
			request.id(),
			request.title(),
			request.content()
		);
	}

}