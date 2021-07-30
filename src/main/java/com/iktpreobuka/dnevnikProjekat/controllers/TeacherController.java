package com.iktpreobuka.dnevnikProjekat.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.iktpreobuka.dnevnikProjekat.entities.GradeEntity;
import com.iktpreobuka.dnevnikProjekat.entities.GradeMonth;
import com.iktpreobuka.dnevnikProjekat.entities.StudentEntity;
import com.iktpreobuka.dnevnikProjekat.entities.SubjectEntity;
import com.iktpreobuka.dnevnikProjekat.entities.TeacherEntity;
import com.iktpreobuka.dnevnikProjekat.entities.TeacherSubject;
import com.iktpreobuka.dnevnikProjekat.entities.TeacherSubjectClassStudent;
import com.iktpreobuka.dnevnikProjekat.repositories.GradeRepository;
import com.iktpreobuka.dnevnikProjekat.repositories.SubjectRepository;
import com.iktpreobuka.dnevnikProjekat.repositories.TSRepository;
import com.iktpreobuka.dnevnikProjekat.repositories.TeacherRepository;
import com.iktpreobuka.dnevnikProjekat.security.Views;

@RestController
@RequestMapping("/api/v1/teachers")
public class TeacherController {
	
	
	@Autowired
	private TeacherRepository teacherRepo;
	
	@Autowired
	private SubjectRepository subjectRepo;
	
	@Autowired
	private TSRepository tsRepo;
	
	@Autowired
	private GradeRepository gradeRepo;
	
	
	
	
	// Dodaj novog nastavnika - testirano, radi 
		@JsonView(Views.Admin.class)
		@RequestMapping(method = RequestMethod.POST, path = "/addTeacher")
		public TeacherEntity addTeacher( @RequestParam String userName, @RequestParam String password,
				@RequestParam String firstName, @RequestParam String lastName) {
			TeacherEntity teacher = new TeacherEntity();
			teacher.setUserName(userName);
			teacher.setPassword(password);
			teacher.setFirstName(firstName);
			teacher.setLastName(lastName);
			return teacherRepo.save(teacher);		
		}
		
		
		// Prikazi sve nastavnike
		@RequestMapping(method = RequestMethod.GET, path = "/allTeachers")
		public Iterable<TeacherEntity> allTeachers() {
			return (List<TeacherEntity>) teacherRepo.findAll();
		}
		
		// Dodeli nastavniku predmet - testirano, radi
		@JsonView(Views.Admin.class)
		@RequestMapping(method = RequestMethod.PUT, path = "/{id}/addTeacherSubject")
		public TeacherSubject addTeacherSubject(@PathVariable Integer id, @RequestParam Integer subjectId) {
			TeacherSubject ts = new TeacherSubject();
			TeacherEntity teacher = teacherRepo.findById(id).get();
			SubjectEntity subject = subjectRepo.findById(subjectId).get();
			ts.setTeacher(teacher);
			ts.setSubject(subject);
			return tsRepo.save(ts);
			
		}
		
		// Oceni ucenika
		@RequestMapping(method = RequestMethod.POST, path = "/addStudentsGrade")
		public GradeEntity addStudentsGrade(@RequestParam Integer grade, @RequestParam GradeMonth month, 
				@RequestParam TeacherSubjectClassStudent tscsId) {
		GradeEntity grade1 = new GradeEntity();
		grade1.setGrade(grade);
		grade1.setGradeMonth(month);
		grade1.setStudentGrade(tscsId);
		return gradeRepo.save(grade1);
		
			
		}
		
	}
