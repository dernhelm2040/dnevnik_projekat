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
import com.iktpreobuka.dnevnikProjekat.entities.RoleEntity;
import com.iktpreobuka.dnevnikProjekat.entities.StudentEntity;
import com.iktpreobuka.dnevnikProjekat.entities.SubjectEntity;
import com.iktpreobuka.dnevnikProjekat.entities.TeacherEntity;
import com.iktpreobuka.dnevnikProjekat.entities.UserEntity;
import com.iktpreobuka.dnevnikProjekat.repositories.ClassRepository;
import com.iktpreobuka.dnevnikProjekat.repositories.ParentRepository;
import com.iktpreobuka.dnevnikProjekat.repositories.RoleRepository;
import com.iktpreobuka.dnevnikProjekat.repositories.StudentRepository;
import com.iktpreobuka.dnevnikProjekat.repositories.SubjectRepository;
import com.iktpreobuka.dnevnikProjekat.repositories.TeacherRepository;
import com.iktpreobuka.dnevnikProjekat.repositories.UserRepository;



@RestController
@RequestMapping("/api/v1/users")
public class UserController {
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private RoleRepository roleRepo;
	
	@Autowired
	private ParentRepository parentRepo;
	
	@Autowired
	private StudentRepository studentRepo;
	
	@Autowired
	private ClassRepository classRepo;
	
	@Autowired
	private TeacherRepository teacherRepo;
	
	@Autowired
	private SubjectRepository subjectRepo;
	
	
	// Dodaj novog roditelja - testirano, radi 
	@RequestMapping(method = RequestMethod.POST, path = "/addParent")
	public ParentEntity addParent(@RequestParam String userName, @RequestParam String password,
			@RequestParam String firstName, @RequestParam String lastName,
			@RequestParam String email) {
		ParentEntity parent = new ParentEntity();
		parent.setUserName(userName);
		parent.setPassword(password);
		parent.setFirstName(firstName);
		parent.setLastName(lastName);
		parent.setEmail(email);
		return parentRepo.save(parent);		
	}
	
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
	
	// Dodaj novog nastavnika - testirano, radi 
	@RequestMapping(method = RequestMethod.POST, path = "/addTeacher")
	public TeacherEntity addTeacher(@RequestParam String userName, @RequestParam String password,
			@RequestParam String firstName, @RequestParam String lastName) {
		TeacherEntity teacher = new TeacherEntity();
		teacher.setUserName(userName);
		teacher.setPassword(password);
		teacher.setFirstName(firstName);
		teacher.setLastName(lastName);
		return teacherRepo.save(teacher);		
	}
	
	// Dodaj novi predmet - testirano, radi
	@RequestMapping(method = RequestMethod.POST, path = "/addSubject")
	public SubjectEntity addSubject(@RequestParam String subjectName, @RequestParam Integer hoursPerWeek) {
		SubjectEntity subject = new SubjectEntity();
		subject.setSubjectName(subjectName);
		subject.setHoursPerWeek(hoursPerWeek);
		return subjectRepo.save(subject);		
	}
	
	// Postavi rolu za korisnika - testirano, radi
	@RequestMapping(method = RequestMethod.PUT, path = "setRole/{id}")
	public UserEntity setRole(@PathVariable Integer id, @RequestParam Integer roleId) {
		UserEntity user = userRepo.findById(id).get();
		RoleEntity role = roleRepo.findById(roleId).get();
		user.setRole(role);
		return userRepo.save(user);
		
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
	
	// Nadji ucenike po ID roditelja - testirano, radi
	@RequestMapping(method = RequestMethod.GET, path = "/{parentId}/findByParent")
	public List<StudentEntity> findByParent(@PathVariable Integer parentId){
		return studentRepo.findByParentId(parentId);
	}
	
	// Prikazi sve ucenike - testirano, radi
	@RequestMapping(method = RequestMethod.GET, path = "/allStudents")
	public Iterable<StudentEntity> allStudents() {
		return (List<StudentEntity>) studentRepo.findAll();
	}
	
	// Prikazi sve nastavnike - testirano, radi
	@RequestMapping(method = RequestMethod.GET, path = "/allTeachers")
	public Iterable<TeacherEntity> allTeachers() {
		return (List<TeacherEntity>) teacherRepo.findAll();
	}
	
	// Prikazi sve roditelje - testirano, radi
	@RequestMapping(method = RequestMethod.GET, path = "/allParents")
	public Iterable<ParentEntity> allParents() {
		return (List<ParentEntity>) parentRepo.findAll();
	}
	
	
	
	
	
}
