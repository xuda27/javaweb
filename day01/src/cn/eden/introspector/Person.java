package cn.eden.introspector;

import java.util.Date;

/**
 * Person类的javabean 
 * 一个bean的属性是由get方法决定
 * 
 * @author Eden
 *
 */
public class Person {
	private String name;
	private String password;
	private int age;
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Integer getId() {
		return null;
	}
}
