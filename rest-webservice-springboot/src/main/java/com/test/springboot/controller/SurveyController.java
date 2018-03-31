package com.test.springboot.controller;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.springboot.model.Question;
import com.test.springboot.service.SurveyService;


@RestController
class SurveyController {
	@Autowired
	private SurveyService surveyService;

	public static final Logger logger = LoggerFactory.getLogger(SurveyController.class);
	
	@GetMapping("/surveys/{surveyId}/questions")
	
	public List<Question> retrieveQuestions(@PathVariable String surveyId) {
		return surveyService.retrieveQuestions(surveyId);
	}
	
		@GetMapping("/surveys/{surveyId}/questions/{questionId}")
		public Question retrieveDetailsForQuestion(@PathVariable String surveyId,
				@PathVariable String questionId) {
			//System.out.println("{questionId} : =" + questionId + "{surveyId} : " + surveyId);
			return surveyService.retrieveQuestion(surveyId, questionId);
		}
       
		@PostMapping("/surveys/{surveyId}/questions/{questionId}")
		public Question addForQuestion(@PathVariable String surveyId,
				@PathVariable String questionId) {
			logger.info("POST Method");
			
			logger.info("surveyId " + surveyId);
			logger.info("questionId " + questionId);
		if(surveyService.exitQuestion(surveyId, questionId, logger)) {
			logger.info("adding new questions " + questionId);
			Question question = new Question(questionId,
					"Third largest english speaking country", "Russia", Arrays
							.asList("India", "Russia", "United States", "China"));
			surveyService.addQuestion(surveyId, question);
			
		}else {
			logger.error("Question are areadly exit in Survery1" + questionId);
		}
			return surveyService.retrieveQuestion(surveyId, questionId);
		}
}