package com.iktpreobuka.dnevnikProjekat.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.iktpreobuka.dnevnikProjekat.entities.ClassEntity;
import com.iktpreobuka.dnevnikProjekat.entities.ParentEntity;
import com.iktpreobuka.dnevnikProjekat.entities.StudentEntity;
import com.iktpreobuka.dnevnikProjekat.entities.TeacherSubject;
import com.iktpreobuka.dnevnikProjekat.entities.TeacherSubjectClass;
import com.iktpreobuka.dnevnikProjekat.entities.TeacherSubjectClassStudent;
import com.iktpreobuka.dnevnikProjekat.repositories.ClassRepository;
import com.iktpreobuka.dnevnikProjekat.repositories.ParentRepository;
import com.iktpreobuka.dnevnikProjekat.repositories.StudentRepository;
import com.iktpreobuka.dnevnikProjekat.repositories.TSCRepository;
import com.iktpreobuka.dnevnikProjekat.repositories.TSCSRepository;

@RestController
@RequestMapping("/api/v1/students")
public class StudentController {
	
	@Autowired
	private StudentRepository studentRepo;
	
	@Autowired
	private ParentRepository parentRepo;
	
	@Autowired
	private ClassRepository classRepo;
	
	@Autowired
	private TSCRepository tscRepo;
	
	@Autowired
	private TSCSRepository tscsRepo;
	
	
	
	// Dodaj novog ucenika - testirano, radi 
		@RequestMapping(method = RequestMethod.POST, path = "/addStudent")
		public StudentEntity addParent(@RequestParam String userName, @RequestParam String password,
				@RequestParam String firstName, @RequestParam String lastName) {
			StudentEntity student = new StudentEntity();
			student.setUserName(userName);
			student.setPassword(password);
			student.setFirstName(firstName);
			student.setLastName(lastName);
			return studentRepo.save(student);		
		}
		
		// Postavi roditelja za ucenika - testirano, radi
				@RequestMapping(method = RequestMethod.PUT, path = "addStudentsParent/{id}")
				public StudentEntity addStudentsParent(@PathVariable Integer id, @RequestParam Integer parentId) {
					StudentEntity student = studentRepo.findById(id).get();
					ParentEntity parent = parentRepo.findById(parentId).get();
					student.setParent(parent);
					return studentRepo.save(student);
				}
				
		
		
		// Postavi odeljenje za ucenika - testirano, radi
		@RequestMapping(method = RequestMethod.PUT, path = "/{id}/addStudentsClass/{classId}")
		public StudentEntity addStudentsClass(@PathVariable Integer id, @PathVariable Integer classId) {
			StudentEntity student = studentRepo.findById(id).get();
			ClassEntity classroom = classRepo.findById(classId).get();
			student.setClassroom(classroom);
			return studentRepo.save(student);
		}
		
		
		// Prikazi sve ucenike - testirano, radi
		@RequestMapping(method = RequestMethod.GET, path = "/allStudents")
		public Iterable<StudentEntity> allStudents() {
			return (List<StudentEntity>) studentRepo.findAll();
		}
		
		// Povezi ucenika sa odeljenjem u kojem predaje nastavnik
		@RequestMapping(method = RequestMethod.PUT, path = "/{id}/addStudentToTSC")
		public TeacherSubjectClassStudent addStudentToTSC(@PathVariable Integer id, @RequestParam Integer tscId) {
			TeacherSubjectClassStudent tscStudent = new TeacherSubjectClassStudent();
			StudentEntity student = studentRepo.findById(id).get();
			TeacherSubjectClass tsc = tscRepo.findById(tscId).get();
			tscStudent.setStudentClass(student);
			tscStudent.setTeacherSubjectClass(tsc);
			return tscsRepo.save(tscStudent);
			
		}
		
		
	}
