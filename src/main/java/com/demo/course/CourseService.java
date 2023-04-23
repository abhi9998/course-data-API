package com.demo.course;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.topic.Topic;

@Service
public class CourseService {
	
	@Autowired
	private CourseRepository repository;
	
//	private List<Course> list = new ArrayList<>(Arrays.asList(
//			new Course("spring","Spring","Descritipno"),
//			new Course("spring2","Spring2","Descritipno2"),
//			new Course("spring3","Spring3","Descritipno3")
//			));
	
	public List<Course> getAllCourses(String id){
		
		return repository.findByTopicId(id);
	
	}
	
	public Course getCourse(String name) {
		System.out.println(name);
//		return list.stream().filter(e->e.getId().equals(name)).findFirst().get();
		return repository.findById(name).get();
	}	
	
	public void addCourse(Course course) {
		
		Course t= repository.save(course);
		
	}
	
	public void updateCourse(Course course) {
		
//		Iterator<Course> itr = list.iterator();
//		
//		while(itr.hasNext()) {
//			Course t= itr.next();
//			if(id==Course.getId()) {
//				itr.remove();
//				list.add(Course);
//				return;
//			}
//		}
		
		repository.save(course);
	}
	
	public void deleteCourse(String courseId) {
		
//		Iterator<Course> itr = list.iterator();
//		
//		while(itr.hasNext()) {
//			Course t= itr.next();
//			if(id.equals(t.getId())) {
//				itr.remove();
//				return;
//			}
//		}
		
		repository.deleteById(courseId);
	}
}
