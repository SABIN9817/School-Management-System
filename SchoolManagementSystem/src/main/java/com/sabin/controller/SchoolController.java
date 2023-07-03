package com.sabin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.sabin.model.Student;
import com.sabin.model.Teacher;
import com.sabin.repository.StudentRepository;
import com.sabin.repository.TeacherRepository;

@Controller
public class SchoolController {
	
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private TeacherRepository teacherRepository;
	
	@GetMapping
	public String getStudent(Model model) {
		
		List<Student> studentlist  = this.studentRepository.findAll();
		model.addAttribute("student", studentlist);
		return"index";
	}
	
	@GetMapping("/")
	public String getTeacher(Model model) {
		
		List<Teacher> teacherlist	=this.teacherRepository.findAll();
		model.addAttribute("teacher", teacherlist);
		return "index";
		
	}
	@GetMapping("/showNewStudentDetails")
	public String showNewStudentDetails(Model model) {
		Student student = new Student();
		model.addAttribute("student", student);
	
		return "student_details";
	}
	
	@GetMapping("listDetails")
	public String listDetails(Model model) {
		List<Student> student = this.studentRepository.findAll();
		model.addAttribute("student", student);
		return "views_details";
	}
	
	@GetMapping("/addStudents")
	public String addStudent(Model model) {
		Student student = new Student();
		model.addAttribute("student", student);
		return "new_students";
	}
	
	@PostMapping("/saveStudent")
	public String saveStudent(@ModelAttribute("student") Student student, Model model) {
		this.studentRepository.save(student);
		List<Student> students = this.studentRepository.findAll();
		model.addAttribute("student", students);
		return "views_details";
	}
	
	@GetMapping("/updateStudent/{id}")
	public String updateStudent(@PathVariable(value = "id")Integer id, Model model) {
	
	Student student = this.studentRepository.findById(id).get();
	model.addAttribute("student", student);
	return "update_student";
	}
	
	@GetMapping("/deleteStudent/{id}")
	public String deleteStudent(@PathVariable(value = "id") Integer id) {
	
			Student student = this.studentRepository.findById(id).get();
	this.studentRepository.delete(student);
	return"redirect:/listDetails";
	}
	
	@GetMapping("/showNewTeacherDetails")
	public String showNewTeacherDetails(Model model) {
		Teacher teacher = new Teacher();
		model.addAttribute("teacher", teacher);
		return "teacher_details";
	}
	
	@GetMapping("listtDetails")
	public String listtDetails(Model model) {
		List<Teacher> Teacher = this.teacherRepository.findAll();
		model.addAttribute("teacher", Teacher);
		return "viewt_details";
	}
	
	@GetMapping("/addTeachers")
	public String addTeachers(Model model) {
		Teacher teacher = new Teacher();
		model.addAttribute("teacher", teacher);
		return "new_teachers";
	}
	
	@PostMapping("/saveTeacher")
	public String saveTeacher(@ModelAttribute("teacher") Teacher teacher, Model model) {	
		this.teacherRepository.save(teacher);
		List<Teacher> teachers = this.teacherRepository.findAll();
		model.addAttribute("teacher", teachers);
		return "viewt_details";
	}
	
	@GetMapping("/updateTeacher/{id}")
	public String updateTeacher(@PathVariable(value = "id")Integer id, Model model){
		Teacher teacher=this.teacherRepository.findById(id).get();
		model.addAttribute("teacher", teacher);
		return "update_teacher";
	}
	
	@GetMapping("/deleteTeacher/{id}")
	public String deleteTeacher(@PathVariable(value = "id") Integer id) {
	
			Teacher teacher = this.teacherRepository.findById(id).get();
	this.teacherRepository.delete(teacher);
	return"redirect:/listtDetails";
	}
	
	
}
