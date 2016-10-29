package cn.eden.enumeration;
/**
 * 枚举原型
 * @author Eden
 *
 */
public class Demo1 {
	public void print(Grade g) {
		
	}
	public void test() {
		print(Grade.A);
	}
}

class Grade {
	private Grade() {}
	public static final Grade A = new Grade();
	public static final Grade B = new Grade();
	public static final Grade C = new Grade();
	public static final Grade D = new Grade();
	public static final Grade E = new Grade();
}