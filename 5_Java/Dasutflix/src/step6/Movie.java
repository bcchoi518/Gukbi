package step6;

import java.io.Serializable;
import java.util.ArrayList;

public class Movie implements Serializable {
	int serialNumber; // ï¿½ë–†?”±?Šë¼¹ï¿½ê½†è¸°ï¿½
	String title; // ï¿½ì £ï§ï¿½
	String genre; // ï¿½ì˜£?‘œï¿?
	double score; // è¹‚ê¾©? 
	String synopsis; // ä»¥ê¾§êµ…ç”±ï¿?
	int filmRating; // ï¿½ë¿°ï¿½ì¡Šï¿½ì £ï¿½ë¸³
	int scoreCount; // è¹‚ê¾©?  ï¿½ë£Šæ´¹ì¢?Š‚ ?¨ê¾©ê¶›ï¿½?Šœ
	int scoreSum; // è¹‚ê¾©?  ï¿½ë£Šæ´¹ì¢?Š‚ ?¨ê¾©ê¶›ï¿½?Šœ
	ArrayList<String> userCheck; // ?‰?  ê¸°ë¡?š©

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

	public void setScore(double score) { // ï¿½ì?ï¿½ï¿½åª›ï¿½ è¹‚ê¾©?  ï§ã…ºë§Œï¿½ë¸£ï§?ˆ?– ï¿½ìƒ‡?•°?’—ë¹ï¿½ê½? ?¨ê¾©ê¶?
		if (score <= 5 && score >= 0) {
			scoreCount++;
			scoreSum += score;
			this.score = scoreSum / scoreCount;
		} else {
			System.out.println("0?—?„œ 5?‚¬?´?˜ ê°’ì„ ?…? ¥?•´ì£¼ì„¸?š”.");
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
			return "¡Ù";
		}
		if (score > 0.5 && score <= 1) {
			return "¡Ú";
		}
		if (score > 1 && score <= 1.5) {
			return "¡Ú¡Ù";
		}
		if (score > 1.5 && score <= 2) {
			return "¡Ú¡Ú";
		}
		if (score > 2 && score <= 2.5) {
			return "¡Ú¡Ú¡Ù";
		}
		if (score > 2.5 && score <= 3) {
			return "¡Ú¡Ú¡Ú";
		}
		if (score > 3 && score <= 3.5) {
			return "¡Ú¡Ú¡Ú¡Ù";
		}
		if (score > 3.5 && score <= 4) {
			return "¡Ú¡Ú¡Ú¡Ú";
		}
		if (score > 4 && score <= 4.5) {
			return "¡Ú¡Ú¡Ú¡Ú¡Ù";
		}
		if (score > 4.5 && score <= 5) {
			return "¡Ú¡Ú¡Ú¡Ú¡Ú";
		} else {
			return "º°Á¡°ªÀÌ ¹üÀ§¿¡¼­ ¹ş¾î³²";
		}
	}

	@Override
	public String toString() {
		return "ï¿½ë–†?”±?Šë¼¹ï¿½ê½†è¸°ï¿½: " + serialNumber + "\nï¿½ì £ï§ï¿½: " + title + ", ï¿½ì˜£?‘œï¿?: " + genre + " , è¹‚ê¾©? : " + score
				+ ", ï¿½ë–†ï§£ï¿½ï¿½ë¿°ï¿½ì¡Š: " + filmRating + "\n";
	}
}
