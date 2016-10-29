package cn.eden.reflect;

import java.io.InputStream;
import java.util.List;

public class Person {
	private String name;
	private String password;
	
	public Person() {
		System.out.println("空构造");
	}
	public Person(String arg) {
		System.out.println("构造 1个arg");
	}
	public Person(String arg, String arg1) {
		System.out.println("构造 2个arg");
	}
	private Person(List list) {
		System.out.println("私有构造");
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getPassword() {
		System.out.println("调用getPassword()方法");
		return password;
	}
	public void setPassword(String password) {
		System.out.println("调用setPassword()方法");
		this.password = password;
	}
	
	public void a() {
		System.out.println("a,无arg");
	}
	
	public void a(String name, String password) {
		System.out.println("a,两个arg：" + name + "--" + password);
	}
	
	public Class[] a(String name, String[] password) {
		System.out.println("返回值的方法");
		return new Class[] {String.class};
	}
	
	private void a(InputStream in) {
		System.out.println("private方法，输出参数信息：" +in);
	}
	
	public static void a(int num) {
		System.out.println("静态方法，参数信息：" + num);
	}
}
