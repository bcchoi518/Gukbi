package poketmonproject;

import java.io.Serializable;

public class Poketmon implements Serializable{
    String name; //이름
    int type; //타입
    int level; //잡힐확률을 나누기 위한 레벨
    int cp; //뮤츠와의 대결을 위한 공격력

    public Poketmon(String name, int type, int level){ //Map에서 사용
        this.name = name;
        this.type = type;
        this.level= level;
    }

    public Poketmon(Poketmon p){ //new로 불러옴으로써 주소값이 겹치는것을 방지함
        this.name = p.name;
        this.type = p.type;
        this.level = p.level;
    }

    void showGetMon() { //출력 양식 메서드 - getPoketmon()에서 사용
        System.out.println("        │ Lv."+level+" "+name+" [CP: "+cp+"]	│");
    }

}
