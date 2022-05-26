package step4_1;

import java.io.Serializable;
import java.util.ArrayList;

public class Movie implements Serializable {
	int serialNumber; // �떆?��?�뼹�꽆踰�
	String title; // �젣紐�
	String genre; // �옣?���?
	double score; // 蹂꾩?��
	String synopsis; // 以꾧굅由�?
	int filmRating; // �뿰�졊�젣�븳
	int scoreCount; // 蹂꾩?�� �룊洹좎?�� ?�꾩궛�?��
	int scoreSum; // 蹂꾩?�� �룊洹좎?�� ?�꾩궛�?��
	ArrayList<String> userCheck; // ?��?�� 기록?��

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

	public void setScore(double score) { // ��?��媛� 蹂꾩?�� 留ㅺ만�븣留?��?�� �샇?��?��빐��? ?�꾩�?
		if (score <= 5 && score >= 0) {
			scoreCount++;
			scoreSum += score;
			this.score = scoreSum / scoreCount;
		} else {
			System.out.println("    ──────────────────────────── Enter Score Between 0 and 5.");
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
			return "Rating is Out of Range";
		}
	}

	@Override
	public String toString() {
		return "Serial Number: " + serialNumber + "Title: " + title + ", Genre: " + genre + " , Score: " + score
				+ ", FilmRating: " + filmRating + "\n";
	}
}
