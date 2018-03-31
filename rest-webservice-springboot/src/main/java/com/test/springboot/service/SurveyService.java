package com.test.springboot.service;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.slf4j.Logger;
import org.springframework.stereotype.Component;

import com.test.springboot.model.Question;
import com.test.springboot.model.Survey;


@Component
public class SurveyService {
	private static List<Survey> surveys = new ArrayList();
	static {
		Question question1 = new Question("Question1",
				"Largest Country in the World", "Russia", Arrays.asList(
						"India", "Russia", "United States", "China"));
		Question question2 = new Question("Question2",
				"Most Populus Country in the World", "China", Arrays.asList(
						"India", "Russia", "United States", "China"));
		Question question3 = new Question("Question3",
				"Highest GDP in the World", "United States", Arrays.asList(
						"India", "Russia", "United States", "China"));
		Question question4 = new Question("Question4",
				"Second largest english speaking country", "India", Arrays
						.asList("India", "Russia", "United States", "China"));

		List<Question> questions = new ArrayList(Arrays.asList(question1,
				question2, question3, question4));

		Survey survey = new Survey("Survey1", "My Favorite Survey",
				"Description of the Survey", questions);

		surveys.add(survey);
	}

	public List<Survey> retrieveAllSurveys() {
		return surveys;
	}

	public Survey retrieveSurvey(String surveyId) {
		for (Survey survey : surveys) {
			if (survey.getId().equals(surveyId)) {
				return survey;
			}
		}
		return null;
	}

	public List<Question> retrieveQuestions(String surveyId) {
		Survey survey = retrieveSurvey(surveyId);

		if (survey == null) {
			return null;
		}

		return survey.getQuestions();
	}

	

	public Question retrieveQuestion(String surveyId, String questionId) {
		//System.out.println("retrieveQuestion(String surveyId, String questionId) ");
		Survey survey = retrieveSurvey(surveyId);
		
       // System.out.println("Survey :" + survey);
		if (survey == null) {
			return null;
		}

		for (Question question : survey.getQuestions()) {
			if (question.getId().equals(questionId)) {
				  // System.out.println("question :" + question);
				return question;
			}
		}

		return null;
	}

	private SecureRandom random = new SecureRandom();

	public void addQuestion(String surveyId, Question question) {
		Survey survey = retrieveSurvey(surveyId);

		if (survey == null || !(survey.getId().equals(surveyId))) {
			survey = retrieveSurvey("Survey1");
		}
		
			survey.getQuestions().add(question);
	
		
	}
	
	public Boolean exitQuestion(String surveyId, String question, Logger logger) {
		Survey survey = retrieveSurvey(surveyId);
		String que;
		List l=new ArrayList();
		if (survey != null) {
			
			System.out.println("survey.getQuestions().iterator() " + survey.getQuestions());
			logger.info("Question list q = " + survey.getQuestions() );
			List<Question> ql=survey.getQuestions();
			Iterator it=ql.iterator();
			while(it.hasNext()) {
				String id=((Question)it.next()).getId();
				l.add(id);
			}
			logger.info("Question list ID = " + l);
			logger.info("Question is alreadly exit  :" + l.contains(question));
			if(l.contains(question)) {
				return false;
			}
	}
	 return true;	
	}
}
	
