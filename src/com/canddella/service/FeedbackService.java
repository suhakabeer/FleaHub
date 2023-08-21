package com.canddella.service;

import java.util.List;

import com.canddella.entity.Feedback;

public interface FeedbackService {
	public void  saveFeedback(Feedback  feedback);
	public  Feedback viewFeedback(String feedbackId);
	public  Feedback deleteFeedback(String feedbackId);
	public List<Feedback> ListAllFeedback();
}
