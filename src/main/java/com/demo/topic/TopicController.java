package com.demo.topic;

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

import com.demo.topic.Topic;
import com.demo.topic.TopicService;

import jakarta.websocket.server.PathParam;

@RestController
public class TopicController {
	
	
	@Autowired
	private TopicService topicService;
	
	@GetMapping("/topics")
	public List<Topic> getAllTopics()
	{
		return topicService.getAllTopics();
	}
	
	
	@GetMapping("/topic/{name}")
	public Topic getTopicByName(@PathVariable String name) {
		return topicService.getTopic(name);	
	}
	
	@PostMapping("/topics")
	public ResponseEntity<Topic> addTopic(@RequestBody Topic body) {
		System.out.println(body.getDescription());
		topicService.addTopic(body);
		return new ResponseEntity(body,null,HttpStatus.CREATED);
	}
	
	
	@PutMapping("/topics/{id}")
	public ResponseEntity<Topic> updateTopic(@RequestBody Topic body,@PathVariable String id) {
		System.out.println(body.getDescription());
		topicService.updateTopic(body,id);
		return new ResponseEntity(body,null,HttpStatus.NO_CONTENT);
	}
	
	@DeleteMapping("/topic/{id}")
	public void deleteTopic(@PathVariable String id) {
		topicService.deleteTopic(id);
		
		return;
	}
	
}
