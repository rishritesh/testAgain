package com.spring.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.spring.model.Student;




@Component
public class StudentDao {
	
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	@Transactional
	public void createStudent(Student student) {
		this.hibernateTemplate.saveOrUpdate(student);
	}
	
	
	//get all product
	@Transactional
	public List<Student> getStudent(){
		List<Student> student = this.hibernateTemplate.loadAll(Student.class);
		return student;
	}
	
	//delete product
	@Transactional
	public  void deleteStudent(int Id) {
		Student s=(Student) this.hibernateTemplate.get(Student.class, Id);
		this.hibernateTemplate.delete(s);
		
	}
	
	@Transactional
	public Student getStudent(int Id) {
	
		return this.hibernateTemplate.get(Student.class, Id);
	}

	 
}
