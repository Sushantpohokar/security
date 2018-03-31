package io.java.springbootquickstart.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import io.java.springbootquickstart.model.Topic;

@RestController
public class TopicController {
	
	@RequestMapping("/topics")
	
	public List<Topic> getAllTopics()
	{
		return Arrays.asList(
				new Topic("Spring","Spring framework", "Spring framework description"),
				new Topic("Java","core Java", "core java description"),
				new Topic(".Net","C#", ".Net description")
				);
	}

}
