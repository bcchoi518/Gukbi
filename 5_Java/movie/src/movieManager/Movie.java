package movieManager;

import java.io.Serializable;

public class Movie implements Serializable {
	int serialNumber;		//�ø���ѹ�
	String title;			//����
	String category;		//�帣
	double score;			//����
	String synopsis;		//�ٰŸ�
	String tag; 			//�±�
	String contentsRating;	//�������
	int scoreCount;			//���� ���ġ ����
	int scoreSum;			//���� ���ġ ����
	
	Movie(){}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public double getScore() {
		return score;
	}
	public void setScore(double score) { //������ ���� �ű涧���� ȣ���ؼ� ���
		scoreCount++;
		scoreSum+=score;
		this.score = scoreSum/(scoreCount*5);
	}
	public String getSynopsis() {
		return synopsis;
	}
	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}
	public String isContentsRating() {
		return contentsRating;
	}
	public void setContentsRating(String contentsRating) {
		this.contentsRating = contentsRating;
	}

	public int getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(int serialNumber) {
		this.serialNumber = serialNumber;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public int getScoreCount() {
		return scoreCount;
	}

	public void setScoreCount(int scoreCount) {
		this.scoreCount = scoreCount;
	}

	public int getScoreSum() {
		return scoreSum;
	}

	public void setScoreSum(int scoreSum) {
		this.scoreSum = scoreSum;
	}

	public String getContentsRating() {
		return contentsRating;
	}

	@Override
	public String toString() {
		return "�ø���ѹ� : "+serialNumber+"\n���� : "+title+", �帣 : "+category+" , ���� : "+score+", ������� : "+contentsRating+", �±� : "+tag+"\n";
	}
}
