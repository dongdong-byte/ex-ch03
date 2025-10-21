package kim.service.Day10_15_Calculate;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService {

	public String add( ) {
	
	 return "덧셈_con";
	}
	public String calculate( double num1, double num2 ,String operation) {
		
		 return switch (operation.toUpperCase()){
		 case "ADD" -> add(num1,num2);
		 case "SUBSTRACT" -> subtract(num1, num2);
		 case "MULITIPLY" ->	 multiply(num1, num2);
		 case "DIVIDE" -> divide(num1, num2);
		 default -> throw new IllegalArgumentException("적합하지 않은 연산자");
		 
		 };}
		 
	

	public String add(double num1, double num2) {
		String result = String.valueOf(num1+ num2);
		return result;
	
	
	}

	 public String subtract(double num1, double num2) {  // 철자 수정!
	        return String.valueOf(num1 - num2);
	    }

	public String multiply(double num1, double num2) {
		String result = String.valueOf(num1 * num2);
		return result;
	}

	public String divide(double num1, double num2) {
		if(num2 ==0) {
			return "0으로 나눌수가 없습니다";
		}
		
		String result = String.valueOf(num1/num2);
		return result;
	}
		
		
	}

	
	
	

