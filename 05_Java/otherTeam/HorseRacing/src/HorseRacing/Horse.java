package HorseRacing;
import java.io.Serializable;

public class Horse implements Serializable {

	float posX = 0;
	float posY = 0;
	
	int gateNumber;

	public String name;
    int horseNumber;
	String age;
	String gender;
	String kind;
	String condition;
	
	Horse(){
		this("이름", 1, "나이", "성별", "종", "컨디션");
	}
	
	Horse(String name, int horseNumber, String age,
		String gender, String kind, String condition){
		this.name = name;
		this.horseNumber = horseNumber;
		this.age = age;
		this.gender = gender;
		this.kind = kind;
		this.condition = condition;
	}

	public String toString() {
		return " [ 이름 ] " + name + "\n" + " [ 마번 ] " + horseNumber + "\n" + " [ 나이 ] " + age + "\n"
				+ " [ 성별 ] " + gender + "\n" + " [ 품종 ] " + kind + "\n" +" [ 오늘의 컨디션 상태 ] " + condition + "\n"
				+ " [ 오늘의 출발 게이트 번호 ] " + gateNumber + "\n";

	}
}