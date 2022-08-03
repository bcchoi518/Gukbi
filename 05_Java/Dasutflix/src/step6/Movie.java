package step6;

import java.io.Serializable;
import java.util.ArrayList;

public class Movie implements Serializable {
	int serialNumber;
	String title;
	String genre;
	double score;
	String synopsis;
	int filmRating;
	int scoreCount;
	int scoreSum;
	ArrayList<String> userCheck;

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

	public void setGenre(int tmp) {
		this.genre = MenuViewer.genreArr[tmp - 1];
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
			return "    ──────────────────────────── Rating is Out of Range";
		}
	}

	@Override
	public String toString() {
		return "    ──────────────────────────── "+"[SERIAL NUMBER: " + serialNumber + "  TITLE: " + title + "  GENRE: " + genre + "  SCORE: " + score
				+ "  FILMRATING: " + filmRating + "]\n";
	}
}
