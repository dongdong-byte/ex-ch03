package com.example.demo.Service.Ch03;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Optional;

@Service
public class Myservice {

   

    

   


	
	private static final Logger Log = LoggerFactory.getLogger(Myservice.class);


    


   

    



	public String sayHello(String hi) {
		String msg = hi + " -> 완료";
		
		System.out.println(msg);
		
		Log.info(msg);
		return msg;
	}

	public String IF() {
		
		String result ="";
		
		int i = 1;
		
		if( i == 1){
            System.out.println("if 블록입니다");
            result ="if 블록입니다";
        }else if (i == 2){
            System.out.println("else if 블록입니다.");
            result ="else if 블록입니다";
        }else {

            System.out.println("else 블록입니다.");
            result ="else 블록입니다";
        }
		System.out.println(result);
		
		Log.info(result);	
		
		
		
		
		
		String msg = "p.70 if문 결과는 : " + result+ " 입니다."; 
		return msg;
	}

	

	public String For() {
		
		String result ="";
		int[] arry ={1,2,3,4,5,6};
        for (int i = 0; i<arry.length;i++ ){
            result= "i =" + arry[i];

        }
        System.out.println(result);
        Log.info(result);
        
        String msg = "p.72 for 문 결과는 : " +result+" 입니다.";
		return msg;
	}



	public String While() {
		String result = "";
		int[] arry = {1,2,3,4,5,6,7,8};
        int i=0;
        while (i<arry.length){
            result = "i =" + arry[i];
            i++;

        }
        
        System.out.println(result);
        Log.info(result);
        System.out.println("while문은 형태는 for문보다 간결하지만 실제로 코드를 작성하면 for문에 비해 훨씬 복잡하다.");
        System.out.println("왜냐하면 for문에서 조건식으로 적은코드가 while 문에서는 순서가 뒤섞여 있기 때문이다 ");
        System.out.println("while 문은 언제 반복 을 끝내야할지 명확하지 않는 경우, 특정 조건만 만족하면 무한히 반복해야하는 경우에 적합히다.");
        System.out.println("주로 break 문하고 같이 사용한다.");
        
        String msg = "p.73 while 문 결과는 : " + result+" 입니다.";
		return msg;
	}

	public String List() {
		
		String result = "";
//      <Integer>는 ArrayList 에 InTeger 타입이 저장될수 있다는것을 의미한다
      List<Integer> list = new ArrayList<Integer>();

      list.add(1);
      list.add(2);
      list.add(3);

      result = String.valueOf(list.get(1));
      System.out.println("List 의 크기 = " + list.size());
      System.out.println("List 의 1번 인덱스 결과값 = " + result);
      Log.info("list의 결과 = "+ result);
      String msg = "p.76 array 문 결과는 : " + result+" 입니다.";
		return msg;
	}






	public String ArrayList() {
		String result ="";
		List<String> list = new ArrayList<String>();
        list.add("public");
        list.add("static");
        list.add("void");
System.out.println("초기 리스트");
//        for문으로 List를 순회 할수 있다.
        for(int a = 0 ; a <list.size(); a++ ){

            System.out.println(list.get(a));
        }
//        1번째 요소인 static이 제거 된다 -> ["public","void"]
        list.remove(1);
        System.out.println("static 제거후");
        for(String item : list) {
        	System.out.println(item);
        }
        System.out.println("void의 인덱스인 1이 반환된다.");
        int voidIndex = list.indexOf("void");
        System.out.println("void 의 Index = " + voidIndex);
Log.info("void 의 Index = " + voidIndex);
result = "void 의 Index는"+voidIndex;
String msg = "p.78 arrayList 문 결과는 : " + result +" 입니다.";
		return msg;
	}




	public String ArrayListAPI() {
		
		String result = "";
		List<String> list = new ArrayList<String>();
        list.add("public");
        list.add("static");
        list.add("void");

         
        
        StringBuilder  sd = new StringBuilder();
 list.stream().forEach(str -> sd.append(str + "<br>"));
 result = sd.toString();
 
String msg = "p.78 arrayList 문 결과는 : " +"<br>" + result +" 입니다.";
		return msg;
	}

	public String ArrayListFor1() {
	 String	result = "";
	 Integer[] integersarray = new Integer[]{1,2,3,4,5,6,7,8,9,10};
     List<Integer> list = Arrays.asList(integersarray);
     List <Integer>evenList = new ArrayList<Integer>();
     for (int i =0 ; i<list.size(); i ++){
         Integer number = list.get(i);
         if(number %2 ==0){
//             2로 나누었을때 나머지가 0이면 2의배수이다.
             evenList.add(number);

         }

     }
     
    result = "짝수 리스트" + "<br>";
    for (int i =0; i<evenList.size(); i++){
         result += evenList.get(i) + "<br>";

     }
    
    
   
     
	 
		return result;
	}

	public String ArrayListFor2() {
		
		 Integer[] integersarray = new Integer[]{1,2,3,4,5,6,7,8,9,10};
	     List<Integer> list = Arrays.asList(integersarray);
	     List <Integer>evenList = new ArrayList<Integer>();
	     for (int i =0 ; i<list.size(); i ++){
	         Integer number = list.get(i);
	         if(number %2 ==0){
//	             2로 나누었을때 나머지가 0이면 2의배수이다.
	             evenList.add(number);

	         }

	     }
	    System.out.println("문자열이 많을때는 StringBulider 가 더 효율적이다");
	    
	    StringBuilder sb = new StringBuilder();
	    for(int i =0; i< evenList.size(); i++) {
	    	sb.append(evenList.get(i));
	    	
	    }
	    
		
		return sb.toString();
	}
	
	public String ArrayListBetterFor() {
		
		 Integer[] integersarray = new Integer[]{1,2,3,4,5,6,7,8,9,10};
	     List<Integer> list = Arrays.asList(integersarray);
	     List <Integer>evenList = new ArrayList<Integer>();
	     for(Integer number : list ) {
	    	 if(number %2 ==0) {
	    		 evenList.add(number);
	    	 }
	    	 
	     }

	     
	    System.out.println("문자열이 많을때는 StringBulider 가 더 효율적이다");
	    Log.info("문자열이 많을때는 StringBulider 가 더 효율적이다");
	    StringBuilder sb = new StringBuilder();
	    sb.append("향상된 for문을 사용해서 짝수만 출력" + "<br>");
	    for(Integer num : evenList) {
//	    	evenlist 순회
	    	sb.append(num +"<br>");
	    	
	    }
	    
		
		return sb.toString();
	}

	public String Fiter() {
		Integer[] integersarray = new Integer[]{1,2,3,4,5,6,7,8,9,10};
        List<Integer> list = Arrays.asList(integersarray);

List <Integer> evenList   = list.stream()
        .filter(value -> value%2 ==0).collect(Collectors.toList());
        
StringBuilder sb = new StringBuilder();
sb.append("짝수 리스트 fiter함수 사용" + "<br>");

for(Integer num : list ) {
	sb.append(num + "<br>");
	
}

        
		return sb.toString();
	}

	public String Distanct() {
		 Integer [] interArray = new Integer[]{1,1,1,1,2,2,3,4,5,6,7,7};
	        List<Integer > list = Arrays.asList(interArray);
	        List<Integer> distinctList = list.stream().distinct().toList();
	       

	        
	        StringBuilder  sb = new StringBuilder();
	        sb.append("distinct메서드 사용해서 중복된 숫자 제거" + "<br>");
	        for(Integer number : distinctList) {
	        	sb.append(number + "<br>");
	        	
	        }
	        
		
		
		return sb.toString();
	}

	public String Map() {
		String result = "";
		String [] lowercaseArray = new String[]{"public","static", "void"};
        List<String> lowercaseList = Arrays.asList(lowercaseArray);
        List<String> uppercaseList = lowercaseList.stream()
                .map(value -> value.toUpperCase() ).toList();
        uppercaseList.stream().forEach(val -> System.out.println(val));
        
		StringBuilder sb = new StringBuilder();
		sb.append("map함수 사용해서 소문자를 대문자로 바꾸기" +"<br>");
		uppercaseList.forEach(val -> sb.append(val +"<br>"));
		
		result = sb.toString();
        
        return result;
	}

	private static String getSomeString() {
	    return null;
	    // 이 메서드는 항상 null을 반환한다
	}

	public String Optional() {
	    StringBuilder sb = new StringBuilder();
	    sb.append("null 체크 예제<br><br>");
	    
	    String isThisNull = getSomeString();
	    
	    if (isThisNull != null) {
	        sb.append("결과: " + isThisNull.toUpperCase() + "<br>");
	    } else {
	        sb.append("결과: null이므로 출력할 내용이 없습니다.<br>");
	    }
	    
	    return sb.toString();
	}

	public String NullPointerException1() {
		StringBuilder sb = new StringBuilder();
		  String isThisNull = getSomeString();
	        
	        // null 체크 추가
	        if (isThisNull != null) {
	            System.out.println(isThisNull.toUpperCase());
	        } else {
	            System.out.println("값이 null입니다.");
	        }
	        return sb.toString();
	}

    public String equal() {
        String result = "";
        String str1 = new String("is same?");
        String str2 = new String("is same?");
        if(str1 == str2) {
          result = "true";
        }else {

            result = "false";
        };
        String msg = "p.79 동일성비교에서  if를 사용한 결과는" + result + "이다.";

     return msg;
    }

    public String equal1() {

        String str1 = new String("is same?");
        String str2 = new String("is same?");
        boolean result = str1.equals(str2);
        String msg = "p.79 동등성 비교에서 equal함수를 사용한 결과는" + result + "이다.";

        return msg;

    }

    public String equal2() {
        String result = "";
        String str1 = new String("is same?");
        String str2 = new String("is same?");
         result = str1.equals(str2) ? "true":"false";
        String msg = "p.79 동등성비교에서 삼항 연산자를 사용한 결과는" + result + "이다.";

        return msg;
    }

    public String equal3() {

        String str1 = new String("is same?");
        String str2 = new String("is same?");


        return "p.79 동일성비교에서 위에 식을 한줄로 압축한 결과는" + str1.equals(str2) + "이다." ;
    }

    public String equa4() {
        String result = "";
        String str1 = new String("is same?");
        String str2 = new String("is same?");
        result = (str1 == str2) ? "true":"false";
        String msg = "p.79 동등성비교에서 삼항 연산자를 사용한 결과는" + result + "이다.";

        return msg;
    }

    public String equa5() {

        String str1 = new String("is same?");
        String str2 = new String("is same?");
        boolean result = (str1 == str2);
        String msg = "p.79 동등성비교에서 boolean를 사용한 결과는" + result + "이다.";

        return msg;

    }

    public String ForEach() {



        Integer[] intArray = new Integer[]{1,2,3,4,5};
        List<Integer> list = Arrays.asList(intArray);
        StringBuilder  sb = new StringBuilder();
        for(Integer number : list){
            sb.append(number);
        }

        return sb.toString();

    }

    public String StreamAPI() {
        Integer [ ] intArray = new Integer[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16};
        List<Integer> list = Arrays.asList(intArray);
        List<Integer> evenlist = list.stream()
                .filter(value -> value %2 ==0).collect(Collectors.toList());
        StringBuilder sb = new StringBuilder();
        for (Integer num :evenlist ){
            sb.append(num);

        }

        return "p.90 스트림 API 결과는" + sb.toString() + "입니다.";
    }

    public String AntiPattern() {
        Optional<String> optional = getSomeString12();
        StringBuilder sb = new StringBuilder();
        if (optional.isPresent()) {
            sb.append(optional.get());
        }
        return sb.toString();

    }

    private Optional<String> getSomeString12() {
        return  Optional.ofNullable("public static void");
    }


    public static interface Car{
        public String getColor();
}
    public static class Sonata implements Car{
        public Sonata(){
            Log.info("이건 소나타입니다");
        }
       @Override
        public String getColor() {
            return "==== 색상 : 빨강=====";
       }
    }
    public static class K5 implements Car{

        public K5(){
            Log.info("이건 k5입니다.");
        }
        @Override
        public String getColor() {
            return "색상 : 검정";
        }
    }


    public static String Interface() {
    Car car1 = new Sonata();
    String str1 = car1.getColor();
    Car car2 = new K5();
    String str2 = car2.getColor();
    String result =  str1+"<br>" + str2 + "<br>"+ "차 2대를 출고하였음";
    return result;
    }


    public class Main{
        private  static  Optional<String> getsomeString(){
            return Optional.empty();
//            null을 반환하는것이 아니라 비어있는 Opitional을 반환한다
        }

    }

	public String OptionalEmpty() {
		 StringBuilder sb = new StringBuilder();
		    sb.append("Optional 사용 예제<br><br>");
		    
		    Optional<String> isThisNull = Optional.ofNullable(getSomeString());
		    
		    // ifPresentOrElse로 처리
		    isThisNull
		        .map(String::toUpperCase)
		        .ifPresentOrElse(
		            value -> sb.append("결과: " + value + "<br>"),  // 값이 있으면
		            () -> sb.append("결과: null이므로 출력할 내용이 없습니다.<br>")  // null이면
		        );
		    
		    return sb.toString();
	}
	public class Main1 {
	    private static Optional<String> getsomeString() {
	        return Optional.ofNullable("public, static ,void");
	        // 값이 있는 Optional을 반환한다
	    }
	}

	// 컨트롤러에서
	public String Optional03() {
	    StringBuilder sb = new StringBuilder();
	    sb.append("Optional ifPresent 예제<br><br>");
	    
	    Optional<String> isThisNull = Main1.getsomeString();
	    
	    isThisNull.ifPresentOrElse(
	        str -> sb.append("결과: " + str.toUpperCase() + "<br>"),
	        () -> sb.append("결과: 값이 없습니다.<br>")
	    );
	    
	    return sb.toString();
	}
}
	
	
	

