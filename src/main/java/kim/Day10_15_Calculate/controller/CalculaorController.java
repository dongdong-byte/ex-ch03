package kim.controller.Day10_15_Calculate;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kim.request.Day10_15_Calculate.CalculateRequest;
import kim.response.Day10_15_Calculate.CalculationResponse;
import kim.service.Day10_15_Calculate.CalculatorService;
import lombok.RequiredArgsConstructor;

/**
 * 계산기 REST API 컨트롤러
 *
 * 기능:
 * - 덧셈, 뺄셈, 곱셈, 나눗셈 연산
 * - POST, GET 요청 지원
 */
@RestController
@RequestMapping("/calculator")
@RequiredArgsConstructor
public class CalculaorController {

	private final CalculatorService calculatorService;

	/**
	 * POST 방식 계산 요청
	 *
	 * @param request 계산 요청 정보 (num1, num2, operation)
	 * @return 계산 결과
	 */
	@PostMapping("/calculate")
	public CalculationResponse calculate(@RequestBody CalculateRequest request) {
		String result = calculatorService.calculate(
			request.getNum1(),
			request.getNum2(),
			request.getOperation()
		);
		return new CalculationResponse(
			request.getNum1(),
			request.getNum2(),
			request.getOperation(),
			result
		);
	}

	/**
	 * GET 방식 덧셈
	 *
	 * @param num1 첫 번째 숫자
	 * @param num2 두 번째 숫자
	 * @return 덧셈 결과
	 */
	@GetMapping("/add")
	public CalculationResponse add(
		@RequestParam double num1,
		@RequestParam double num2) {
		String result = calculatorService.add(num1, num2);
		return new CalculationResponse(num1, num2, "ADD", result);
	}

	/**
	 * GET 방식 뺄셈
	 *
	 * @param num1 첫 번째 숫자
	 * @param num2 두 번째 숫자
	 * @return 뺄셈 결과
	 */
	@GetMapping("/subtract")
	public String subtract(
		@RequestParam double num1,
		@RequestParam double num2) {
		return calculatorService.subtract(num1, num2);
	}

	/**
	 * GET 방식 곱셈
	 *
	 * @param num1 첫 번째 숫자
	 * @param num2 두 번째 숫자
	 * @return 곱셈 결과
	 */
	@GetMapping("/multiply")
	public CalculationResponse multiply(
		@RequestParam double num1,
		@RequestParam double num2) {
		String result = calculatorService.multiply(num1, num2);
		return new CalculationResponse(num1, num2, "MULTIPLY", result);
	}

	/**
	 * GET 방식 나눗셈
	 *
	 * @param num1 첫 번째 숫자
	 * @param num2 두 번째 숫자
	 * @return 나눗셈 결과
	 */
	@GetMapping("/divide")
	public CalculationResponse divide(
		@RequestParam double num1,
		@RequestParam double num2) {
		String result = calculatorService.divide(num1, num2);
		return new CalculationResponse(num1, num2, "DIVIDE", result);
	}

}