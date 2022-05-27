package step01;

public class ChoiceException extends Exception {
  public ChoiceException() {
    super("");
  }
  
  public void showWrongChoice() {
    System.out.println("잘못 입력하셨습니다. 다시입력해주세요");
  }
}
