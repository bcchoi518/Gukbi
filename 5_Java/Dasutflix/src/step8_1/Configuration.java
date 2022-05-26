package step8;

public class Configuration {
	private String nations;
	private boolean caption;
	private String quality;

	public Configuration() {
		this("Korea", false, "720p");
	}

	public Configuration(String nations, boolean caption, String quality) {
		this.nations = nations;
		this.caption = caption;
		this.quality = quality;
	}

	public String getNations() {
		return nations;
	}// end getNations

	public void setNations(String nations) {
		this.nations = nations;
	}// end setNations

	public boolean isCaption() {
		return caption;
	}// end isCaption

	public void setCaption(boolean caption) {
		this.caption = caption;
	}// end setCaption

	public String getQuality() {
		return quality;
	}// end getQuality

	public void setQuality(String quality) {
		this.quality = quality;
	}// end setQuality

	@Override
	public String toString() {
		return "[NATIONS: " + nations + "  CAPTION: " + (caption ? "ON" : "OFF") + "  QUALITY: " + quality+"]";
	}// end toString
}// end Settings
