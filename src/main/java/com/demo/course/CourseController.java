package com.demo.course;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.course.Course;
import com.demo.topic.Topic;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.websocket.server.PathParam;

@RestController
public class CourseController {
	
		
	@Autowired
	private CourseService courseService;
	
	@Operation(summary="get all courses")
	@GetMapping("/topics/{id}/courses")
	public List<Course> getAllCourses(@PathVariable String id)
	{
		return courseService.getAllCourses(id);
	}
	
	
	@GetMapping("/topics/{id}/courses/{courseId}")
	public Course getCourseByName(@PathVariable String id,@PathVariable String courseId) {
		return courseService.getCourse(courseId);	
	}
	
	@PostMapping("/topics/{id}/courses")
	public ResponseEntity<Course> addCourse(@RequestBody Course body,@PathVariable String id) {
		
		body.setTopic(new Topic(id,"",""));
		courseService.addCourse(body);
		return new ResponseEntity(body,null,HttpStatus.CREATED);
	}
	
	
	@PutMapping("/topics/{id}/courses/{courseId}")
	public ResponseEntity<Course> updateCourse(@RequestBody Course body,@PathVariable String id,
			@PathVariable String courseId) {
		
		body.setTopic(new Topic(id,"",""));
		courseService.updateCourse(body);
		return new ResponseEntity(body,null,HttpStatus.NO_CONTENT);
	}
	
	@DeleteMapping("/topics/{id}/course/{courseId}")
	public void deleteCourse(@PathVariable String id,@PathVariable String courseId) {
		courseService.deleteCourse(courseId);
		
		return;
	}
	
}
