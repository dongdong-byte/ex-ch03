package com.example.demo.Service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


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
		
		
		
		
		
		String msg = "p.70 if문 결과는 : " + result; 
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
        
        String msg = "p.72 for 문 결과는 : " +result;
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
        
        String msg = "p.73 while 문 결과는 : " + result;
		return msg;
	}
	

	
	
}
