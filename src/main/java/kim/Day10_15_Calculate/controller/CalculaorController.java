package kim.controller.Day10_15_Calculate;

import kim.request.Day10_15_Calculate.CalculateRequest;
import kim.response.Day10_15_Calculate.CalculationResponse;


import org.springframework.web.bind.annotation.RestController;




import kim.service.Day10_15_Calculate.CalculatorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;




@RestController
@RequestMapping("/calculator")
public class CalculaorController {
//	타입(클래스) 오브젝트 이름
//	@Autowired 사용법 
	@Autowired
CalculatorService calculatorService;
	public CalculaorController(CalculatorService calculatorService)
	{this.calculatorService = calculatorService ;}
	  @PostMapping("/calculate")
public CalculationResponse calculate (@RequestBody CalculateRequest request)
{
String result =( calculatorService.calculate(request.getNum1(),request.getNum2(),request.getOperation()));
//return new CalculationResponse(num1,num2,"ADD",result);
return new CalculationResponse(
		request.getNum1(),
		request.getNum2(),
		request.getOperation(),
		result
		);
}	
	
    // ✅ 방법 1: CalculationResponse 객체 반환 (권장)
    @GetMapping("/add")
    public CalculationResponse add(
        @RequestParam double num1,
        @RequestParam double num2) {
        
        String result = calculatorService.add(num1, num2);  // 서비스 호출
        return new CalculationResponse(num1, num2, "ADD", result);
    }
    
    // ✅ 방법 2: String 직접 반환
    @GetMapping("/subtract")  // 공백 제거!
    public String subtract(
        @RequestParam double num1,
        @RequestParam double num2) {
                      
        return calculatorService.subtract(num1, num2);  // 철자 수정!
    }
  

	@GetMapping("/multiply")
	public CalculationResponse multiply(@RequestParam double num1 ,@RequestParam double num2) {
		
		String result = calculatorService.add(num1, num2);  // 서비스 호출
        return new CalculationResponse(num1, num2, "MULTIPLY", result);
	}
	@GetMapping("/divide")
	public CalculationResponse divide(@RequestParam double num1 ,@RequestParam double num2) {
		
		String result = calculatorService.add(num1, num2);  // 서비스 호출
        return new CalculationResponse(num1, num2, "DIVIDE", result);
	}
		
	
	

}
