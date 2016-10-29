package cn.eden.enumeration;

import org.junit.Test;

/**
 * 带抽象方法的枚举
 * 
 * @author Eden
 *
 */
public class Demo3 {
	
	public void print(EnGrade g) {
		String value = g.localValue();
		System.out.println(value);
	}

	@Test
	public void test() {
		print(EnGrade.A);
	}
}
/**
 * 如何定义枚举的构造方法、方法和字段，去封装更多的信息
 * 带抽象方法时，枚举需要定义时需要重写
 * @author Eden
 *
 */
enum EnGrade { // 定义class 优 良 一般 及格 不及格
	A("90-100") {
		public String localValue() {
			return "优";
		}
	}
	, B("80-89") {
		public String localValue() {
			return "良";
		}
	}, C("70-79") {
		public String localValue() {
			return "一般";
		}
	}, D("60-69") {
		public String localValue() {
			return "及格";
		}
	}, E("0-59") {
		public String localValue() {
			return "不及格";
		}
	}; // Object
																// 相当于new出了5个对象

	private String value; // 封装每个对象对应的分数

	private EnGrade(String value) {
		this.value = value;
	}

	public String getValue() {
		return this.value;
	}

	public abstract String localValue();
}

/**
 * 相当于使用单例设计定义出了一个类
 * @author Eden
 *
 */
enum A {
	A;
}