package chap03;

public class Book {

	private String title;
	private String author;
	private String publisher;
	private String year;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public void showAll() {
		System.out.println("title : " + title);
		System.out.println("author : " + author);
		System.out.println("publisher : " + publisher);
		System.out.println("year : " + year);
		System.out.println();
	}
}// end Book
