package kim.service.Day10_15_Calculate;

import org.springframework.stereotype.Service;

/**
 * 계산기 서비스
 *
 * 기능:
 * - 덧셈, 뺄셈, 곱셈, 나눗셈 계산
 * - 동적 연산 수행
 */
@Service
public class CalculatorService {

	/**
	 * 동적 계산 메서드
	 *
	 * @param num1 첫 번째 숫자
	 * @param num2 두 번째 숫자
	 * @param operation 연산자 (ADD, SUBSTRACT, MULTIPLY, DIVIDE)
	 * @return 계산 결과
	 */
	public String calculate(double num1, double num2, String operation) {
		return switch (operation.toUpperCase()) {
			case "ADD" -> add(num1, num2);
			case "SUBSTRACT" -> subtract(num1, num2);
			case "MULTIPLY" -> multiply(num1, num2);
			case "DIVIDE" -> divide(num1, num2);
			default -> throw new IllegalArgumentException("적합하지 않은 연산자: " + operation);
		};
	}

	/**
	 * 덧셈
	 *
	 * @param num1 첫 번째 숫자
	 * @param num2 두 번째 숫자
	 * @return 덧셈 결과
	 */
	public String add(double num1, double num2) {
		return String.valueOf(num1 + num2);
	}

	/**
	 * 뺄셈
	 *
	 * @param num1 첫 번째 숫자
	 * @param num2 두 번째 숫자
	 * @return 뺄셈 결과
	 */
	public String subtract(double num1, double num2) {
		return String.valueOf(num1 - num2);
	}

	/**
	 * 곱셈
	 *
	 * @param num1 첫 번째 숫자
	 * @param num2 두 번째 숫자
	 * @return 곱셈 결과
	 */
	public String multiply(double num1, double num2) {
		return String.valueOf(num1 * num2);
	}

	/**
	 * 나눗셈
	 *
	 * @param num1 첫 번째 숫자
	 * @param num2 두 번째 숫자
	 * @return 나눗셈 결과 (0으로 나누기 불가)
	 */
	public String divide(double num1, double num2) {
		if (num2 == 0) {
			return "0으로 나눌 수 없습니다";
		}
		return String.valueOf(num1 / num2);
	}

}