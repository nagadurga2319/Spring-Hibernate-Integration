package com.pack.controller;

import java.util.List;
import java.util.Random;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pack.model.Student;
import com.pack.service.StudentService;

@Controller
public class StudentController {
	private static Logger log = Logger.getLogger(StudentController.class);
	@Autowired
	private StudentService studentService;

	@RequestMapping(value = "/redirect", method = RequestMethod.GET)
	public String loadRegistrationForm(ModelMap map) {
		log.info("Request inside loadRegistration method");
		Student student = new Student();
		map.addAttribute("stdForm", student);
		return "studentReg";
	}

	@RequestMapping(value = "/saveStd", method = RequestMethod.POST)
	public String saveStudent(@Validated @ModelAttribute("stdForm") Student student, BindingResult result,
			ModelMap map) {
		String viewPage;
		if (result.hasErrors()) {
			log.info("validation errors occured");
			viewPage = "studentReg";
		} else {
			log.info("invoking saveStudent method");
			Random r = new Random();
			int stdid = r.nextInt(99999) + 10000;
			student.setId(stdid);
			studentService.saveStudent(student);
			List<Student> stdList = studentService.fetchStudent();
			map.addAttribute("studentList", stdList);
			viewPage = "success";
		}
		return viewPage;
	}

	@RequestMapping(value = "/fetchById/{stdId}")
	public String fetchStudentById(@PathVariable("stdId") Integer studId, ModelMap map) {
		log.info("Fetching student info by id");
		Student student = studentService.fetchStudentById(studId);
		map.addAttribute("editForm", student);
		return "StudentUpdate";
	}

	@RequestMapping(value = "/editStd", method = RequestMethod.POST)
	public String updateStudent(@Validated @ModelAttribute("editForm") Student student, BindingResult result,
			ModelMap map) {
		String editViewPage;
		if (result.hasErrors()) {
			log.info("validations error occur");
			editViewPage = "StudentUpdate";
		} else {
			log.info("invoking method to update data");
			studentService.updateStudent(student);
			List<Student> stdList = studentService.fetchStudent();
			map.addAttribute("studentList", stdList);
			editViewPage = "success";
		}
		return editViewPage;
	}

	@RequestMapping(value = "/delete/{stdId}")
	public String deleteStudent(@PathVariable("stdId") Integer sid, ModelMap map) {
		log.info("Deleting student based on student id");
		studentService.deleteStudent(sid);
		List<Student> stdList = studentService.fetchStudent();
		map.addAttribute("studentList", stdList);
		return "success";
	}
}
