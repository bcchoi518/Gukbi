package step2;

import java.io.Serializable;

public class Movie implements Serializable {
	int serialNumber; // 시리얼넘버
	String title; // 제목
	String genre; // 장르
	double score; // 별점
	String synopsis; // 줄거리
	int filmRating; // 연령제한
	int scoreCount; // 별점 평균치 계산용
	int scoreSum; // 별점 평균치 계산용

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

	public void setScore(double score) { // 유저가 별점 매길때마다 호출해서 계산
		scoreCount++;
		scoreSum += score;
		this.score = scoreSum / (scoreCount * 5);
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

	@Override
	public String toString() {
		return "시리얼넘버: " + serialNumber + "\n제목: " + title + ", 장르: " + genre + " , 별점: " + score + ", 시청연령: "
				+ filmRating + "\n";
	}
}
