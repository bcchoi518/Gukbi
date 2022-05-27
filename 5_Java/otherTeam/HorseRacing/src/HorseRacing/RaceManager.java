package HorseRacing;
import java.util.ArrayList;

public class RaceManager {

	// 9개 게이트가 한바퀴 돌아서 27 / 경기장 길이 25
	final int GATE = 7;
	int [][] track = new int[GATE*3][25];
	float[] addForce = new float[10];

	// 결승점에 출력해줄 라인
	String[] goalLine = {"  G"," O"," A"," L","    ","L ","I ","N ","E       "};
	
	// 무조건 1,2,3 결과를 반환하는 테스트용 메서드
    public ArrayList testRace(ArrayList Stable){
    	ArrayList testResult = new ArrayList();
    	testResult.add(1);
    	testResult.add(2);
    	testResult.add(3);
    	return testResult;
    }
	
	// 실제 사용
    public ArrayList race(ArrayList Stable){
    	// 1,2,3 등 말 저장할 리스트 
    	ArrayList grade = new ArrayList(); 
    	
	    // 출전마들
    	ArrayList horseList = new ArrayList(Stable);
    	System.out.println(horseList);
    	// 게이트 순서에 맞게 말들 위치 정렬
    	for(int i=0;i<GATE;i++) {
    		((Horse)horseList.get(i)).posX=0;
    		((Horse)horseList.get(i)).posY=i;
    	}
    	
    	// 세마리가 모두 완주할때까지 반복
		while(true) {

			// 총 경기장 크기 만큼 반복
		    for(int y=0;y<track.length;y++){
		    	int curLine = 0;
		    	
		    	// 경기장 길이 만큼 반복
				for(int x=0;x<track[y].length;x++){	
					// 경기장 구성 문자 대신 말번호를 출력했는지의 여부
					boolean lotte = false;
					for(int i=0; i<horseList.size(); i++) {
						if((Math.round(((Horse)horseList.get(i)).posX)==x && Math.round(((Horse)horseList.get(i)).posY)==y))
						{
							// 말위치와 현재 그리는 위치가같으면 말번호를 대신 출력
							System.out.print("["+((Horse)horseList.get(i)).gateNumber+"]");
							lotte=true;
							curLine++;
						}
					}
					// 7번째 행에서 7 개 열에 GOAL LINE 출력
					if(lotte!=true) {
						curLine++;
						if(y==GATE&&x<=8)	
							System.out.print(goalLine[x]);
						// 7~14번째 행 7~17번째 열은 공백으로 벨로드럼 형상을 구현
						else if((curLine>GATE+1&&curLine<=17)&&(y>=GATE&&y<GATE*2))
							System.out.print("   ");
							// 이외에는 모두 빈 중괄호 출력
						else if(curLine<=25) System.out.print("[ ]");
					}
				}
					// 한 개 라인이 다돌면 개행처리
					System.out.println("");			
			}
		    // 한 화면의 출력이 끝나면 화면 구분을 위해 개행처리
			System.out.println("");
		    
		    // 0.3초마다 말위치 변경
		    try {Thread.sleep(300);
		    }catch(Exception e) {}
		    		    
		    // 현재 참조하는 말의 포지션에 따라 방향 지정
		    for(int i=0;i<horseList.size();i++) {  
		    	// addForce배열을 모두 1로 초기화 후 확률 수치 만큼의 인덱스를 2로 교체
			    for (int r =0; r<addForce.length; r++) addForce[r] = 1;
			    
			    // 말컨디션에 따라 두번씩 뛸 확률을 조정(좋음70%,보통50%,나쁨30%)
			    String condition = ((Horse)horseList.get(i)).condition;
			    switch(condition) {
			    case "좋음":
			    	 for(int r =0; r<7; r++) addForce[r] = (float)Math.random()*2;
			    	 break;
			    case "보통":
			    	for(int r =0; r<5; r++) addForce[r] = (float)Math.random()*2;			    	
			    	break;
			    case "나쁨":
			    	for(int r =0; r<3; r++) addForce[r] = (float)Math.random()*2;
			    	break;
			    }
			    
		    	// addForce배열에서 랜덤한 인덱스를 뽑아 말 위치를 증감
		    	int ran =(int)(Math.random()*10);
		    	// 골라인에 도달한 말은 리스트에서 삭제   	
		    	if(((Horse)horseList.get(i)).posX<=7 && (((Horse)horseList.get(i)).posY>=8&&((Horse)horseList.get(i)).posY<=10)){		
		    		grade.add(((Horse)horseList.get(i)).gateNumber);
		    		horseList.remove(i);
		    	// Y+ 조건
		    	}else if (((Horse)horseList.get(i)).posX<=6 && (((Horse)horseList.get(i)).posY>=7&&((Horse)horseList.get(i)).posY<=18)) ((Horse)horseList.get(i)).posY-=addForce[ran];
		    	// X- 조건
		    	else if (((Horse)horseList.get(i)).posY>=14) ((Horse)horseList.get(i)).posX-=addForce[ran];
		    	// Y+ 조건
		    	else if(((Horse)horseList.get(i)).posX>=18) ((Horse)horseList.get(i)).posY+=addForce[ran];
		    	// X+ 조건
		    	else ((Horse)horseList.get(i)).posX+=addForce[ran];
				
		    	// 3등까지 다들어온경우 경기종료하고 1~3등까지의 값을담은 리스트 반환
				if(grade.size()>=3) {
		    		System.out.println("╔═══───────────────── • ─────────────────═══╗");
		    		System.out.println("                  【경기 결과】");
		    		for(int z = 0; z<grade.size();z++) {
		    			System.out.println("  "+(z+1)+"등 마 : "
		    					+((Horse)Stable.get((int)(grade.get(z))-1)).name
		    					+ ", 출발게이트 번호 : " + grade.get(z));
		    		}
		    		return grade;
		    	}
		    }
		}
	}
    
    // 프로그램 시작시 띄워줄 로고
    public void startMovie() {
    	System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
    			+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣠⣴⣏⡀⠀⠀⣴⡿⣓⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
    			+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣤⣶⣾⣿⣿⣿⣷⣄⠈⠑⠾⠿⢃⣠⡀⠀⠀⠀⠀⠀⠀⠀\r\n"
    			+ "⠀⠀⠀⠀⠀⣠⣾⣇⠀⠀⠀⣾⠿⣃⡀⠀⠀⠘⠛⠛⠛⠛⣿⣿⣿⣿⣆⠀⢀⣴⣿⣿⣿⣦⣀⠀⠀⠀⠀⠀\r\n"
    			+ "⠀⢀⣤⣶⣿⣿⣿⣿⣷⡄⠈⠐⠿⠟⢁⣤⡀⠀⠀⠀⠀⠀⢹⡟⣋⣭⣭⣵⣿⡿⠛⢿⣿⣿⣿⣶⡀⠀⠀⠀\r\n"
    			+ "⠀⠙⠛⠛⠛⠛⣿⣿⣿⣿⣆⠀⢀⣴⣿⣿⣿⣦⣄⠀⠀⠀⠸⣧⣛⣛⣛⣛⣯⡴⢀⣠⣾⣿⡿⠟⠃⠀⠀⠀\r\n"
    			+ "⠀⠀⠀⠀⠀⠀⢹⡟⣫⣭⣥⣴⣿⡟⠛⢿⣿⣿⣿⣶⡄⠀⠀⣿⣿⣿⣿⣿⣟⢰⣿⣿⡛⣡⣶⣿⣿⣿⣿⣿\r\n"
    			+ "⠀⠀⠀⠀⠀⠀⢸⣇⣛⣛⣛⣫⣥⡶⢀⣤⣾⣿⡿⠛⠁⠀⠀⠘⠛⠻⣿⣿⣿⣷⡙⢿⣿⣌⠻⣿⣿⣿⣿⣿\r\n"
    			+ "⠀⠀⠀⠀⠀⠀⠘⣿⣿⣿⣿⣿⣏⢸⣿⣿⠛⣥⣶⣿⣿⣿⣿⣿⣿⣷⣄⠙⣿⣿⣿⣦⡻⣿⣷⢸⣿⣿⣿⣿\r\n"
    			+ "⠀⠀⠀⠀⠀⠀⠀⠹⣿⣿⣿⣿⣿⣧⡙⣿⣿⣌⢻⣿⣿⣿⣿⣿⣿⣿⣿⣧⠈⠛⠛⠻⠷⠦⠤⠾⠿⠟⠛⠛\r\n"
    			+ "⠀⠀⠀⠀⠀⠀⠀⢀⣼⣿⣿⣿⣿⣿⣿⣎⠻⣿⣷⢹⣿⣿⣿⣿⣿⣿⣿⣿⡆⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
    			+ "⠀⠀⠀⠀⠀⢀⣴⣿⣿⡿⠋⣬⠉⠛⠻⠿⠷⠬⠵⠿⠿⠛⠛⠛⢿⣿⣿⣿⣧⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
    			+ "⠀⠀⠀⢀⣴⣿⣿⠿⢋⣠⠞⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠻⢦⡙⢿⣿⣿⣦⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
    			+ "⠀⠀⠀⢿⣿⡉⢤⡖⠉⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠙⢦⣍⠻⣿⣷⡀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
    			+ "⠀⠀⠀⠈⠻⣷⣌⠳⡄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠙⢷⣌⠻⣿⣦⡀⠀⠀⠀⠀⠀⠀\r\n"
    			+ "⠀⠀⠀⠀⠀⠈⠉⠀⠉⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠉⠁⠈⠉⠁⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
    			+ "\r\n"
    			+ "⢰⡆⢰⡆⣠⡶⢶⣦⢶⣶⣶⣶⣤⣶⠷⣶⢴⣶⣶⣶⠀⠀⢲⣶⣶⣶⡄⢀⣦⠀⢀⣴⣶⡖⣴⡆⣶⣦⠀⣶⢀⣴⣶⡶⠀\r\n"
    			+ "⢸⣇⣸⡇⣿⡇⢀⣿⠈⣿⣴⡿⠋⣛⠷⣦⢸⣿⣶⣶⠀⠀⢸⣿⣴⡿⠃⣾⢿⣆⢸⡟⠀⡀⣿⡇⣿⡿⣷⣿⣾⣏⠶⣶⡆\r\n"
    			+ "⠸⠏⠹⠇⠘⠿⠿⠋⠀⠿⠙⠿⠈⠻⠿⠟⠸⠿⠿⠿⠀⠀⠸⠿⠹⠿⠚⠟⠛⠿⠊⠿⠿⠟⠻⠇⠿⠇⠻⠿⠘⠿⠿⠟⠀");
	    // 로고 띄워주고 3초 대기
	    try {Thread.sleep(3000);
	    }catch(Exception e) {}
    }
}