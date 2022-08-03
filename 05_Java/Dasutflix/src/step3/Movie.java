package step3;

import java.io.Serializable;
import java.util.ArrayList;

public class Movie implements Serializable {
	int serialNumber; // �떆由ъ뼹�꽆踰�
	String title; // �젣紐�
	String genre; // �옣瑜�
	double score; // 蹂꾩젏
	String synopsis; // 以꾧굅由�
	int filmRating; // �뿰�졊�젣�븳
	int scoreCount; // 蹂꾩젏 �룊洹좎튂 怨꾩궛�슜
	int scoreSum; // 蹂꾩젏 �룊洹좎튂 怨꾩궛�슜
	ArrayList<String> userCheck; // 평점 기록용

	Movie() {
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) { // �쑀��媛� 蹂꾩젏 留ㅺ만�븣留덈떎 �샇異쒗빐�꽌 怨꾩궛
		if (score <= 5 && score >= 0) {
			scoreCount++;
			scoreSum += score;
			this.score = scoreSum / scoreCount;
		} else {
			System.out.println("0에서 5사이의 값을 입력해주세요.");
		}
	}

	public String getSynopsis() {
		return synopsis;
	}

	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}

	public int getFilmRating() {
		return filmRating;
	}

	public void setFilmRating(int filmRating) {
		this.filmRating = filmRating;
	}

	public int getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(int serialNumber) {
		this.serialNumber = serialNumber;
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

	public String getStarScore() {
		if (score >= 0 && score <= 0.5) {
			return "☆";
		}
		if (score >= 0.5 && score <= 1) {
			return "★";
		}
		if (score >= 1 && score <= 1.5) {
			return "★☆";
		}
		if (score >= 1.5 && score <= 2) {
			return "★★";
		}
		if (score >= 2 && score <= 2.5) {
			return "★★☆";
		}
		if (score >= 2.5 && score <= 3) {
			return "★★★";
		}
		if (score >= 3 && score <= 3.5) {
			return "★★★☆";
		}
		if (score >= 3.5 && score <= 4) {
			return "★★★★";
		}
		if (score >= 4 && score <= 4.5) {
			return "★★★★☆";
		}
		if (score >= 4.5 && score <= 5) {
			return "★★★★★";
		} else {
			return "별점값이 범위에서 벗어남";
		}
	}

	@Override
	public String toString() {
		return "�떆由ъ뼹�꽆踰�: " + serialNumber + "\n�젣紐�: " + title + ", �옣瑜�: " + genre + " , 蹂꾩젏: " + score
				+ ", �떆泥��뿰�졊: " + filmRating + "\n";
	}
}
