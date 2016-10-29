package cn.eden.reflect;

import java.util.List;

public class Person {
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
	
}
