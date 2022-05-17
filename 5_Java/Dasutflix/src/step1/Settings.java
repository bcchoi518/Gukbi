package step1;

public class Settings {
	private String nations;
	private boolean caption;
	private String quality;

	public Settings() {
	}

	public Settings(String nations, boolean caption, String quality) {
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
		return "nations: " + nations + ", caption: " + caption + "quality: " + quality;
	}// end toString
}// end Settings
