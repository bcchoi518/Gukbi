package poketmonproject;

import java.util.stream.Collectors;

public class BattleMewtwo {
    final int MEWTWO_CP = 1200; //뮤츠의 CP를 1200으로 고정(상수)
    
	public int getTotalCp() { //vsList에 담긴 포켓몬 3마리의 CP를 더한 총 합
		return (int) GameConst.vsList.stream().collect(Collectors.summarizingInt(v -> v.cp)).getSum(); //람다식
	}
	
	public void battleIf() { //승패를 결정하는 함수
		
		if(MEWTWO_CP < getTotalCp()) { //getTotalCp()값이 뮤츠의 CP값보다 클 경우
			System.out.println();
			System.out.println("                  < 승리 >"); //이겼다는 메세지 출력
			System.out.println();
		}else { //getTotalCp()값보다 뮤츠의 CP값이 더 클 경우
			System.out.println();
			System.out.println("                  < 패배 >"); //졌다는 메세지 출력
			System.out.println();
		}
	}
	public void showBattle() { //쓰레드(Thread.sleep)를 사용하여 싸우는 모습과 연산값을 출력
		System.out.println();
		try 
		{
			Thread.sleep(1000); //1초동안 일시정지
			System.out.println("   	      Ａ__Ａ  		 	");
			System.out.println("   	 　　  (o・ω・)  	 	");
			System.out.println(" 	  /ヽヘし▄︻▇〓┳═-・*。 	");
			System.out.println(" 	   ＼/ヽｕ─ｕ'  		");
			System.out.println();
			Thread.sleep(500); //0.5초
			System.out.print("	    싸");
			Thread.sleep(500);
			System.out.print(" 우");
			Thread.sleep(500);
			System.out.print(" 는");
			Thread.sleep(500);
			System.out.print(" 중");
			Thread.sleep(500);
			System.out.print(" .");
			Thread.sleep(500);
			System.out.print(" .");
			Thread.sleep(2000); //2초
			System.out.println();
			battleIf(); //승패를 출력
			Thread.sleep(500);
			System.out.println("            [뮤츠의　CP] "+ MEWTWO_CP); //뮤츠의 CP값 출력
			Thread.sleep(1000);
			System.out.println("            [TOTAL CP] " + getTotalCp()); //연산값 출력
			Thread.sleep(1000);
		}catch(InterruptedException e) { //쓰레드 예외처리
		}
		System.out.println();
		GameConst.vsList.clear(); //vsList 초기화
		
	}

}