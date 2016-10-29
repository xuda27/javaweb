package cn.eden.enumeration;

import org.junit.Test;

/**
 * 枚举
 * 
 * @author Eden
 *
 */
public class Demo2 {
	
	public void print(EGrade g) {
		String value = g.getValue();
		System.out.println(value);
	}

	@Test
	public void test() {
		print(EGrade.A);
	}
}
/**
 * 如何定义枚举的构造方法、方法和字段，去封装更多的信息
 * @author Eden
 *
 */
enum EGrade { // 定义class
	A("90-100"), B("80-89"), C("70-79"), D("60-69"), E("0-59"); // Object
																// 相当于new出了5个对象

	private String value; // 封装每个对象对应的分数

	private EGrade(String value) {
		this.value = value;
	}

	public String getValue() {
		return this.value;
	}

}