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
import com.iktpreobuka.dnevnikProjekat.entities.StudentEntity;
import com.iktpreobuka.dnevnikProjekat.entities.TeacherSubject;
import com.iktpreobuka.dnevnikProjekat.entities.TeacherSubjectClass;
import com.iktpreobuka.dnevnikProjekat.repositories.ClassRepository;
import com.iktpreobuka.dnevnikProjekat.repositories.StudentRepository;
import com.iktpreobuka.dnevnikProjekat.repositories.TSCRepository;
import com.iktpreobuka.dnevnikProjekat.repositories.TSRepository;
import com.iktpreobuka.dnevnikProjekat.services.StudentDAO;


@RestController
@RequestMapping("/api/v1/classes")
public class ClassController {
	
	@Autowired
	private ClassRepository classRepo; 
	
	@Autowired
	private StudentRepository studentRepo;
	
	@Autowired
	private TSRepository tsRepo;
	
	@Autowired
	private TSCRepository tscRepo;
	
	@Autowired
	private StudentDAO studentService;
	
	// Dodaj odeljenje - testirano, radi
	@RequestMapping(method = RequestMethod.POST)
	public ClassEntity createClass(@RequestParam String className) {
		ClassEntity classroom = new ClassEntity();
		classroom.setClassName(className);
		return classRepo.save(classroom);
		}

	// Dodeli nastavnika koji predaje predmet odeljenju
	@RequestMapping(method = RequestMethod.PUT, path = "/{id}/addTStoClass")
	public TeacherSubjectClass addTStoClass(@PathVariable Integer id, @RequestParam Integer tsId) {
		TeacherSubjectClass tsClass = new TeacherSubjectClass();
		ClassEntity classroom = classRepo.findById(id).get();
		TeacherSubject ts = tsRepo.findById(tsId).get();
		tsClass.setTeacherSubject(ts);
		tsClass.setClassNo(classroom);
		return tscRepo.save(tsClass);
		
	}
	
	// Prikazi sve ucenike u odeljenju po IDu odeljenja - ne radi
	@RequestMapping(method = RequestMethod.GET, path = "/findByClassroom")
	public List<StudentEntity> findByClassroom(@RequestParam String clName){
		return studentService.findByClassroom(clName);
	}
	
}
