package cn.eden.dao;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import cn.eden.domain.Student;
import cn.eden.utils.XmlUtils;

public class StudentDao {
	public void add(Student student) {
		try {
			Document document = XmlUtils.getDocument();
			Element student_tag = document.createElement("student");
			student_tag.setAttribute("idcard", student.getIdCard() + "");
			student_tag.setAttribute("examId", student.getExamId() + "");
			
			Element name_tag = document.createElement("name");
			Element location_tag = document.createElement("location");
			Element grade_tag = document.createElement("grade");
			
			name_tag.setTextContent(student.getName());
			location_tag.setTextContent(student.getLocation());
			grade_tag.setTextContent(student.getGrade() + "");
			
			student_tag.appendChild(name_tag);
			student_tag.appendChild(location_tag);
			student_tag.appendChild(grade_tag);
			
			document.getElementsByTagName("exam").item(0).appendChild(student_tag);
			XmlUtils.write2Xml(document);
		} catch (Exception e) {
			throw new RuntimeException(e); // checked  
		}
	}
	
	public void delete(String name) {
		
	}
	
	public Student find(String examId) {
		
		return null;
	}
}
