package step01;

public class ChoiceException extends Exception {
  public ChoiceException() {
    super("");
  }
  
  public void showWrongChoice() {
    System.out.println("�߸� �Է��ϼ̽��ϴ�. �ٽ��Է����ּ���");
  }
}
