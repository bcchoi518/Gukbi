package step2;

import java.io.Serializable;
import java.util.ArrayList;

public class Movie implements Serializable {
	int serialNumber; // 시리얼넘버
	String title; // 제목
	String genre; // 장르
	double score; // 별점
	String synopsis; // 줄거리
	int filmRating; // 연령제한
	int scoreCount; // 별점 평균치 계산용
	int scoreSum; // 별점 평균치 계산용
	ArrayList<String> userCheck;

	Movie() {
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		if (score <= 5 && score >= 0) {
			scoreCount++;
			scoreSum += score;
			this.score = scoreSum / scoreCount;
		} else {
			System.out.println("Please enter a value between 0 and 5");
		}
	}

	public String getSynopsis() {
		return synopsis;
	}

	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
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

	public double getScoreSum() {
		return scoreSum;
	}

	public void setScoreSum(int scoreSum) {
		this.scoreSum = scoreSum;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public int getFilmRating() {
		return filmRating;
	}

	public void setFilmRating(int filmRating) {
		this.filmRating = filmRating;
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
			return "Rating out of range";
		}
	}

	@Override
	public String toString() {
		return "SerialNumber: " + serialNumber + "\nTitle: " + title + ", Genre: " + genre + " , Rating: " + score
				+ ", FilmRating: " + filmRating + "\n";
	}
}
