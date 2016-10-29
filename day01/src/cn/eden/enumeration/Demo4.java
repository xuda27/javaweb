package cn.eden.enumeration;

import org.junit.Test;

/**
 * 测试枚举的常用方法
 * 
 * @author Eden
 *
 */
public class Demo4 {
	
	public void print(EGrade g) {
		String value = g.getValue();
		System.out.println(value);
	}

	@Test
	public void test() {
		System.out.println(EGrade.C.name());
		System.out.println(EGrade.C.ordinal());
		
		String str = "B";
		EGrade g = EGrade.valueOf(str);
		System.out.println(g);
		
		EGrade[] gs = EGrade.values();
		for(EGrade gg : gs) {
			System.out.println(gg);
		}
	}
}
