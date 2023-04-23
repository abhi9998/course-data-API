package com.demo.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {
	
	@Autowired
	private TopicRepository repository;
	
//	private List<Topic> list = new ArrayList<>(Arrays.asList(
//			new Topic("spring","Spring","Descritipno"),
//			new Topic("spring2","Spring2","Descritipno2"),
//			new Topic("spring3","Spring3","Descritipno3")
//			));
	
	public List<Topic> getAllTopics(){
		
		List<Topic> response = new ArrayList<>();
		repository.findAll().forEach(e->response.add(e));	
		return response;
	}
	
	public Topic getTopic(String name) {
		System.out.println(name);
//		return list.stream().filter(e->e.getId().equals(name)).findFirst().get();
		return repository.findById(name).get();
	}	
	
	public void addTopic(Topic topic) {
		
		Topic t= repository.save(topic);
		
	}
	
	public void updateTopic(Topic topic,String id) {
		
//		Iterator<Topic> itr = list.iterator();
//		
//		while(itr.hasNext()) {
//			Topic t= itr.next();
//			if(id==topic.getId()) {
//				itr.remove();
//				list.add(topic);
//				return;
//			}
//		}
		
		repository.save(topic);
	}
	
	public void deleteTopic(String id) {
		
//		Iterator<Topic> itr = list.iterator();
//		
//		while(itr.hasNext()) {
//			Topic t= itr.next();
//			if(id.equals(t.getId())) {
//				itr.remove();
//				return;
//			}
//		}
		
		repository.deleteById(id);
	}
}
