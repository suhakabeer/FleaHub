package com.canddella.service;

import java.util.List;

import com.canddella.dao.FeedbackDAOImpl;
import com.canddella.entity.Feedback;
 
public class FeedbackServiceImpl implements FeedbackService {
	FeedbackDAOImpl feedbackDAOImpl = new FeedbackDAOImpl();
	@Override
	public void saveFeedback(Feedback feedback) {
		feedbackDAOImpl.saveFeedback(feedback);
		
	}

	@Override
	public Feedback viewFeedback(String feedbackId) {
		
		return feedbackDAOImpl.viewFeedback(feedbackId);
	}

	@Override
	public Feedback deleteFeedback(String feedbackId) {
		
		return feedbackDAOImpl.deleteFeedback(feedbackId);
	}

	@Override
	public List<Feedback> ListAllFeedback() {
		
		return feedbackDAOImpl.ListAllFeedback();
	}

}
