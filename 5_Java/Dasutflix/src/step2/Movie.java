package step2;

import java.io.Serializable;

public class Movie implements Serializable {
  int serialNumber; // 시리얼넘버
  String title; // 제목
  String category; // 장르
  double score; // 별점
  String synopsis; // 줄거리
  String tag; // 태그
  String contentsRating; // 관람등급
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

  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
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
    return "시리얼넘버 : " + serialNumber + "\n제목 : " + title + ", 장르 : " + category + " , 별점 : " + score
        + ", 관람등급 : " + contentsRating + ", 태그 : " + tag + "\n";
  }
}
