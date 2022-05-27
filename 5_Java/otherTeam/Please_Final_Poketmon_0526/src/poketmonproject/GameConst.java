package poketmonproject;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class GameConst { //상수
    static Scanner sc = new Scanner(System.in); //값을 입력받는 스캐너
    static List<Poketmon> poketmons = List.of( // List.of -> 생성과 동시에 선언
            //type1 = 풀, type2 = 불, type3 = 물, type4 = 전기
            //level = 개체별 CP범위와 잡을확률을 나눔
            new Poketmon("이상해씨", 1, 3), //ex) "이상해씨"는 풀타입(1)이고, 210~500 랜덤CP, 30%의 확률로 잡을 수 있다(lv.3)
            new Poketmon("파라스", 1, 2),
            new Poketmon("뚜벅초", 1, 1),
            new Poketmon("파이리", 2, 3),
            new Poketmon("식스테일", 2, 2),
            new Poketmon("가디", 2, 1),
            new Poketmon("꼬부기", 3, 3),
            new Poketmon("발챙이", 3, 2),
            new Poketmon("고라파덕", 3, 1),
            new Poketmon("피카츄", 4, 3),
            new Poketmon("코일", 4, 2),
            new Poketmon("찌리리공", 4, 1)
    );

    // 2차원 맵 구조. 레벨, 최소cp, 최대cp, 확률에 대한 상수값 셋팅
    public static final Map<Integer, Map<String, Integer>> LV_CP_MAPPING = Map.of(
            1, Map.of("min", 10, "max", 100, "p", 90),
            2, Map.of("min", 80, "max", 200, "p", 60),
            3, Map.of("min", 210, "max", 500, "p", 30)
    ); //레벨이 1인 포켓몬의 최소값(min)은 10, 최대값(max)은 100, 확률(p)는 90

    static List<Poketmon> poketmonBag = new ArrayList<>(); //잡은 포켓몬을 담을 ArrayList() 선언 및 생성
    static List<Poketmon> vsList = new ArrayList<>(); //뮤츠와 싸우기 위해 고른 포켓몬을 담을 ArrayList() 선언 및 생성
}
