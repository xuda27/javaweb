package cn.itcast.UI;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import cn.itcast.dao.StudentDao;
import cn.itcast.domain.Student;

public class Main {

	public static void main(String[] args) {
		
		try{
			System.out.println("����û���a��   �����û���b��  ɾ���û���c��");
			System.out.print("�������������:");
			
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String type = br.readLine();
			
			if("a".equals(type)){
				//ִ�����ѧ���Ĳ���
				System.out.print("������ѧ������:");
				String name = br.readLine();
				
				
				System.out.print("������ѧ��׼��֤��:");
				String examid = br.readLine();
				
				
				System.out.print("������ѧ�����֤��:");
				String idcard = br.readLine();
				
				
				System.out.print("������ѧ�����ڵ�:");
				String location = br.readLine();
				
				
				System.out.print("������ѧ���ɼ�:");
				double grade = 0;
				try{
					grade = Double.parseDouble(br.readLine());
				}catch (Exception e) {
					System.out.println("ֻ���������֣���");
					return;
				}
				Student student = new Student();
				student.setExamid(examid);
				student.setGrade(grade);
				student.setIdcard(idcard);
				student.setLocation(location);
				student.setName(name);
				
				StudentDao dao = new StudentDao();
				dao.add(student);
				System.out.println("��ӳɹ�����");
				
			}else if("b".equals(type)){
				
			}else if("c".equals(type)){
				
			}else{
				System.out.println("��ϵͳֻ֧��abc��������");
			}
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("����δ֪ԭ�򣬵��³��������");
		}
	}

}
