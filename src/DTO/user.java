package DTO;

public class user {
	private String id;
	private String name;
	private int age;
	private String address;
	private String email;
	private String password;
	public void setEmail(String email) {
		this.email = email;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setID(String id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public void setAddress(String addr) {
		this.address = addr;
	}
	public void setUserData(String id, String name, int age, String addr) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.address = addr;
	}
}
