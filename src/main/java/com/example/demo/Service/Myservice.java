package com.example.demo.Service;


import com.example.demo.controller.MyController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class Myservice {

    

   


	
	private static final Logger Log = LoggerFactory.getLogger(Myservice.class);


   

    



	public String sayHello(String hi) {
		String msg = hi + " -> 그렇다";
		
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
	

	
	
}
