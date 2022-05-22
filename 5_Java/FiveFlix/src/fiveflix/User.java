package fiveflix;

public class User {
	String name;
	String age;
	String grade;
	String id;
	String password;
	
	User(){
		this("taemin", "30", "pro", "tamin123", "0525");
	}
	
	public User(String name,String age,String grade,String id, String password) {
		this.name = name;
		this.age = age;
		this.grade = grade;
		this.id = id;
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
