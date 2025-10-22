package kim.day10_20_Student.domain;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
//lombok->상자 제작 자동화 공장
import lombok.Data;
import lombok.NoArgsConstructor;

//Student class-> "학생정보 " 택배 상자에 설계도
// 공문서 형식이라고 보면됨 -> 이름 : , 나이: , 거주지:
//이게 없으면 사용자는 무슨정보를 입력해야할지 모르고, 받는사람입장에서도 사용자가 아무렇게 작성한 정보를 따로 분석해야해서
// 사용자 가 뭘 입력하면 좋을지 형식을 정해줌
//택배 상자로 비유하면 택배 상자에 이상한 칸들이 뒤죽박죽 섞여 잇으면 택배기사가 분류를 못하니까 칸을 정해준거임

//=============
//원래는 특별한 도구 getter,setter을 직접 만들어야하지만 @data를통해 자동으로 생성되게한다.-> 간단해짐
//@data는 만능칼 -> 멕가이버 칼이라고 생각하면된다 -> 맥가이버칼 하나만 있으면 굳이 여려개의 도구를 들고 다닐 필요가 없다.
//@data에 기능
//1. getter
//2.setter
//3.tostring
//4.equalsAndHashCode-> equals () + hashCode()
//5.RequiredArgsConstructor -> final 필드 생성자
@Data
//Builder -> 레고 블록처럼 단계별로 상자 조립하기!
// 각각에 변수-> 블럭을 레고 블럭처럼 조립해서 전체 상자를 만드는것이다.
//이렇게 하면 가독성이 좋아지고, 레고 블력을 조립해서 파라미터를 선택하는데도 용이하다-> 빼고 싶을 블럭만 빼면된다.
//순서에 상관없이 원하는 것만 넣을수 있다
// 마치 커스텀 키보드하고 비슷하다.
//내가 원하는 구성으로  나만에 키보드를 조립하는거다.

@Builder

//AllArgsConstructor -> 완성품 한번에 만들기
@AllArgsConstructor//모든 필드를 받는 생성자 bulider가 비슷한 역할을해서 불필요 할수가 있다.
//그런데도 사용하는 이유는 명시적으로 이러한 기능을 쓴다고 다시한번 선언한다-> 코드를 볼때 무슨 기능을 사용했는지 명확히 보임


@NoArgsConstructor//기본생성자 (파라미터 없음)
//NoArgsConstructor-> MyBatis 가 객체를 생성할때 반드 시 필요하다 , 없으면 객체를 생성하지 못해서 컴파일 오류가 나온다.


public class Student {
//각자의 칸은 private 비공개라서 외부에서 함부로 열수가 없다.
//    특별한 도구 getter,setter로만 접근 가능

	private long id;
	private String name;
	private String email;
	private Integer age;
	private LocalDateTime create_at;
	private LocalDateTime update_at;
}
