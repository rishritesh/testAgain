package com.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.spring.dao.StudentDao;
import com.spring.model.Student;

@org.springframework.stereotype.Controller
public class Controller {
	@Autowired
	private StudentDao studentdao;

	@RequestMapping("/")
	public String Home(Model m) {
		List<Student> student = studentdao.getStudent();
		m.addAttribute("student", student);
		// System.out.println(student);
		return "index";
	}

	// add product form
	@RequestMapping("/add")
	public String Add() {
		return "add_product_form";
	}

	//save to database
	@RequestMapping(value = "/handler", method = RequestMethod.POST)
	public String handler(@ModelAttribute Student student) {
		studentdao.createStudent(student);
		System.out.println(student);
		return "redirect:/";
	}

	//delete the student
	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable("id") int id) {
		studentdao.deleteStudent(id);
		return "redirect:/";
	}

	//update the student before get data from database and show to update page 
	@RequestMapping("/update/{id}")
	public String update(@PathVariable("id") int id, Model m) {
		Student student = studentdao.getStudent(id);
		m.addAttribute("student", student);
		return "update_form";
	}

	//update the form with handler and save the in database
	@RequestMapping(value = "/updateHandler", method = RequestMethod.POST)
	public String updateHandler(@ModelAttribute Student student) {
		studentdao.createStudent(student);
		return "redirect:/";
	}
}
