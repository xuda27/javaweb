package cn.eden.UI;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import cn.eden.dao.StudentDao;
import cn.eden.domain.Student;

public class Main {

	public static void main(String[] args) {

		try {
			System.out.println("添加用户（a）   查找用户（b）  删除用户（c）");
			System.out.print("请输入操作类型:");

			BufferedReader br = new BufferedReader(new InputStreamReader(
					System.in));
			String type = br.readLine();

			if ("a".equals(type)) {
				// 执行添加学生的操作
				System.out.print("请输入学生姓名:");
				String name = br.readLine();

				System.out.print("请输入学生准考证号:");
				String examid = br.readLine();

				System.out.print("请输入学生身份证号:");
				String idcard = br.readLine();

				System.out.print("请输入学生所在地:");
				String location = br.readLine();

				System.out.print("请输入学生成绩:");
				Integer grade = 0;
				try {
					grade = Integer.parseInt(br.readLine());
				} catch (Exception e) {
					System.out.println("只能输入数字！！");
					return;
				}
				Student student = new Student();
				student.setExamId(Integer.parseInt(examid));
				student.setGrade(grade);
				student.setIdCard(Integer.parseInt(idcard));
				student.setLocation(location);
				student.setName(name);

				StudentDao dao = new StudentDao();
				dao.add(student);
				System.out.println("添加成功！！");

			} else if ("b".equals(type)) {

			} else if ("c".equals(type)) {

			} else {
				System.out.println("本系统只支持abc操作！！");
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("由于未知原因，导致程序出错！！");
		}
	}

}
